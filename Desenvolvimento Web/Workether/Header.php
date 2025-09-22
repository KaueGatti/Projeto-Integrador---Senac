<?php ?>

<link rel="stylesheet" href="Style/Header.css">

<header>
    <img id="iconeUserHeader" src="Icones/User.png" alt="">
    <p>Usuário: <?php echo $_SESSION['usuario']->usuario; ?></p>
    <img id="iconeNotificationHeader" src="Icones/Notification.png" alt="">
</header>

