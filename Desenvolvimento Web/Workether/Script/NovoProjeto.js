import {carregarComponente, request} from "./index.js";
import {initProjetos} from "./Projetos.js";
import {Colors} from "./../assets/constants.js";

export async function initNovoProjeto() {

    await carregarComponente("Loading.php");

    await carregarComponente("NovoProjeto.php");

    let usuarioLogado = {
        id: document.querySelector(".usuarioLogado").id,
        usuario: document.querySelector(".usuarioLogado").textContent
    }

    let dataAtual = new Date().toISOString().split("T")[0];

    const DOM = {
        articleDetalhes: document.querySelector(".articleDetalhes"),
        btnVoltar: document.querySelector('#btnVoltar'),
        inputNome: document.querySelector('#inputNome'),
        textAreaDescricao: document.querySelector('#textArea_descricao'),
        selectResponsavel: document.querySelector('#select_responsavel'),
        inputDataConclusao: document.querySelector('#inputDataConclusao'),
        info: document.querySelector('#info'),
        btnCancelar: document.querySelector('#btnCancelar'),
        btnConcluir: document.querySelector('#btnConcluir'),
    }

    DOM.btnVoltar.onclick = async () => {
        await initProjetos();
    }

    DOM.inputDataConclusao.min = dataAtual;

    function mostrarInfo(success, message) {
        DOM.info.textContent = message;
        DOM.info.style.color = success ? Colors.green : Colors.red;
    }

    function validarProjeto(projeto) {

        if (projeto.nome.replace(/ /g, '') === '') {
            DOM.inputNome.focus();
            return {
                success: false,
                message: 'Nome do projeto não pode estar vázio'
            };
        }

        if (projeto.descricao.replace(/ /g, '') === '') {
            DOM.textAreaDescricao.focus();
            return {
                success: false,
                message: 'Descrição do projeto não pode estar vázio'
            };
        }

        if (projeto.responsavel.id === '') {
            DOM.selectResponsavel.focus();
            return {
                success: false,
                message: 'Selecione um responsável para o projeto'
            };
        }

        if (projeto.dataConclusao < dataAtual) {
            DOM.inputDataConclusao.focus();
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

    async function criarProjeto(projeto) {
        let form = new FormData();

        form.append('novoProjeto[nome]', projeto.nome);
        form.append('novoProjeto[descricao]', projeto.descricao);
        form.append('novoProjeto[id_criador]', usuarioLogado.id);
        form.append('novoProjeto[id_responsavel]', projeto.responsavel.id);
        form.append('novoProjeto[dataInicialConclusao]', projeto.dataConclusao);

        return await request("../API/Projeto/createProjeto.php", {method: "POST", body: form});
    }

    DOM.btnCancelar.onclick = () => {
        DOM.btnVoltar.click();
    }

    DOM.btnConcluir.onclick = async function () {

        let projeto = {
            nome: DOM.inputNome.value,
            descricao: DOM.textAreaDescricao.value,
            responsavel: {
                id: DOM.selectResponsavel.options[DOM.selectResponsavel.selectedIndex].value,
            },
            dataConclusao: DOM.inputDataConclusao.value
        }

        let validacao = validarProjeto(projeto);

        if (!validacao.success) {
            mostrarInfo(false, validacao.message);
            return;
        }

        DOM.btnCancelar.disabled = true;
        DOM.btnConcluir.disabled = true;

        try {
            let response = await criarProjeto(projeto);
            if (response.success) {
                mostrarInfo(true, response.message);
                DOM.articleDetalhes.style.borderColor = Colors.green ;
                setTimeout(() => {
                    DOM.btnVoltar.click();
                }, 2000);
            }
        } catch (error) {
            mostrarInfo(false, error.message);
            DOM.btnCancelar.disabled = false;
            DOM.btnConcluir.disabled = false;
        }
    }
}
