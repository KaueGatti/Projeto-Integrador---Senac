<?php

require_once __DIR__ . "/Controller/ProjetoController.php";
require_once __DIR__ . "/Model/Projeto.php";

$controller = new ProjetoController();
$warning = false;

include_once __DIR__ . "/session.php";

$projects = $controller->readProjectsByUsuario($_SESSION['usuario']->id);

if (count($projects) == 0) {
    $warning = "Você não tem nenhum projeto no momento";
}

?>


<section class="conteudo">
    <link rel="stylesheet" href="Style/Projetos.css">
    <div id="divTitulo">
        <img id="btnVoltar" src="Icones/Voltar.png" alt="">
        <h1>Projetos</h1>
    </div>
    <div id="divPesquisa">
        <button id="btnAdicionarProjeto">+ Novo Projeto</button>
    </div>
    <section class="sectionProjetos">
        <?php if ($warning) { echo "<p class=\"pWarning\">$warning</p>";} ?>
        <?php foreach ($projects as $project) :?>
            <article class="articleProjeto" id="<?= $project->id ?>">
                <div class="divTitulo">
                    <h1><?= $project->nome ?></h1>
                    <p><?= $project->descricao ?></p>
                </div>
                <div class="divInfo">
                    <p class="pData">Data para conclusão: <?= $project->dataAtualConclusao ?></p>
                    <div class="divResponsavel">
                        <img src="Icones/User.png" alt="">
                        <p><?= $project->usuario_responsavel ?></p>
                    </div>
                    <p class="pEmAndamento pStatus"><?= $project->status ?></p>
                </div>
            </article>
        <?php endforeach;?>
    </section>
</section>
