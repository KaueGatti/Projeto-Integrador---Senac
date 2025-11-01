import {carregarComponente, interactModal, usuarioLogado} from "./index.js";
import {request} from "./request.js";
import {initProjetos} from "./Projetos.js";
import {initTarefas} from "./Tarefas.js";
import {Colors} from "../assets/constants.js";

function novaEquipeValida(novaEquipe) {

    if (novaEquipe.nome.replace(/ /g, '') === '') {
        return {
            success: false, message: 'O nome da equipe não pode estar vázio'
        };
    }

    if (novaEquipe.descricao.replace(/ /g, '') === '') {
        return {
            success: false, message: 'A descrição da equipe não pode estar vázia'
        };
    }

    if (novaEquipe.responsavel.id === '') {
        return {
            success: false, message: 'Selecione um responsável para a equipe'
        };
    }

    return {
        success: true, message: 'Equipe válida'
    };
}

function articleParticipante(usuario) {
    return '<article class="articleParticipante" id="' + usuario.id + '">\n' + '<p class="usuario_participante">' + usuario.usuario + '</p>\n' + '<img class="btnRemover" src="Icones/Remover.png" alt="">\n' + '</article>';
}

function articleEquipe(equipe) {
    return '<article id="' + equipe.id + '" class="articleEquipe">' + '<p id="nome_equipe">' + equipe.nome + '</p>' + '<img class="btnRemover" src="Icones/Remover.png" alt="">' + '</article>';
}

function articleComentario(comentario) {
    let data_horaFormatada = new Date(comentario.data_hora.replace(' ', 'T') + 'Z');
    let horaFormatada = data_horaFormatada.toLocaleTimeString('pt-BR', {
        hour: '2-digit',
        minute: '2-digit',
        timeZone: 'America/Sao_Paulo',
    });
    let dataFormatada = data_horaFormatada.toLocaleDateString('pt-BR', {
        timeZone: 'America/Sao_Paulo',
    });
    return '<article class="articleComentario" id="' + comentario.id + '">' + '<p class="textoComentario">' + comentario.texto + '</p>' + '<div class="divInfo">' + '<img id="btnRemover" class="imgRemover btnRemover" src="Icones/Remover.png" alt="">' + '<p class="data">' + dataFormatada + '</p>' + '<p class="hora">' + horaFormatada + '</p>' + '<div class="divUser">' + '<img src="Icones/User.png" alt="">' + '<p>' + comentario.usuario + '</p>' + '</div>' + '</div>' + '</article>';
}

function optionUsuario(usuario) {
    return '<option value="' + usuario.id + '">' + usuario.usuario + '</option>';
}

