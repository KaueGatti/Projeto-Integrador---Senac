<?php

require_once __DIR__ . "/../Config/Banco.php";
require_once __DIR__ . "/../Model/PedidoAmizade.php";
class PedidoAmizadeController
{
    public $pedidoAmizade;
    public function __construct()
    {
        $db = new Banco();
        $con = $db->conectar();
        $this->pedidoAmizade = new PedidoAmizade($con);
    }

    public function createPedidoAmizade($pedidoAmizade)
    {
        $this->pedidoAmizade->id_solicitante = $pedidoAmizade['id_solicitante'];
        $this->pedidoAmizade->id_receptor = $pedidoAmizade['id_receptor'];
        return $this->pedidoAmizade->create();
    }

    public function readPedidoAmizadeByNotificacao($id_notificacao)
    {
        $this->pedidoAmizade->id_notificacao = $id_notificacao;
        return $this->pedidoAmizade->readByNotificacao();
    }

    public function updatePedidoAmizade($pedidoAmizade)
    {
        $this->pedidoAmizade->id = $pedidoAmizade['id'];
        $this->pedidoAmizade->status = $pedidoAmizade['status'];
        return $this->pedidoAmizade->update();
    }
}