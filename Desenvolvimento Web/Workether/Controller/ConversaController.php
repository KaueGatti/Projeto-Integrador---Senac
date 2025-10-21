<?php

require_once __DIR__ . '/../Config/Banco.php';
require_once __DIR__ . '/../Model/Conversa.php';

class ConversaController
{
    private $conversa;

    public function __construct()
    {
        $con = new Banco();
        $this->conversa = new Conversa($con->conectar());
    }

    public function createConversa($conversa)
    {
        $this->conversa->id_usuarioA = $conversa['id_usuarioA'];
        $this->conversa->id_usuarioB = $conversa['id_usuarioB'];

        return $this->conversa->create();
    }

    public function readConversasByUsuario($id_usuario)
    {
        $this->conversa->id_usuarioA = $id_usuario;

        return $this->conversa->readByUsuario();
    }

    public function readConversaByID($id_conversa, $id_usuario)
    {
        $this->conversa->id = $id_conversa;
        $this->conversa->id_usuarioA = $id_usuario;

        return $this->conversa->readByID();
    }

    public function readMensagensConversa($id_conversa)
    {
        $this->conversa->id = $id_conversa;

        return $this->conversa->readMensagens();
    }
}