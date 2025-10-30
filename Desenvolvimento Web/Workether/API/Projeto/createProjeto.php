<?php

header('Content-type: application/json');

require_once __DIR__ . "/../../Controller/ProjetoController.php";

$controller = new ProjetoController();

if ($_SERVER["REQUEST_METHOD"] === "POST") {
    if (isset($_POST["novoProjeto"])) {
        echo json_encode($controller->createProjeto($_POST["novoProjeto"]));
        die();
    }
}