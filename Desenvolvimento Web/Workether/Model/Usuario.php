<?php

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

    public function login($login) {
        $sql = "CALL READ_USUARIO_BY_NOME(:nome)";
        $stmt = $this->con->prepare($sql);
        $stmt->bindParam(':nome', $login['usuario']);
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

    public function update() {

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

}

?>