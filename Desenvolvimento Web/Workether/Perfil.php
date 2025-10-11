<?php

session_start();

?>


<section class="conteudo">
    <link rel="stylesheet" href="Style/Perfil.css">
    <div id="divTitulo">
        <img onclick="voltar('PaginaInicial.php')" src="Icones/Voltar.png" alt="">
        <h1>Perfil</h1>
    </div>
    <div class="input-group" id="divID">
        <input type="text" name="id" id="inputId" readonly value="<?php echo $_SESSION['usuario']->id; ?>">
        <label for="id">ID</label>
    </div>
    <div class="divInput">
        <div class="input-group">
            <input type="text" id="input_usuario" readonly value="<?php echo $_SESSION['usuario']->usuario; ?>">
            <label for="input_usuario">Usuário</label>
        </div>
        <img id="IconEditarUsuario" src="Icones/Editar.png" alt="">
        <button class="buttonRed" id="btnCancelar" hidden>Cancelar</button>
        <button class="buttonBlue" id="btnAtualizarUsuario" hidden>Atualizar</button>
    </div>
    <p id="infoUsuario"></p>
    <div class="divInput">
        <div class="input-group">
            <input type="email" id="input_email" readonly value="<?php echo $_SESSION['usuario']->email; ?>">
            <label for="input_email">E-mail</label>
        </div>
    </div>
    <a class="buttonBlue" href="RedefinirSenha.php" id="btnAlterarSenha">Alterar senha</a>
</section>
