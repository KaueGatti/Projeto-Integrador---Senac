<?php

require_once __DIR__ . '/Controller/ProjetoController.php';

session_start();

$controllerProjeto = new ProjetoController();

$projetos = [];

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (isset($_POST[''])) {
    }
} else if ($_SERVER['REQUEST_METHOD'] == 'GET') {
    $projetos = $controllerProjeto->readProjectsByUsuario($_SESSION['usuario']->id);
}

?>


<section class="conteudo">
    <link rel="stylesheet" href="Style/NovaTarefa.css">
    <div id="divTitulo">
        <img id="btnVoltar" src="Icones/Voltar.png" alt="">
        <h1>Nova tarefa</h1>
    </div>
    <section class="sectionDetalhes">
        <article class="articleDetalhes">
            <div class="input-group" id="divInputNome">
                <input type="text" id="input_nome" placeholder=" ">
                <label for="input_nome">Nome</label>
            </div>
            <div class="textArea-group" id="divInputDescricao">
                <textarea id="textArea_descricao" placeholder=" "></textarea>
                <label for="textArea_descricao">Descrição</label>
            </div>
            <div id="divProjeto_Equipe">
                <div class="select-group divProjeto">
                    <select id="select_projeto">
                        <option value="" disabled selected>Selecione um projeto</option>
                        <?php foreach ($projetos as $projeto) : ?>
                            <option value="<?= $projeto->id ?>"><?= $projeto->nome ?></option>
                        <?php endforeach; ?>
                    </select>
                    <label for="select_projeto">Projeto</label>
                </div>
                <div class="select-group divEquipe">
                    <select id="select_equipe">
                        <option value="" disabled selected>Selecione uma equipe</option>
                        <option value="0">Sem equipe</option>
                    </select>
                    <label for="select_equipe">Equipe</label>
                </div>
            </div>

            <div class="select-group divResponsavel">
                <select id="select_responsavel">
                    <option value="" disabled selected>Selecione um responsável</option>
                    <option value="<?= $_SESSION['usuario']->id ?>"><?= $_SESSION['usuario']->usuario ?></option>
                </select>
                <label for="select_responsavel">Responsável</label>
            </div>
            <div class="input-group divData">
                <input type="date" id="inputDataConclusao" placeholder=" ">
                <label for="inputDataConclusao">Data para conclusão</label>
            </div>
            <p id="info">Texto teste para testar no teste</p>
            <div class="divCancelar_Concluir">
                <button id="btnCancelar">Cancelar</button>
                <button id="btnConcluir">Concluir</button>
            </div>
        </article>
    </section>
</section>
