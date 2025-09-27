<?php ?>


<section class="conteudo">
    <link rel="stylesheet" href="Style/DetalhesTarefa.css">
    <div id="divTitulo">
        <img onclick="voltar()" src="Icones/Voltar.png" alt="">
        <h1 class="mb-0">Detalhes da tarefa</h1>
    </div>
    <section class="sectionDetalhes">
        <article class="articleDetalhes">
            <div class="input-group" id="divInputNome">
                <input type="text" id="nome" name="nome" placeholder=" ">
                <label for="nome">Nome</label>
            </div>
            <div class="textArea-group" id="divInputDescricao">
                <textarea type="text" id="descricao" name="descricao" placeholder=" "></textarea>
                <label for="descricao">Descrição</label>
            </div>
            <div class="divProjeto_Comentarios">
                <div class="input-group">
                    <input type="text" id="projeto" name="projeto" placeholder=" ">
                    <label for="projeto">Projeto</label>
                </div>
                <button>Comentários</button>
            </div>
            <div class="input-group divEquipe">
                <input type="text" id="inputEquipe" name="equipe" placeholder=" ">
                <label for="equipe">Equipe</label>
            </div>
            <div class="input-group divResponsavel">
                <input type="text" id="inputResponsavel" name="responsavel" placeholder=" ">
                <label for="responsavel">Responsável</label>
            </div>
            <div class="input-group divData">
                <input type="text" id="inputData" name="dataConclusao" placeholder=" ">
                <label for="dataConclusao">Data para conclusão</label>
            </div>
            <div class="divEditar_Salvar">
                <button id="btnEditar">Editar</button>
                <button id="btnSalvar">Salvar</button>
            </div>
        </article>
    </section>
</section>
