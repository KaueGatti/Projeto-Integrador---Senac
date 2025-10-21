<?php

require_once __DIR__ . '/Controller/ConversaController.php';
require_once __DIR__ . '/Controller/AmizadeController.php';

session_start();

$controller = new ConversaController();
$amizadeController = new AmizadeController();

$conversas = $controller->readConversasByUsuario($_SESSION['usuario']->id)['data'];
$amizades = $amizadeController->readAllAmizadesByUsuario($_SESSION['usuario']->id);

?>


<section class="conteudo">
    <link rel="stylesheet" href="Style/Conversas.css">
    <div id="divTitulo">
        <img id="btnVoltar" src="Icones/Voltar.png" alt="">
        <h1>Conversas</h1>
    </div>
    <div id="divPesquisa">
        <input type="text" id="inputPesquisa" placeholder="Pesquisar">
        <button id="btnNovaConversa">+ Nova Conversa</button>
    </div>
    <section class="sectionConversas" id="sectionConversas">
        <?php foreach ($conversas as $conversa) : ?>
            <article class="articleConversa" id="<?= $conversa->id ?>">
                <div id="divUsuario_Mensagem">
                    <h1><?= $conversa->usuario ?></h1>
                    <p>Última mensagem enviada...</p>
                </div>
                <div class="divHorario">
                    <p>20/02/2020</p>
                    <p>20:20</p>
                </div>
            </article>
        <?php endforeach; ?>
    </section>
    <div class="modal" id="modalConversas">
        <div class="divTitulo">
            <h1>Selecione o usuário</h1>
            <img id="btnFechar" src="Icones/Fechar.png" alt="">
        </div>
        <div class="select-group">
            <select id="select_usuario">
                <option value="" selected disabled>Selecione um usuário</option>
                <?php foreach ($amizades as $amizade) : ?>
                    <option value="<?= $amizade->id ?>"><?= $amizade->usuario ?></option>
                <?php endforeach; ?>
            </select>
            <label for="select_usuario">Usuário</label>
        </div>
        <p id="info"></p>
        <button id="btnAdicionarConversa">Adicionar conversa +</button>
    </div>
</section>
