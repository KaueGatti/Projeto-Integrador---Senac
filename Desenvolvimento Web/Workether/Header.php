<?php ?>

<header>
    <link rel="stylesheet" href="Style/Header.css">
    <img id="iconeUserHeader" src="Icones/User.png" alt="">
    <p class="mb-0">Usuário: <?php echo $_SESSION['usuario']->usuario; ?></p>
    <a id="btnNotificacoes" >
        <img id="iconeNotificationHeader" src="Icones/Notification.png" alt="">
    </a>
</header>

