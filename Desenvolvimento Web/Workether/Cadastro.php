<?php

require_once __DIR__ . '/Controller/UsuarioController.php';

$usuarioController = new UsuarioController();
$erros = [];

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (isset($_POST["usuario"])) {
        $erros = $usuarioController->createUsuario($_POST["usuario"]);
        if (empty($erros)) {
            header("Location: Login.php");
        }
    }
}

?>

<!doctype html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Workether - Cadastro</title>
    <link rel="stylesheet" href="Style/Cadastro.css">
</head>
<body>
<main>
    <div id="divLogo">
        <h1 id="WORK">WORK</h1>
        <h1 id="ETHER">ETHER</h1>
    </div>
    <div id="divForm">
        <form action="Cadastro.php" method="post">
            <h1>Cadastro</h1>
            <input type="text" name="usuario[usuario]" placeholder="Usuário" required>
            <p id="pErroUsuario"><?php if (isset($erros['usuario'])) { echo $erros['usuario']; } ?></p>
            <input type="email" name="usuario[email]" placeholder="E-mail" required>
            <p id="pErroEmail"><?php if (isset($erros['email'])) { echo $erros['email']; } ?></p>
            <input type="password" name="usuario[senha]" placeholder="Senha" required>
            <input type="password" name="usuario[confirmarSenha]" placeholder="Confirmar senha" required>
            <p id="pErroSenha"><?php if (isset($erros['senha'])) { echo $erros['senha']; } ?></p>
            <p id="pJaPossuiCadastro">Já possui cadastro? <a href="Login.php" id="login">Login</a></p>
            <button id="btnCadastrar">Cadastrar</button>
        </form>
    </div>
</main>
</body>
</html>
