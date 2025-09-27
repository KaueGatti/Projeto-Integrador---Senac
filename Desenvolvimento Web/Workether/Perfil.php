<?php

session_start();

?>


<section class="conteudo">
    <link rel="stylesheet" href="Style/Perfil.css">
    <div id="divTitulo">
        <img onclick="voltar()" src="Icones/Voltar.png" alt="">
        <h1>Perfil</h1>
    </div>
    <div class="input-group" id="divID">
        <input type="text" name="id" id="inputId" readonly value="<?php echo $_SESSION['usuario']->id; ?>">
        <label for="id">ID</label>
    </div>
    <div class="divInput">
        <div class="input-group">
            <input type="text" name="usuario" id="" readonly value="<?php echo $_SESSION['usuario']->usuario; ?>">
            <label for="usuario">Usuário</label>
        </div>
        <img src="Icones/Editar.png" alt="">
    </div>
    <div class="divInput">
        <div class="input-group">
            <input type="email" name="email" id="" readonly value="<?php echo $_SESSION['usuario']->email; ?>">
            <label for="email">E-mail</label>
        </div>
        <img src="Icones/Editar.png" alt="">
    </div>
    <a href="RedefinirSenha.php" id="btnAlterarSenha">Alterar senha</a>
</section>
