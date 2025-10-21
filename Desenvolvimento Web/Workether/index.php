<?php

include_once 'session.php';

?>

<!doctype html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Workether - Página Inicial</title>
    <link rel="stylesheet" href="Style/index.css">
</head>
<p class="usuarioLogado" id="<?= $_SESSION['usuario']->id ?>" hidden><?= $_SESSION['usuario']->usuario ?></p>
<body id="body">
<?php include_once 'MenuLateral.php'; ?>
<main id="main">
    <?php include_once 'Header.php'; ?>
    <?php include_once 'PaginaInicial.php'; ?>
</main>
<section class="abaNotificacoes" id="notificacoes">
    <link rel="stylesheet" href="Style/Notificacoes.css">
    <div id="divTitulo">
        <h1 id="h1Notificacoes">Notificações</h1>
        <img id="btn_refresh_notificacoes" src="Icones/Refresh.png" alt="">
    </div>
    <section id="sectionNotificacoes">
    </section>
</section>
</body>
<script type="module" id="script" src="Script/index.js"></script>
</html>
