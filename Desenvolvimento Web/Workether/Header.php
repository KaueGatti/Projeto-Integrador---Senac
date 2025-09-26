<?php ?>


<header>
    <link rel="stylesheet" href="Style/Header.css">
    <img id="iconeUserHeader" src="Icones/User.png" alt="">
    <p class="mb-0">Usuário: <?php echo $_SESSION['usuario']->usuario; ?></p>
    <button id="btnNotificacoes" >
        <img id="iconeNotificationHeader" src="Icones/Notification.png" alt="">
    </button>
</header>

