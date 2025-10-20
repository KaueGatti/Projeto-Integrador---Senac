import {carregarComponente, interactModal, request} from "./index.js";
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

    if (novaTarefa.id_projeto === '') {
        return {
            success: false,
            message: 'Selecione um projeto para a tarefa'
        };
    }

    if (novaTarefa.responsavel.id === '' || novaTarefa.responsavel.usuario === '') {
        return {
            success: false,
            message: 'Selecione um responsável pela tarefa'
        };
    }

    if (novaTarefa.dataConclusao === '') {
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
    let selectResponsavel = document.querySelector('#select_responsavel');

    let inputDataConclusao = document.querySelector('#inputDataConclusao');
    let info = articleDetalhes.querySelector('#info');
    let btnEditar = document.querySelector('#btnEditar');
    let btnSalvar = document.querySelector('#btnSalvar');

    inputDataConclusao.min = new Date().toISOString().split("T")[0];

    let form = new FormData();
    form.append('id_tarefa', id_tarefa);

    let responseTarefa = await request('../API/Tarefa/readTarefaByID.php', {method: 'POST', body: form});

    if (responseTarefa.success) {
        let tarefa = responseTarefa.data;

        inputNome.value = tarefa.nome;
        textAreaDescricao.value = tarefa.descricao;

        document.querySelector('#btnVoltar').onclick = async () => {
            await initTarefas('Projeto', tarefa.id_projeto);
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
    }

    btnSalvar.onclick = async () => {

        /*let editarProjeto = new FormData();

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
        }*/
    };
}
