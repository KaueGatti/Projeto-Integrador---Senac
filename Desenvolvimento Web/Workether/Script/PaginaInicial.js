import {carregarComponente} from "./index.js";
import {initNovoProjeto} from "./NovoProjeto.js";
export async function initPaginaInicial() {

    await carregarComponente("Loading.php");

    await carregarComponente("PaginaInicial.php");

    let btnNovoProjeto = document.querySelector("#btnNovoProjeto");

    btnNovoProjeto.onclick = async () => {
        await initNovoProjeto();
    }
}
