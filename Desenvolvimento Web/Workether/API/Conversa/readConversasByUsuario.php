<?php

header('Content-type: application/json');

require_once __DIR__ . "/../../Controller/ConversaController.php";

$controller = new ConversaController();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (isset($_POST['conversa'])) {
        echo json_encode($controller->readConversasByUsuario($_POST['conversa']));
        die();
    }
}