<?php

require_once __DIR__ . '/Controller/UsuarioController.php';
require_once __DIR__ . '/Model/Usuario.php';


session_start();
$usuarioController = new UsuarioController();
$usuario = 1;

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (isset($_POST["login"])) {
        $usuario = $usuarioController->loginUsuario($_POST["login"]);
        if ($usuario != null) {
            $_SESSION["usuario"] = $usuario;
            header("Location: index.php");
        }
    }
} else if (isset($_GET["sair"])) {
    unset($_SESSION["usuario"]);
}

?>

<!doctype html>
<html lang="pr-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Workether - Login</title>
    <link rel="stylesheet" href="Style/Login.css">
</head>
<body>
<main>
    <div id="divLogo">
        <h1 id="WORK">WORK</h1>
        <h1 id="ETHER">ETHER</h1>
    </div>
    <div id="form">
        <h1>Login</h1>
        <p id="info"></p>
        <div class="input-group">
            <input type="email" id="input_email" placeholder=" " required>
            <label for="input_email">E-mail</label>
        </div>
        <div class="input-group">
            <input type="password" id="input_senha" placeholder=" " required>
            <label for="input_senha">Senha</label>
        </div>
        <p class="labelLink">Não lembra a senha? <a href="RedefinirSenha.php" id="redefinirSenha">Redefinir senha</a></p>
        <p class="labelLink">Não possui cadastro? <a href="Cadastro.php" id="cadastrar">Cadastrar</a></p>
        <button id="btnEntrar">Entrar</button>
    </div>
</main>
</body>
<script src="./Script/Login.js" type="module"></script>
</html>
