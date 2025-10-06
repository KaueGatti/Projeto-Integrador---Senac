<?php

require_once __DIR__ . "/../Config/Banco.php";
require_once __DIR__ . "/../Model/Notificacao.php";

class NotificacaoController
{

    public $notificacao;

    public function __construct() {
        $db = new Banco();
        $con = $db->conectar();
        $this->notificacao = new Notificacao($con);
    }

    public function createNotificacao($notificacao) {
        $this->notificacao->id_usuario = $notificacao['id_usuario'];
        $this->notificacao->assunto = $notificacao['assunto'];
        $this->notificacao->texto = $notificacao['texto'];
        return $this->notificacao->create();
    }

    public function readNotificacoesByUsuario($id_usuario) {
        $this->notificacao->id_usuario = $id_usuario;
        return $this->notificacao->readByUsuario();
    }
}