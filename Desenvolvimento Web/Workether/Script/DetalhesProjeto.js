import {carregarComponente, interactModal, request} from "./index.js";
import {initProjetos} from "./Projetos.js";

function novaEquipeValida(novaEquipe, equipes) {

    if (equipes.find(e => e.nome === novaEquipe.nome)) {
        return {
            success: false,
            message: 'Já existe uma equipe no projeto com este nome'
        };
    }

    if (novaEquipe.nome.replace(/ /g, '') === '') {
        return {
            success: false,
            message: 'O nome da equipe não pode estar vázio'
        };
    }

    if (novaEquipe.descricao.replace(/ /g, '') === '') {
        return {
            success: false,
            message: 'A descrição da equipe não pode estar vázia'
        };
    }

    if (novaEquipe.responsavel.id === '' || novaEquipe.responsavel.usuario === '') {
        return {
            success: false,
            message: 'Selecione um responsável para a equipe'
        };
    }

    return {
        success: true,
        message: 'Equipe adicionada'
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
        }, dataConclusao: '', participantes: [], equipes: [], comentarios: []
    }

    let articleDetalhes = document.querySelector('.articleDetalhes');

    // Inputs

    let inputNome = document.querySelector('#inputNome');
    let textAreaDescricao = document.querySelector('#textArea_descricao');
    let selectResponsavel = document.querySelector('.divResponsavel_Participantes_Equipes #select_responsavel');

    // Buttons

    let btnParticipantes = document.querySelector('.divResponsavel_Participantes_Equipes #btnParticipantes');
    let btnEquipes = document.querySelector('.divResponsavel_Participantes_Equipes #btnEquipes');
    let btnTarefas = document.querySelector('.divDataConclusao_Tarefas_Comentarios #btnTarefas');
    let inputDataConclusao = document.querySelector('.divDataConclusao_Tarefas_Comentarios #inputDataConclusao');
    let btnComentarios = document.querySelector('.divDataConclusao_Tarefas_Comentarios #btnComentarios');
    let btnEditar = document.querySelector('.divEditar_Salvar #btnEditar');
    let btnSalvar = document.querySelector('.divEditar_Salvar #btnSalvar');

    // Modais

    let modalParticipantes = document.querySelector('#modalParticipantes');
    let modalAdicionarParticipante = document.querySelector('#modalAdicionarParticipante');

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

        let section_participantes = modalParticipantes.querySelector('.sectionParticipantes');

        section_participantes.addEventListener('click', function (e) {
            if (e.target.classList.contains('btnRemover')) {
                let articleParticipante = e.target.closest('.articleParticipante');

                articleParticipante.remove();
                detalhesProjeto.participantes = detalhesProjeto.participantes.filter(p => p.id !== articleParticipante.id);

            }
        })

        modalParticipantes.querySelector('#btnAdicionarParticipante').onclick = () => {
            interactModal('modalAdicionarParticipante', 'modalParticipantes');

            modalAdicionarParticipante.querySelector('#btnFechar').onclick = () => {
                interactModal('modalAdicionarParticipante', 'modalParticipantes');
            }

            modalAdicionarParticipante.querySelector('#btnAdicionar').onclick = () => {
                let select_participante = modalAdicionarParticipante.querySelector('#select_participante');
                let info = modalAdicionarParticipante.querySelector('#info');

                if (select_participante.selectedIndex !== 0) {
                    let option = select_participante.options[select_participante.selectedIndex];
                    let participante = {
                        id: option.value, usuario: option.textContent
                    }

                    detalhesProjeto.participantes.push(participante);

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
                articleEquipe.remove();

                detalhesProjeto.equipes = detalhesProjeto.equipes.filter(e => e.nome !== articleEquipe.querySelector('#nome_equipe').textContent);
            }
        })

        modalEquipes.querySelector('#btnAdicionarEquipe').onclick = () => {
            interactModal('modalAdicionarEquipe', 'modalEquipes');

            let btnCancelar = modalAdicionarEquipe.querySelector('#btnCancelar')

            btnCancelar.onclick = () => {
                interactModal('modalAdicionarEquipe', 'modalEquipes');
            };

            let novaEquipe = {
                nome: '',
                descricao: '',
                responsavel: {
                    id: '',
                    usuario: ''
                }
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
            detalhesProjeto.participantes.forEach(p => {
                selectResponsavel.innerHTML += '<option value="' + p.id + '">' + p.usuario + '</option>';
            });

            let btnConcluir = modalAdicionarEquipe.querySelector('#btnConcluir')

            btnConcluir.onclick = () => {
                novaEquipe.nome = inputNome.value;
                novaEquipe.descricao = textAreaDescricao.value;
                novaEquipe.responsavel.id = selectResponsavel.options[selectResponsavel.selectedIndex].value;
                novaEquipe.responsavel.usuario = selectResponsavel.options[selectResponsavel.selectedIndex].textContent;

                let validacao = novaEquipeValida(novaEquipe, detalhesProjeto.equipes);

                if (validacao.success) {
                    detalhesProjeto.equipes.push(novaEquipe);
                    sectionEquipes.insertAdjacentHTML("afterbegin", articleEquipe(novaEquipe.nome));
                    info.style.color = '#46b640';
                    btnCancelar.disabled = true;
                    btnConcluir.disabled = true;
                    setTimeout(() => {
                        interactModal('modalAdicionarEquipe', 'modalEquipes');
                        btnCancelar.disabled = false;
                        btnConcluir.disabled = false;
                    }, 1500);
                } else {
                    info.style.color = '#E65A55';
                }
                info.textContent = validacao.message;
            }
        }
    })

    btnComentarios.addEventListener('click', async function () {
        interactModal('modalComentarios', 'sectionDetalhes');

        setInterval(() => {
            console.log(detalhesProjeto.comentarios);
        }, 5000);


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
                        hour: '2-digit',
                        minute: '2-digit',
                        hour12: false
                    });
                    let usuario = usuarioLogado.usuario;


                    detalhesProjeto.comentarios.push({
                        id: tempId,
                        comentario: comentario,
                        data: data,
                        hora: hora,
                        usuario: usuario
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
