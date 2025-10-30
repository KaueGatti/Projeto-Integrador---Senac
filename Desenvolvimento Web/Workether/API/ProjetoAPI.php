<?php

header('Content-Type: application/json; charset=utf-8');

require_once __DIR__ . "/../Controller/ProjetoController.php";

$controller = new ProjetoController();

if ($_SERVER["REQUEST_METHOD"] === "POST") {
    if (isset($_POST["editarProjeto"])) {
        echo json_encode($controller->updateProjeto($_POST["editarProjeto"]));
        die();
    }
}
