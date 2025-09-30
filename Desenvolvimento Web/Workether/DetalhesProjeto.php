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

    <!-- Detalhes do Projeto -> Participantes -->
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
    <!-- Detalhes do Projeto -> Participantes -->

    <!-- Detalhes do Projeto -> Comentários -->
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
            <button class="buttonRed" onclick="interactModal('modalAdicionarComentario', 'modalComentarios')">Cancelar
            </button>
            <button class="buttonGreen" onclick="adicionarComentario()">Adicionar</button>
        </div>
    </div>
    <!-- Detalhes do Projeto -> Comentários -->

    <!-- Detalhes do Projeto -> Equipes -->
    <div class="modal modalEquipes" id="modalEquipes">
        <div class="divTitulo">
            <h1>Equipes</h1>
            <img class="btnBack" onclick="interactModal('modalEquipes', 'sectionDetalhes')" src="Icones/Fechar.png"
                 alt="">
        </div>
        <button onclick="interactModal('modalAdicionarEquipe', 'modalEquipes')"
                class="btnAdicionarEquipe">+ Adicionar equipe
        </button>
        <section class="sectionEquipes">
            <article onclick="interactModal('modalDetalhesEquipe', 'modalEquipes')" class="articleEquipe">
                <p>Equipe do Kauê</p>
                <img src="Icones/Remover.png" alt="">
            </article>
        </section>
    </div>
    <div class="modal modalAdicionarEquipe" id="modalAdicionarEquipe">
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
    <!-- Detalhes do Projeto -> Equipes -->

    <!-- Detalhes do Projeto -> Equipes -> Detalhes da Equipe -->
    <div class="modal modalDetalhesEquipe" id="modalDetalhesEquipe">
        <div class="divTitulo">
            <h1>Detalhes da equipe</h1>
            <img class="btnBack" onclick="interactModal('modalDetalhesEquipe', 'modalEquipes')" src="Icones/Fechar.png"
                 alt="">
        </div>
        <div class="input-group" id="inputNome">
            <input type="text" name="nome" placeholder=" " readonly>
            <label for="nome">Nome</label>
        </div>
        <div class="textArea-group" id="textArea-descricao">
            <textarea type="text" name="descricao" placeholder=" " readonly></textarea>
            <label for="descricao">Descrição</label>
        </div>
        <div class="grid">
            <div class="input-group" id="inputResponsavel">
                <input type="text" placeholder=" ">
                <label for="">Responsável</label>
            </div>
            <button onclick="interactModal('modalParticipantesDetalhesEquipe', 'modalDetalhesEquipe')" class="buttonOrange">Participantes</button>
            <button class="buttonGray">Chat</button>
            <button onclick="loadTarefas()" class="buttonOrange">Tarefas</button>
            <button onclick="interactModal('modalComentariosDetalhesEquipe', 'modalDetalhesEquipe')" class="buttonOrange" id="btnComentarios">Comentários</button>
        </div>
        <div class="divEditar_Salvar">
            <button class="buttonBlue">Editar</button>
            <button class="buttonGreen">Salvar</button>
        </div>
    </div>
    <!-- Detalhes do Projeto -> Equipes -> Detalhes da Equipe -->

    <!-- Detalhes do Projeto -> Equipes -> Detalhes da Equipe -> Participantes -->
    <div class="modal modalParticipantes" id="modalParticipantesDetalhesEquipe">
        <div class="divTitulo">
            <h1>Participantes</h1>
            <img class="btnBack" onclick="interactModal('modalParticipantesDetalhesEquipe', 'modalDetalhesEquipe')"
                 src="Icones/Fechar.png" alt="">
        </div>
        <button onclick="interactModal('modalAdicionarParticipanteDetalhesEquipe', 'modalParticipantesDetalhesEquipe')"
                class="btnAdicionarParticipantes">+ Adicionar participante
        </button>
        <section class="sectionParticipantes">
            <article class="articleParticipante">
                <p>Kauê</p>
                <img src="Icones/Remover.png" alt="">
            </article>
        </section>
    </div>
    <div class="modal modalAdicionarParticipante" id="modalAdicionarParticipanteDetalhesEquipe">
        <div class="divTitulo">
            <h1>Adicionar participantes</h1>
            <img class="btnBack" onclick="interactModal('modalAdicionarParticipanteDetalhesEquipe', 'modalParticipantesDetalhesEquipe')"
                 src="Icones/Fechar.png"
                 alt="">
        </div>
        <div class="input-group">
            <input type="text" name="usuario" placeholder=" ">
            <label for="usuario">Usuário</label>
        </div>
        <button onclick="adicionarParticipante()">Adicionar</button>
    </div>
    <!-- Detalhes do Projeto -> Equipes -> Detalhes da Equipe -> Participantes -->

    <!-- Detalhes do Projeto -> Equipes -> Detalhes da Equipe -> Comentários -->
    <div class="modal modalComentarios" id="modalComentariosDetalhesEquipe">
        <div class="divTitulo">
            <h1>Comentários</h1>
            <img class="btnBack" onclick="interactModal('modalComentariosDetalhesEquipe', 'modalDetalhesEquipe')"
                 src="Icones/Fechar.png" alt="">
        </div>
        <button onclick="interactModal('modalAdicionarComentarioDetalhesEquipe', 'modalComentariosDetalhesEquipe')"
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
    <div class="modal modalAdicionarComentario" id="modalAdicionarComentarioDetalhesEquipe">
        <h1 class="tituloModal">Novo comentário</h1>
        <div class="textArea-group">
            <textarea type="text" name="comentario" placeholder=" "></textArea>
            <label for="comentario">Comentário</label>
        </div>
        <div class="divCancelar_Adicionar">
            <button class="buttonRed" onclick="interactModal('modalAdicionarComentarioDetalhesEquipe', 'modalComentariosDetalhesEquipe')">Cancelar
            </button>
            <button class="buttonGreen" onclick="adicionarComentario()">Adicionar</button>
        </div>
    </div>
    <!-- Detalhes do Projeto -> Equipes -> Detalhes da Equipe -> Comentários -->

    <!-- Detalhes do Projeto -> Equipes -> Participantes -->
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
    <!-- Detalhes do Projeto -> Equipes -> Participantes -->
</section>
