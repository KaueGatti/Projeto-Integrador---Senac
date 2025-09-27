<?php ?>


<section class="conteudo">
    <link rel="stylesheet" href="Style/Amigos.css">
    <div id="divTitulo">
        <img onclick="voltar()" src="Icones/Voltar.png" alt="">
        <h1 class="mb-0">Amigos</h1>
    </div>
    <div id="divPesquisa">
        <input type="text" name="pesquisa" id="inputPesquisa" placeholder="Pesquisar">
        <button onclick="interactModal('modalAmigos', 'sectionAmigos')">+ Adicionar amigo</button>
    </div>
    <section class="sectionAmigos" id="sectionAmigos">
        <article class="articleAmigo">
            <img src="Icones/Amigo.png" alt="">
            <h1 class="mb-0">Gustavo</h1>
            <p class="pID mb-0">ID: 12DB7Q8</p>
        </article>
        <article class="articleAmigo">
            <img src="Icones/Amigo.png" alt="">
            <h1 class="mb-0">Gustavo</h1>
            <p class="pID mb-0">ID: 12DB7Q8</p>
        </article>
        <article class="articleAmigo">
            <img src="Icones/Amigo.png" alt="">
            <h1 class="mb-0">Gustavo</h1>
            <p class="pID mb-0">ID: 12DB7Q8</p>
        </article>
        <article class="articleAmigo">
            <img src="Icones/Amigo.png" alt="">
            <h1 class="mb-0">Gustavo</h1>
            <p class="pID mb-0">ID: 12DB7Q8</p>
        </article>
        <article class="articleAmigo">
            <img src="Icones/Amigo.png" alt="">
            <h1 class="mb-0">Gustavo</h1>
            <p class="pID mb-0">ID: 12DB7Q8</p>
        </article>
        <article class="articleAmigo">
            <img src="Icones/Amigo.png" alt="">
            <h1 class="mb-0">Gustavo</h1>
            <p class="pID mb-0">ID: 12DB7Q8</p>
        </article>
        <article class="articleAmigo">
            <img src="Icones/Amigo.png" alt="">
            <h1 class="mb-0">Gustavo</h1>
            <p class="pID mb-0">ID: 12DB7Q8</p>
        </article>
        <article class="articleAmigo">
            <img src="Icones/Amigo.png" alt="">
            <h1 class="mb-0">Gustavo</h1>
            <p class="pID mb-0">ID: 12DB7Q8</p>
        </article>
    </section>
    <div class="modal" id="modalAmigos">
        <div class="divTitulo">
            <h1>Adicionar amigo</h1>
            <img onclick="interactModal('modalAmigos', 'sectionAmigos')" src="Icones/Fechar.png" alt="">
        </div>
        <p>Insira o ID do usuário</p>
        <div class="input-group">
            <input type="text" name="id" placeholder=" ">
            <label for="id">ID</label>
        </div>
        <button onclick="enviarConviteAmigo()">Enviar convite <img src="Icones/Enviar.png" alt=""</button>
    </div>
</section>
