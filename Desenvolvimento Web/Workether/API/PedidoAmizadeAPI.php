<?php

require_once __DIR__ . '/../Controller/PedidoAmizadeController.php';

$controller = new PedidoAmizadeController();

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (isset($_POST["pedidoAmizade"])) {
        echo json_encode($controller->createPedidoAmizade($_POST["pedidoAmizade"]));
        die();
    } else if (isset($_POST["respostaPedidoAmizade"])) {
        $pedidoAmizade = ($controller->readPedidoAmizadeByNotificacao($_POST["respostaPedidoAmizade"]['id_notificacao']));

        echo json_encode($controller->updatePedidoAmizade(["id" => $pedidoAmizade->id, "status" => $_POST["respostaPedidoAmizade"]['resposta']]));
        die();
    }
}
