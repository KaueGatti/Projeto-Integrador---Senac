import {carregarComponente, interactModal, request} from "./index.js";

export async function initConversas() {

    await carregarComponente('Loading.php');

    await carregarComponente('Conversas.php');

    let sectionConversas = document.querySelector('.sectionConversas');



}
