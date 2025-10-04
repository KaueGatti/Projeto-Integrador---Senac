<?php

class Projeto
{
    public $id;
    public $id_chat;
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

    public function create()
    {
        $valid = $this->projetoIsValid();
        if ($valid !== true) {
            return $valid;
        }

        try {

            $sql = "CALL CREATE_PROJETO(:id_responsavel, :nome, :descricao, :dataInicialConclusao)";
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(":id_responsavel", $this->id_responsavel);
            $stmt->bindParam(":nome", $this->nome);
            $stmt->bindParam(":descricao", $this->descricao);
            $stmt->bindParam(":dataInicialConclusao", $this->dataInicialConclusao);

            if ($stmt->execute()) {
                return [
                    "success" => true,
                    "message" => "Projeto cadastrado com sucesso!"
                ];
            }
        } catch (Exception $e) {
            http_response_code(500);

            if (str_contains($e->getMessage(), "1062 Duplicate entry") ) {
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

    public function projetoIsValid()
    {
        if (trim($this->nome) === "") {
            return [
                "success" => false,
                "message" => "Nome do projeto não pode estar vazio!"
            ];
        }

        if (trim($this->descricao) === "") {
            return [
                "success" => false,
                "message" => "Descrição do projeto não pode estar vazio!"
            ];
        }

        if (trim($this->id_responsavel) === "") {
            return [
                "success" => false,
                "message" => "Selecione um responsável para o projeto!"
            ];
        }

        if (trim($this->dataInicialConclusao) === "") {
            return [
                "success" => false,
                "message" => "Selecione uma data para a conclusão do projeto!"
            ];
        }

        return true;
    }
}

