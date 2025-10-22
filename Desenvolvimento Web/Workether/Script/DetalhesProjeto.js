import {carregarComponente, interactModal, request} from "./index.js";
import {initProjetos} from "./Projetos.js";
import {initTarefas} from "./Tarefas.js";

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

    if (novaEquipe.responsavel.id === '' || novaEquipe.responsavel.usuario === '') {
        return {
            success: false, message: 'Selecione um responsável para a equipe'
        };
    }

    return {
        success: true, message: 'Equipe válida'
    };
}

function articleParticipante(id, usuario) {
    return '<article class="articleParticipante" id="' + id + '">\n' + '<p class="usuario_participante">' + usuario + '</p>\n' + '<img class="btnRemover" src="Icones/Remover.png" alt="">\n' + '</article>';
}

function articleEquipe(id, nome) {
    return '<article id="' + id + '" class="articleEquipe">' + '<p id="nome_equipe">' + nome + '</p>' + '<img class="btnRemover" src="Icones/Remover.png" alt="">' + '</article>';
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

export async function initDetalhesProjeto(id_projeto) {

    await carregarComponente('Loading.php');

    await carregarComponente('DetalhesProjeto.php?id=' + id_projeto);

    document.querySelector('#btnVoltar').onclick = async () => {
        await initProjetos();
    }

    let usuarioLogado = {
        id: document.querySelector('.usuarioLogado').id,
        usuario: document.querySelector('.usuarioLogado').textContent
    };

    let detalhesProjeto = {
        nome: '', descricao: '', responsavel: {
            id: '', usuario: '',
        }, dataConclusao: ''
    }

    let articleDetalhes = document.querySelector('.articleDetalhes');

    // Inputs

    let inputNome = document.querySelector('#inputNome');
    let textAreaDescricao = document.querySelector('#textArea_descricao');
    let selectResponsavel = document.querySelector('.divResponsavel_Participantes_Equipes #select_responsavel');
    let optionsSelectResponsavel = Array.from(selectResponsavel.options);

    // Buttons

    let btnParticipantes = document.querySelector('.divResponsavel_Participantes_Equipes #btnParticipantes');
    let btnEquipes = document.querySelector('.divResponsavel_Participantes_Equipes #btnEquipes');
    let btnTarefas = document.querySelector('.divDataConclusao_Tarefas_Comentarios #btnTarefas');
    let inputDataConclusao = document.querySelector('.divDataConclusao_Tarefas_Comentarios #inputDataConclusao');
    let btnComentarios = document.querySelector('.divDataConclusao_Tarefas_Comentarios #btnComentarios');
    let info = articleDetalhes.querySelector('#info');
    let btnExcluir = document.querySelector('#btnExcluir');
    let btnConcluir = document.querySelector('#btnConcluir');
    let btnEditar = document.querySelector('.divEditar_Salvar #btnEditar');
    let btnSalvar = document.querySelector('.divEditar_Salvar #btnSalvar');

    // Modais

    let modalParticipantes = document.querySelector('#modalParticipantes');
    let modalAdicionarParticipante = document.querySelector('#modalAdicionarParticipante');

    let section_participantes = modalParticipantes.querySelector('.sectionParticipantes');

    selectResponsavel.addEventListener('change', function (e) {
        let articlesParticipantes = Array.from(section_participantes.querySelectorAll('.articleParticipante'));
        articlesParticipantes.forEach(article => {
            if (article.id === e.target.value) {
                article.querySelector('.btnRemover').remove();
            } else if (article.querySelector('img') === null) {
                article.insertAdjacentHTML('beforeend', '<img class="btnRemover" src="Icones/Remover.png" alt="">');
            }
        })
    });

    let modalEquipes = document.querySelector('#modalEquipes');
    let modalAdicionarEquipe = document.querySelector('#modalAdicionarEquipe');

    let modalParticipantesEquipe = document.querySelector('#modalParticipantesEquipe');
    let modalAdicionarParticipanteEquipe = document.querySelector('#modalAdicionarParticipantesEquipe');

    let modalDetalhesEquipe = document.querySelector('#modalDetalhesEquipe');

    let modalParticipantesDetalhesEquipe = document.querySelector('#modalParticipantesDetalhesEquipe');
    let modalAdicionarParticipanteDetalhesEquipe = document.querySelector('#modalAdicionarParticipanteDetalhesEquipe');
    let selectParticipanteDetalhesEquipe = modalAdicionarParticipanteDetalhesEquipe.querySelector('#select_participante');

    let modalComentarios = document.querySelector('#modalComentarios');
    let modalAdicionarComentario = document.querySelector('#modalAdicionarComentario');

    let modalExcluir = document.querySelector('#modalExcluir');
    let btnCancelarModalExcluir = modalExcluir.querySelector('#btnCancelarModalExcluir');
    let btnExcluirModalExcluir = modalExcluir.querySelector('#btnExcluirModalExcluir');

    let modalConcluir = document.querySelector('#modalConcluir');
    let inputDataModalConcluir = document.querySelector('#inputDataModalConcluir');
    let btnCancelarModalConcluir = modalConcluir.querySelector('#btnCancelarModalConcluir');
    let btnConcluirModalConcluir = modalConcluir.querySelector('#btnConcluirModalConcluir');

    inputDataModalConcluir.min = document.querySelector('#dataCriacao').textContent;

    if (document.querySelector('#status').textContent == 'Concluido') {
        btnConcluir.style.display = 'none';
        btnEditar.style.display = 'none';
        btnSalvar.style.display = 'none';

        if (document.querySelector('#id_responsavel').textContent == usuarioLogado.id) {
            btnExcluir.style.display = 'none';
        }
    }

    btnParticipantes.addEventListener('click', async function () {

        interactModal('modalParticipantes', 'sectionDetalhes');

        modalParticipantes.querySelector('#btnFechar').onclick = () => {
            interactModal('modalParticipantes', 'sectionDetalhes');
        }

        let select_participante = modalAdicionarParticipante.querySelector('#select_participante');

        section_participantes.addEventListener('click', async function (e) {
            if (e.target.classList.contains('btnRemover')) {
                e.stopPropagation();
                let articleParticipante = e.target.closest('.articleParticipante');

                let form = new FormData();

                form.append('id_projeto', id_projeto);
                form.append('id_usuario', articleParticipante.id);

                let response = await request('../API/Projeto/deleteUsuarioProjeto.php', {method: "POST", body: form});

                if (response.success) {
                    articleParticipante.remove();
                    Array.from(selectResponsavel.options).forEach(o => {
                        if (o.value == articleParticipante.id) {
                            o.remove();
                        }
                    });
                    Array.from(select_participante.options).forEach(o => {
                        if (o.value == articleParticipante.id) {
                            o.disabled = false;
                        }
                    });
                    Array.from(modalAdicionarEquipe.querySelector('#select_responsavel').options).forEach(o => {
                        if (o.value == articleParticipante.id) {
                            o.remove();
                        }
                    });
                }
            }
        });

        modalParticipantes.querySelector('#btnAdicionarParticipante').onclick = () => {
            interactModal('modalAdicionarParticipante', 'modalParticipantes');

            modalAdicionarParticipante.querySelector('#btnFechar').onclick = () => {
                interactModal('modalAdicionarParticipante', 'modalParticipantes');
            }

            let btnAdicionar = modalAdicionarParticipante.querySelector('#btnAdicionar');

            btnAdicionar.onclick = async () => {
                let info = modalAdicionarParticipante.querySelector('#info');

                if (select_participante.selectedIndex !== 0) {

                    btnAdicionar.disabled = true;

                    let option = select_participante.options[select_participante.selectedIndex];
                    let participante = {
                        id: option.value, usuario: option.textContent
                    }

                    let form = new FormData();
                    form.append('id_usuario', participante.id);
                    form.append('id_projeto', id_projeto);

                    let response = await request('../API/Projeto/addUsuarioProjeto.php', {method: "POST", body: form})

                    if (response.success) {

                        select_participante.selectedIndex = 0;
                        btnAdicionar.disabled = false;
                        option.disabled = true;

                        selectResponsavel.insertAdjacentHTML('beforeend', '<option value="' + participante.id + '">' + participante.usuario + '</option>');
                        modalAdicionarEquipe.querySelector('#select_responsavel').insertAdjacentHTML('beforeend',
                            '<option value="' + participante.id + '">' + participante.usuario + '</option>');
                        section_participantes.insertAdjacentHTML('afterbegin', articleParticipante(participante.id, participante.usuario));
                        info.textContent = 'Participante adicionado';
                        setTimeout(() => {
                            info.textContent = '';
                        }, 1500);
                        console.log(response);
                    }
                }
            }
        }

    });

    btnEquipes.addEventListener('click', async function () {
        interactModal('modalEquipes', 'sectionDetalhes');

        modalEquipes.querySelector('#btnFechar').onclick = () => {
            interactModal('modalEquipes', 'sectionDetalhes');
        }

        let sectionEquipes = modalEquipes.querySelector('.sectionEquipes');

        sectionEquipes.addEventListener('click', async function (e) {
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

                        let equipe = {};
                        equipe.id = responseEquipe.data.id;
                        equipe.nome = responseEquipe.data.nome;
                        equipe.descricao = responseEquipe.data.descricao;
                        equipe.responsavel = {
                            id: responseEquipe.data.id_responsavel,
                            usuario: responseEquipe.data.usuario_responsavel
                        };

                        let form = new FormData();
                        form.append('id_equipe', equipe.id);

                        let responseUsuariosEquipe = await request('../API/Usuario/readUsuariosByEquipe.php', {
                            method: "POST",
                            body: form
                        });

                        let participantesEquipe = responseUsuariosEquipe.data;

                        console.log(responseUsuariosEquipe);
                        interactModal('modalDetalhesEquipe', 'modalEquipes');

                        modalDetalhesEquipe.querySelector('#btnFechar').onclick = function () {
                            interactModal('modalDetalhesEquipe', 'modalEquipes');
                        }

                        let inputNome = modalDetalhesEquipe.querySelector('#input_nome');
                        let textAreaDescricao = modalDetalhesEquipe.querySelector('#textArea_descricao');
                        let selectResponsavel = modalDetalhesEquipe.querySelector('#select_responsavel');
                        let btnParticipantes = modalDetalhesEquipe.querySelector('#btnParticipantes');
                        let sectionParticipantesDetalhesEquipe = modalParticipantesDetalhesEquipe.querySelector('.sectionParticipantes');
                        let info = modalDetalhesEquipe.querySelector('#info');
                        let btnEditar = modalDetalhesEquipe.querySelector('#btnEditar');
                        let btnSalvar = modalDetalhesEquipe.querySelector('#btnSalvar');

                        participantesEquipe.forEach(participante => {
                            sectionParticipantesDetalhesEquipe.insertAdjacentHTML('afterbegin', articleParticipante(participante.id, participante.usuario));
                        });

                        Array.from(selectParticipanteDetalhesEquipe.options).forEach(option => {
                            if (participantesEquipe.find(participante => participante.id == option.value)) {
                                option.disabled = true;
                            }
                        })

                        inputNome.readOnly = true;
                        textAreaDescricao.readOnly = true;
                        selectResponsavel.disabled = true;

                        btnEditar.disabled = false;
                        btnSalvar.disabled = true;

                        inputNome.value = equipe.nome;
                        textAreaDescricao.value = equipe.descricao;
                        selectResponsavel.innerHTML = '<option value="" disabled>Selecione um responsável</option>';
                        selectResponsavel.innerHTML += '<option value="' + equipe.responsavel.id + '" selected >' + equipe.responsavel.usuario + '</option>';

                        btnParticipantes.onclick = async function () {
                            interactModal('modalParticipantesDetalhesEquipe', 'modalDetalhesEquipe');

                            modalParticipantesDetalhesEquipe.querySelector('#btnFechar').onclick = function () {
                                interactModal('modalParticipantesDetalhesEquipe', 'modalDetalhesEquipe');
                            }

                            sectionParticipantesDetalhesEquipe.addEventListener('click', async function (e) {
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
                                        Array.from(selectParticipanteDetalhesEquipe.options).forEach(option => {
                                            if (option.value == articleParticipante.id) {
                                                option.disabled = false;
                                            }
                                        });
                                    }

                                    console.log(responseDeleteUsuarioEquipe);

                                }
                            })

                            modalParticipantesDetalhesEquipe.querySelector('#btnAdicionarParticipante').onclick = () => {
                                interactModal('modalAdicionarParticipanteDetalhesEquipe', 'modalParticipantesDetalhesEquipe');

                                modalAdicionarParticipanteDetalhesEquipe.querySelector('#btnFechar').onclick = () => {
                                    interactModal('modalAdicionarParticipanteDetalhesEquipe', 'modalParticipantesDetalhesEquipe');
                                }

                                let info = modalAdicionarParticipanteDetalhesEquipe.querySelector('#info');

                                modalAdicionarParticipanteDetalhesEquipe.querySelector('#btnAdicionar').onclick = async function () {

                                    if (selectParticipanteDetalhesEquipe.selectedIndex != 0) {

                                        this.disabled = true;

                                        let option = selectParticipanteDetalhesEquipe.options[selectParticipanteDetalhesEquipe.selectedIndex];
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

                                            selectParticipanteDetalhesEquipe.selectedIndex = 0;
                                            this.disabled = false;
                                            option.disabled = true;

                                            sectionParticipantesDetalhesEquipe.insertAdjacentHTML('afterbegin', articleParticipante(participante.id, participante.usuario));
                                            info.textContent = 'Participante adicionado';
                                            setTimeout(() => {
                                                info.textContent = '';
                                            }, 1500);
                                        }
                                    }


                                }
                            }

                        }

                        btnEditar.onclick = () => {
                            btnEditar.disabled = true;
                            btnSalvar.disabled = false;
                            inputNome.readOnly = false;
                            textAreaDescricao.readOnly = false;
                            selectResponsavel.disabled = false;

                            inputNome.focus();
                        }

                        btnSalvar.onclick = async () => {

                            equipe.nome = inputNome.value;
                            equipe.descricao = textAreaDescricao.value;
                            equipe.responsavel.id = selectResponsavel.options[selectResponsavel.selectedIndex].value;
                            equipe.responsavel.usuario = selectResponsavel.options[selectResponsavel.selectedIndex].textContent;

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

                                        sectionEquipes.insertAdjacentHTML("afterbegin", articleEquipe(equipe.id, equipe.nome));

                                        info.style.color = '#75CE70';
                                        info.textContent = 'Equipe atualizada';

                                        setTimeout(() => {
                                            info.textContent = '';
                                        }, 1500);

                                        inputNome.readOnly = true;
                                        textAreaDescricao.readOnly = true;
                                        selectResponsavel.disabled = true;

                                        btnEditar.disabled = false;
                                        btnSalvar.disabled = true;

                                    }
                                } catch (error) {
                                    if (error.message.includes('1062 Duplicate entry')) {
                                        info.style.color = '#E65A55';
                                        info.textContent = 'Já existe uma equipe com esse nome no projeto';
                                        btnSalvar.disabled = false;
                                    }
                                }
                            } else {
                                info.style.color = '#E65A55';
                                info.textContent = validacao.message;
                            }
                        }
                    }

                    console.log(responseEquipe);
                }
            }
        });

        modalEquipes.querySelector('#btnAdicionarEquipe').onclick = () => {
            interactModal('modalAdicionarEquipe', 'modalEquipes');

            let btnCancelar = modalAdicionarEquipe.querySelector('#btnCancelar')

            btnCancelar.onclick = () => {
                interactModal('modalAdicionarEquipe', 'modalEquipes');
            };

            let novaEquipe = {
                nome: '', descricao: '', responsavel: {
                    id: '', usuario: ''
                }, participantes: []
            }

            let info = modalAdicionarEquipe.querySelector('#info');

            let inputNome = modalAdicionarEquipe.querySelector('#input_nome');
            let textAreaDescricao = modalAdicionarEquipe.querySelector('#textArea_descricao');
            let selectResponsavelEquipe = modalAdicionarEquipe.querySelector('#select_responsavel');

            inputNome.value = '';
            textAreaDescricao.value = '';
            selectResponsavelEquipe.selectedIndex = 0;
            info.textContent = '';

            let btnConcluir = modalAdicionarEquipe.querySelector('#btnConcluir')

            btnConcluir.onclick = async () => {
                novaEquipe.nome = inputNome.value;
                novaEquipe.descricao = textAreaDescricao.value;
                novaEquipe.responsavel.id = selectResponsavel.options[selectResponsavel.selectedIndex].value;
                novaEquipe.responsavel.usuario = selectResponsavel.options[selectResponsavel.selectedIndex].textContent;

                let validacao = novaEquipeValida(novaEquipe);

                if (validacao.success) {

                    btnCancelar.disabled = true;
                    btnConcluir.disabled = true;

                    let formNovaEquipe = new FormData();

                    formNovaEquipe.append('novaEquipe', JSON.stringify({
                        id_projeto: id_projeto,
                        nome: novaEquipe.nome,
                        descricao: novaEquipe.descricao,
                        id_responsavel: novaEquipe.responsavel.id
                    }));

                    try {
                        let response = await request('../API/Equipe/createEquipe.php', {
                            method: "POST", body: formNovaEquipe
                        });

                        if (response.success) {
                            sectionEquipes.insertAdjacentHTML("afterbegin", articleEquipe(response.data.id, novaEquipe.nome));
                            info.style.color = '#46b640';
                            info.textContent = 'Equipe adicionada';
                            setTimeout(() => {
                                interactModal('modalAdicionarEquipe', 'modalEquipes');
                                btnCancelar.disabled = false;
                                btnConcluir.disabled = false;
                            }, 1500);
                        } else {
                            btnCancelar.disabled = false;
                            btnConcluir.disabled = false;
                        }
                    } catch (error) {
                        if (error.message.includes('1062 Duplicate entry')) {
                            info.style.color = '#E65A55';
                            info.textContent = 'Já existe uma equipe com esse nome no projeto';
                            btnCancelar.disabled = false;
                            btnConcluir.disabled = false;
                            inputNome.focus();
                        }
                    }
                } else {
                    info.style.color = '#E65A55';
                    info.textContent = validacao.message;
                }
            }
        }
    });

    btnTarefas.addEventListener('click', async function () {
        await initTarefas("Projeto", id_projeto);
    })

    btnComentarios.addEventListener('click', async function () {
        interactModal('modalComentarios', 'sectionDetalhes');

        modalComentarios.querySelector('#btnFechar').onclick = () => {
            interactModal('modalComentarios', 'sectionDetalhes');
        };

        let sectionComentarios = modalComentarios.querySelector('.sectionComentarios');

        sectionComentarios.addEventListener('click', async function (e) {
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

                console.log(responseDeleteComentario);

            }
        })

        modalComentarios.querySelector('#btnAdicionarComentario').onclick = () => {
            interactModal('modalAdicionarComentario', 'modalComentarios');

            let btnCancelar = modalAdicionarComentario.querySelector('#btnCancelar');

            let textAreaComentario = modalAdicionarComentario.querySelector('#textArea_comentario');
            let info = modalAdicionarComentario.querySelector('#info');

            btnCancelar.onclick = () => {
                interactModal('modalAdicionarComentario', 'modalComentarios');
                textAreaComentario.value = '';
                info.textContent = '';
            }

            let btnAdicionar = modalAdicionarComentario.querySelector('#btnAdicionar');

            btnAdicionar.onclick = async () => {
                if (!(textAreaComentario.value.replace(/ /g, '') === '')) {

                    btnAdicionar.disabled = true;
                    btnCancelar.disabled = true;

                    let form = new FormData();
                    form.append('comentario[id_projeto]', id_projeto);
                    form.append('comentario[id_usuario]', usuarioLogado.id);
                    form.append('comentario[texto]', textAreaComentario.value);

                    let responseAddComentario = await request('../API/Comentario/addComentarioProjeto.php', {
                        method: 'POST',
                        body: form
                    });

                    if (responseAddComentario.success) {

                        sectionComentarios.insertAdjacentHTML('afterbegin', articleComentario(responseAddComentario.data));

                        info.textContent = 'Comentário adicionado';
                        info.style.color = '#46b640';

                        setTimeout(() => {
                            interactModal('modalAdicionarComentario', 'modalComentarios');
                            info.textContent = '';
                            textAreaComentario.value = '';
                            btnAdicionar.disabled = false;
                            btnCancelar.disabled = false;
                        }, 1500);
                    }
                } else {
                    info.textContent = 'O campo de comentário não pode estar vázio';
                    info.style.color = '#E65A55';
                }
            }
        }

    });

    inputDataConclusao.min = new Date().toISOString().split("T")[0];

    btnExcluir.onclick = () => {
        interactModal('modalExcluir', 'sectionDetalhes');

        btnCancelarModalExcluir.onclick = () => {
            interactModal('modalExcluir', 'sectionDetalhes');
        }

        btnExcluirModalExcluir.onclick = async () => {
            let form = new FormData();

            form.append('id_projeto', id_projeto);

            let responseExcluir = await request('../API/Projeto/deleteProjeto.php', {method: 'POST', body: form});

            if (responseExcluir.success) {
                await initProjetos('', null);
            }
        }
    }

    btnConcluir.onclick = () => {
        interactModal('modalConcluir', 'sectionDetalhes');

        btnCancelarModalConcluir.onclick = () => {
            interactModal('modalConcluir', 'sectionDetalhes');
        }

        btnConcluirModalConcluir.onclick = async () => {

            inputDataModalConcluir.required = true;

            if (!inputDataModalConcluir.checkValidity() || inputDataModalConcluir.value === '') {
                inputDataModalConcluir.reportValidity();
                return;
            }

            let form = new FormData();
            form.append('id_projeto', id_projeto);
            form.append('dataConclusao', inputDataModalConcluir.value);

            let responseConcluir = await request('../API/Projeto/concluirProjeto.php', {method: 'POST', body: form});

            if (responseConcluir.success) {
                await initProjetos('', null);
            }
        }
    }

    btnEditar.onclick = () => {

        btnEditar.disabled = true;

        inputNome.focus();

        inputNome.readOnly = false;
        textAreaDescricao.readOnly = false;
        inputDataConclusao.readOnly = false;
        selectResponsavel.disabled = false;

        btnSalvar.disabled = false;
        articleDetalhes.style.borderColor = "rgba(5, 104, 230, 0.75)";
    };

    btnSalvar.onclick = async () => {

        let editarProjeto = new FormData();

        editarProjeto.append('editarProjeto[id]', id_projeto);
        editarProjeto.append('editarProjeto[nome]', inputNome.value);
        editarProjeto.append('editarProjeto[descricao]', textAreaDescricao.value);
        editarProjeto.append('editarProjeto[dataAtualConclusao]', inputDataConclusao.value);
        editarProjeto.append('editarProjeto[id_responsavel]', selectResponsavel.value);
        editarProjeto.append('editarProjeto[dataConclusao]', '');
        editarProjeto.append('editarProjeto[status]', "Em andamento");

        try {
            let response = await request("../API/ProjetoAPI.php", {method: "POST", body: editarProjeto});
            console.log(response);
            if (response.success) {
                articleDetalhes.style.borderColor = "#75CE70";
                info.textContent = 'Projeto atualizado com sucesso!';
                setTimeout(() => {
                    articleDetalhes.style.borderColor = "rgba(195, 195, 195, 0.5)";
                    info.textContent = '';
                }, 5000);

                inputNome.readOnly = true;
                textAreaDescricao.readOnly = true;
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
