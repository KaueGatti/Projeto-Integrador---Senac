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

    public function readByUsuario($id) {
        $sql = "CALL READ_PROJETOS_BY_USUARIO(:id)";
        $stmt = $this->con->prepare($sql);
        $stmt->bindParam(":id", $id);
        $stmt->execute();
        return $stmt->fetchAll(PDO::FETCH_OBJ);
    }
}

