import {carregarComponente, interactModal, request} from "./index.js";
import {initProjetos} from "./Projetos.js";
export async function initNovoProjeto() {

    await carregarComponente("Loading.php");

    await carregarComponente("NovoProjeto.php");

    let novoProjeto = {
        nome: '',
        descricao: '',
        responsavel: {
            id: '',
            usuario: '',
        },
        dataConclusao: ''
    }

    let btnVoltar = document.querySelector('#btnVoltar');

    btnVoltar.onclick = async () => {
        await initProjetos();
    }

    let dataAtual = new Date().toISOString().split("T")[0];

    let inputNome = document.querySelector('#inputNome');
    let textAreaDescricao = document.querySelector('#textArea_descricao');
    let selectResponsavel = document.querySelector('#select_responsavel');
    let inputDataConclusao = document.querySelector('#inputDataConclusao');
    let info = document.querySelector('#info');

    inputDataConclusao.min = dataAtual;

    function novoProjetoValido(novoProjeto) {

        if (novoProjeto.nome.replace(/ /g, '') === '') {
            inputNome.focus();
            return {
                success: false,
                message: 'Nome do projeto não pode estar vázio'
            };
        }

        if (novoProjeto.descricao.replace(/ /g, '') === '') {
            textAreaDescricao.focus();
            return {
                success: false,
                message: 'Descrição do projeto não pode estar vázio'
            };
        }

        if (novoProjeto.responsavel.id === '' || novoProjeto.responsavel.usuario === '') {
            selectResponsavel.focus();
            return {
                success: false,
                message: 'Selecione um responsável para o projeto'
            };
        }

        if (novoProjeto.dataConclusao < dataAtual) {
            inputDataConclusao.focus();
            return {
                success: false,
                message: 'A data de conclusão não pode ser anterior a data atual'
            };
        }

        return {
            success: true,
            message: 'Projeto criado com sucesso!'
        };

    }

    let btnCancelar = document.querySelector('#btnCancelar');
    let btnConcluir = document.querySelector('#btnConcluir');

    btnCancelar.onclick = () => {
        btnVoltar.click();
    }

    btnConcluir.onclick = async function () {

        novoProjeto.nome = inputNome.value;
        novoProjeto.descricao = textAreaDescricao.value;
        novoProjeto.responsavel.id = selectResponsavel.options[selectResponsavel.selectedIndex].value;
        novoProjeto.responsavel.usuario = selectResponsavel.options[selectResponsavel.selectedIndex].textContent;
        novoProjeto.dataConclusao = inputDataConclusao.value;

        let validacao = novoProjetoValido(novoProjeto);

        if (validacao.success) {

            btnCancelar.disabled = true;
            btnConcluir.disabled = true;

            let formNovoProjeto = new FormData();

            formNovoProjeto.append('novoProjeto[nome]', novoProjeto.nome);
            formNovoProjeto.append('novoProjeto[descricao]', novoProjeto.descricao);
            formNovoProjeto.append('novoProjeto[id_criador]', selectResponsavel.options[1].value);
            formNovoProjeto.append('novoProjeto[id_responsavel]', novoProjeto.responsavel.id);
            formNovoProjeto.append('novoProjeto[dataInicialConclusao]', novoProjeto.dataConclusao);

            try {
                let response = await request("../API/ProjetoAPI.php", {method: "POST", body: formNovoProjeto});
                if (response.success) {
                    info.textContent = response.message;
                    info.style.color = '#75CE70';
                    setTimeout(() => {
                        btnVoltar.click();
                    }, 3000)
                }
            } catch (erro) {
                info.textContent = erro.message;
                info.style.color = "#E65A55";
                btnCancelar.disabled = false;
                btnConcluir.disabled = false;
            }
        } else {
            info.style.color = "#E65A55";
            info.textContent = validacao.message;
        }


    }
}
