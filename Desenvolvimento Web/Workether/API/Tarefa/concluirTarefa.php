<?php

header('Content-type: application/json');

require_once __DIR__ . "/../../Controller/TarefaController.php";

$controller = new TarefaController();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (isset($_POST['id_tarefa']) && isset($_POST['dataConclusao'])) {
        echo json_encode($controller->concluirTarefa($_POST['id_tarefa'], $_POST['dataConclusao']));
        die();
    }
}