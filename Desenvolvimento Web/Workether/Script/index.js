import {initAmigos} from "./Amigos.js";
import {initProjetos} from "./Projetos.js";
import {initPaginaInicial} from "./PaginaInicial.js";
import {initPerfil} from "./Perfil.js";
import {initTarefas} from "./Tarefas.js";
import {initConversas} from "./Conversas.js";

let logo = document.querySelector('#divLogo');
let body = document.querySelector("#body");
let main = document.querySelector("#main");
let notificacoes = document.querySelector("#notificacoes");
let btnRefreshNotificacoes = document.querySelector('#btn_refresh_notificacoes');
let sectionNotificacoes = document.querySelector("#sectionNotificacoes");
let btnsAside = document.querySelectorAll(".btnAside");
let btnProjetos = document.querySelector('#btnProjetos');
let btnTarefas = document.querySelector('#btnTarefas');
let btnConversas = document.querySelector('#btnConversas');
let btnAmigos = document.querySelector('#btnAmigos');
let btnPerfil = document.querySelector('#btnPerfil');
let btnNotificao = document.querySelector('#btnNotificacoes');

export function interactModal(modal, background) {
    document.getElementById(modal).classList.toggle("show");
    document.getElementById(background).classList.toggle("onblur");
}

export async function request(url, options = {}) {
    let res = await fetch(url, options);
    let text = await res.text();

    let json;

    try {
        json = JSON.parse(text);
    } catch (e) {
        console.error("Erro ao parsear JSON:", e);
        console.log("Resposta bruta do PHP:", text);
        throw new Error("Resposta inválida do servidor (não é JSON)");
    }

    if (!res.ok || json.success === false) {
        throw new Error(json.message || "Erro desconhecido");
    }

    return json;
}

function atualizarNotificacoes() {
    return fetch('/../Notificacoes.php', {cache: 'no-store'}).then(res => {
        if (!res.ok) throw new Error("Erro ao atualizar notificações");
        return res.text();
    }).then(conteudo => {
        sectionNotificacoes.innerHTML = conteudo;
    }).catch(err => console.log("Erro no atualizarNotificacoes()" + "\n" + err));
}

export function carregarComponente(url) {
    return fetch(url).then(res => {
        if (!res.ok) throw new Error("Response failed in carregarComponente():" + url);
        return res.text();
    }).then(conteudo => {
        if (main.children.length >= 2) {
            main.children[1].remove();
        }
        main.insertAdjacentHTML("beforeend", conteudo);
    }).catch(err => console.log("Erro no carregarComponente(): " + url + "\n" + err));
}

btnNotificao.addEventListener('click', async function () {

    if (!notificacoes.classList.contains('open')) {
        await atualizarNotificacoes();
    }

    notificacoes.classList.toggle('open');
    document.getElementsByClassName("conteudo")[0].classList.toggle("onblur");

});

btnRefreshNotificacoes.onclick = async () => {
    await atualizarNotificacoes();
}

sectionNotificacoes.addEventListener('click', async e => {

    if (e.target.classList.contains('btnRecusar') || e.target.classList.contains('btnAceitar')) {
        let notificacao;
        let id_notificacao;
        let resposta;

        if (e.target.classList.contains('btnRecusar')) {
            let notificacao = e.target.closest('.articleNotificacao');
            id_notificacao = notificacao.querySelector('#idNotificacao').textContent;
            resposta = "Recusado";
            notificacao.innerHTML = "Pedido recusado!";
            notificacao.classList.toggle('recusado');
        } else if (e.target.classList.contains('btnAceitar')) {
            let notificacao = e.target.closest('.articleNotificacao');
            id_notificacao = notificacao.querySelector('#idNotificacao').textContent;
            resposta = "Aceito";
            notificacao.innerHTML = "Pedido aceito!";
            notificacao.classList.toggle('aceito');
        }

        let respostaPedidoAmizade = new FormData();

        respostaPedidoAmizade.append('respostaPedidoAmizade[id_notificacao]', id_notificacao);
        respostaPedidoAmizade.append('respostaPedidoAmizade[resposta]', resposta);

        try {
            await request('/../API/PedidoAmizadeAPI.php', {method: "POST", body: respostaPedidoAmizade});
        } catch (error) {
            console.error(error);
        }

        setTimeout(async () => {
            atualizarNotificacoes();
        }, 1000);
    }


})

Array.from(btnsAside).forEach(btn => {
    btn.onclick = () => {
        if (document.querySelector('#notificacoes').classList.contains('open')) {
            btnNotificao.click();
        }
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

    await initProjetos();

});

btnTarefas.addEventListener('click', async function () {
    await initTarefas('', null);
});

btnConversas.addEventListener('click', async function () {

    await initConversas();
});

btnAmigos.addEventListener('click', async function () {

    await carregarComponente('Loading.php');

    await carregarComponente('Amigos.php');

    initAmigos();

});

btnPerfil.addEventListener('click', async function () {
    await initPerfil();
});

logo.onclick = async () => {

    await initPaginaInicial();

    Array.from(btnsAside).forEach(btn => {
        let srcImg = btn.firstElementChild.getAttribute('src');
        if (btn.classList.contains('Selected')) {
            btn.classList.toggle('Selected');
            btn.firstElementChild.setAttribute('src', srcImg.replace("Selected", ""));
        }
    })
}

document.addEventListener("DOMContentLoaded", async () => {
    await initPaginaInicial();
})
