<?php

header('Content-type: application/json');

require_once __DIR__ . "/../../Controller/ComentarioController.php";

$controller = new ComentarioController();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (isset($_POST['id'])) {
        echo json_encode($controller->deleteComentarioProjeto($_POST['id']));
        die();
    }
}