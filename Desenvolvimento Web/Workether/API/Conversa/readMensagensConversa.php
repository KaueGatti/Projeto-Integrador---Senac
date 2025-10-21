<?php

header('Content-type: application/json');

require_once __DIR__ . "/../../Controller/ConversaController.php";

$controller = new ConversaController();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (isset($_POST['id_conversa'])) {
        echo json_encode($controller->readMensagensConversa($_POST['id_conversa']));
        die();
    }
}