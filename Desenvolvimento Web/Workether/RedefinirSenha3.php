<?php

header('Content-Type: application/json');

require_once __DIR__ . '/Controller/UsuarioController.php';

$controller = new UsuarioController();

$response = ["success" => false, "data" => null, "error" => "Erro ao redefinir senha"];

session_start();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (isset($_POST["senha"]) && isset($_POST["confirmarSenha"])) {
        if ($_POST["senha"] === $_POST["confirmarSenha"]) {
            $_SESSION["usuarioUpdated"]->senha = $_POST["senha"];
            $controller->updateUsuario($_SESSION["usuarioUpdated"]);
            session_destroy();
            $response = ["success" => true, "data" => null, "error" => "Senha alterada com sucesso! <br> Você será redirecionado em alguns segundos."];
        } else {
            $response = ["success" => false, "data" => null, "error" => "Senhas diferentes, tente novamente."];
        }
    } else {
        $response = ["success" => false, "data" => null, "error" => "Preencha todos os campos!"];
    }
    echo json_encode($response);
    exit();
} if ($_SERVER['REQUEST_METHOD'] == 'GET' && !isset($_SESSION["usuarioUpdated"])) {
    header("Location: RedefinirSenha.php");
}

?>

<link rel="stylesheet" href="Style/RedefinirSenha3.css">

<form id="form-passo3" method="post">
    <div id="divTitulo">
        <img onclick="carregarPasso(2)" src="Icones/Voltar.png" alt="">
        <h1>Redefinir senha</h1>
    </div>
    <p>Digite sua nova senha</p>
    <p id="pErro"></p>
    <div class="divInput">
        <div class="input-group">
            <input type="password" name="senha" placeholder=" ">
            <label for="senha">Senha</label>
        </div>
        <img src="Icones/VerSenha.png" alt="">
    </div>
    <div class="divInput">
        <div class="input-group">
            <input type="password" name="confirmarSenha" placeholder=" ">
            <label for="confirmarSenha">Confirmar senha</label>
        </div>
        <img src="Icones/VerSenha.png" alt="">
    </div>
    <button id="btnRedefinir">Redefinir</button>
    <div id="divProgresso">
        <div id="Etapa1"></div>
        <div id="Etapa2"></div>
        <div id="Etapa3"></div>
    </div>
</form>