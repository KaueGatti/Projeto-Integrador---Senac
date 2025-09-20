<?php ?>

<!doctype html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Workether - Página Inicial</title>
    <link rel="stylesheet" href="Style/index.css">
</head>
<body>
<aside id="menu">
    <div id="divLogo">
        <h1 id="WORK">WORK</h1>
        <h1 id="ETHER">ETHER</h1>
    </div>
    <button class="btnAside" id="btnProjetos">
        <img src="Icones/Projetos.png" alt="">
        <p>Projetos</p>
    </button>
    <button class="btnAside" id="btnTarefas">
        <img src="Icones/Tarefas.png" alt="">
        <p>Tarefas</p>
    </button>
    <button class="btnAside" id="btnConversas">
        <img src="Icones/Conversas.png" alt="">
        <p>Conversas</p>
    </button>
    <button class="btnAside" id="btnAmigos">
        <img src="Icones/Amigos.png" alt="">
        <p>Amigos</p>
    </button>
    <button class="btnAside" id="btnPerfil">
        <img src="Icones/Perfil.png" alt="">
        <p>Perfil</p>
    </button>
</aside>
<main>
    <header>
        <img id="iconeUserHeader" src="Icones/User.png" alt="">
        <p>Usuário: Kauê</p>
        <img id="iconeNotificationHeader" src="Icones/Notification.png" alt="">
    </header>
    <section>
        <h1>Vamos projetar</h1>
        <article>
            <button class="btnBox">
                <img src="Icones/NovoProjeto.png" alt="">
                <p>Novo Projeto +</p>
            </button>
            <button class="btnBox">
                <img src="Icones/NovaTarefa.png" alt="">
                <p>Nova Tarefa +</p>
            </button>
        </article>
    </section>
</main>

</body>
<script src="Script/index.js"></script>
</html>
