<?php

header('Content-type: application/json');

require_once __DIR__ . "/../../Controller/UsuarioController.php";

$controller = new UsuarioController();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (isset($_POST["login"])) {
        echo json_encode($controller->loginUsuario($_POST["login"]));
        die();
    }
}