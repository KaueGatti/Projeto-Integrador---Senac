<?php

class Projeto
{
    public $id;
    public $id_chat;
    public $id_criador;
    public $id_responsavel;
    public $nome;
    public $descricao;
    public $dataCriacao;
    public $dataInicialConclusao;
    public $dataAtualConclusao;
    public $dataConclusao;
    public $status;
    private $con;

    public function __construct($con)
    {
        $this->con = $con;
    }

    public function readByUsuario($id)
    {
        $sql = "CALL READ_PROJETOS_BY_USUARIO(:id)";
        $stmt = $this->con->prepare($sql);
        $stmt->bindParam(":id", $id);
        $stmt->execute();
        return $stmt->fetchAll(PDO::FETCH_OBJ);
    }

    public function readByID()
    {
        try {

            $sql = "CALL READ_PROJETO_BY_ID(:id)";
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(":id", $this->id);

            if ($stmt->execute()) {
                return [
                    'success' => true,
                    'message' => 'Projeto encontrado pelo ID com sucesso!',
                    'data' => $stmt->fetch(PDO::FETCH_OBJ)
                ];
            }

        } catch (PDOException $e) {
            http_response_code(500);
            return [
                'success' => false,
                'message' => $e->getMessage(),
                'data' => []
            ];
        }

        return [
            'success' => false,
            'message' => 'Erro desconhecido ao buscar projeto pelo ID',
            'data' => []
        ];
    }

    public function update()
    {
        try {
            $sql = "CALL UPDATE_PROJETO(:id, :id_responsavel, :nome, :descricao, :dataAtualConclusao, :dataConclusao, :status)";
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(":id", $this->id);
            $stmt->bindParam(":id_responsavel", $this->id_responsavel);
            $stmt->bindParam(":nome", $this->nome);
            $stmt->bindParam(":descricao", $this->descricao);
            $stmt->bindParam(":dataAtualConclusao", $this->dataAtualConclusao);

            if ($this->dataConclusao !== null) {
                $stmt->bindParam(":dataConclusao", $this->dataConclusao);
            } else {
                $stmt->bindValue(":dataConclusao", null, PDO::PARAM_NULL);
            }

            $stmt->bindParam(":status", $this->status);

            if ($stmt->execute()) {
                return [
                    "success" => true,
                    "message" => "Projeto atualizado com sucesso!"
                ];
            }
        } catch (Exception $e) {
            http_response_code(500);

            if (str_contains($e->getMessage(), "1062 Duplicate entry")) {
                return [
                    "success" => false,
                    "message" => 'Você já possui um projeto com este nome!'
                ];
            }

            return [
                "success" => false,
                "message" => $e->getMessage()
            ];
        }

        return [
            "success" => false,
            "message" => 'Erro desconhecido!'
        ];

    }

    public function create()
    {

        $validacao = $this->validarProjeto($this);
        if (!$validacao["success"]) {
            return $validacao;
        }

        try {

            $sql = "CALL CREATE_PROJETO(:id_criador, :id_responsavel, :nome, :descricao, :dataInicialConclusao)";
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(":id_criador", $this->id_criador);
            $stmt->bindParam(":id_responsavel", $this->id_responsavel);
            $stmt->bindParam(":nome", $this->nome);
            $stmt->bindParam(":descricao", $this->descricao);
            $stmt->bindParam(":dataInicialConclusao", $this->dataInicialConclusao);

            if ($stmt->execute()) {
                return [
                    "success" => true,
                    "message" => "Projeto criado com sucesso!"
                ];
            }
        } catch (Exception $e) {
            http_response_code(500);

            if (str_contains($e->getMessage(), "1062 Duplicate entry")) {
                return [
                    "success" => false,
                    "message" => 'Você já possui um projeto com este nome!'
                ];
            }

            return [
                "success" => false,
                "message" => $e->getMessage()
            ];
        }

        return [
            "success" => false,
            "message" => 'Erro desconhecido!'
        ];
    }

    public function addUsuario($id_usuario)
    {
        try {

            $sql = "CALL CREATE_USUARIO_PROJETO(:id_usuario, :id_projeto)";
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(":id_usuario", $id_usuario);
            $stmt->bindParam(":id_projeto", $this->id);

            if ($stmt->execute()) {
                return [
                    "success" => true,
                    "message" => "Usuario adicionado ao projeto com sucesso!"
                ];
            }
        } catch (Exception $e) {
            http_response_code(500);

            if (str_contains($e->getMessage(), "1062 Duplicate entry")) {
                return [
                    "success" => false,
                    "message" => 'Esse usuário já está no projeto!'
                ];
            }

            return [
                "success" => false,
                "message" => $e->getMessage()
            ];
        }

        return [
            "success" => false,
            "message" => 'Erro desconhecido ao adicionar um usuário ao projeto!'
        ];
    }

    public function deleteUsuario($id_usuario)
    {
        try {

            $sql = "CALL DELETE_USUARIO_PROJETO(:id_usuario, :id_projeto)";
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(":id_usuario", $id_usuario);
            $stmt->bindParam(":id_projeto", $this->id);

            if ($stmt->execute()) {
                return [
                    "success" => true,
                    "message" => "Usuario removido do projeto com sucesso!"
                ];
            }
        } catch (Exception $e) {
            http_response_code(500);
            return [
                "success" => false,
                "message" => $e->getMessage()
            ];
        }

        return [
            "success" => false,
            "message" => 'Erro desconhecido ao remover usuário do projeto!'
        ];
    }

    public function concluir() {
        try {
            $sql = 'CALL CONCLUIR_PROJETO(:id_projeto, :dataConclusao)';
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(':id_projeto', $this->id);
            $stmt->bindParam(':dataConclusao', $this->dataConclusao);

            if ($stmt->execute()) {
                return [
                    'success' => true,
                    'message' => 'Projeto concluido com sucesso!'
                ];
            }
        } catch (PDOException $e) {
            return [
                'success' => false,
                'message' => $e->getMessage(),
            ];
        }

        return [
            'success' => false,
            'message' => 'Erro desconhecido ao concluir projeto!'
        ];
    }

    public function delete()
    {
        try {
            $sql = 'CALL DELETE_PROJETO(:id_projeto)';
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(':id_projeto', $this->id);

            if ($stmt->execute()) {
                return [
                    'success' => true,
                    'message' => 'Projeto deletado com sucesso!'
                ];
            }
        } catch (PDOException $e) {
            return [
                'success' => false,
                'message' => $e->getMessage(),
            ];
        }

        return [
            'success' => false,
            'message' => 'Erro desconhecido ao deletar projeto!'
        ];
    }

    public function validarProjeto() {

        if (trim($this->nome) == '') {
            return [
                "success" => false,
                "message" => 'Nome do projeto não pode estar vázio'
            ];
        }

        if (trim($this->descricao) == '') {
            return [
                "success" => false,
                "message" => 'Descrição do projeto não pode estar vázio'
            ];
        }

        if (trim($this->id_responsavel) == "") {
            return [
                "success" => false,
                "message" => 'Selecione um responsável para o projeto'
            ];
        }

        if (trim($this->dataInicialConclusao) == "") {
            return [
                "success" => false,
                "message" => 'Defina uma data de conclusão para o projeto'
            ];
        }

        return [
            "success" => true,
            "message" => 'Projeto válido'
        ];
    }
}

