<?php

require_once __DIR__ . "/../Config/Banco.php";
require_once __DIR__ . "/../Model/Equipe.php";

class EquipeController
{
    private $equipe;

    public function __construct()
    {
        $con = new Banco();
        $this->equipe = new Equipe($con->conectar());
    }

    public function createEquipe($dadosEquipe)
    {
        $this->equipe->id_projeto = $dadosEquipe['id_projeto'];
        $this->equipe->nome = $dadosEquipe['nome'];
        $this->equipe->descricao = $dadosEquipe['descricao'];
        $this->equipe->id_responsavel = $dadosEquipe['id_responsavel'];

        return $this->equipe->create();
    }

    public function deleteEquipe($id_equipe) {
        $this->equipe->id = $id_equipe;
        return $this->equipe->delete();
    }

    public function updateEquipe($dadosEquipe)
    {
        $this->equipe->id = $dadosEquipe['id'];
        $this->equipe->id_responsavel = $dadosEquipe['id_responsavel'];
        $this->equipe->nome = $dadosEquipe['nome'];
        $this->equipe->descricao = $dadosEquipe['descricao'];

        return $this->equipe->update();
    }

    public function addUsuarioEquipe($id_usuario, $id_equipe)
    {
        return $this->equipe->addUsuarioEquipe($id_usuario, $id_equipe);
    }

    public function deleteUsuarioEquipe($id_usuario, $id_equipe)
    {
        return $this->equipe->deleteUsuarioEquipe($id_usuario, $id_equipe);
    }

    public function deleteAllUsuariosEquipe($id_equipe)
    {
        return $this->equipe->deleteAllUsuariosEquipe($id_equipe);
    }

    public function readAllEquipesByProjeto($id_projeto)
    {
        return $this->equipe->readAllByProjeto($id_projeto);
    }

    public function readEquipeByProjeto($id_projeto, $nome)
    {
        $this->equipe->nome = $nome;
        return $this->equipe->readByProjeto($id_projeto);
    }

    public function readAllEquipesByUsuario($id_usuario)
    {
        return $this->equipe->readAllByUsuario($id_usuario);
    }
}