export async function initDetalhesProjeto(id_projeto) {

    await carregarComponente('Loading.php');

    await carregarComponente('DetalhesProjeto.php?id=' + id_projeto);

    const DOM = {

        btnVoltar: document.querySelector('#btnVoltar'),

        detalhes: {
            section: document.querySelector('#sectionDetalhes'),
            article: document.querySelector('#articleDetalhes'),

            dados: {
                projetoID: document.querySelector('#projetoID'),
                dataCriacao: document.querySelector('#dataCriacao'),
                status: document.querySelector('#status'),
                idResponsavel: document.querySelector('#id_responsavel')
            },

            campos: {
                inputNome: document.querySelector('#inputNome'),
                divInputNome: document.querySelector('#divInputNome'),
                textAreaDescricao: document.querySelector('#textArea_descricao'),
                divInputDescricao: document.querySelector('#divInputDescricao'),
                selectResponsavel: document.querySelector('#select_responsavel'),
                inputDataConclusao: document.querySelector('#inputDataConclusao'),
                divDataConclusao: document.querySelector('#input-groupDataConclusao')
            },

            botoes: {
                participantes: document.querySelector('#articleDetalhes #btnParticipantes'),
                equipes: document.querySelector('#articleDetalhes #btnEquipes'),
                tarefas: document.querySelector('#articleDetalhes #btnTarefas'),
                comentarios: document.querySelector('#articleDetalhes #btnComentarios'),
                excluir: document.querySelector('#articleDetalhes #btnExcluir'),
                concluir: document.querySelector('#articleDetalhes #btnConcluir'),
                editar: document.querySelector('#articleDetalhes #btnEditar'),
                salvar: document.querySelector('#articleDetalhes #btnSalvar')
            },

            info: document.querySelector('#articleDetalhes #info')
        },

        participantes: {
            modal: document.querySelector('#modalParticipantes'),
            btnFechar: document.querySelector('#modalParticipantes #btnFechar'),
            btnAdicionar: document.querySelector('#btnAdicionarParticipante'),
            section: document.querySelector('#sectionParticipantes'),

            // Modal de adicionar participante
            modalAdicionar: {
                modal: document.querySelector('#modalAdicionarParticipante'),
                btnFechar: document.querySelector('#modalAdicionarParticipante #btnFechar'),
                select: document.querySelector('#modalAdicionarParticipante #select_participante'),
                info: document.querySelector('#modalAdicionarParticipante #info'),
                btnAdicionar: document.querySelector('#modalAdicionarParticipante #btnAdicionar')
            }
        },

        equipes: {
            modal: document.querySelector('#modalEquipes'),
            btnFechar: document.querySelector('#modalEquipes #btnFechar'),
            btnAdicionarEquipe: document.querySelector('#btnAdicionarEquipe'),
            section: document.querySelector('.sectionEquipes'),

            // Modal de adicionar equipe
            modalAdicionar: {
                modal: document.querySelector('#modalAdicionarEquipe'),
                inputNome: document.querySelector('#modalAdicionarEquipe #input_nome'),
                textAreaDescricao: document.querySelector('#modalAdicionarEquipe #textArea_descricao'),
                selectResponsavel: document.querySelector('#modalAdicionarEquipe #select_responsavel'),
                info: document.querySelector('#modalAdicionarEquipe #info'),
                btnCancelar: document.querySelector('#modalAdicionarEquipe #btnCancelar'),
                btnConcluir: document.querySelector('#modalAdicionarEquipe #btnConcluir')
            },

            // Modal de participantes da equipe (ao criar)
            participantes: {
                modal: document.querySelector('#modalParticipantesEquipe'),
                btnFechar: document.querySelector('#modalParticipantesEquipe #btnFechar'),
                btnAdicionar: document.querySelector('#modalParticipantesEquipe #btnAdicionarParticipante'),
                section: document.querySelector('#modalParticipantesEquipe .sectionParticipantes'),

                modalAdicionar: {
                    modal: document.querySelector('#modalAdicionarParticipanteEquipe'),
                    btnFechar: document.querySelector('#modalAdicionarParticipanteEquipe #btnFechar'),
                    select: document.querySelector('#modalAdicionarParticipanteEquipe #select_participante'),
                    info: document.querySelector('#modalAdicionarParticipanteEquipe #info'),
                    btnAdicionar: document.querySelector('#modalAdicionarParticipanteEquipe #btnAdicionar')
                }
            },

            // Modal de detalhes da equipe
            detalhes: {
                modal: document.querySelector('#modalDetalhesEquipe'),
                btnFechar: document.querySelector('#modalDetalhesEquipe #btnFechar'),
                inputNome: document.querySelector('#modalDetalhesEquipe #input_nome'),
                textAreaDescricao: document.querySelector('#modalDetalhesEquipe #textArea_descricao'),
                selectResponsavel: document.querySelector('#modalDetalhesEquipe #select_responsavel'),
                btnParticipantes: document.querySelector('#modalDetalhesEquipe #btnParticipantes'),
                info: document.querySelector('#modalDetalhesEquipe #info'),
                btnEditar: document.querySelector('#modalDetalhesEquipe #btnEditarEquipe'),
                btnSalvar: document.querySelector('#modalDetalhesEquipe #btnSalvar'),

                // Participantes da equipe (nos detalhes)
                participantes: {
                    modal: document.querySelector('#modalParticipantesDetalhesEquipe'),
                    btnFechar: document.querySelector('#modalParticipantesDetalhesEquipe #btnFechar'),
                    btnAdicionar: document.querySelector('#modalParticipantesDetalhesEquipe #btnAdicionarParticipante'),
                    section: document.querySelector('#modalParticipantesDetalhesEquipe .sectionParticipantes'),

                    modalAdicionar: {
                        modal: document.querySelector('#modalAdicionarParticipanteDetalhesEquipe'),
                        btnFechar: document.querySelector('#modalAdicionarParticipanteDetalhesEquipe #btnFechar'),
                        select: document.querySelector('#modalAdicionarParticipanteDetalhesEquipe #select_participante'),
                        info: document.querySelector('#modalAdicionarParticipanteDetalhesEquipe #info'),
                        btnAdicionar: document.querySelector('#modalAdicionarParticipanteDetalhesEquipe #btnAdicionar')
                    }
                }
            }
        },

        comentarios: {
            modal: document.querySelector('#modalComentarios'),
            btnFechar: document.querySelector('#modalComentarios #btnFechar'),
            btnAdicionar: document.querySelector('#modalComentarios #btnAdicionarComentario'),
            section: document.querySelector('.sectionComentarios'),

            modalAdicionar: {
                modal: document.querySelector('#modalAdicionarComentario'),
                textArea: document.querySelector('#modalAdicionarComentario #textArea_comentario'),
                info: document.querySelector('#modalAdicionarComentario #info'),
                btnCancelar: document.querySelector('#modalAdicionarComentario #btnCancelar'),
                btnAdicionar: document.querySelector('#modalAdicionarComentario #btnAdicionar')
            }
        },

        excluir: {
            modal: document.querySelector('#modalExcluir'),
            btnCancelar: document.querySelector('#btnCancelarModalExcluir'),
            btnExcluir: document.querySelector('#btnExcluirModalExcluir')
        },

        concluir: {
            modal: document.querySelector('#modalConcluir'),
            inputData: document.querySelector('#inputDataModalConcluir'),
            divData: document.querySelector('#divDataModalConcluir'),
            btnCancelar: document.querySelector('#btnCancelarModalConcluir'),
            btnConcluir: document.querySelector('#btnConcluirModalConcluir')
        }
    };

    if (DOM.detalhes.dados.status.textContent === 'Concluido') {

        DOM.detalhes.campos.inputDataConclusao.labels[0].textContent = 'Data de conclusão';
        DOM.detalhes.botoes.concluir.style.display = 'none';
        DOM.detalhes.botoes.editar.style.display = 'none';
        DOM.detalhes.botoes.salvar.style.display = 'none';

        if (DOM.detalhes.dados.idResponsavel.textContent !== usuarioLogado.id) {
            DOM.detalhes.botoes.excluir.style.display = 'none';
        }
    }

    DOM.btnVoltar.onclick = async () => {
        await initProjetos();
    }

    DOM.detalhes.campos.selectResponsavel.addEventListener('change', function (e) {
        let articlesParticipantes = Array.from(DOM.participantes.section.querySelectorAll('.articleParticipante'));
        articlesParticipantes.forEach(article => {
            if (article.id === e.target.value) {
                article.querySelector('.btnRemover').remove();
            } else if (article.querySelector('img') === null) {
                article.insertAdjacentHTML('beforeend', '<img class="btnRemover" src="Icones/Remover.png" alt="">');
            }
        })
    });

    DOM.detalhes.botoes.participantes.addEventListener('click', async function () {

        interactModal('modalParticipantes', 'sectionDetalhes');

        DOM.participantes.btnFechar.onclick = () => {
            interactModal('modalParticipantes', 'sectionDetalhes');
        }

        DOM.participantes.section.addEventListener('click', async function (e) {
            if (e.target.classList.contains('btnRemover')) {
                e.stopPropagation();
                let articleParticipante = e.target.closest('.articleParticipante');

                let form = new FormData();

                form.append('id_projeto', id_projeto);
                form.append('id_usuario', articleParticipante.id);

                let response = await request('../API/Projeto/deleteUsuarioProjeto.php', {method: "POST", body: form});

                if (response.success) {
                    articleParticipante.remove();
                    Array.from(DOM.detalhes.campos.selectResponsavel.options).forEach(o => {
                        if (o.value == articleParticipante.id) {
                            o.remove();
                        }
                    });
                    Array.from(DOM.participantes.modalAdicionar.select.options).forEach(o => {
                        if (o.value == articleParticipante.id) {
                            o.disabled = false;
                        }
                    });
                    Array.from(DOM.equipes.modalAdicionar.selectResponsavel.options).forEach(o => {
                        if (o.value == articleParticipante.id) {
                            o.remove();
                        }
                    });
                }
            }
        });

        DOM.participantes.btnAdicionar.onclick = () => {
            interactModal('modalAdicionarParticipante', 'modalParticipantes');

            DOM.participantes.modalAdicionar.btnFechar.onclick = () => {
                interactModal('modalAdicionarParticipante', 'modalParticipantes');
            }

            DOM.participantes.modalAdicionar.btnAdicionar.onclick = async () => {
                if (DOM.participantes.modalAdicionar.select.selectedIndex !== 0) {

                    DOM.participantes.modalAdicionar.btnAdicionar.disabled = true;

                    let option = DOM.participantes.modalAdicionar.select.options[DOM.participantes.modalAdicionar.select.selectedIndex];
                    let participante = {
                        id: option.value, usuario: option.textContent
                    }

                    let form = new FormData();
                    form.append('id_usuario', participante.id);
                    form.append('id_projeto', id_projeto);

                    let response = await request('../API/Projeto/addUsuarioProjeto.php', {method: "POST", body: form})

                    if (response.success) {

                        DOM.participantes.modalAdicionar.select.selectedIndex = 0;
                        DOM.participantes.modalAdicionar.btnAdicionar.disabled = false;
                        option.disabled = true;

                        DOM.detalhes.campos.selectResponsavel.insertAdjacentHTML('beforeend', optionUsuario(participante));
                        DOM.equipes.modalAdicionar.selectResponsavel.insertAdjacentHTML('beforeend', optionUsuario(participante));
                        DOM.participantes.section.insertAdjacentHTML('afterbegin', articleParticipante(participante));
                        DOM.participantes.modalAdicionar.info.textContent = 'Participante adicionado';
                        setTimeout(() => {
                            DOM.participantes.modalAdicionar.info.textContent = '';
                        }, 1500);
                    }
                }
            }
        }

        Array.from(DOM.participantes.section.querySelectorAll('.articleParticipante')).forEach(p => {
            if (p.id == DOM.detalhes.dados.idResponsavel.textContent) {
                p.querySelector('.btnRemover').style.display = 'none';
            }
        })

    });

    DOM.detalhes.botoes.equipes.addEventListener('click', async function () {
        interactModal('modalEquipes', 'sectionDetalhes');

        DOM.equipes.btnFechar.onclick = () => {
            interactModal('modalEquipes', 'sectionDetalhes');
        }

        DOM.equipes.section.addEventListener('click', async function (e) {
            if (e.target.classList.contains('btnRemover')) {
                let articleEquipe = e.target.closest('.articleEquipe');

                let id_equipe = new FormData();
                id_equipe.append('id_equipe', articleEquipe.id);

                let response = await request('../API/Equipe/deleteEquipe.php', {method: "POST", body: id_equipe});

                if (response.success) {
                    articleEquipe.remove();
                }
            } else {

                let articleEquipe = e.target.closest('.articleEquipe');

                if (articleEquipe) {
                    e.stopPropagation();

                    let nomeEquipe = e.target.querySelector('#nome_equipe').textContent;

                    let form = new FormData();
                    form.append('id_projeto', id_projeto);
                    form.append('nome', nomeEquipe);

                    let responseEquipe = await request('../API/Equipe/readEquipeByProjeto.php', {
                        method: "POST",
                        body: form
                    });

                    if (responseEquipe.success) {

                        let equipe = {
                            id: responseEquipe.data.id,
                            nome: responseEquipe.data.nome,
                            descricao: responseEquipe.data.descricao,
                            responsavel: {
                                id: responseEquipe.data.id_responsavel,
                                usuario: responseEquipe.data.usuario_responsavel
                            }
                        };

                        let form = new FormData();
                        form.append('id_equipe', equipe.id);

                        let responseUsuariosEquipe = await request('../API/Usuario/readUsuariosByEquipe.php', {
                            method: "POST",
                            body: form
                        });

                        let participantesEquipe = responseUsuariosEquipe.data;

                        interactModal('modalDetalhesEquipe', 'modalEquipes');

                        DOM.equipes.detalhes.btnFechar.onclick = function () {
                            interactModal('modalDetalhesEquipe', 'modalEquipes');
                        }

                        if (usuarioLogado.id != equipe.responsavel.id) {
                            DOM.equipes.detalhes.btnEditar.style.display = 'none';
                            DOM.equipes.detalhes.btnSalvar.style.display = 'none';
                        }

                        participantesEquipe.forEach(participante => {
                            DOM.equipes.detalhes.participantes.section.insertAdjacentHTML('afterbegin', articleParticipante(participante));
                        });

                        Array.from(DOM.equipes.detalhes.participantes.modalAdicionar.select.options).forEach(option => {
                            if (participantesEquipe.find(p => p.id == option.value)) {
                                option.disabled = true;
                            }
                        })

                        DOM.equipes.detalhes.inputNome.readOnly = true;
                        DOM.equipes.detalhes.textAreaDescricao.readOnly = true;
                        DOM.equipes.detalhes.selectResponsavel.disabled = true;

                        DOM.equipes.detalhes.btnEditar.disabled = false;
                        DOM.equipes.detalhes.btnSalvar.disabled = true;

                        DOM.equipes.detalhes.inputNome.value = equipe.nome;
                        DOM.equipes.detalhes.textAreaDescricao.value = equipe.descricao;
                        DOM.equipes.detalhes.selectResponsavel.innerHTML = '<option value="" disabled>Selecione um responsável</option>';
                        DOM.equipes.detalhes.selectResponsavel.innerHTML += '<option value="' + equipe.responsavel.id + '" selected >' + equipe.responsavel.usuario + '</option>';

                        DOM.equipes.detalhes.btnParticipantes.onclick = async function () {
                            interactModal('modalParticipantesDetalhesEquipe', 'modalDetalhesEquipe');

                            DOM.equipes.detalhes.participantes.btnFechar.onclick = function () {
                                interactModal('modalParticipantesDetalhesEquipe', 'modalDetalhesEquipe');
                            }

                            if (usuarioLogado.id != equipe.responsavel.id) {
                                DOM.equipes.detalhes.participantes.btnAdicionar.style.display = 'none';
                                Array.from(DOM.equipes.detalhes.participantes.section.querySelectorAll('.btnRemover')).forEach(btn => {
                                    btn.style.display = 'none';
                                });
                            }

                            DOM.equipes.detalhes.participantes.section.addEventListener('click', async function (e) {
                                if (e.target.classList.contains('btnRemover')) {
                                    e.target.disabled = true;
                                    let articleParticipante = e.target.closest('.articleParticipante');

                                    let form = new FormData();
                                    form.append('id_usuario', articleParticipante.id);
                                    form.append('id_equipe', equipe.id);

                                    let responseDeleteUsuarioEquipe = await request('../API/Equipe/deleteUsuarioEquipe.php', {
                                        method: "POST",
                                        body: form
                                    });

                                    if (responseDeleteUsuarioEquipe.success) {
                                        participantesEquipe = participantesEquipe.filter(p => p.id !== articleParticipante.id);
                                        articleParticipante.remove();
                                        Array.from(DOM.equipes.participantes.modalAdicionar.select.options).forEach(option => {
                                            if (option.value == articleParticipante.id) {
                                                option.disabled = false;
                                            }
                                        });
                                    }

                                }
                            });

                            DOM.equipes.detalhes.participantes.btnAdicionar.onclick = () => {
                                interactModal('modalAdicionarParticipanteDetalhesEquipe', 'modalParticipantesDetalhesEquipe');

                                DOM.equipes.detalhes.participantes.modalAdicionar.querySelector('#btnFechar').onclick = () => {
                                    interactModal('modalAdicionarParticipanteDetalhesEquipe', 'modalParticipantesDetalhesEquipe');
                                }

                                DOM.equipes.detalhes.participantes.modalAdicionar.btnAdicionar.onclick = async function () {
                                    if (DOM.equipes.detalhes.participantes.modalAdicionar.select.selectedIndex != 0) {

                                        DOM.equipes.detalhes.participantes.modalAdicionar.btnAdicionar.disabled = true;

                                        let option = DOM.equipes.detalhes.participantes.modalAdicionar.select.options[DOM.equipes.detalhes.participantes.modalAdicionar.select.selectedIndex];
                                        let participante = {
                                            id: option.value, usuario: option.textContent
                                        };

                                        let form = new FormData();
                                        form.append('id_usuario', participante.id);
                                        form.append('id_equipe', equipe.id);

                                        let response = await request('../API/Equipe/addUsuarioEquipe.php', {
                                            method: 'POST',
                                            body: form
                                        });

                                        if (response.success) {
                                            participantesEquipe.push(participante);

                                            DOM.equipes.detalhes.participantes.modalAdicionar.select.selectedIndex = 0;
                                            DOM.equipes.detalhes.participantes.modalAdicionar.btnAdicionar.disabled = false;
                                            option.disabled = true;

                                            DOM.equipes.detalhes.participantes.modalAdicionar.select.insertAdjacentHTML('afterbegin', articleParticipante(participante));
                                            DOM.equipes.detalhes.participantes.modalAdicionar.info.textContent = 'Participante adicionado';
                                            setTimeout(() => {
                                                DOM.equipes.detalhes.participantes.modalAdicionar.info.textContent = '';
                                            }, 1500);
                                        }
                                    }
                                }
                            }

                        }

                        DOM.equipes.detalhes.btnEditar.onclick = () => {
                            DOM.equipes.detalhes.btnEditar.disabled = true;
                            DOM.equipes.detalhes.btnSalvar.disabled = false;
                            DOM.equipes.detalhes.inputNome.readOnly = false;
                            DOM.equipes.detalhes.textAreaDescricao.readOnly = false;
                            DOM.equipes.detalhes.selectResponsavel.disabled = false;

                            DOM.equipes.detalhes.inputNome.focus();
                        }

                        DOM.equipes.detalhes.btnSalvar.onclick = async () => {

                            equipe.nome = DOM.equipes.detalhes.inputNome.value;
                            equipe.descricao = DOM.equipes.detalhes.textAreaDescricao.value;
                            equipe.responsavel.id = DOM.equipes.detalhes.selectResponsavel.options[DOM.equipes.detalhes.selectResponsavel.selectedIndex].value;
                            equipe.responsavel.usuario = DOM.equipes.detalhes.selectResponsavel.options[DOM.equipes.detalhes.selectResponsavel.selectedIndex].textContent;

                            let validacao = novaEquipeValida(equipe);

                            if (validacao.success) {

                                let form = new FormData();
                                form.append('equipeAtualizada[id]', equipe.id);
                                form.append('equipeAtualizada[id_responsavel]', equipe.responsavel.id);
                                form.append('equipeAtualizada[nome]', equipe.nome);
                                form.append('equipeAtualizada[descricao]', equipe.descricao);

                                try {

                                    let response = await request('../API/Equipe/updateEquipe.php', {
                                        method: 'POST',
                                        body: form
                                    });

                                    if (response.success) {

                                        e.target.remove();

                                        DOM.equipes.section.insertAdjacentHTML("afterbegin", articleEquipe(equipe));

                                        DOM.equipes.detalhes.info.style.color = Colors.green;
                                        DOM.equipes.detalhes.info.textContent = 'Equipe atualizada';

                                        setTimeout(() => {
                                            DOM.equipes.detalhes.info.textContent = '';
                                        }, 1500);

                                        DOM.equipes.detalhes.inputNome.readOnly = true;
                                        DOM.equipes.detalhes.textAreaDescricao.readOnly = true;
                                        DOM.equipes.detalhes.selectResponsavel.disabled = true;

                                        DOM.equipes.detalhes.btnEditar.disabled = false;
                                        DOM.equipes.detalhes.btnSalvar.disabled = true;

                                    }
                                } catch (error) {
                                    if (error.message.includes('1062 Duplicate entry')) {
                                        DOM.equipes.detalhes.info.style.color = Colors.red;
                                        DOM.equipes.detalhes.info.textContent = 'Já existe uma equipe com esse nome no projeto';
                                        DOM.equipes.detalhes.btnSalvar.disabled = false;
                                    }
                                }
                            } else {
                                DOM.equipes.detalhes.info.style.color = Colors.red;
                                DOM.equipes.detalhes.info.textContent = validacao.message;
                            }
                        }
                    }
                }
            }
        });

        DOM.equipes.btnAdicionarEquipe.onclick = () => {
            interactModal('modalAdicionarEquipe', 'modalEquipes');

            DOM.equipes.modalAdicionar.btnCancelar.onclick = () => {
                interactModal('modalAdicionarEquipe', 'modalEquipes');
            };

            DOM.equipes.modalAdicionar.inputNome.value = '';
            DOM.equipes.modalAdicionar.textAreaDescricao.value = '';
            DOM.equipes.modalAdicionar.selectResponsavel.selectedIndex = 0;
            DOM.equipes.modalAdicionar.info.textContent = '';

            DOM.equipes.modalAdicionar.btnConcluir.onclick = async () => {
                let equipe = {
                    nome: DOM.equipes.modalAdicionar.inputNome.value,
                    descricao: DOM.equipes.modalAdicionar.textAreaDescricao.value,
                    responsavel: {
                        id: DOM.equipes.modalAdicionar.selectResponsavel.options[DOM.equipes.modalAdicionar.selectResponsavel.selectedIndex].value,
                        usuario: DOM.equipes.modalAdicionar.selectResponsavel.options[DOM.equipes.modalAdicionar.selectResponsavel.selectedIndex].textContent
                    }
                }

                let validacao = novaEquipeValida(equipe);

                if (validacao.success) {

                    DOM.equipes.modalAdicionar.btnCancelar.disabled = true;
                    DOM.equipes.modalAdicionar.btnConcluir.disabled = true;

                    let formNovaEquipe = new FormData();

                    formNovaEquipe.append('novaEquipe', JSON.stringify({
                        id_projeto: id_projeto,
                        nome: equipe.nome,
                        descricao: equipe.descricao,
                        id_responsavel: equipe.responsavel.id
                    }));

                    try {
                        let response = await request('../API/Equipe/createEquipe.php', {
                            method: "POST", body: formNovaEquipe
                        });

                        if (response.success) {
                            let novaEquipe = {
                                id: response.data.id,
                                nome: equipe.nome
                            };
                            DOM.equipes.section.insertAdjacentHTML("afterbegin", articleEquipe(novaEquipe));
                            DOM.equipes.modalAdicionar.info.style.color = Colors.green;
                            DOM.equipes.modalAdicionar.info.textContent = 'Equipe adicionada';
                            setTimeout(() => {
                                interactModal('modalAdicionarEquipe', 'modalEquipes');
                                DOM.equipes.modalAdicionar.btnCancelar.disabled = false;
                                DOM.equipes.modalAdicionar.btnConcluir.disabled = false;
                            }, 1500);
                        } else {
                            DOM.equipes.modalAdicionar.btnCancelar.disabled = false;
                            DOM.equipes.modalAdicionar.btnConcluir.disabled = false;
                        }
                    } catch (error) {
                        if (error.message.includes('1062 Duplicate entry')) {
                            DOM.equipes.modalAdicionar.info.style.color = Colors.red;
                            DOM.equipes.modalAdicionar.info.textContent = 'Já existe uma equipe com esse nome no projeto';
                            DOM.equipes.modalAdicionar.btnCancelar.disabled = false;
                            DOM.equipes.modalAdicionar.btnConcluir.disabled = false;
                            DOM.equipes.modalAdicionar.inputNome.focus();
                        }
                    }
                } else {
                    DOM.equipes.modalAdicionar.info.style.color = Colors.red;
                    DOM.equipes.modalAdicionar.info.textContent = validacao.message;
                }
            }
        }
    });

    DOM.detalhes.botoes.tarefas.addEventListener('click', async function () {
        await initTarefas("Projeto", id_projeto);
    })

    DOM.detalhes.botoes.comentarios.addEventListener('click', async function () {
        interactModal('modalComentarios', 'sectionDetalhes');

        DOM.comentarios.btnFechar.onclick = () => {
            interactModal('modalComentarios', 'sectionDetalhes');
        };

        DOM.comentarios.section.addEventListener('click', async function (e) {
            if (e.target.classList.contains('btnRemover')) {
                let articleComentario = e.target.closest('.articleComentario');

                let form = new FormData();
                form.append('id', articleComentario.id);

                let responseDeleteComentario = await request('../API/Comentario/deleteComentarioProjeto.php', {
                    method: 'POST',
                    body: form
                });

                if (responseDeleteComentario.success) {
                    articleComentario.remove();
                }
            }
        })

        DOM.comentarios.btnAdicionar.onclick = () => {
            interactModal('modalAdicionarComentario', 'modalComentarios');

            DOM.comentarios.modalAdicionar.btnCancelar.onclick = () => {
                interactModal('modalAdicionarComentario', 'modalComentarios');
                DOM.comentarios.modalAdicionar.textArea.value = '';
                DOM.comentarios.modalAdicionar.info.textContent = '';
            }

            DOM.comentarios.modalAdicionar.btnAdicionar.onclick = async () => {
                if (DOM.comentarios.modalAdicionar.textArea.value.replace(/ /g, '') === '') {
                    DOM.comentarios.modalAdicionar.info.style.color = Colors.red;
                    DOM.comentarios.modalAdicionar.info.textContent = 'O campo de comentário não pode estar vázio';
                    return;
                }

                DOM.comentarios.modalAdicionar.btnAdicionar.disabled = true;
                DOM.comentarios.modalAdicionar.btnCancelar.disabled = true;

                let form = new FormData();
                form.append('comentario[id_projeto]', id_projeto);
                form.append('comentario[id_usuario]', usuarioLogado.id);
                form.append('comentario[texto]', DOM.comentarios.modalAdicionar.textArea.value);

                let responseAddComentario = await request('../API/Comentario/addComentarioProjeto.php', {
                    method: 'POST',
                    body: form
                });

                if (responseAddComentario.success) {

                    DOM.comentarios.section.insertAdjacentHTML('afterbegin', articleComentario(responseAddComentario.data));

                    DOM.comentarios.modalAdicionar.info.style.color = Colors.green;
                    DOM.comentarios.modalAdicionar.info.textContent = 'Comentário adicionado';

                    setTimeout(() => {
                        interactModal('modalAdicionarComentario', 'modalComentarios');
                        DOM.comentarios.modalAdicionar.info.textContent = '';
                        DOM.comentarios.modalAdicionar.textArea.value = '';
                        DOM.comentarios.modalAdicionar.btnAdicionar.disabled = false;
                        DOM.comentarios.modalAdicionar.btnCancelar.disabled = false;
                    }, 1500);
                }
            }
        }

    });

    DOM.detalhes.campos.inputDataConclusao.min = new Date().toISOString().split("T")[0];

    DOM.detalhes.botoes.excluir.onclick = () => {
        interactModal('modalExcluir', 'sectionDetalhes');

        DOM.excluir.btnCancelar.onclick = () => {
            interactModal('modalExcluir', 'sectionDetalhes');
        }

        DOM.excluir.btnExcluir.onclick = async () => {
            let form = new FormData();

            form.append('id_projeto', id_projeto);

            let responseExcluir = await request('../API/Projeto/deleteProjeto.php', {method: 'POST', body: form});

            if (responseExcluir.success) {
                await initProjetos('', null);
            }
        }
    }

    DOM.detalhes.botoes.concluir.onclick = () => {
        interactModal('modalConcluir', 'sectionDetalhes');

        DOM.concluir.btnCancelar.onclick = () => {
            interactModal('modalConcluir', 'sectionDetalhes');
        }

        DOM.concluir.btnConcluir.onclick = async () => {

            let form = new FormData();
            form.append('id_projeto', id_projeto);

            let responseConcluir = await request('../API/Projeto/concluirProjeto.php', {method: 'POST', body: form});

            if (responseConcluir.success) {
                await initProjetos('', null);
            }
        }
    }

    DOM.detalhes.botoes.editar.onclick = function () {

        DOM.detalhes.botoes.editar.disabled = true;
        DOM.detalhes.botoes.concluir.disabled = true;
        DOM.detalhes.botoes.excluir.disabled = true;

        DOM.detalhes.campos.inputNome.focus();

        DOM.detalhes.campos.inputNome.readOnly = false;
        DOM.detalhes.campos.textAreaDescricao.readOnly = false;
        DOM.detalhes.campos.inputDataConclusao.readOnly = false;
        DOM.detalhes.campos.selectResponsavel.disabled = false;

        DOM.detalhes.botoes.salvar.disabled = false;
        DOM.detalhes.article.style.borderColor = Colors.blue;
    };

    DOM.detalhes.botoes.salvar.onclick = async () => {

        let editarProjeto = new FormData();

        editarProjeto.append('editarProjeto[id]', id_projeto);
        editarProjeto.append('editarProjeto[nome]', DOM.detalhes.campos.inputNome.value);
        editarProjeto.append('editarProjeto[descricao]', DOM.detalhes.campos.textAreaDescricao.value);
        editarProjeto.append('editarProjeto[dataAtualConclusao]', DOM.detalhes.campos.inputDataConclusao.value);
        editarProjeto.append('editarProjeto[id_responsavel]', DOM.detalhes.campos.selectResponsavel.value);
        editarProjeto.append('editarProjeto[dataConclusao]', '');
        editarProjeto.append('editarProjeto[status]', "Em andamento");

        try {
            let response = await request("../API/ProjetoAPI.php", {method: "POST", body: editarProjeto});
            console.log(response);
            if (response.success) {
                DOM.detalhes.article.style.borderColor = Colors.green;
                DOM.detalhes.info.color = Colors.green;
                DOM.detalhes.info.textContent = 'Projeto atualizado com sucesso!';
                setTimeout(() => {
                    DOM.detalhes.article.style.borderColor = Colors.grayLight;
                    DOM.detalhes.info.textContent = '';
                }, 2500);

                DOM.detalhes.campos.inputNome.readOnly = true;
                DOM.detalhes.campos.textAreaDescricao.readOnly = true;
                DOM.detalhes.campos.inputDataConclusao.readOnly = true;
                DOM.detalhes.campos.selectResponsavel.disabled = true;

                DOM.detalhes.botoes.salvar.disabled = true;
                DOM.detalhes.botoes.editar.disabled = false;
                DOM.detalhes.botoes.concluir.disabled = false;
                DOM.detalhes.botoes.excluir.disabled = false;
            }
        } catch (e) {
            console.log(e);
        }
    };
}
