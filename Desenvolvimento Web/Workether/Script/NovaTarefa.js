import {carregarComponente} from "./index.js";
import {request} from "./request.js";
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

export async function initNovaTarefa(tipo, id) {
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
    let info = document.querySelector('#info');
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

        let responseUsuario = await request('../API/UsuarioAPI.php', {method: "POST", body: id_projeto});

        select_responsavel.innerHTML = '<option value="" disabled selected>Selecione um responsável</option>';
        responseUsuario.data.forEach(r => {
            select_responsavel.innerHTML +=
                '<option value="' + r.id + '">' + r.usuario + '</option>';
        });

        let responseEquipe = await request('../API/Equipe/readAllEquipesByProjeto.php', {
            method: "POST",
            body: id_projeto
        });

        select_equipe.innerHTML = '<option value="" disabled>Selecione uma equipe</option>';
        select_equipe.innerHTML += '<option value="0" selected>Sem equipe</option>';

        responseEquipe.data.forEach(e => {
            select_equipe.innerHTML +=
                '<option value="' + e.id + '">' + e.nome + '</option>';
        });

    });

    select_equipe.addEventListener('change', async (e) => {
        console.log(e.target.value);
        if (e.target.value != 0 && e.target.value != '') {
            let id_equipe = new FormData();
            id_equipe.append('id_equipe', select_equipe.value);

            let responseParticipantesEquipe = await request('../API/Usuario/readUsuariosByEquipe.php', {
                method: "POST",
                body: id_equipe
            });

            if (responseParticipantesEquipe.success) {
                select_responsavel.selectedIndex = 0;
                let participantesEquipe = responseParticipantesEquipe.data;
                Array.from(select_responsavel.options).forEach(option => {
                    if (participantesEquipe.find(p => p.id == option.value)) {
                        option.disabled = false;
                    } else {
                        option.disabled = true;
                    }
                });
            }
            return;
        }

        if (e.target.value == 0) {
            Array.from(select_responsavel.options).forEach(option => {
                if (option.value !== '') {
                    option.disabled = false;
                }
            });
        }
    });

    if (tipo == 'Projeto') {
        select_projeto.disabled = true;

        let form = new FormData();
        form.append('id_projeto', id);

        let responseProjeto = await request('../API/Projeto/readProjetoByID.php', {method: 'POST', body: form});

        if (responseProjeto.success /*&& responseUsuario.success*/) {

            let projeto = responseProjeto.data;
            select_projeto.innerHTML = `<option value="${projeto.id}" selected>${projeto.nome}</option>`;

            select_projeto.dispatchEvent(new Event('change'));


        }

    }

    inputDataConclusao.min = new Date().toISOString().split("T")[0];

    btnCancelar.onclick = async () => {
        await initTarefas();
    }

    btnConcluir.onclick = async () => {

        novaTarefa.nome = inputNome.value;
        novaTarefa.descricao = textAreaDescricao.value;

        novaTarefa.id_projeto = select_projeto.value;
        novaTarefa.id_equipe = select_equipe.value;
        novaTarefa.responsavel.id = select_responsavel.value;
        novaTarefa.responsavel.usuario = select_responsavel.options[select_responsavel.selectedIndex].textContent;
        novaTarefa.dataConclusao = inputDataConclusao.value;

        let validacao = novaTarefaValida(novaTarefa);

        if (validacao.success) {

            btnConcluir.disabled = true;
            btnCancelar.disabled = true;

            let form = new FormData();
            form.append('tarefa[id_projeto]', novaTarefa.id_projeto);
            form.append('tarefa[id_equipe]', novaTarefa.id_equipe);
            form.append('tarefa[id_responsavel]', novaTarefa.responsavel.id);
            form.append('tarefa[nome]', novaTarefa.nome);
            form.append('tarefa[descricao]', novaTarefa.descricao);
            form.append('tarefa[data_inicial_conclusao]', novaTarefa.dataConclusao);

            let responseAddTarefa = await request('../API/Tarefa/createTarefa.php', {method: 'POST', body: form});

            if (responseAddTarefa.success) {
                info.textContent = 'Tarefa adicionada com sucesso!';
                info.style.color = '#75CE70';
                setTimeout(async () => {

                    if (tipo == 'Projeto') {
                        await initTarefas('Projeto', id);
                        return;
                    }

                    await initTarefas('', null);

                }, 1000);
            }

        } else {
            info.style.color = '#E65A55';
            info.textContent = validacao.message;
        }
    }

}