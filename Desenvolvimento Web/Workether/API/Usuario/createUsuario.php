<?php

header('Content-type: application/json');

require_once __DIR__ . "/../../Controller/UsuarioController.php";

$controller = new UsuarioController();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (isset($_POST["usuario"])) {
        echo json_encode($controller->createUsuario($_POST["usuario"]));
        die();
    }
}