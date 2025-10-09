<?php

require_once __DIR__ . '/Controller/AmizadeController.php';

session_start();

$controller = new AmizadeController();

$amizades = $controller->readAllAmizadesByUsuario($_SESSION['usuario']->id);

?>


<section class="conteudo">
    <link rel="stylesheet" href="Style/Amigos.css">
    <div id="divTitulo">
        <img id="btnVoltar" src="Icones/Voltar.png" alt="">
        <h1>Amigos</h1>
    </div>
    <div id="divPesquisa">
        <input type="text" name="pesquisa" id="inputPesquisa" placeholder="Pesquisar">
        <button id="btnAddAmigo">+ Adicionar amigo</button>
    </div>
    <section class="sectionAmigos" id="sectionAmigos">
        <p id="id_usuario" hidden><?= $_SESSION['usuario']->id ?></p>
        <p id="usuario" hidden><?= $_SESSION['usuario']->usuario ?></p>
        <?php if (empty($amizades)) echo '<p id="info">Você ainda não tem nenhum amigo</p>'?>
        <?php foreach ($amizades as $amizade) : ?>
            <article class="articleAmigo">
                <img src="Icones/Amigo.png" alt="">
                <h1><?= $amizade->usuario ?></h1>
                <p class="pID">ID: <?= $amizade->id ?></p>
            </article>
        <?php endforeach; ?>
    </section>
    <div class="modal" id="modalAmigos">
        <div class="divTitulo">
            <h1>Adicionar amigo</h1>
            <img id="btnFechar" src="Icones/Fechar.png" alt="">
        </div>
        <p>Insira o ID do usuário</p>
        <p id="info"></p>
        <div class="input-group">
            <input id="inputIdUsuario" type="text" name="id" placeholder=" ">
            <label for="id">ID</label>
        </div>
        <button id="btnEnviarConvite">
            <p>Enviar convite</p>
            <img src="Icones/Enviar.png" alt="">
            <div id="progress_bar"></div>
        </button>
    </div>
</section>
