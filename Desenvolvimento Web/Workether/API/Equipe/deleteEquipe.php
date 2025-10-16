<?php

header('Content-type: application/json');

require_once __DIR__ . "/../../Controller/EquipeController.php";

$controller = new EquipeController();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (isset($_POST['id_equipe'])) {
        echo json_encode($controller->deleteEquipe($_POST['id_equipe']));
        die();
    }
}