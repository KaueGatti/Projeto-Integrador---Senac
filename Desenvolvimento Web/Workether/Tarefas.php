<?php

?>


<section class="conteudo">
    <link rel="stylesheet" href="Style/Tarefas.css">
    <div id="divTitulo">
        <img onclick="voltar('PaginaInicial.php')" src="Icones/Voltar.png" alt="">
        <h1 class="mb-0">Tarefas</h1>
    </div>
    <div id="divPesquisa">
        <input type="text" name="pesquisa" id="inputPesquisa" placeholder="Pesquisar">
        <label for="inputPesquisa" hidden></label>
        <button id="btnNovaTarefa">+ Nova Tarefa</button>
    </div>
    <section class="sectionTarefas">
        <article onclick="detalhes('Tarefa')" class="articleTarefa">
            <h1 class="mb-0">Tarefa</h1>
            <p class="pDescricao mb-0">Descrição do projeto</p>
            <p class="pData mb-0">Data para conclusão: 20/02/2020</p>
            <div class="divStatus">
                <img src="Icones/User.png" alt="">
                <p class="pResponsavel mb-0">Kauê</p>
                <p class="pStatus mb-0" id="pEmAndamento">Em andamento</p>
            </div>
        </article>
    </section>
</section>
