<?php

header('Content-Type: application/json');

$response = ["success" => false, "data" => null, "error" => "Código inválido"];

session_start();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (isset($_SESSION["codigo"])) {
        if ($_SESSION["codigo"] == $_POST["codigo"]) {
            $response = ["success" => true, "data" => null, "error" => null];
        }
    }
    echo json_encode($response);
    exit();
}
if ($_SERVER['REQUEST_METHOD'] == 'GET' && !isset($_SESSION["codigo"])) {
    header("Location: RedefinirSenha.php");
}
?>

<link rel="stylesheet" href="Style/RedefinirSenha2.css">

<form id="form-passo2" method="post">
    <div id="divTitulo">
        <img onclick="carregarPasso(1)" src="Icones/Voltar.png" alt="">
        <h1>Redefinir senha</h1>
    </div>
    <p>Digite o código enviado por email</p>
    <p id="pErro"></p>
    <div class="input-group">
        <input type="text" name="codigo" placeholder=" ">
        <label for="codigo">Código</label>
    </div>
    <button>Enviar</button>
    <div id="divProgresso">
        <div id="Etapa1"></div>
        <div id="Etapa2"></div>
        <div id="Etapa3"></div>
    </div>
</form>