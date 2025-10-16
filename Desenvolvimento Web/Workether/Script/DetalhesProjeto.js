import {carregarComponente, interactModal, request} from "./index.js";
import {initProjetos} from "./Projetos.js";

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

function articleEquipe(nome) {
    return '<article class="articleEquipe">' + '<p id="nome_equipe">' + nome + '</p>' + '<img class="btnRemover" src="Icones/Remover.png" alt="">' + '</article>';
}

function articleComentario(id, comentario, data, hora, usuario) {
    return '<article class="articleComentario" id="' + id + '">' + '<p class="textoComentario">' + comentario + '</p>' + '<div class="divInfo">' + '<img id="btnRemover" class="imgRemover btnRemover" src="Icones/Remover.png" alt="">' + '<p class="data">' + data + '</p>' + '<p class="hora">' + hora + '</p>' + '<div class="divUser">' + '<img src="Icones/User.png" alt="">' + '<p>' + usuario + '</p>' + '</div>' + '</div>' + '</article>';
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

    let modalComentariosDetalhesEquipe = document.querySelector('#modalComentariosDetalhesEquipe');
    let modalAdicionarComentarioDetalhesEquipe = document.querySelector('#modalAdicionarComentarioDetalhesEquipe');

    let modalComentarios = document.querySelector('#modalComentarios');
    let modalAdicionarComentario = document.querySelector('#modalAdicionarComentario');

    btnParticipantes.addEventListener('click', async function () {

        interactModal('modalParticipantes', 'sectionDetalhes');

        modalParticipantes.querySelector('#btnFechar').onclick = () => {
            interactModal('modalParticipantes', 'sectionDetalhes');
        }

        let select_participante = modalAdicionarParticipante.querySelector('#select_participante');
        let options = Array.from(select_participante.options);

        section_participantes.addEventListener('click', async function (e) {
            if (e.target.classList.contains('btnRemover')) {
                let articleParticipante = e.target.closest('.articleParticipante');

                let form = new FormData();

                form.append('id_projeto', id_projeto);
                form.append('id_usuario', articleParticipante.id);

                let response = await request('../API/Projeto/deleteUsuarioProjeto.php', {method: "POST", body: form});

                if (response.success) {
                    articleParticipante.remove();
                    optionsSelectResponsavel.forEach(o => {
                        if (o.value == articleParticipante.id) {
                            o.remove();
                        }
                    });
                    options.forEach(o => {
                        if (o.value == articleParticipante.id) {
                            o.disabled = false;
                        }
                    });
                }
            }
        })

        modalParticipantes.querySelector('#btnAdicionarParticipante').onclick = () => {
            interactModal('modalAdicionarParticipante', 'modalParticipantes');

            modalAdicionarParticipante.querySelector('#btnFechar').onclick = () => {
                interactModal('modalAdicionarParticipante', 'modalParticipantes');
            }

            modalAdicionarParticipante.querySelector('#btnAdicionar').onclick = async () => {
                let info = modalAdicionarParticipante.querySelector('#info');

                if (select_participante.selectedIndex !== 0) {
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
                        option.disabled = true;

                        selectResponsavel.insertAdjacentHTML('beforeend', '<option value="' + participante.id + '">' + participante.usuario + '</option>');
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
            } else if (e.target.classList.contains('articleEquipe')) {
                interactModal('modalDetalhesEquipe', 'modalEquipes');

                modalDetalhesEquipe.querySelector('#btnFechar').onclick = function () {
                    interactModal('modalDetalhesEquipe', 'modalEquipes');
                }

                let nomeEquipe = e.target.querySelector('#nome_equipe').textContent;

                let detalhesEquipe;

                let inputNome = modalDetalhesEquipe.querySelector('#input_nome');
                let textAreaDescricao = modalDetalhesEquipe.querySelector('#textArea_descricao');
                let selectResponsavel = modalDetalhesEquipe.querySelector('#select_responsavel');
                let btnParticipantes = modalDetalhesEquipe.querySelector('#btnParticipantes');
                let info = modalDetalhesEquipe.querySelector('#info');
                let btnEditar = modalDetalhesEquipe.querySelector('#btnEditar');
                let btnSalvar = modalDetalhesEquipe.querySelector('#btnSalvar');

                inputNome.readOnly = true;
                textAreaDescricao.readOnly = true;
                selectResponsavel.disabled = true;

                btnEditar.disabled = false;
                btnSalvar.disabled = true;

                inputNome.value = detalhesEquipe.nome;
                textAreaDescricao.value = detalhesEquipe.descricao;

                selectResponsavel.innerHTML = '<option value="" disabled>Selecione um responsável</option>';
                selectResponsavel.innerHTML += '<option value="' + detalhesEquipe.responsavel.id + '" selected >' + detalhesEquipe.responsavel.usuario + '</option>';

                btnParticipantes.onclick = async function () {
                    interactModal('modalParticipantesDetalhesEquipe', 'modalDetalhesEquipe');

                    modalParticipantesDetalhesEquipe.querySelector('#btnFechar').onclick = function () {
                        interactModal('modalParticipantesDetalhesEquipe', 'modalDetalhesEquipe');
                    }

                    let section_participantes = modalParticipantesDetalhesEquipe.querySelector('.sectionParticipantes');

                    section_participantes.innerHTML = '';

                    if (detalhesEquipe.participantes.length > 0) {
                        detalhesEquipe.participantes.forEach(p => {
                            section_participantes.insertAdjacentHTML('afterbegin', articleParticipante(p.id, p.usuario));
                        });
                    }

                    section_participantes.addEventListener('click', function (e) {
                        if (e.target.classList.contains('btnRemover')) {
                            let articleParticipante = e.target.closest('.articleParticipante');

                            articleParticipante.remove();
                            detalhesEquipe.participantes = detalhesEquipe.participantes.filter(p => p.id !== articleParticipante.id);

                        }
                    })

                    modalParticipantesDetalhesEquipe.querySelector('#btnAdicionarParticipante').onclick = () => {
                        interactModal('modalAdicionarParticipanteDetalhesEquipe', 'modalParticipantesDetalhesEquipe');

                        modalAdicionarParticipanteDetalhesEquipe.querySelector('#btnFechar').onclick = () => {
                            interactModal('modalAdicionarParticipanteDetalhesEquipe', 'modalParticipantesDetalhesEquipe');
                        }

                        let select_participante = modalAdicionarParticipanteDetalhesEquipe.querySelector('#select_participante');
                        let info = modalAdicionarParticipanteDetalhesEquipe.querySelector('#info');

                        select_participante.innerHTML = '<option value="" disabled selected>Selecione um responsável</option>';
                        select_participante.innerHTML += '<option value="' + usuarioLogado.id + '">' + usuarioLogado.usuario + '</option>';

                        modalAdicionarParticipanteDetalhesEquipe.querySelector('#btnAdicionar').onclick = () => {

                            if (select_participante.selectedIndex !== 0) {
                                let option = select_participante.options[select_participante.selectedIndex];
                                let participante = {
                                    id: option.value, usuario: option.textContent
                                }

                                detalhesEquipe.participantes.push(participante);

                                select_participante.selectedIndex = 0;
                                option.disabled = true;

                                section_participantes.insertAdjacentHTML('afterbegin', articleParticipante(participante.id, participante.usuario));
                                info.textContent = 'Participante adicionado';
                                setTimeout(() => {
                                    info.textContent = '';
                                }, 1500);

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

                btnSalvar.onclick = () => {

                    let validacao = novaEquipeValida(detalhesEquipe);

                    if (validacao.success) {

                        e.target.remove();

                        detalhesEquipe.nome = inputNome.value;
                        detalhesEquipe.descricao = textAreaDescricao.value;
                        detalhesEquipe.responsavel = {
                            id: selectResponsavel.options[selectResponsavel.selectedIndex].value,
                            usuario: selectResponsavel.options[selectResponsavel.selectedIndex].textContent,
                        };

                        sectionEquipes.insertAdjacentHTML("afterbegin", articleEquipe(detalhesEquipe.nome));

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
                    } else {
                        info.style.color = '#E65A55';
                        info.textContent = validacao.message;
                    }
                }
            }
        })

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
            let selectResponsavel = modalAdicionarEquipe.querySelector('#select_responsavel');

            inputNome.value = '';
            textAreaDescricao.value = '';
            selectResponsavel.selectedIndex = 0;
            info.textContent = '';

            selectResponsavel.innerHTML = '<option value="" disabled selected>Selecione um responsável</option>';
            selectResponsavel.innerHTML += '<option value="' + usuarioLogado.id + '">' + usuarioLogado.usuario + '</option>';

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

                    let response = await request('../API/Equipe/createEquipe.php', {
                        method: "POST", body: formNovaEquipe
                    });

                    if (response.success) {
                        sectionEquipes.insertAdjacentHTML("afterbegin", articleEquipe(novaEquipe.nome));
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
                } else {
                    info.style.color = '#E65A55';
                    info.textContent = validacao.message;
                }
            }
        }
    });

    btnTarefas.addEventListener('click', async function () {
    })

    btnComentarios.addEventListener('click', async function () {
        interactModal('modalComentarios', 'sectionDetalhes');

        modalComentarios.querySelector('#btnFechar').onclick = () => {
            interactModal('modalComentarios', 'sectionDetalhes');
        };

        let sectionComentarios = modalComentarios.querySelector('.sectionComentarios');

        sectionComentarios.addEventListener('click', function (e) {
            if (e.target.classList.contains('btnRemover')) {
                let articleComentario = e.target.closest('.articleComentario');

                articleComentario.remove();

                detalhesProjeto.comentarios = detalhesProjeto.comentarios.filter(c => c.id !== articleComentario.id);
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

            btnAdicionar.onclick = () => {
                if (!(textAreaComentario.value.replace(/ /g, '') === '')) {
                    let tempId = crypto.randomUUID();
                    let comentario = textAreaComentario.value;
                    let data = new Date().toLocaleDateString('pt-BR');
                    let hora = new Date().toLocaleTimeString('pt-BR', {
                        hour: '2-digit', minute: '2-digit', hour12: false
                    });
                    let usuario = usuarioLogado.usuario;


                    detalhesProjeto.comentarios.push({
                        id: tempId, comentario: comentario, data: data, hora: hora, usuario: usuario
                    });

                    sectionComentarios.insertAdjacentHTML('afterbegin', articleComentario(tempId, comentario, data, hora, usuario));

                    info.textContent = 'Comentário adicionado';
                    info.style.color = '#46b640';
                    btnSalvar.disabled = true;
                    btnCancelar.disabled = true;

                    setTimeout(() => {
                        interactModal('modalAdicionarComentario', 'modalComentarios');
                        info.textContent = '';
                        textAreaComentario.value = '';
                        btnSalvar.disabled = false;
                        btnCancelar.disabled = false;
                    }, 1500);
                } else {
                    info.textContent = 'O campo de comentário não pode estar vázio';
                    info.style.color = '#E65A55';
                }
            }
        }

    });

    inputDataConclusao.min = new Date().toISOString().split("T")[0];

    btnEditar.onclick = () => {

        btnEditar.disabled = true;

        inputNome.focus();

        inputNome.readOnly = false;
        textAreaDescricao.readOnly = false;
        inputDataConclusao.readOnly = false;
        selectResponsavel.disabled = false;

        btnSalvar.disabled = false;
        articleDetalhes.style.borderColor = "rgba(5, 104, 230, 0.75)";
    }

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
