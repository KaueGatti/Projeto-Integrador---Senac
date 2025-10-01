let stackModais = {};

function voltar(url) {
    fetch(url).then(res => {
        if (!res.ok) throw new Error("Response failed in back to: " + url);
        return res.text();
    }).then(conteudo => {
        if (main.children.length >= 2) {
            main.children[1].remove();
        }
        main.innerHTML += conteudo;
    }).catch(err => console.log("Erro no fetch de back to: " + url + "\n" + err));
}

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

function novoProjeto() {
    fetch("NovoProjeto.php").then(res => {
        if (!res.ok) throw new Error("Response failed in:" + "NovoProjeto.php");
        return res.text();
    }).then(conteudo => {
        if (main.children.length >= 2) {
            main.children[1].remove();
        }
        main.innerHTML += conteudo;
    }).catch(err => console.log("Erro no fetch de: " + "NovoProjeto.php" + "\n" + err));
}

function notificacoes() {
    document.getElementById("notificacoes").classList.toggle("open");
    document.getElementsByClassName("conteudo")[0].classList.toggle("onblur");
}

let main = document.getElementById('main');
let logo = document.getElementById("divLogo");
let btnsAside = document.getElementsByClassName("btnAside");
document.addEventListener('DOMContentLoaded', event => {

    logo.addEventListener("click", function () {
        fetch("PaginaInicial.php").then(res => {
            if (!res.ok) throw new Error("Response failed in:" + "PaginaInicial.php");
            return res.text();
        }).then(conteudo => {
            if (main.children.length >= 2) {
                main.children[1].remove();
            }
            main.innerHTML += conteudo;
        }).catch(err => console.log("Erro no fetch de: PaginaInicial.php" + "\n" + err));
    });

    Array.from(btnsAside).forEach(function (btn) {
        btn.addEventListener("click", function () {
            if (btn.classList.contains("Selected")) {
                fetch(btn.getAttribute("name") + ".php").then(res => {
                    if (!res.ok) throw new Error("Response failed in:" + btn.getAttribute("name") + ".php");
                    return res.text();
                }).then(conteudo => {
                    if (main.children.length >= 2) {
                        main.children[1].remove();
                    }
                    main.innerHTML += conteudo;
                }).catch(err => console.log("Erro no fetch de: " + btn.getAttribute("name") + "\n" + err));
            }
        });
    });

    window.onload = function () {
        logo.click();
    };
});

