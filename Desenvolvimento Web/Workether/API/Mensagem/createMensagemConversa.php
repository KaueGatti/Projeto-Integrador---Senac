<?php

header('Content-type: application/json');

require_once __DIR__ . "/../../Controller/MensagemController.php";

$controller = new MensagemController();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (isset($_POST['mensagem'])) {
        echo json_encode($controller->createMensagemConversa($_POST['mensagem']));
        die();
    }
}