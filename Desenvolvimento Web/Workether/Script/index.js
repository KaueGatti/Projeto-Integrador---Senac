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

async function request(url, options = {}) {
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

function carregarComponente(url) {
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

sectionNotificacoes.addEventListener('click', e => {

    if (e.target.classList.contains('btnRecusar') || e.target.classList.contains('btnAceitar')) {

        let id_notificacao;
        let resposta;

        if (e.target.classList.contains('btnRecusar')) {
            let notificacao = e.target.closest('.articleNotificacao');
            id_notificacao = notificacao.querySelector('#idNotificacao').textContent;
            resposta = "Recusado";
        } else if (e.target.classList.contains('btnAceitar')) {
            let notificacao = e.target.closest('.articleNotificacao');
            id_notificacao = notificacao.querySelector('#idNotificacao').textContent;
            resposta = "Aceito";
        }

        let respostaPedidoAmizade = new FormData();

        respostaPedidoAmizade.append('respostaPedidoAmizade[id_notificacao]', id_notificacao);
        respostaPedidoAmizade.append('respostaPedidoAmizade[resposta]', resposta);

        try {
            let response = request('/../API/PedidoAmizadeAPI.php', {method: "POST", body: respostaPedidoAmizade});
        } catch (error) {
            console.error(error);
        }

        atualizarNotificacoes();
    }





})

logo.onclick = async () => {
    await carregarComponente("Loading.php");
    await carregarComponente('PaginaInicial.php');
}

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

    await carregarComponente('Loading.php');

    await carregarComponente('Projetos.php');

    document.querySelector('#btnVoltar').onclick = () => {
        carregarComponente('PaginaInicial.php');
        let btnProjetos = document.querySelector('#btnProjetos');
        let srcImg = btnProjetos.firstElementChild.getAttribute('src');
        btnProjetos.classList.toggle('Selected');
        btnProjetos.firstElementChild.setAttribute('src', srcImg.replace("Selected", ""));
    }

    let projetos = document.querySelectorAll('.articleProjeto');

    projetos.forEach(projeto => {
        projeto.onclick = async () => {

            await carregarComponente('Loading.php');

            await carregarComponente('DetalhesProjeto.php?id=' + projeto.id);

            let articleDetalhes = document.querySelector('#articleDetalhes');

            let btnEditar = document.querySelector('#btnEditar');
            let btnSalvar = document.querySelector('#btnSalvar');

            let projetoID = document.querySelector('#projetoID').textContent;
            let inputNome = document.querySelector('#inputNome');
            let inputDescricao = document.querySelector('#inputDescricao');
            let selectResponsavel = document.querySelector('#selectResponsavel');
            let inputDataConclusao = document.querySelector('#inputDataConclusao');

            inputDataConclusao.min = new Date().toISOString().split("T")[0];

            document.querySelector('#btnVoltar').onclick = () => {
                btnProjetos.click();
            }

            btnEditar.onclick = () => {

                btnEditar.disabled = true;

                inputNome.focus();

                inputNome.readOnly = false;
                inputDescricao.readOnly = false;
                inputDataConclusao.readOnly = false;
                selectResponsavel.disabled = false;

                btnSalvar.disabled = false;
                articleDetalhes.style.borderColor = "rgba(5, 104, 230, 0.75)";
            }

            btnSalvar.onclick = async () => {

                let editarProjeto = new FormData();

                editarProjeto.append('editarProjeto[id]', projetoID);
                editarProjeto.append('editarProjeto[nome]', inputNome.value);
                editarProjeto.append('editarProjeto[descricao]', inputDescricao.value);
                editarProjeto.append('editarProjeto[dataAtualConclusao]', inputDataConclusao.value);
                editarProjeto.append('editarProjeto[id_responsavel]', selectResponsavel.value);
                editarProjeto.append('editarProjeto[dataConclusao]', '');
                editarProjeto.append('editarProjeto[status]', "Em andamento");

                try {
                    let response = await request("../API/ProjetoAPI.php", {method: "POST", body: editarProjeto});
                    console.log(response);
                    if (response.success) {
                        articleDetalhes.style.borderColor = "#75CE70";
                        setTimeout(() => {
                            articleDetalhes.style.borderColor = "rgba(195, 195, 195, 0.5)";
                        }, 5000);

                        inputNome.readOnly = true;
                        inputDescricao.readOnly = true;
                        inputDataConclusao.readOnly = true;
                        selectResponsavel.disabled = true;

                        btnSalvar.disabled = true;
                        btnEditar.disabled = false;
                    }
                } catch (e) {
                    console.log(e.message);
                }
            };
        }
    })

    document.querySelector('#btnNovoProjeto').onclick = async () => {

        await carregarComponente("NovoProjeto.php");

        document.querySelector('#btnVoltar').onclick = () => {
            btnProjetos.click();
        }

        document.querySelector('#inputDataConclusao').min = new Date().toISOString().split("T")[0];

        document.querySelector('#btnCancelar').onclick = () => {
            btnProjetos.click();
        }

        document.querySelector('#btnConcluir').onclick = async () => {
            let info = document.querySelector('#info');

            let novoProjeto = new FormData();

            novoProjeto.append('novoProjeto[nome]', document.querySelector('#inputNome').value);
            novoProjeto.append('novoProjeto[descricao]', document.querySelector('#inputDescricao').value);
            novoProjeto.append('novoProjeto[dataInicialConclusao]', document.querySelector('#inputDataConclusao').value);
            novoProjeto.append('novoProjeto[id_responsavel]', document.querySelector('#select_responsavel').value);

            try {
                let response = await request("../API/ProjetoAPI.php", {method: "POST", body: novoProjeto});
                info.textContent = response.message;
                if (response.success) {
                    info.style.color = "#75CE70";
                    document.querySelector('#btnConcluir').disabled = true;
                    setTimeout(() => {
                        btnProjetos.click()
                    }, 3000)
                } else {
                    info.style.color = "#E65A55";
                }
            } catch (erro) {
                info.textContent = erro.message;
                info.style.color = "#E65A55";
            }
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

    document.querySelector('#btnVoltar').onclick = () => {
        carregarComponente('PaginaInicial.php');
        let btnAmigos = document.querySelector('#btnAmigos');
        let srcImg = btnAmigos.firstElementChild.getAttribute('src');
        btnAmigos.classList.toggle('Selected');
        btnAmigos.firstElementChild.setAttribute('src', srcImg.replace("Selected", ""));
    }

    document.querySelector('#btnAddAmigo').onclick = () => {

        interactModal('modalAmigos', 'sectionAmigos');

        document.querySelector('#btnModalAmigos').onclick = () => interactModal('modalAmigos', 'sectionAmigos');

        document.querySelector('#btnEnviarConvite').onclick = async () => {

            let info = document.querySelector('#modalAmigos #info');

            let id_solicitante = document.querySelector('#id_usuario').textContent;
            let id_receptor = document.querySelector('#inputIdUsuario').value;

            if (id_solicitante === id_receptor) {
                info.textContent = "Usuário inválido";
                info.style.color = "#E65A55";
                return;
            }

            let pedidoAmizade = new FormData();

            pedidoAmizade.append('pedidoAmizade[id_solicitante]', id_solicitante);
            pedidoAmizade.append('pedidoAmizade[id_receptor]', id_receptor);

            try {
                let response = await request('/../API/PedidoAmizadeAPI.php', {method: "POST", body: pedidoAmizade});
                if (response.success) {
                    info.textContent = "Pedido de amizade enviado!";
                    info.style.color = "#75CE70";
                } else {
                }
            } catch (error) {
                if (error.message.includes('Integrity constraint violation: 1452')) {
                    info.textContent = "Usuário não encontrado!";
                } else {
                    console.error(error);
                }
                    info.style.color = "#E65A55";
            }


        }

    }


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
