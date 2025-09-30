<?php ?>


<section class="conteudo">
    <link rel="stylesheet" href="Style/DetalhesProjeto.css">
    <div id="divTitulo">
        <img class="btnBack" onclick="voltar()" src="Icones/Voltar.png" alt="">
        <h1 class="mb-0">Detalhes do projeto</h1>
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
            <div class="divResponsavel_Participantes">
                <div class="input-group">
                    <input type="text" id="responsavel" name="responsavel" placeholder=" ">
                    <label for="descricao">Responsável</label>
                </div>
                <button onclick="interactModal('modalParticipantes', 'sectionDetalhes')">Participantes</button>
            </div>
            <div class="divDataConclusao_Tarefas">
                <div class="input-group">
                    <input type="text" id="dataConclusao" name="dataConclusao" placeholder=" ">
                    <label for="dataConclusao">Data para conclusão</label>
                </div>
                <button onclick="loadTarefas()">Tarefas</button>
            </div>
            <div class="divChat_Equipes">
                <button id="btnChat">Chat</button>
                <button onclick="interactModal('modalEquipes', 'sectionDetalhes')" id="btnEquipes">Equipes</button>
            </div>
            <div>
                <div id="space"></div>
                <button onclick="interactModal('modalComentarios', 'sectionDetalhes')" id="btnComentarios">Comentários
                </button>
            </div>
            <div class="divEditar_Salvar">
                <button id="btnEditar">Editar</button>
                <button id="btnSalvar">Salvar</button>
            </div>
        </article>
    </section>

    <!-- Modal Participante -> Projeto -->
    <div class="modal modalParticipantes" id="modalParticipantes">
        <div class="divTitulo">
            <h1>Participantes</h1>
            <img class="btnBack" onclick="interactModal('modalParticipantes', 'sectionDetalhes')"
                 src="Icones/Fechar.png" alt="">
        </div>
        <button onclick="interactModal('modalAdicionarParticipante', 'modalParticipantes')"
                class="btnAdicionarParticipantes">+ Adicionar participante
        </button>
        <section class="sectionParticipantes">
            <article class="articleParticipante">
                <p>Kauê</p>
                <img src="Icones/Remover.png" alt="">
            </article>
        </section>
    </div>
    <div class="modal modalAdicionarParticipante" id="modalAdicionarParticipante">
        <div class="divTitulo">
            <h1>Adicionar participantes</h1>
            <img class="btnBack" onclick="interactModal('modalAdicionarParticipante', 'modalParticipantes')"
                 src="Icones/Fechar.png"
                 alt="">
        </div>
        <div class="input-group">
            <input type="text" name="usuario" placeholder=" ">
            <label for="usuario">Usuário</label>
        </div>
        <button onclick="adicionarParticipante()">Adicionar</button>
    </div>
    <!-- Modal Participante -> Projeto -->

    <!-- Modal Comentário -> Projeto -->
    <div class="modal modalComentarios" id="modalComentarios">
        <div class="divTitulo">
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
            <button class="buttonRed" onclick="interactModal('modalAdicionarComentario', 'modalComentarios')">Cancelar</button>
            <button class="buttonGreen" onclick="adicionarComentario()">Adicionar</button>
        </div>
    </div>
    <!-- Modal Comentário -> Projeto -->

    <!-- Modal Equipe -->
    <div class="modal" id="modalEquipes">
        <div class="divTitulo">
            <h1>Equipes</h1>
            <img class="btnBack" onclick="interactModal('modalEquipes', 'sectionDetalhes')" src="Icones/Fechar.png"
                 alt="">
        </div>
        <button onclick="interactModal('modalAdicionarEquipe', 'modalEquipes')"
                class="btnAdicionarEquipe">+ Adicionar equipe
        </button>
        <section class="sectionEquipes">
            <article class="articleEquipes">
                <p>Equipe do Kauê</p>
                <img src="Icones/Remover.png" alt="">
            </article>
        </section>
    </div>
    <div class="modal" id="modalAdicionarEquipe">
        <h1 class="tituloModal">Nova Equipe</h1>
        <div class="input-group input-nome">
            <input type="text" id="nome" placeholder=" ">
            <label for="nome">Nome</label>
        </div>
        <div class="textArea-group textArea-descricao">
            <textarea type="text" id="descricao" placeholder=" "></textarea>
            <label for="nome">Descrição</label>
        </div>
        <div class="input-group input-responsavel">
            <input type="text" id="responsavel" placeholder=" ">
            <label for="nome">Responsável</label>
        </div>
        <button onclick="interactModal('modalParticipantesEquipe', 'modalAdicionarEquipe')" class="btnParticipantes">
            Participantes
        </button>
        <div class="divCancelar_Concluir">
            <button onclick="interactModal('modalAdicionarEquipe', 'modalEquipes')" class="buttonRed" id="btnCancelar">
                Cancelar
            </button>
            <button class="buttonGreen" id="btnConcluir">Concluir</button>
        </div>
    </div>
    <!-- Modal Equipe -->

    <!-- Modal Participante -> Equipe -->
    <div class="modal modalParticipantes" id="modalParticipantesEquipe">
        <div class="divTitulo">
            <h1>Participantes</h1>
            <img class="btnBack" onclick="interactModal('modalParticipantesEquipe', 'modalAdicionarEquipe')"
                 src="Icones/Fechar.png" alt="">
        </div>
        <button onclick="interactModal('modalAdicionarParticipanteEquipe', 'modalParticipantesEquipe')"
                class="btnAdicionarParticipantes">+ Adicionar participante
        </button>
        <section class="sectionParticipantes">
            <article class="articleParticipante">
                <p>Kauê</p>
                <img src="Icones/Remover.png" alt="">
            </article>
        </section>
    </div>
    <div class="modal modalAdicionarParticipante" id="modalAdicionarParticipanteEquipe">
        <div class="divTitulo">
            <h1>Adicionar participantes</h1>
            <img class="btnBack" onclick="interactModal('modalAdicionarParticipanteEquipe', 'modalParticipantesEquipe')"
                 src="Icones/Fechar.png"
                 alt="">
        </div>
        <div class="input-group">
            <input type="text" name="usuario" placeholder=" ">
            <label for="usuario">Usuário</label>
        </div>
        <button onclick="adicionarParticipante()">Adicionar</button>
    </div>
    <!-- Modal Participante -> Equipe -->
</section>
