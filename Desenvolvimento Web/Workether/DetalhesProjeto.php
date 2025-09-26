<?php ?>


<section class="conteudo">
    <link rel="stylesheet" href="Style/DetalhesProjeto.css">
    <div id="divTitulo">
        <img onclick="voltar()" src="Icones/Voltar.png" alt="">
        <h1 class="mb-0">Tarefas</h1>
    </div>
    <section class="sectionDetalhes">
        <article class="articleTarefa">
            <div class="input-group">
                <input type="text" id="nome" name="nome" placeholder=" ">
                <label for="nome">Nome</label>
            </div>
            <div class="input-group">
                <input type="text" id="descricao" name="descricao" placeholder=" ">
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
        </article>
    </section>
</section>
