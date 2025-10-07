<?php

require_once __DIR__ . "/../Controller/UsuarioController.php";

header('Content-type: application/json');

$controller = new UsuarioController();

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (isset($_POST["pedidoAmizade"])) {
        echo json_encode($controller->enviarPedidoAmizade($_POST["pedidoAmizade"]));
        die();
    } else if (isset($_POST["respostaPedidoAmizade"])) {
        echo json_encode($controller->responderPedidoAmizade($_POST["respostaPedidoAmizade"]));
        die();
    }
}