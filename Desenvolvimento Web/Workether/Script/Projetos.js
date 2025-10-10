import {carregarComponente, interactModal, request} from "./index.js";

export function initProjetos() {

    document.querySelector('#btnVoltar').onclick = async () => {
        await carregarComponente('PaginaInicial.php');
        let btnProjetos = document.querySelector('#btnProjetos');
        let srcImg = btnProjetos.firstElementChild.getAttribute('src');
        btnProjetos.classList.toggle('Selected');
        btnProjetos.firstElementChild.setAttribute('src', srcImg.replace("Selected", ""));
    }

    let projetos = document.querySelectorAll('.articleProjeto');

    function novaEquipeValida(novaEquipe) {
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
        return '<article class="articleParticipante" id="' + id + '">\n' +
            '<p class="usuario_participante">' + usuario + '</p>\n' +
            '<img class="btnRemover" src="Icones/Remover.png" alt="">\n' +
            '</article>';
    }

    function articleEquipe(nome) {
        return '<article class="articleEquipe">' +
            '<p id="nome_equipe">' + nome + '</p>' +
            '<img class="btnRemover" src="Icones/Remover.png" alt="">' +
            '</article>';
    }

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

    document.querySelector('#btnAdicionarProjeto').onclick = async () => {

        await carregarComponente("NovoProjeto.php");

        let participantes = [];
        let equipes = [];

        setInterval(() => {
            console.log(equipes);
        }, 5000);

        document.querySelector('#btnVoltar').onclick = () => {
            btnProjetos.click();
        }

        document.querySelector('#inputDataConclusao').min = new Date().toISOString().split("T")[0];

        document.querySelector('.articleDetalhes #btnParticipantes').onclick = function () {

            let selectParticipante = document.getElementById('select_participante');

            interactModal('modalParticipantes', 'sectionDetalhes');

            document.querySelector('#modalParticipantes #btnFechar').onclick = () => {
                interactModal('modalParticipantes', 'sectionDetalhes');
            }

            document.querySelector('#btnAdicionarParticipante').onclick = () => {

                interactModal('modalAdicionarParticipante', 'modalParticipantes');

                document.querySelector('#modalAdicionarParticipante #btnFechar').onclick = () => {
                    interactModal('modalAdicionarParticipante', 'modalParticipantes');
                };

                document.querySelector('#modalAdicionarParticipante #btnAdicionar').onclick = () => {

                    if (selectParticipante.selectedIndex === 0) {
                        return;
                    }

                    let info = document.querySelector('#modalAdicionarParticipante #info');

                    let option = selectParticipante.options[selectParticipante.selectedIndex];
                    let idParticipante = option.value;
                    let usuarioParticipante = option.textContent;

                    document.querySelector('#sectionParticipantes').insertAdjacentHTML('afterbegin', articleParticipante(idParticipante, usuarioParticipante));

                    option.disabled = true;
                    selectParticipante.options[0].selected = true;

                    info.textContent = 'Participante adicionado';
                    setTimeout(() => {
                        info.textContent = ''
                    }, 1000);

                    participantes.unshift({id: idParticipante, usuario: usuarioParticipante});

                }
            };

            document.querySelector('#modalParticipantes #sectionParticipantes').addEventListener('click', e => {

                if (e.target.classList.contains('btnRemover')) {
                    let idParticipante = e.target.closest('.articleParticipante').id;
                    let usuarioParticipante = e.target.closest('.articleParticipante').querySelector('.usuario_participante').textContent;
                    e.target.closest('.articleParticipante').remove();

                    selectParticipante.querySelectorAll('option').forEach(option => {
                        if (option.value === idParticipante) {
                            option.disabled = false;
                        }
                    })

                    participantes = participantes.filter(p => p.id !== idParticipante);

                }

            });

        };

        document.querySelector('.articleDetalhes #btnEquipes').onclick = function () {

            interactModal('modalEquipes', 'sectionDetalhes');

            document.querySelector('#modalEquipes #btnFechar').onclick = () => {
                interactModal('modalEquipes', 'sectionDetalhes');
            }

            let sectionEquipes = document.querySelector('#modalEquipes .sectionEquipes');

            sectionEquipes.addEventListener('click', e => {
                if (e.target.classList.contains('btnRemover')) {
                    let nomeEquipe = e.target.closest('.articleEquipe').querySelector('#nome_equipe').textContent;
                    e.target.closest('.articleEquipe').remove();

                    equipes = equipes.filter(e => e.nome !== nomeEquipe);

                } else if (e.target.classList.contains('articleEquipe')) {

                    let modalDetalhesEquipe = document.querySelector('#modalDetalhesEquipe');

                    let nomeEquipe = e.target.querySelector('#nome_equipe').textContent;

                    let detalhesEquipe = equipes.find(e => e.nome === nomeEquipe);

                    let inputNomeDetalhesEquipe = modalDetalhesEquipe.querySelector('#inputNome');
                    let textAreaDescricaoDetalhesEquipe = modalDetalhesEquipe.querySelector('#textArea_descricao');
                    let selectResposavelDetalhesEquipe = modalDetalhesEquipe.querySelector('#select_responsavel');

                    console.log(e.target);

                    inputNomeDetalhesEquipe.value = detalhesEquipe.nome;
                    textAreaDescricaoDetalhesEquipe.value = detalhesEquipe.descricao;
                    selectResposavelDetalhesEquipe.innerHTML = '<option value="' + detalhesEquipe.responsavel.id + '" selected>' + detalhesEquipe.responsavel.nome + '</option>';
                    participantes.forEach(p => {
                        selectResposavelDetalhesEquipe.innerHTML += '<option value="' + p.id + '">' + p.usuario + '</option>';
                    });

                    interactModal('modalDetalhesEquipe', 'modalEquipes');
                }
            })

            document.querySelector('#modalEquipes #btnAdicionarEquipe').onclick = function () {

                let modalAdicionarEquipe = document.querySelector('#modalAdicionarEquipe');

                interactModal('modalAdicionarEquipe', 'modalEquipes');

                let novaEquipe = {
                    nome: '',
                    descricao: '',
                    responsavel: {
                        id: '',
                        usuario: '',
                    },
                    participantes: []
                }

                let inputNomeEquipe = document.querySelector('#modalAdicionarEquipe #input_nome');
                let textAreaDescricaoEquipe = document.querySelector('#modalAdicionarEquipe #textArea_descricao');
                let selectResponsavelEquipe = document.querySelector('#modalAdicionarEquipe #select_responsavel');

                let infoNovaEquipe = document.querySelector('#modalAdicionarEquipe #info');

                let sectionParticipantesEquipe = document.querySelector('#modalParticipantesEquipe .sectionParticipantes');

                inputNomeEquipe.value = '';
                textAreaDescricaoEquipe.value = '';
                selectResponsavelEquipe.selectedIndex = 0;
                infoNovaEquipe.textContent = '';

                selectResponsavelEquipe.innerHTML = '<option value="" selected disabled>Selecione um responsável</option>';

                participantes.forEach(p => {
                    selectResponsavelEquipe.innerHTML += '<option value="' + p.id + '">' + p.usuario + '</option>';
                });

                document.querySelector('#modalAdicionarEquipe #btnParticipantes').onclick = () => {

                    interactModal('modalParticipantesEquipe', 'modalAdicionarEquipe');

                    document.querySelector('#modalParticipantesEquipe #btnFechar').onclick = () => {
                        interactModal('modalParticipantesEquipe', 'modalAdicionarEquipe');
                    }

                    let selectParticipanteEquipe = document.querySelector('#modalAdicionarParticipanteEquipe #select_participante');

                    selectParticipanteEquipe.innerHTML = '<option value="" selected disabled>Selecione um participante</option>';

                    participantes.forEach(p => {
                        selectParticipanteEquipe.innerHTML += '<option value="' + p.id + '">' + p.usuario + '</option>';
                    });

                    sectionParticipantesEquipe.addEventListener('click', e => {
                        if (e.target.classList.contains('btnRemover')) {
                            let idParticipante = e.target.closest('.articleParticipante').id;
                            let usuarioParticipante = e.target.closest('.articleParticipante').querySelector('.usuario_participante').textContent;
                            e.target.closest('.articleParticipante').remove();

                            selectParticipanteEquipe.querySelectorAll('option').forEach(option => {
                                if (option.value === idParticipante) {
                                    option.disabled = false;
                                }
                            })

                            novaEquipe.participantes.filter(p => p.id !== idParticipante);

                        }
                    })

                    document.querySelector('#modalParticipantesEquipe #btnAdicionarParticipante').onclick = () => {

                        interactModal('modalAdicionarParticipanteEquipe', 'modalParticipantesEquipe');

                        let info = document.querySelector('#modalAdicionarParticipanteEquipe #info');

                        document.querySelector('#modalAdicionarParticipanteEquipe #btnFechar').onclick = () => {
                            interactModal('modalAdicionarParticipanteEquipe', 'modalParticipantesEquipe');
                        }

                        document.querySelector('#modalAdicionarParticipanteEquipe #btnAdicionar').onclick = () => {
                            if (!(selectParticipanteEquipe.selectedIndex === 0)) {
                                let option = selectParticipanteEquipe.options[selectParticipanteEquipe.selectedIndex];
                                let id_participante = option.value;

                                let usuario = option.textContent;

                                sectionParticipantesEquipe.insertAdjacentHTML('afterbegin', articleParticipante(id_participante, usuario));

                                option.disabled = true;
                                selectParticipanteEquipe.options[0].selected = true;

                                info.textContent = 'Participante adicionado';
                                setTimeout(() => {
                                    info.textContent = ''
                                }, 1000);

                                novaEquipe.participantes.unshift({id: id_participante, usuario: usuario});

                            }
                        }
                    }
                }

                document.querySelector('#modalAdicionarEquipe #btnCancelar').onclick = () => {
                    interactModal('modalAdicionarEquipe', 'modalEquipes');
                }

                document.querySelector('#modalAdicionarEquipe #btnConcluir').onclick = () => {

                    novaEquipe.nome = inputNomeEquipe.value;
                    novaEquipe.descricao = textAreaDescricaoEquipe.value;
                    let optionResponsavel = selectResponsavelEquipe.options[selectResponsavelEquipe.selectedIndex];
                    novaEquipe.responsavel.id = optionResponsavel.value;
                    novaEquipe.responsavel.usuario = optionResponsavel.textContent;

                    let validacao = novaEquipeValida(novaEquipe);

                    if (validacao.success) {
                        equipes.unshift(novaEquipe);
                        sectionEquipes.insertAdjacentHTML("afterbegin", articleEquipe(novaEquipe.nome));
                        infoNovaEquipe.style.color = '#75CE70';
                        modalAdicionarEquipe.classList.toogle = 'adicionada';
                        setTimeout(() => {
                            modalAdicionarEquipe.classList.toogle = 'adicionada';
                            interactModal('modalAdicionarEquipe', 'modalEquipes');
                        }, 2000);
                    } else {
                        infoNovaEquipe.style.color = '#E65A55';
                    }
                    infoNovaEquipe.textContent = validacao.message;

                }

            }

        };

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

}
