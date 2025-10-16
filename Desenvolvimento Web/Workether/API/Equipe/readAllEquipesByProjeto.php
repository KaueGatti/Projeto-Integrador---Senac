<?php

header('Content-type: application/json');

require_once __DIR__ . "/../../Controller/EquipeController.php";

$controller = new EquipeController();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (isset($_POST['id_projeto'])) {
        echo json_encode($controller->readAllEquipesByProjeto($_POST['id_projeto']));
        die();
    }
}
