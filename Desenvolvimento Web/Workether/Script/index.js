import {initAmigos} from "./Amigos.js";
import {initProjetos} from "./Projetos.js";
import {initPaginaInicial} from "./PaginaInicial.js";
import {initPerfil} from "./Perfil.js";
import {initTarefas} from "./Tarefas.js";
import {initConversas} from "./Conversas.js";
import {request} from "./request.js";

export const usuarioLogado = {
    id: document.querySelector('.usuarioLogado').id,
    usuario: document.querySelector('.usuarioLogado').textContent
};
const DOM = {
    logo: document.querySelector('#divLogo'),
    body: document.querySelector("#body"),
    main: document.querySelector("#main"),
    notificacoes: document.querySelector("#notificacoes"),
    btnRefreshNotificacoes: document.querySelector('#btn_refresh_notificacoes'),
    sectionNotificacoes: document.querySelector("#sectionNotificacoes"),
    btnsAside: document.querySelectorAll(".btnAside"),
    btnProjetos: document.querySelector('#btnProjetos'),
    btnTarefas: document.querySelector('#btnTarefas'),
    btnConversas: document.querySelector('#btnConversas'),
    btnAmigos: document.querySelector('#btnAmigos'),
    btnPerfil: document.querySelector('#btnPerfil'),
    btnNotificao: document.querySelector('#btnNotificacoes')
};

export function interactModal(modal, background) {
    document.querySelector('#' + modal).classList.toggle("show");
    document.querySelector('#' + background).classList.toggle("onblur");
}

function atualizarNotificacoes() {
    return fetch('/../Notificacoes.php', {cache: 'no-store'}).then(res => {
        if (!res.ok) throw new Error("Erro ao atualizar notificações");
        return res.text();
    }).then(conteudo => {
        DOM.sectionNotificacoes.innerHTML = conteudo;
    }).catch(err => console.log("Erro no atualizarNotificacoes()" + "\n" + err));
}

export function carregarComponente(url) {
    return fetch(url).then(res => {
        if (!res.ok) throw new Error("Response failed in carregarComponente():" + url);
        return res.text();
    }).then(conteudo => {
        if (DOM.main.children.length >= 2) {
            DOM.main.children[1].remove();
        }
        DOM.main.insertAdjacentHTML("beforeend", conteudo);
    }).catch(err => console.log("Erro no carregarComponente(): " + url + "\n" + err));
}

DOM.btnNotificao.addEventListener('click', async function () {

    if (!DOM.notificacoes.classList.contains('open')) {
        await atualizarNotificacoes();
    }

    DOM.notificacoes.classList.toggle('open');
    document.getElementsByClassName("conteudo")[0].classList.toggle("onblur");

});

DOM.btnRefreshNotificacoes.onclick = async () => {
    await atualizarNotificacoes();
}

DOM.sectionNotificacoes.addEventListener('click', async e => {

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
            await atualizarNotificacoes();
        }, 1000);
    }


});

Array.from(DOM.btnsAside).forEach(btn => {
    btn.onclick = () => {
        if (DOM.notificacoes.classList.contains('open')) {
            DOM.btnNotificao.click();
        }
        let btnSelected = btn;
        let srcImgSelected = btnSelected.firstElementChild.getAttribute('src');
        if (!btnSelected.classList.contains('Selected')) {
            btnSelected.classList.toggle('Selected');
            btnSelected.firstElementChild.setAttribute('src', srcImgSelected.replace(".png", "Selected.png"));
            Array.from(DOM.btnsAside).forEach(btn => {
                if (btn !== btnSelected && btn.classList.contains('Selected')) {
                    let srcImg = btn.firstElementChild.getAttribute('src');
                    btn.classList.toggle('Selected');
                    btn.firstElementChild.setAttribute('src', srcImg.replace("Selected", ""));
                }
            })
        }
    }
});

DOM.btnProjetos.addEventListener('click', async () => {

    await initProjetos();

});

DOM.btnTarefas.addEventListener('click', async function () {
    await initTarefas('', null);
});

DOM.btnConversas.addEventListener('click', async function () {

    await initConversas();
});

DOM.btnAmigos.addEventListener('click', async function () {

    await carregarComponente('Loading.php');

    await carregarComponente('Amigos.php');

    initAmigos();

});

DOM.btnPerfil.addEventListener('click', async function () {
    await initPerfil();
});

DOM.logo.onclick = async () => {

    await initPaginaInicial();

    Array.from(DOM.btnsAside).forEach(btn => {
        let srcImg = btn.firstElementChild.getAttribute('src');
        if (btn.classList.contains('Selected')) {
            btn.classList.toggle('Selected');
            btn.firstElementChild.setAttribute('src', srcImg.replace("Selected", ""));
        }
    })
}

document.addEventListener("DOMContentLoaded", async () => {
    await initPaginaInicial();
});
