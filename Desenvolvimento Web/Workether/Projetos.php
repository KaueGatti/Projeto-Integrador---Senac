<?php ?>


<section class="conteudo">
    <link rel="stylesheet" href="Style/Projetos.css">
    <div id="divTitulo">
        <img onclick="voltar()" src="Icones/Voltar.png" alt="">
        <h1>Projetos</h1>
    </div>
    <div id="divPesquisa">
        <input type="text" name="pesquisa" id="inputPesquisa" placeholder="Pesquisar">
        <button>+ Novo Projeto</button>
    </div>
    <section class="sectionProjetos">
        <article onclick="detalhes('Projeto')" class="articleProjeto">
            <div class="divTitulo">
                <h1 class="mb-0">Nome do projeto</h1>
                <p class="mb-0">Descrição do projeto...</p>
            </div>
            <div class="divInfo">
                <p class="pData mb-0">Data para conclusão: 20/02/2020</p>
                <div class="divResponsavel">
                    <img src="Icones/User.png" alt="">
                    <p class="mb-0">Kauê</p>
                </div>
                <p class="pEmAndamento pStatus mb-0">Em andamento</p>
            </div>
        </article>
    </section>

</section>
