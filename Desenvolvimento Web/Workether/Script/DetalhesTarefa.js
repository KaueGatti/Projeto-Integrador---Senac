import {carregarComponente, interactModal, usuarioLogado} from "./index.js";
import {request} from "./request.js";
import {initProjetos} from "./Projetos.js";
import {initTarefas} from "./Tarefas.js";

function novaTarefaValida(novaTarefa) {

    if (novaTarefa.nome.replace(/ /g, '') === '') {
        return {
            success: false,
            message: 'O nome da tarefa não pode estar vázio'
        };
    }

    if (novaTarefa.descricao.replace(/ /g, '') === '') {
        return {
            success: false,
            message: 'A descrição da tarefa não pode estar vázia'
        };
    }

    if (!novaTarefa.dataAtualConclusao || isNaN(new Date(novaTarefa.dataAtualConclusao).getTime())) {
        return {
            success: false,
            message: 'Selecione uma data para a conclusão da tarefa'
        }
    }

    return {
        success: true,
        message: "Tarefa criada com sucesso"
    };
}

export async function initDetalhesTarefa(id_tarefa) {

    await carregarComponente('Loading.php');

    await carregarComponente('DetalhesTarefa.php');

    let articleDetalhes = document.querySelector('.articleDetalhes');

    // Inputs

    let inputNome = document.querySelector('#input_nome');
    let textAreaDescricao = document.querySelector('#textArea_descricao');
    let inputProjeto = document.querySelector('#input_projeto');
    let inputEquipe = document.querySelector('#input_equipe');
    let inputResponsavel = document.querySelector('#input_responsavel');

    let inputDataConclusao = document.querySelector('#inputDataConclusao');
    let info = articleDetalhes.querySelector('#info');
    let btnExcluir = document.querySelector('#btnExcluir');
    let btnConcluir = document.querySelector('#btnConcluir');
    let btnEditar = document.querySelector('#btnEditar');
    let btnSalvar = document.querySelector('#btnSalvar');

    let modalExcluir = document.querySelector('#modalExcluir');
    let btnCancelarModalExcluir = modalExcluir.querySelector('#btnCancelarModalExcluir');
    let btnExcluirModalExcluir = modalExcluir.querySelector('#btnExcluirModalExcluir');

    let modalConcluir = document.querySelector('#modalConcluir');
    let inputDataModalConcluir = document.querySelector('#inputDataModalConcluir');
    let btnCancelarModalConcluir = modalConcluir.querySelector('#btnCancelarModalConcluir');
    let btnConcluirModalConcluir = modalConcluir.querySelector('#btnConcluirModalConcluir');

    inputDataConclusao.min = new Date().toISOString().split("T")[0];

    let form = new FormData();
    form.append('id_tarefa', id_tarefa);

    let responseTarefa = await request('../API/Tarefa/readTarefaByID.php', {method: 'POST', body: form});

    if (responseTarefa.success) {
        let tarefa = responseTarefa.data;

        document.querySelector('#btnVoltar').onclick = async () => {
            await initTarefas('Projeto', tarefa.id_projeto);
        }

        inputNome.value = tarefa.nome;
        textAreaDescricao.value = tarefa.descricao;
        inputProjeto.value = tarefa.nome_projeto;

        if (tarefa.nome_equipe != null) {
            inputEquipe.value = tarefa.nome_equipe;
        } else {
            inputEquipe.value = 'Sem equipe';
        }

        inputResponsavel.value = tarefa.usuario_responsavel;

        inputDataConclusao.value = tarefa.dataAtualConclusao;

        inputDataModalConcluir.min = tarefa.dataCriacao;

        if (tarefa.status == 'Concluida') {
            btnConcluir.style.display = 'none';
            btnEditar.style.display = 'none';
            btnSalvar.style.display = 'none';

            if (tarefa.id_responsavel == usuarioLogado.id) {
                btnExcluir.style.display = 'none';
            }
        }
    }

    btnExcluir.onclick = () => {
        interactModal('modalExcluir', 'sectionDetalhes');

        btnCancelarModalExcluir.onclick = () => {
            interactModal('modalExcluir', 'sectionDetalhes');
        }

        btnExcluirModalExcluir.onclick = async () => {
            let form = new FormData();

            form.append('id_tarefa', id_tarefa);

            let responseExcluir = await request('../API/Tarefa/deleteTarefa.php', {method: 'POST', body: form});

            if (responseExcluir.success) {
                await initTarefas('', null);
            }

            console.log(responseExcluir);
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
            form.append('id_tarefa', id_tarefa);
            form.append('dataConclusao', inputDataModalConcluir.value);

            let responseConcluir = await request('../API/Tarefa/concluirTarefa.php', {method: 'POST', body: form});

            if (responseConcluir.success) {
                await initTarefas('', null);
            }
        }
    }

    btnEditar.onclick = () => {
        inputNome.disabled = false;
        textAreaDescricao.disabled = false;
        inputDataConclusao.disabled = false;
        btnExcluir.disabled = true;
        btnConcluir.disabled = true;
        btnEditar.disabled = true;
        btnSalvar.disabled = false;

        inputNome.focus();

    }

    btnSalvar.onclick = async () => {

        let tarefa = {};
        tarefa.nome = inputNome.value;
        tarefa.descricao = textAreaDescricao.value;
        tarefa.dataAtualConclusao = inputDataConclusao.value;

        let validacao = novaTarefaValida(tarefa);

        if (validacao.success) {

            let form = new FormData();
            form.append('tarefa[id]', id_tarefa);
            form.append('tarefa[nome]', tarefa.nome);
            form.append('tarefa[descricao]', tarefa.descricao);
            form.append('tarefa[dataAtualConclusao]', tarefa.dataAtualConclusao);

            let responseAtualizacaoTarefa = await request('../API/Tarefa/updateTarefa.php', {
                method: 'POST',
                body: form
            });

            if (responseAtualizacaoTarefa.success) {
                info.textContent = 'Tarefa atualizada com sucesso!';
                info.style.color = '#75CE70';

                inputNome.disabled = true;
                textAreaDescricao.disabled = true;
                inputDataConclusao.disabled = true;
                btnExcluir.disabled = false;
                btnConcluir.disabled = false;
                btnEditar.disabled = false;
                btnSalvar.disabled = true;

            }

            console.log(responseAtualizacaoTarefa);
        } else {
            info.textContent = validacao.message;
            info.style.color = '#E65A55';
        }

    }

}
