<?php


require_once __DIR__ . "/../Model/Projeto.php";
require_once __DIR__ . "/../Config/Banco.php";

class ProjetoController
{
    public $projeto;

    public function __construct() {
        $bd = new Banco();
        $this->projeto = new Projeto($bd->conectar());
    }

    public function readProjectsByUsuario($id) {
        return $this->projeto->readByUsuario($id);
    }

    public function createProjeto($novoProjeto) {
        $this->projeto->nome = $novoProjeto['nome'];
        $this->projeto->descricao = $novoProjeto['descricao'];
        $this->projeto->id_responsavel = $novoProjeto['id_responsavel'];
        $this->projeto->dataInicialConclusao = $novoProjeto['dataInicialConclusao'];
        return $this->projeto->create();
    }
}
