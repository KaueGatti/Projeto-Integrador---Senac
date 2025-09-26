<?php ?>

<header>
    <link rel="stylesheet" href="Style/Header.css">
    <img id="iconeUserHeader" src="Icones/User.png" alt="">
    <p class="mb-0">Usuário: <?php echo $_SESSION['usuario']->usuario; ?></p>
    <a onclick="click()" id="btnNotificacoes" >
        <img onclick="click()" id="iconeNotificationHeader" src="Icones/Notification.png" alt="">
    </a>
</header>

