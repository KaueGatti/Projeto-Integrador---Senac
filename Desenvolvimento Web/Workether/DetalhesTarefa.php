<?php ?>


<section class="conteudo">
    <link rel="stylesheet" href="Style/DetalhesTarefa.css">
    <div id="divTitulo">
        <img onclick="voltar()" src="Icones/Voltar.png" alt="">
        <h1 class="mb-0">Detalhes da tarefa</h1>
    </div>
    <section class="sectionDetalhes" id="sectionDetalhes">
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
                <button onclick="interactModal('modalComentarios', 'sectionDetalhes')">Comentários</button>
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

    <!-- Detalhes da Tarefa -> Comentários -->
    <div class="modal modalComentarios" id="modalComentarios">
        <div class="divTitulo" id="titulo">
            <h1>Comentários</h1>
            <img class="btnBack" onclick="interactModal('modalComentarios', 'sectionDetalhes')"
                 src="Icones/Fechar.png" alt="">
        </div>
        <button onclick="interactModal('modalAdicionarComentario', 'modalComentarios')"
                class="buttonGreen" id="btnAdicionarComentario">+ Adicionar comentário
        </button>
        <section class="sectionComentarios">
            <article class="articleComentario">
                <p class="textoComentario">Comentário...</p>
                <div class="divInfo">
                    <img class="imgRemover" src="Icones/Remover.png" alt="">
                    <p class="data">20/02/2020</p>
                    <p class="hora">18:20</p>
                    <div class="divUser">
                        <img src="Icones/User.png" alt="">
                        <p>Kauê</p>
                    </div>
                </div>
            </article>
        </section>
    </div>
    <div class="modal modalAdicionarComentario" id="modalAdicionarComentario">
        <h1 class="tituloModal">Novo comentário</h1>
        <div class="textArea-group">
            <textarea type="text" name="comentario" placeholder=" "></textArea>
            <label for="comentario">Comentário</label>
        </div>
        <div class="divCancelar_Adicionar">
            <button class="buttonRed" onclick="interactModal('modalAdicionarComentario', 'modalComentarios')">Cancelar
            </button>
            <button class="buttonGreen" onclick="adicionarComentario()">Adicionar</button>
        </div>
    </div>
    <!-- Detalhes da Tarefa -> Comentários -->
</section>
