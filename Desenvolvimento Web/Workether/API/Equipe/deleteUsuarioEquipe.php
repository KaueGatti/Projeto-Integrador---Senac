<?php

header('Content-type: application/json');

require_once __DIR__ . "/../../Controller/EquipeController.php";

$controller = new EquipeController();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (isset($_POST['id_usuario']) && isset($_POST['id_equipe'])) {
        echo json_encode($controller->deleteUsuarioEquipe($_POST['id_usuario'], $_POST['id_equipe']));
        die();
    }
}
