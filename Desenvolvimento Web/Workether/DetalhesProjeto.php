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
                <button>Tarefas</button>
            </div>
            <div class="divChat_Equipes">
                <button id="btnChat">Chat</button>
                <button onclick="interactModal('modalEquipes', 'sectionDetalhes')" id="btnEquipes">Equipes</button>
            </div>
            <div>
                <div id="space"></div>
                <button id="btnComentarios">Comentários</button>

            </div>
            <div class="divEditar_Salvar">
                <button id="btnEditar">Editar</button>
                <button id="btnSalvar">Salvar</button>
            </div>
        </article>
    </section>
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
        <div class="input-group input-descricao">
            <input type="text" id="descricao" placeholder=" ">
            <label for="nome">Descrição</label>
        </div>
        <div class="input-group input-responsavel">
            <input type="text" id="responsavel" placeholder=" ">
            <label for="nome">Responsável</label>
        </div>
        <button onclick="interactModal('modalParticipantes', 'modalAdicionarEquipe')" class="btnParticipantes">Participantes</button>
        <div class="divCancelar_Concluir">
            <button onclick="interactModal('modalAdicionarEquipe', 'modalEquipes')" class="buttonRed" id="btnCancelar">Cancelar</button>
            <button class="buttonGreen" id="btnConcluir">Concluir</button>
        </div>
    </div>
    <div class="modal" id="modalParticipantes">
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
    <div class="modal" id="modalAdicionarParticipante">
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
</section>
