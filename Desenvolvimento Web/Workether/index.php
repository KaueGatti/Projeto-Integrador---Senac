<?php

include_once 'session.php'

?>

<!doctype html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Workether - Página Inicial</title>
    <link rel="stylesheet" href="Style/index.css">
</head>
<body>
<?php include_once 'MenuLateral.php'; ?>
<main id="main">
    <?php include_once 'Header.php'; ?>
    <?php include_once 'PaginaInicial.php'; ?>
</main>
<?php include_once 'Notificacoes.php'; ?>
</body>
<script src="Script/index.js"></script>
</html>