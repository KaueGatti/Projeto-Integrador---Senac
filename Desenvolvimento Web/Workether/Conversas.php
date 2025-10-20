<?php

require_once __DIR__ . '/Controller/ConversaController.php';

session_start();

$controller = new ConversaController();

$conversas = $controller->readConversasByUsuario($_SESSION['usuario']->id)['data'];

?>


<section class="conteudo">
    <link rel="stylesheet" href="Style/Conversas.css">
    <div id="divTitulo">
        <img onclick="voltar('PaginaInicial.php')" src="Icones/Voltar.png" alt="">
        <h1>Conversas</h1>
    </div>
    <div id="divPesquisa">
        <input type="text" name="pesquisa" id="inputPesquisa" placeholder="Pesquisar">
        <button>+ Nova Conversa</button>
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
            <img src="Icones/Fechar.png" alt="">
        </div>
        <div class="input-group">
            <input type="text" name="usuario" placeholder=" ">
            <label for="usuario">Usuário</label>
        </div>
        <button>Enviar convite <img src="Icones/Enviar.png" alt=""></button>
    </div>
</section>
