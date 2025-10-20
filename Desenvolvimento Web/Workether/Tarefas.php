<?php

require_once __DIR__ . '/Controller/TarefaController.php';

session_start();

$controller = new TarefaController();

$tarefas = [];

if ($_SERVER["REQUEST_METHOD"] == "GET") {
    $tarefas = $controller->readTarefasByUsuario($_SESSION['usuario']->id)['data'];
} else if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (isset($_POST["id_projeto"])) {
        $tarefas = $controller->readTarefasByProjeto($_POST['id_projeto'])['data'];
    }
}

?>


<section class="conteudo">
    <link rel="stylesheet" href="Style/Tarefas.css">
    <div id="divTitulo">
        <img id="btnVoltar" src="Icones/Voltar.png" alt="">
        <h1>Tarefas</h1>
    </div>
    <div id="divPesquisa">
        <input type="text" name="pesquisa" id="inputPesquisa" placeholder="Pesquisar">
        <label for="inputPesquisa" hidden></label>
        <button id="btnNovaTarefa">+ Nova Tarefa</button>
    </div>
    <section class="sectionTarefas">
        <?php foreach ($tarefas as $tarefa) : ?>
            <article class="articleTarefa" id="<?= $tarefa->id ?>">
                <h1 id="nome_tarefa"><?= $tarefa->nome ?></h1>
                <p class="pDescricao"><?= $tarefa->descricao ?></p>
                <p class="pData">Data para conclusão: <?= $tarefa->dataAtualConclusao ?></p>
                <div class="divStatus">
                    <img src="Icones/User.png" alt="">
                    <p class="pResponsavel"><?= $tarefa->usuario_responsavel ?></p>
                    <p class="pStatus" id="pEmAndamento"><?= $tarefa->status ?></p>
                </div>
            </article>
        <?php endforeach; ?>
    </section>
</section>
