<?php

require_once __DIR__ . "/../Model/Tarefa.php";
require_once __DIR__ . "/../Config/Banco.php";

class TarefaController
{
    public $tarefa;

    public function __construct() {
        $bd = new Banco();
        $this->tarefa = new Tarefa($bd->conectar());
    }

    public function readTarefasByUsuario($id_usuario) {
        $this->tarefa->id_responsavel = $id_usuario;
        return $this->tarefa->readAllByUser();
    }

    public function readTarefasByProjeto($id_projeto) {
        $this->tarefa->id_projeto = $id_projeto;
        return $this->tarefa->readAllByProjeto();
    }
    public function readTarefaByID($id) {

    }

    public function updateTarefa($tarefa) {

    }

    public function createTarefa($tarefa) {
        $this->tarefa->id_projeto = $tarefa['id_projeto'];
        $this->tarefa->id_equipe = $tarefa['id_equipe'];
        $this->tarefa->id_responsavel = $tarefa['id_responsavel'];
        $this->tarefa->nome = $tarefa['nome'];
        $this->tarefa->descricao = $tarefa['descricao'];
        $this->tarefa->dataInicialConclusao = $tarefa['data_inicial_conclusao'];
        return $this->tarefa->create();
    }
}
