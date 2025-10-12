<?php

require_once __DIR__ . "/../Controller/UsuarioController.php";

header('Content-type: application/json');

$controller = new UsuarioController();

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (isset($_POST["atualizarUsuario"])) {
        echo json_encode($controller->updateNomeUsuario($_POST["atualizarUsuario"]));
        die();
    }

    if (isset($_POST["id"])) {
        $usuario = $controller->readUsuarioByID($_POST["id"]);
        $_SESSION["usuario"] = $usuario;
        echo json_encode($controller->readUsuarioByIDJSON($_POST["id"]));
        die();
    }
}