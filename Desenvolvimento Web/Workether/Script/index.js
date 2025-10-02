let main = document.querySelector("#main");
let btnsAside = document.querySelectorAll(".btnAside");
let btnProjetos = document.querySelector('#btnProjetos');
let btnTarefas = document.querySelector('#btnTarefas');
let btnConversas = document.querySelector('#btnConversas');
let btnAmigos = document.querySelector('#btnAmigos');
let btnPerfil = document.querySelector('#btnPerfil');

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

Array.from(btnsAside).forEach(btn => {
    btn.onclick = () => {
        let btnSelected = btn;
        let srcImgSelected = btnSelected.firstElementChild.getAttribute('src');
        if (!btnSelected.classList.contains('Selected')) {
            btnSelected.classList.toggle('Selected');
            btnSelected.firstElementChild.setAttribute('src', srcImgSelected.replace(".png", "Selected.png"));
            Array.from(btnsAside).forEach(btn => {
                if (btn !== btnSelected && btn.classList.contains('Selected')) {
                    let srcImg = btn.firstElementChild.getAttribute('src');
                    btn.classList.toggle('Selected');
                    btn.firstElementChild.setAttribute('src', srcImg.replace("Selected", ""));
                }
            })
        }
    }
})

btnProjetos.addEventListener('click', async () => {

    await carregarComponente('Loading.php');

    await carregarComponente('Projetos.php');

    document.querySelector('#btnVoltar').onclick = () => {
        carregarComponente('PaginaInicial.php');
        let btnProjetos = document.querySelector('#btnProjetos');
        let srcImg = btnProjetos.firstElementChild.getAttribute('src');
        btnProjetos.classList.toggle('Selected');
        btnProjetos.firstElementChild.setAttribute('src', srcImg.replace("Selected", ""));
    }

    document.querySelector('#btnNovoProjeto').onclick = async () => {
        await carregarComponente("NovoProjeto.php");

        document.querySelector('#btnCancelar').onclick = () => {
            btnProjetos.click();
        }

        document.querySelector('#btnConcluir').onclick = () => {
            let novoProjeto = new FormData;
            novoProjeto.append('novoProjeto[nome]', document.querySelector('#inputNome').value);
            novoProjeto.append('novoProjeto[descricao]', document.querySelector('#inputDescricao').value);
            novoProjeto.append('novoProjeto[dataInicialConclusao]', document.querySelector('#inputDataConclusao').value);
            novoProjeto.append('novoProjeto[id_responsavel]', document.querySelector('#select_responsavel').value);
            console.log(novoProjeto);
            fetch('NovoProjeto.php', { method: 'POST', body: novoProjeto}).then(response => {
                if (!response.ok) throw new Error('Erro na response do fetch do btnConcluir -> NovoProjeto.php');
                return response;
            }).then(response => {
                console.log(response);
            }).catch(err => console.log("Erro no fetch do btnConcluir -> NovoProjeto.php" + "\n" + err));
        }
    }


});

btnTarefas.addEventListener('click', async function () {

    await carregarComponente('Loading.php');

    await carregarComponente('Tarefas.php');
});

btnConversas.addEventListener('click', async function () {

    await carregarComponente('Loading.php');

    await carregarComponente('Conversas.php');
});

btnAmigos.addEventListener('click', async function () {

    await carregarComponente('Loading.php');

    await carregarComponente('Amigos.php');
});

btnPerfil.addEventListener('click', async function () {

    await carregarComponente('Loading.php');

    await carregarComponente('Perfil.php');
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

