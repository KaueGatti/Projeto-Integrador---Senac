<?php

require_once __DIR__ . "/../Controller/NotificacaoController.php";
require_once __DIR__ . "/../Controller/PedidoAmizadeController.php";

class Usuario
{
    public $id;
    public $usuario;
    public $email;
    public $senha;
    public $status;

    private $con;

    public function __construct($con)
    {
        $this->con = $con;
    }

    public function create(): array
    {
        $erros = [];

        if (!$this->usuarioIsValido($this)) {
            $erros['usuario'] = "Usuário inválido";
        }

        if (!$this->emailIsValido($this)) {
            $erros['email'] = "E-mail já cadastrado";
        }

        if (!$this->senhaIsValido($this)) {
            $erros['senha'] = "Senhas diferentes, tente novamente.";
        }

        if (!empty($erros)) {
            return $erros;
        }

        $senhaHash = password_hash($this->senha, PASSWORD_DEFAULT);
        $id = $this->gerarIdUnico();
        $sql = "CALL CREATE_USUARIO(:id, :email, :usuario, :senha);";
        $stmt = $this->con->prepare($sql);
        $stmt->bindParam(":id", $id);
        $stmt->bindParam(":email", $this->email);
        $stmt->bindParam(":usuario", $this->usuario);
        $stmt->bindParam(":senha", $senhaHash);

        $stmt->execute();

        return [];
    }

    function gerarId(): string
    {
        $caracteres = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
        $id = '';

        for ($i = 0; $i < 7; $i++) {
            $index = random_int(0, strlen($caracteres) - 1);
            $id .= $caracteres[$index];
        }

        return $id;
    }

    function gerarIdUnico(): string
    {
        do {
            $id = $this->gerarId();

            $sql = "SELECT COUNT(*) FROM Usuario WHERE id = :id";
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(':id', $id);
            $stmt->execute();
            $existe = $stmt->fetchColumn();
        } while ($existe > 0);

        return $id;
    }

    public function usuarioIsValido($usuario): bool
    {
        $sql = "SELECT COUNT(*) FROM Usuario WHERE usuario = :usuario";
        $stmt = $this->con->prepare($sql);
        $stmt->bindParam(':usuario', $usuario->usuario);
        $stmt->execute();
        $existe = $stmt->fetchColumn();
        if ($existe > 0) {
            return false;
        }
        return true;
    }

    public function emailIsValido($usuario): bool
    {
        $sql = "SELECT COUNT(*) FROM Usuario WHERE email = :email";
        $stmt = $this->con->prepare($sql);
        $stmt->bindParam(':email', $usuario->email);
        $stmt->execute();
        $existe = $stmt->fetchColumn();
        if ($existe > 0) {
            return false;
        }
        return true;
    }

    public function senhaIsValido($usuario): bool
    {
        if ($usuario->senha !== $usuario->confirmarSenha) {
            return false;
        }
        return true;
    }

    public function login($login)
    {
        $sql = "CALL READ_USUARIO_BY_EMAIL(:email)";
        $stmt = $this->con->prepare($sql);
        $stmt->bindParam(':email', $login['email']);
        $stmt->execute();
        $usuario = $stmt->fetch(PDO::FETCH_OBJ);

        if (!$usuario) {
            return null;
        }

        if (password_verify($login['senha'], $usuario->senha)) {
            return $usuario;
        } else {
            return null;
        }
    }

    public function update()
    {

        $senhaHash = password_hash($this->senha, PASSWORD_DEFAULT);

        $sql = "CALL UPDATE_USUARIO(:id, :email, :usuario, :senha, :status);";
        $stmt = $this->con->prepare($sql);
        $stmt->bindParam(":id", $this->id);
        $stmt->bindParam(":email", $this->email);
        $stmt->bindParam(":usuario", $this->usuario);
        $stmt->bindParam(":senha", $senhaHash);
        $stmt->bindParam(":status", $this->status);

        return $stmt->execute();
    }

    public function readByEmail($email)
    {
        $sql = "CALL READ_USUARIO_BY_EMAIL(:email);";
        $stmt = $this->con->prepare($sql);
        $stmt->bindParam(":email", $email);
        $stmt->execute();
        return $stmt->fetch(PDO::FETCH_OBJ);
    }

    public function readByID($id)
    {
        $sql = "CALL READ_USUARIO_BY_ID(:id);";
        $stmt = $this->con->prepare($sql);
        $stmt->bindParam(":id", $id);
        $stmt->execute();
        return $stmt->fetch(PDO::FETCH_OBJ);
    }

    public function readByIDJSON($id)
    {
        $sql = "CALL READ_USUARIO_BY_ID(:id);";
        $stmt = $this->con->prepare($sql);
        $stmt->bindParam(":id", $id);
        $stmt->execute();
        $usuario = $stmt->fetch(PDO::FETCH_OBJ);

        return [
            "id" => $usuario->id,
            "usuario" => $usuario->usuario
        ];
    }

    public function readAllByProjeto($projeto_id)
    {
        try {
            $sql = 'CALL READ_USUARIOS_BY_PROJETO(:id_projeto)';
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(':id_projeto', $projeto_id);

            if ($stmt->execute()) {
                return [
                    'sucesso' => true,
                    'message' => 'Usuarios encontrados pelo projeto',
                    'data' => $stmt->fetchAll(PDO::FETCH_OBJ)
                ];
            }
        } catch (PDOException $e) {
            return [
               'success' => false,
                'message' => $e->getMessage(),
                'data' => []
            ];
        }

        return [
            'success' => false,
            'message' => 'Erro desconhecido!',
            'data' => []
        ];
    }

    public function readByEquipe($id_equipe)
    {
        try {
            $sql = 'CALL READ_USUARIOS_BY_EQUIPE(:id_equipe)';
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(':id_equipe', $id_equipe);

            if ($stmt->execute()) {
                return [
                    'success' => true,
                    'message' => 'Usuarios encontrados pela equipe',
                    'data' => $stmt->fetchAll(PDO::FETCH_OBJ)
                ];
            }
        } catch (PDOException $e) {
            return [
                'success' => false,
                'message' => $e->getMessage(),
                'data' => []
            ];
        }

        return [
            'success' => false,
            'message' => 'Erro desconhecido ao buscar usuarios pela equipe!',
            'data' => []
        ];
    }

    public function updateNome()
    {

        try {
            $sql = "CALL UPDATE_NOME_USUARIO(:id, :usuario)";
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(":id", $this->id);
            $stmt->bindParam(":usuario", $this->usuario);
            if ($stmt->execute()) {
                return [
                    "success" => true,
                    "message" => "Usuario atualizado com sucesso."
                ];
            }
        } catch (PDOException $e) {
            http_response_code(500);
            return [
                "success" => false,
                "message" => $e->getMessage()
            ];
        }

        return [
            "success" => false,
            "message" => "Erro desconhecido."
        ];

    }
}