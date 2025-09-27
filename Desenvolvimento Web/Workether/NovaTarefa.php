<?php ?>


<section class="conteudo">
    <link rel="stylesheet" href="Style/NovaTarefa.css">
    <div id="divTitulo">
        <img onclick="voltar()" src="Icones/Voltar.png" alt="">
        <h1 class="mb-0">Nova tarefa</h1>
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
            <div class="input-group divProjeto">
                <input type="text" id="projeto" name="projeto" placeholder=" ">
                <label for="projeto">Projeto</label>
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
            <div class="divCancelar_Concluir">
                <button id="btnCancelar">Cancelar</button>
                <button id="btnConcluir">Concluir</button>
            </div>
        </article>
    </section>
</section>
