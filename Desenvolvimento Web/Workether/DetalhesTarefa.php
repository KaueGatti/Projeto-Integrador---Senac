<?php ?>


<section class="conteudo">
    <link rel="stylesheet" href="Style/DetalhesTarefa.css">
    <div id="divTitulo">
        <img src="Icones/Voltar.png" alt="">
        <h1 class="mb-0">Detalhes da tarefa</h1>
    </div>
    <section class="sectionDetalhes" id="sectionDetalhes">
        <article class="articleDetalhes">
            <div class="input-group" id="divInputNome">
                <input type="text" id="input_nome" placeholder=" ">
                <label for="input_nome">Nome</label>
            </div>
            <div class="textArea-group" id="divInputDescricao">
                <textarea id="textArea_descricao" placeholder=" "></textarea>
                <label for="textArea_descricao">Descrição</label>
            </div>
            <div class="divProjeto_Equipe">
                <div class="select-group divEquipe">
                    <select id="select_projeto"></select>
                    <label for="select_projeto">Projeto</label>
                </div>
                <div class="select-group divEquipe">
                    <select id="select_equipe"></select>
                    <label for="select_equipe">Equipe</label>
                </div>
            </div>
            <div class="select-group divResponsavel">
                <select id="select_responsavel"></select>
                <label for="select_responsavel">Responsável</label>
            </div>
            <div class="input-group divData">
                <input type="date" id="inputDataConclusao" placeholder=" ">
                <label for="inputDataConclusao">Data para conclusão</label>
            </div>
            <p id="info"></p>
            <div class="divEditar_Salvar">
                <button id="btnEditar">Editar</button>
                <button id="btnSalvar">Salvar</button>
            </div>
        </article>
    </section>
</section>
