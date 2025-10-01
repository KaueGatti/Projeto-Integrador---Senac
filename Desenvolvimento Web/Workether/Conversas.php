<?php ?>


<section class="conteudo">
    <link rel="stylesheet" href="Style/Conversas.css">
    <div id="divTitulo">
        <img onclick="voltar('PaginaInicial.php')" src="Icones/Voltar.png" alt="">
        <h1>Conversas</h1>
    </div>
    <div id="divPesquisa">
        <input type="text" name="pesquisa" id="inputPesquisa" placeholder="Pesquisar">
        <button onclick="interactModal('modalConversas', 'sectionConversas')">+ Nova Conversa</button>
    </div>
    <section class="sectionConversas" id="sectionConversas">
        <article onclick="abrirConversa_Chat()" class="articleConversa">
            <h1 class="mb-0">Guilherme</h1>
            <p class="mb-0">Última mensagem enviada...</p>
            <div class="divHorario">
                <p class="mb-0">20/02/2020</p>
                <p class="mb-0">20:20</p>
            </div>
        </article>
    </section>
    <div class="modal" id="modalConversas">
        <div class="divTitulo">
            <h1>Selecione o usuário</h1>
            <img onclick="interactModal('modalConversas', 'sectionConversas')" src="Icones/Fechar.png" alt="">
        </div>
        <div class="input-group">
            <input type="text" name="usuario" placeholder=" ">
            <label for="usuario">Usuário</label>
        </div>
        <button onclick="enviarConviteConversa()">Enviar convite <img src="Icones/Enviar.png" alt=""</button>
    </div>
</section>
