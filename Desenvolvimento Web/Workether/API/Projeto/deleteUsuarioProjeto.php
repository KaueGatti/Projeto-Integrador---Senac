<?php

header('Content-type: application/json');

require_once __DIR__ . "/../../Controller/ProjetoController.php";

$controller = new ProjetoController();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (isset($_POST['id_usuario']) && isset($_POST['id_projeto'])) {
        echo json_encode($controller->deleteUsuarioProjeto($_POST['id_usuario'], $_POST['id_projeto']));
        die();
    }
}