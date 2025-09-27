<?php ?>


<section class="conteudo">
    <link rel="stylesheet" href="Style/NovoProjeto.css">
    <div id="divTitulo">
        <img onclick="voltar()" src="Icones/Voltar.png" alt="">
        <h1 class="mb-0">Novo projeto</h1>
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
            <div class="input-group responsavel">
                <input type="text" id="responsavel" name="responsavel" placeholder=" ">
                <label for="descricao">Responsável</label>
            </div>
            <div class="input-group data">
                <input type="text" id="dataConclusao" name="dataConclusao" placeholder=" ">
                <label for="dataConclusao">Data para conclusão</label>
            </div>
            <button id="btnParticipantes">Participantes</button>
            <button id="btnEquipes">Equipes</button>
            <div class="divCancelar_Concluir">
                <button id="btnCancelar">Cancelar</button>
                <button id="btnConcluir">Concluir</button>
            </div>
        </article>
    </section>
</section>
