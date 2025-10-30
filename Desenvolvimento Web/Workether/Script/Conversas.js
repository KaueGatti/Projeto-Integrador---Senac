import {carregarComponente, interactModal, usuarioLogado} from "./index.js";
import {request} from "./request.js";
import {initConversa_Chat} from "./Conversa_Chat.js";

function articleConversa(conversa) {
    return `<article class="articleConversa" id="${conversa.id}">
                    <h1>${conversa.usuario}</h1>
            </article>`;
}

export async function initConversas() {

    await carregarComponente('Loading.php');

    await carregarComponente('Conversas.php');

    document.querySelector('#btnVoltar').onclick = async () => {
        await initConversas();
    };

    let btnNovaConversa = document.querySelector('#btnNovaConversa');

    let sectionConversas = document.querySelector('.sectionConversas');

    let info = document.querySelector('#info');

    sectionConversas.addEventListener('click', async (e) => {
        if (e.target.closest('.articleConversa')) {
            let articleConversa = e.target.closest('.articleConversa');

            await initConversa_Chat('Conversa', articleConversa.id);
        }
    })

    btnNovaConversa.onclick = () => {
        interactModal('modalConversas', 'sectionConversas');

        document.querySelector('#btnFechar').onclick = () => {
            interactModal('modalConversas', 'sectionConversas');
        };

        let selectUsuario = document.querySelector('#select_usuario');

        let infoModal = document.querySelector('#infoModal');

        let btnAdicionarConversa = document.querySelector('#btnAdicionarConversa');

        btnAdicionarConversa.onclick = async () => {
            if (selectUsuario.value != '') {

                try {

                    btnAdicionarConversa.disabled = true;

                    let form = new FormData();
                    form.append('conversa[id_usuarioA]', selectUsuario.value);
                    form.append('conversa[id_usuarioB]', usuarioLogado.id);

                    let responseAdicionarConversa = await request('../API/Conversa/createConversa.php', {
                        method: 'POST',
                        body: form
                    });

                    if (responseAdicionarConversa.success) {

                        let conversa = responseAdicionarConversa.data;

                        info.remove();

                        sectionConversas.insertAdjacentHTML('afterbegin', articleConversa(conversa));


                        infoModal.textContent = 'Conversa adicionada com sucesso!';
                        infoModal.style.color = '#75CE70';
                        selectUsuario.options[selectUsuario.selectedIndex].disabled = true;
                        selectUsuario.selectedIndex = 0;
                        setTimeout(() => {
                            info.textContent = '';
                        }, 1500);
                    }
                } catch (error) {
                    if (error.message.includes('1062 Duplicate entry')) {
                        infoModal.textContent = 'Você já possui uma conversa com esse usuário';
                        infoModal.style.color = '#E65A55';
                    } else {
                        console.error(error);
                    }
                }

                btnAdicionarConversa.disabled = false;

            }
        };
    }


}
