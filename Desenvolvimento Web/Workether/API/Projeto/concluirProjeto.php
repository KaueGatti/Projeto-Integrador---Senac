<?php

header('Content-type: application/json');

require_once __DIR__ . "/../../Controller/ProjetoController.php";

$controller = new ProjetoController();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (isset($_POST['id_projeto']) && isset($_POST['dataConclusao'])) {
        echo json_encode($controller->concluirProjeto($_POST['id_projeto'], $_POST['dataConclusao']));
        die();
    }
}