import {carregarComponente, interactModal, request} from "./index.js";
import {initNovoProjeto} from "./NovoProjeto.js";
import {initDetalhesProjeto} from "./DetalhesProjeto.js";

export async function initProjetos() {

    await carregarComponente('Loading.php');

    await carregarComponente('Projetos.php');

    document.querySelector('#btnVoltar').onclick = async () => {
        document.querySelector('#divLogo').click();
    }

    document.querySelector('#btnAdicionarProjeto').onclick = async () => {
        await initNovoProjeto();
    }

    let projetos = document.querySelectorAll('.articleProjeto');

    projetos.forEach(projeto => {
        projeto.onclick = async () => {
            await initDetalhesProjeto(projeto.id);
        }
    })
}
