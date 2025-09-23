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
            <h1 id="WORK">WORK</h1><h1 id="ETHER">ETHER</h1>
        </div>
        <form action="Login.php" method="post">
            <h1>Login</h1>
            <p id="pErro"><?php if ($usuario == null) { echo "Usuario ou senha incorretos"; }?></p>
            <input type="text" name="login[usuario]" placeholder="Usuário" required>
            <input type="password" name="login[senha]" placeholder="Senha" required>
            <p>Não lembra a senha? <a href="RedefinirSenha.php" id="redefinirSenha">Refefinir senha</a></p>
            <p>Não possui cadastro? <a href="Cadastro.php" id="cadastrar">Cadastrar</a></p>
            <button id="btnEntrar">Entrar</button>
        </form>
    </main>
</body>
</html>
