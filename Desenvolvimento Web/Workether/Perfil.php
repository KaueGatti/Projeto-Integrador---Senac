<?php

session_start();

?>


<section class="conteudo">
    <link rel="stylesheet" href="Style/Perfil.css">
    <div id="divTitulo">
        <img onclick="voltar()" src="Icones/Voltar.png" alt="">
        <h1 class="mb-0">Perfil</h1>
    </div>
    <input type="text" name="id" id="inputId" readonly value="<?php echo $_SESSION['usuario']->id; ?>">
    <div class="divInput">
        <input type="text" name="usuario" id="" readonly value="<?php echo $_SESSION['usuario']->usuario; ?>">
        <img src="Icones/Editar.png" alt="">
    </div>
    <div class="divInput">
        <input type="email" name="email" id="" readonly value="<?php echo $_SESSION['usuario']->email; ?>">
        <img src="Icones/Editar.png" alt="">
    </div>
    <a href="RedefinirSenha.php" id="btnAlterarSenha">Alterar senha</a>
    <div id="divDesativarConta">
        <button id="btnDesativarConta">Desativar conta</button>
        <img src="Icones/Atencao.png" alt="">
    </div>
</section>
