import {carregarComponente, interactModal, request} from "./index.js";
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

    return {
        success: true,
        message: "Tarefa criada com sucesso"
    };
}

export async function initNovaTarefa() {
    await carregarComponente('Loading.php');

    await carregarComponente('NovaTarefa.php');

    document.querySelector('#btnVoltar').onclick = async () => {
        await initTarefas();
    };

    let inputNome = document.querySelector('#input_nome');
    let textAreaDescricao = document.querySelector('#textArea_descricao');
    let select_projeto = document.querySelector('#select_projeto');
    let select_equipe = document.querySelector('#select_equipe');
    let select_responsavel = document.querySelector('#select_responsavel');
    let inputDataConclusao = document.querySelector('#inputDataConclusao');
    let btnCancelar = document.querySelector('#btnCancelar');
    let btnConcluir = document.querySelector('#btnConcluir');

    let novaTarefa = {
        nome: '',
        descricao: '',
        id_projeto: '',
        id_equipe: '',
        responsavel: {
            id: '',
            usuario: '',
        },
        dataConclusao: '',
    }

    select_projeto.addEventListener('change', async () => {
        let id_projeto = new FormData();

        id_projeto.append('id_projeto', select_projeto.value);

        let responseEquipe = await request('../API/EquipeAPI.php', { method: "POST", body: id_projeto});

        select_equipe.innerHTML = '<option value="" disabled selected>Selecione uma equipe</option>';
        responseEquipe.data.forEach(e => {
            select_equipe.innerHTML +=
                '<option value="' + e.id + '">' + e.nome + '</option>';
        });


        let responseUsuario = await request('../API/UsuarioAPI.php', { method: "POST", body: id_projeto});

        select_responsavel.innerHTML = '<option value="" disabled selected>Selecione um responsável</option>';
        responseUsuario.data.forEach(r => {
            select_responsavel.innerHTML +=
                '<option value="' + r.id + '">' + r.usuario + '</option>';
        });

    });

    inputDataConclusao.min = new Date().toISOString().split("T")[0];

    btnCancelar.onclick = async () => {
        await initTarefas();
    }

    btnConcluir.onclick = async () => {

        novaTarefa.nome = inputNome.value;
        novaTarefa.descricao = textAreaDescricao.value;

        novaTarefa.id_projeto = select_projeto.value;
        novaTarefa.id_equipe = select_equipe.value;
        novaTarefa.id_responsavel = select_responsavel.value;

        let validacao = novaTarefaValida(novaTarefa);

        if (validacao.success) {

        } else {

        }
    }

}