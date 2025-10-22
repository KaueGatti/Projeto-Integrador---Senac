<?php

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
        <div id="form">
            <h1>Cadastro</h1>
            <div class="input-group divUsuario">
                <input id="input_usuario" type="text" placeholder=" " required>
                <label for="input_usuario">Usuário</label>
            </div>
            <div class="input-group divEmail">
                <input id="input_email" type="email" placeholder=" " required>
                <label for="input_email">E-mail</label>
            </div>
            <div class="input-group divSenha">
                <input id="input_senha" type="password" placeholder=" " required>
                <label for="input_senha">Senha</label>
            </div>
            <div class="input-group divConfirmarSenha">
                <input id="input_confirmar_senha" type="password" placeholder=" " required>
                <label for="input_confirmar_senha">Confirmar senha</label>
            </div>
            <p id="info">Texto teste para testar</p>
            <p id="pJaPossuiCadastro">Já possui cadastro? <a href="Login.php" id="login">Login</a></p>
            <button id="btnCadastrar">Cadastrar</button>
        </div>
    </div>
</main>
</body>
<script src="./Script/Cadastro.js" type="module"></script>
</html>
