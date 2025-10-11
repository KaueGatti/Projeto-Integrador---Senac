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
        $sql = "CALL READ_PROJETO_BY_ID(:id)";
        $stmt = $this->con->prepare($sql);
        $stmt->bindParam(":id", $this->id);
        $stmt->execute();
        return $stmt->fetch(PDO::FETCH_OBJ);
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
}

