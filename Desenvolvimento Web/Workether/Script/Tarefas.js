import { request, interactModal, carregarComponente } from "./index.js";

export async function initAmigos() {

    await carregarComponente('Loading.php');

    await carregarComponente('Tarefas.php');


}