<?php

require_once __DIR__ . '/Controller/TarefaController.php';

session_start();

$controller = new TarefaController();

$tarefasEmAndamento = [];
$tarefasConcluidas = [];
$tarefasAtrasadas = [];

if ($_SERVER["REQUEST_METHOD"] == "GET") {
    $tarefas = $controller->readTarefasByUsuario($_SESSION['usuario']->id)['data'];
} else if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (isset($_POST["id_projeto"])) {
        $tarefas = $controller->readTarefasByProjeto($_POST['id_projeto'])['data'];
    }
}

foreach ($tarefas as $tarefa) {
    if ($tarefa->status == 'Concluida') {
        array_push($tarefasConcluidas, $tarefa);
    }

    if ($tarefa->status == 'Atrasada') {
        array_push($tarefasAtrasadas, $tarefa);
    }

    if ($tarefa->status == 'Em andamento') {
        array_push($tarefasEmAndamento, $tarefa);
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
        <button id="btnNovaTarefa">+ Nova Tarefa</button>
    </div>
    <?php if (count($tarefas) == 0): ?>
        <p id="info">Você não possui nenhuma tarefa</p>
    <?php endif;?>
    <section class="sectionTarefas">
        <?php foreach ($tarefasAtrasadas as $tarefa) : ?>
            <article class="articleTarefa" id="<?= $tarefa->id ?>">
                <h1 id="nome_tarefa"><?= $tarefa->nome ?></h1>
                <p class="pDescricao"><?= $tarefa->descricao ?></p>
                <p class="pData">Data para conclusão: <?= DateTime::createFromFormat('Y-m-d', $tarefa->dataAtualConclusao)->format('d/m/Y'); ?></p>
                <div class="divStatus">
                    <img src="Icones/User.png" alt="">
                    <p class="pResponsavel"><?= $tarefa->usuario_responsavel ?></p>
                    <p class="pStatus" id="pAtrasado"><?= $tarefa->status ?></p>
                </div>
            </article>
        <?php endforeach; ?>
        <?php foreach ($tarefasEmAndamento as $tarefa) : ?>
            <article class="articleTarefa" id="<?= $tarefa->id ?>">
                <h1 id="nome_tarefa"><?= $tarefa->nome ?></h1>
                <p class="pDescricao"><?= $tarefa->descricao ?></p>
                <p class="pData">Data para conclusão: <?= DateTime::createFromFormat('Y-m-d', $tarefa->dataAtualConclusao)->format('d/m/Y'); ?></p>
                <div class="divStatus">
                    <img src="Icones/User.png" alt="">
                    <p class="pResponsavel"><?= $tarefa->usuario_responsavel ?></p>
                    <p class="pStatus" id="pEmAndamento"><?= $tarefa->status ?></p>
                </div>
            </article>
        <?php endforeach; ?>
        <?php foreach ($tarefasConcluidas as $tarefa) : ?>
            <article class="articleTarefa" id="<?= $tarefa->id ?>">
                <h1 id="nome_tarefa"><?= $tarefa->nome ?></h1>
                <p class="pDescricao"><?= $tarefa->descricao ?></p>
                <p class="pData">Data de conclusão: <?= DateTime::createFromFormat('Y-m-d', $tarefa->dataConclusao)->format('d/m/Y'); ?></p>
                <div class="divStatus">
                    <img src="Icones/User.png" alt="">
                    <p class="pResponsavel"><?= $tarefa->usuario_responsavel ?></p>
                    <p class="pStatus" id="pConcluido"><?= $tarefa->status ?></p>
                </div>
            </article>
        <?php endforeach; ?>
    </section>
</section>
