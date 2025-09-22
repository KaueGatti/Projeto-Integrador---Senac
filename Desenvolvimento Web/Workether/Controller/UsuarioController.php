<?php

require_once __DIR__ . '/../Config/Banco.php';
require_once __DIR__ . '/../Model/Usuario.php';

class UsuarioController
{
    private $usuario;

    public function __construct() {
        $con = new Banco();
        $this->usuario = new Usuario($con->conectar());
    }

    public function createUsuario($usuario) {
        $this->usuario->usuario = $usuario['usuario'];
        $this->usuario->email = $usuario['email'];
        $this->usuario->senha = $usuario['senha'];
        $this->usuario->confirmarSenha = $usuario['confirmarSenha'];

        return $this->usuario->create();
    }

    public function loginUsuario($login) {
        return $this->usuario->login($login);
    }
}