import {request, interactModal, carregarComponente} from "./index.js";
import {initNovaTarefa} from "./NovaTarefa.js";
import {initDetalhesTarefa} from "./DetalhesTarefa.js";
import {initDetalhesProjeto} from "./DetalhesProjeto.js";
import {initPaginaInicial} from "./PaginaInicial.js";

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

    let btnVoltar = document.querySelector('#btnVoltar');

    btnVoltar.onclick = async () => {
        await initPaginaInicial();
    }

    document.querySelector('#btnNovaTarefa').onclick = async function () {
        await initNovaTarefa(tipo, id);
    }

    let sectionTarefas = document.querySelector('.sectionTarefas');

    sectionTarefas.addEventListener('click', async function (e) {
        if (e.target.closest('.articleTarefa')) {
            let articleTarefa = e.target.closest('.articleTarefa');
            await initDetalhesTarefa(articleTarefa.id);
        }
    })

    if (tipo == 'Projeto') {

        sectionTarefas.style.display = 'none';

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
            });

            btnVoltar.onclick = async () => {
                await initDetalhesProjeto(id);
            }

            sectionTarefas.style.display = 'grid';
        }
    }
}