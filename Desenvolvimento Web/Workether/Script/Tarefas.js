import {request, interactModal, carregarComponente} from "./index.js";
import {initNovaTarefa} from "./NovaTarefa.js";

function articleTarefa(tarefa) {
    return `<article class="articleTarefa" id="${tarefa.id}">
        <h1 id="nome_tarefa">${tarefa.nome}</h1>
        <p class="pDescricao">${tarefa.descricao}</p>
        <p class="pData">Data para conclusão: ${tarefa.dataAtualConclusao}</p>
        <div class="divStatus">
            <img src="Icones/User.png" alt="">
                <p class="pResponsavel">${tarefa.usuario_responsavel}</p>
                <p class="pStatus" id="pEmAndamento">${tarefa.status}</p>
        </div>
    </article>`;
}

export async function initTarefas(tipo, id) {

    await carregarComponente('Loading.php');

    await carregarComponente('Tarefas.php');

    document.querySelector('#btnNovaTarefa').onclick = async function () {
        await initNovaTarefa(tipo, id);
    }

    let sectionTarefas = document.querySelector('.sectionTarefas');

    sectionTarefas.addEventListener('click', async function () {
        if (e.target.closest('.articleTarefa')) {
            initDetalhesTarefa();
        }
    })

    if (tipo == 'Projeto') {

        let form = new FormData();
        form.append('id_projeto', id);

        let responseTarefasProjeto = await request('../API/Tarefa/readTarefasByProjeto.php', {
            method: "POST",
            body: form
        });

        if (responseTarefasProjeto.success) {
            let tarefasProjeto = responseTarefasProjeto.data;

            sectionTarefas.innerHTML = '';
            tarefasProjeto.forEach(tarefa => {
                sectionTarefas.innerHTML += articleTarefa(tarefa);
            })
        }
    }
}