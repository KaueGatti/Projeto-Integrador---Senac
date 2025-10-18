import {carregarComponente} from "./index.js";
import {initNovoProjeto} from "./NovoProjeto.js";
import {initNovaTarefa} from "./NovaTarefa.js";
export async function initPaginaInicial() {

    await carregarComponente("Loading.php");

    await carregarComponente("PaginaInicial.php");

    let btnNovoProjeto = document.querySelector("#btnNovoProjeto");
    let btnNovaTarefa = document.querySelector("#btnNovaTarefa");

    btnNovoProjeto.onclick = async () => {
        await initNovoProjeto();
    }

    btnNovaTarefa.onclick = async function () {
        await initNovaTarefa();
    }
}
