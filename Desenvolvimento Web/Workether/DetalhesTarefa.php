<?php ?>


<section class="conteudo">
    <link rel="stylesheet" href="Style/DetalhesTarefa.css">
    <div id="divTitulo">
        <img id="btnVoltar" src="Icones/Voltar.png" alt="">
        <h1 class="mb-0">Detalhes da tarefa</h1>
    </div>
    <section class="sectionDetalhes" id="sectionDetalhes">
        <article class="articleDetalhes">
            <div class="input-group" id="divInputNome">
                <input type="text" id="input_nome" placeholder=" " disabled>
                <label for="input_nome">Nome</label>
            </div>
            <div class="textArea-group" id="divInputDescricao">
                <textarea id="textArea_descricao" placeholder=" " disabled></textarea>
                <label for="textArea_descricao">Descrição</label>
            </div>
            <div class="divProjeto_Equipe">
                <div class="input-group divProjeto">
                    <input id="input_projeto" disabled>
                    <label for="input_projeto">Projeto</label>
                </div>
                <div class="input-group divEquipe">
                    <input id="input_equipe" disabled>
                    <label for="input_equipe">Equipe</label>
                </div>
            </div>
            <div class="input-group divResponsavel">
                <input id="input_responsavel" disabled>
                <label for="input_responsavel">Responsável</label>
            </div>
            <div class="input-group divData">
                <input type="date" id="inputDataConclusao" placeholder=" " disabled>
                <label for="inputDataConclusao">Data para conclusão</label>
            </div>
            <p id="info"></p>
            <div class="divEditar_Salvar">
                <button id="btnEditar">Editar</button>
                <button id="btnSalvar" disabled>Salvar</button>
            </div>
        </article>
    </section>
</section>
