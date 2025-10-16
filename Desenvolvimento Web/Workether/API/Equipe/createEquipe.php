<?php

header('Content-type: application/json');

require_once __DIR__ . "/../../Controller/EquipeController.php";

$controller = new EquipeController();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (isset($_POST['novaEquipe'])) {
        $novaEquipe = json_decode($_POST['novaEquipe'], true);
        echo json_encode($controller->createEquipe($novaEquipe));
        die();
    }
}
