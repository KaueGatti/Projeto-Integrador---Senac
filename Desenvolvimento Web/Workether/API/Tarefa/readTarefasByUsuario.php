<?php

header('Content-type: application/json');

require_once __DIR__ . "/../../Controller/TarefaController.php";

$controller = new TarefaController();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (isset($_POST['id_usuario'])) {
        echo json_encode($controller->readTarefasByUsuario($_POST['id_usuario']));
        die();
    }
}