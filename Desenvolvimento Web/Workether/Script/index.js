let main = document.querySelector("#main");

function carregarComponente(url) {
    return fetch(url).then(res => {
        if (!res.ok) throw new Error("Response failed in carregarComponente():" + url);
        return res.text();
    }).then(conteudo => {
        if (main.children.length >= 2) {
            main.children[1].remove();
        }
        main.innerHTML += conteudo;
    }).catch(err => console.log("Erro no carregarComponente(): " + url + "\n" + err));
}

document.querySelector('#btnProjetos').addEventListener('click', async function () {
    this.classList.toggle('Selected');
    this.children[0].src = 'Icones/ProjetosSelected.png';

    await carregarComponente('Loading.php');

    await carregarComponente('Projetos.php');

    document.querySelector('#btnNovoProjeto').onclick = () => {
        console.log('Novo projeto');
    }

    document.querySelector('#btnVoltar').onclick = () => {
        carregarComponente('PaginaInicial.php');
        this.classList.toggle('Selected');
        this.children[0].src = 'Icones/Projetos.png';
    };


});

document.querySelector('#btnTarefas').addEventListener('click', function () {
    carregarComponente('Tarefas.php');
});

document.querySelector('#btnConversas').addEventListener('click', function () {
    carregarComponente('Conversas.php');
});

document.querySelector('#btnAmigos').addEventListener('click', function () {
    carregarComponente('Amigos.php');
});

document.querySelector('#btnPerfil').addEventListener('click', function () {
    carregarComponente('Perfil.php');
});

function abrirConversa_Chat() {
    fetch("Conversa_Chat.php").then(res => {
        if (!res.ok) throw new Error("Response failed in:" + "Conversa_Chat.php");
        return res.text();
    }).then(conteudo => {
        if (main.children.length >= 2) {
            main.children[1].remove();
        }
        main.innerHTML += conteudo;
    }).catch(err => console.log("Erro no fetch de: " + "Conversa_Chat.php" + "\n" + err));
}

function interactModal(modal, background) {
    document.getElementById(modal).classList.toggle("show");
    document.getElementById(background).classList.toggle("onblur");
}

function detalhes(url, valuesGet) {
    fetch("Detalhes" + url + ".php?" + valuesGet).then(res => {
        if (!res.ok) throw new Error("Response failed in:" + "Detalhes" + url + ".php");
        return res.text();
    }).then(conteudo => {
        if (main.children.length >= 2) {
            main.children[1].remove();
        }
        main.innerHTML += conteudo;
    }).catch(err => console.log("Erro no fetch de: " + "Detalhes" + url + ".php" + "\n" + err));
}

function enviarConviteAmigo() {
}

function novaTarefa() {
    fetch("NovaTarefa.php").then(res => {
        if (!res.ok) throw new Error("Response failed in:" + "NovaTarefa.php");
        return res.text();
    }).then(conteudo => {
        if (main.children.length >= 2) {
            main.children[1].remove();
        }
        main.innerHTML += conteudo;
    }).catch(err => console.log("Erro no fetch de: " + "NovaTarefa.php" + "\n" + err));
}

function loadTarefas() {
    fetch("Tarefas" + ".php").then(res => {
        if (!res.ok) throw new Error("Response failed in:" + "Tarefas" + ".php");
        return res.text();
    }).then(conteudo => {
        if (main.children.length >= 2) {
            main.children[1].remove();
        }
        main.innerHTML += conteudo;
    }).catch(err => console.log("Erro no fetch de: " + "loadTarefas()" + "\n" + err));
}

function notificacoes() {
    document.getElementById("notificacoes").classList.toggle("open");
    document.getElementsByClassName("conteudo")[0].classList.toggle("onblur");
}

