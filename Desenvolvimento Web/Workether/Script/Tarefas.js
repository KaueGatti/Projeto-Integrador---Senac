import {request, interactModal, carregarComponente} from "./index.js";
import {initNovaTarefa} from "./NovaTarefa.js";

export async function initTarefas() {

    await carregarComponente('Loading.php');

    await carregarComponente('Tarefas.php');

    document.querySelector('#btnNovaTarefa').onclick = async function () {
        await initNovaTarefa();
    }
}