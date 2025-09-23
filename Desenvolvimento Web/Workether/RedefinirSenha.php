<?php

use GmailAPI\GmailClient;

require __DIR__ . "/GmailAPI/GmailClient.php";
require __DIR__ . "/Controller/UsuarioController.php";

session_start();

?>

<!doctype html>
<html lang="pr-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Workether - Login</title>
    <link rel="stylesheet" href="Style/RedefinirSenha.css">
</head>
<body>
<main id="main" class="main">
    <div id="divLogo">
        <h1 id="WORK">WORK</h1>
        <h1 id="ETHER">ETHER</h1>
    </div>
    <div id="conteudo-passo">
    </div>
</main>
</body>
<script src="Script/RedefinirSenha.js"></script>
</html>
