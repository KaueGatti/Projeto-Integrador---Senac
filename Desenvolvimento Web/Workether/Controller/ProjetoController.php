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
    public function readProjetoByID($id) {
        $this->projeto->id = $id;
        return $this->projeto->readByID();
    }

    public function updateProjeto($projeto) {
        $this->projeto->id = $projeto['id'];
        $this->projeto->nome = $projeto['nome'];
        $this->projeto->descricao = $projeto['descricao'];
        $this->projeto->id_responsavel = $projeto['id_responsavel'];
        $this->projeto->dataAtualConclusao = $projeto['dataAtualConclusao'];
        $this->projeto->dataConclusao = $projeto['dataConclusao'] ?: null;
        $this->projeto->status = $projeto['status'];

        return $this->projeto->update();
    }

    public function createProjeto($novoProjeto) {
        $this->projeto->nome = $novoProjeto['nome'];
        $this->projeto->descricao = $novoProjeto['descricao'];
        $this->projeto->id_criador = $novoProjeto['id_criador'];
        $this->projeto->id_responsavel = $novoProjeto['id_responsavel'];
        $this->projeto->dataInicialConclusao = $novoProjeto['dataInicialConclusao'];
        return $this->projeto->create();
    }

    public function addUsuarioProjeto($id_usuario, $id_projeto) {
        $this->projeto->id = $id_projeto;
        return $this->projeto->addUsuario($id_usuario);
    }

    public function deleteUsuarioProjeto($id_usuario, $id_projeto) {
        $this->projeto->id = $id_projeto;
        return $this->projeto->deleteUsuario($id_usuario);
    }

    public function deleteProjeto($id_projeto) {
        $this->projeto->id = $id_projeto;
        return $this->projeto->delete();
    }

    public function concluirProjeto($id_projeto, $dataConclusao) {
        $this->projeto->id = $id_projeto;
        $this->projeto->dataConclusao = $dataConclusao;
        return $this->projeto->concluir();
    }
}
