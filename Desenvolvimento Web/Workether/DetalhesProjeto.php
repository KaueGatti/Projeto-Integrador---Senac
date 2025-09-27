<?php ?>


<section class="conteudo">
    <link rel="stylesheet" href="Style/DetalhesProjeto.css">
    <div id="divTitulo">
        <img onclick="voltar()" src="Icones/Voltar.png" alt="">
        <h1 class="mb-0">Detalhes do projeto</h1>
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
            <div class="divResponsavel_Participantes">
                <div class="input-group">
                    <input type="text" id="responsavel" name="responsavel" placeholder=" ">
                    <label for="descricao">Responsável</label>
                </div>
                <button>Participantes</button>
            </div>
            <div class="divDataConclusao_Tarefas">
                <div class="input-group">
                    <input type="text" id="dataConclusao" name="dataConclusao" placeholder=" ">
                    <label for="dataConclusao">Data para conclusão</label>
                </div>
                <button>Tarefas</button>
            </div>
            <div class="divChat_Equipes">
                <button id="btnChat">Chat</button>
                <button id="btnEquipes">Equipes</button>
            </div>
            <button id="btnComentarios">Comentários</button>
            <div class="divEditar_Salvar">
                <button id="btnEditar">Editar</button>
                <button id="btnSalvar">Salvar</button>
            </div>
        </article>
    </section>
</section>
