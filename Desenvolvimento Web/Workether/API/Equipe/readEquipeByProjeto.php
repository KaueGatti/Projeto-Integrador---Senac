<?php

header('Content-type: application/json');

require_once __DIR__ . "/../../Controller/EquipeController.php";

$controller = new EquipeController();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (isset($_POST['id_projeto']) && isset($_POST['nome'])) {
        echo json_encode($controller->readEquipeByProjeto($_POST['id_projeto'], $_POST['nome']));
        die();
    }
}
