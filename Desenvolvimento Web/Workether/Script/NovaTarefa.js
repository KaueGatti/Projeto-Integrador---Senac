import {carregarComponente, interactModal, request} from "./index.js";
import {initTarefas} from "./Tarefas.js";
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

    inputDataConclusao.min = new Date().toISOString().split("T")[0]
}