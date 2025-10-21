<?php

require_once __DIR__ . '/../Config/Banco.php';
require_once __DIR__ . '/../Model/Mensagem.php';

class MensagemController
{
    private $mensagem;

    public function __construct()
    {
        $con = new Banco();
        $this->mensagem = new Mensagem($con->conectar());
    }

    public function createMensagemConversa($mensagem)
    {
        $this->mensagem->id_conversa = $mensagem['id_conversa'];
        $this->mensagem->id_usuario = $mensagem['id_usuario'];
        $this->mensagem->texto = $mensagem['texto'];

        return $this->mensagem->createToConversa();
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