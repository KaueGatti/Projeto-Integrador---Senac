<?php

require_once __DIR__ . '/../Config/Banco.php';
require_once __DIR__ . '/../Model/Usuario.php';

class UsuarioController
{
    private $usuario;

    public function __construct()
    {
        $con = new Banco();
        $this->usuario = new Usuario($con->conectar());
    }

    public function createUsuario($usuario)
    {
        $this->usuario->usuario = $usuario['usuario'];
        $this->usuario->email = $usuario['email'];
        $this->usuario->senha = $usuario['senha'];

        return $this->usuario->create();
    }

    public function loginUsuario($login)
    {
        $this->usuario->email = $login['email'];
        $this->usuario->senha = $login['senha'];
        return $this->usuario->login();
    }

    public function updateUsuario($usuarioUpdated)
    {
        $this->usuario->id = $usuarioUpdated->id;
        $this->usuario->usuario = $usuarioUpdated->usuario;
        $this->usuario->email = $usuarioUpdated->email;
        $this->usuario->senha = $usuarioUpdated->senha;
        $this->usuario->status = $usuarioUpdated->status;

        return $this->usuario->update();
    }

    public function updateNomeUsuario($usuarioUpdated) {
        $this->usuario->id = $usuarioUpdated['id'];
        $this->usuario->usuario = $usuarioUpdated['usuario'];
        return $this->usuario->updateNome();
    }

    public function readUsuarioByEmail($email)
    {
        return $this->usuario->readByEmail($email);
    }

    public function readUsuarioByID($id)
    {
        return $this->usuario->readByID($id);
    }
    public function readUsuarioByIDJSON($id)
    {
        return $this->usuario->readByIDJSON($id);
    }

    public function readAllUsuarioByProjeto($id_projeto) {
        return $this->usuario->readAllByProjeto($id_projeto);
    }
    public function readUsuariosByEquipe($id_equipe) {
        return $this->usuario->readByEquipe($id_equipe);
    }

    function gerarCodigo($tamanho = 8)
    {
        $codigo = '';
        for ($i = 0; $i < $tamanho; $i++) {
            $codigo .= mt_rand(0, 9);
        }
        return $codigo;
    }
}