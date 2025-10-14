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
        $this->tarefa->id_usuario = $id_usuario;
        return $this->tarefa->readAllByUser();
    }
    public function readTarefaByID($id) {

    }

    public function updateTarefa($tarefa) {

    }

    public function createTarefa($novaTarefa) {
        $this->tarefa->id_projeto = $novaTarefa['id_projeto'];
        $this->tarefa->id_equipe = $novaTarefa['id_equipe'];
        $this->tarefa->id_usuario = $novaTarefa['id_usuario'];
        $this->tarefa->nome = $novaTarefa['nome'];
        $this->tarefa->descricao = $novaTarefa['descricao'];
        $this->tarefa->dataInicialConclusao = $novaTarefa['data_inicial_conclusao'];
        return $this->tarefa->create();
    }
}
