<?php

require_once __DIR__ . '/../Config/Banco.php';
require_once __DIR__ . '/../Model/Comentario.php';

class ComentarioController
{
    private $comentario;

    public function __construct()
    {
        $con = new Banco();
        $this->comentario = new Comentario($con->conectar());
    }

    public function addComentarioProjeto($comentario)
    {
        $this->comentario->id_projeto = $comentario['id_projeto'];
        $this->comentario->id_usuario = $comentario['id_usuario'];
        $this->comentario->texto = $comentario['texto'];

        return $this->comentario->addProjeto();
    }

    public function deleteComentarioProjeto($id)
    {
        $this->comentario->id = $id;
        return $this->comentario->deleteProjeto();
    }
    public function readComentariosByProjeto($id_projeto)
    {
        $this->comentario->id_projeto = $id_projeto;
        return $this->comentario->readByProjeto();
    }
}