<?php

require_once __DIR__ . '/Controller/AmizadeController.php';

include_once 'session.php';

$amizadeController = new AmizadeController();

$amizades = $amizadeController->readAllAmizadesByUsuario($_SESSION['usuario']->id);

?>


<section class="conteudo">
    <link rel="stylesheet" href="Style/NovoProjeto.css">
    <div id="divTitulo">
        <img id="btnVoltar" src="Icones/Voltar.png" alt="">
        <h1 class="mb-0">Novo projeto</h1>
    </div>
    <section class="sectionDetalhes" id="sectionDetalhes">
        <article class="articleDetalhes">
            <div class="input-group" id="divInputNome">
                <input type="text" id="inputNome" name="novoProjeto[nome]" placeholder=" ">
                <label for="inputNome">Nome</label>
            </div>
            <div class="textArea-group" id="divInputDescricao">
                <textarea type="text" id="textArea_descricao" placeholder=" "></textarea>
                <label for="textArea_descricao">Descrição</label>
            </div>
            <div class="select-group responsavel">
                <select id="select_responsavel">
                    <option value="" disabled selected>Selecione um responsável</option>
                    <option value="<?= $_SESSION['usuario']->id ?>"><?php echo $_SESSION['usuario']->usuario ?></option>
                    <?php foreach ($amizades as $amizade) : ?>
                        <option value="<?= $amizade->id ?>"><?php echo $amizade->usuario ?></option>
                    <?php endforeach; ?>
                </select>
                <label for="select_responsavel">Responsável</label>
            </div>
            <div class="input-group data">
                <input type="date" id="inputDataConclusao" placeholder=" ">
                <label for="inputDataConclusao">Data para conclusão</label>
            </div>
            <p id="info"></p>
            <div class="divCancelar_Concluir">
                <button id="btnCancelar">Cancelar</button>
                <button id="btnConcluir">Concluir</button>
            </div>
        </article>
    </section>
</section>
