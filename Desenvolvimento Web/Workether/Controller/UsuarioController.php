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
        $this->usuario->confirmarSenha = $usuario['confirmarSenha'];

        return $this->usuario->create();
    }

    public function loginUsuario($login)
    {
        return $this->usuario->login($login);
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

    public function readUsuarioByEmail($email)
    {
        return $this->usuario->readByEmail($email);
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