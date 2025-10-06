<?php

header('Content-type: application/json');

require_once __DIR__ . "/../Controller/NotificacaoController.php";

$controller = new NotificacaoController();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (isset($_POST['novaNotificacao'])) {
        echo json_encode($controller->createNotificacao($_POST['novaNotificacao']));
        die();
    }
}
