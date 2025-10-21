import {carregarComponente, interactModal, request} from "./index.js";
import {initConversa_Chat} from "./Conversa_Chat.js";

export async function initConversas() {

    await carregarComponente('Loading.php');

    await carregarComponente('Conversas.php');

    let usuarioLogado = document.querySelector('.usuarioLogado');

    let btnNovaConversa = document.querySelector('#btnNovaConversa');

    let sectionConversas = document.querySelector('.sectionConversas');

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

        let info = document.querySelector('#info');

        let btnAdicionarConversa = document.querySelector('#btnAdicionarConversa');

        btnAdicionarConversa.onclick = async () => {
            if (selectUsuario.value != '') {

                try {

                let form = new FormData();
                    form.append('conversa[id_usuarioA]', selectUsuario.value);
                    form.append('conversa[id_usuarioB]', usuarioLogado.id);

                    let responseAdicionarConversa = await request('../API/Conversa/createConversa.php', {
                        method: 'POST',
                        body: form
                    });

                    if (responseAdicionarConversa.success) {
                        info.textContent = 'Conversa adicionada com sucesso!';
                        info.style.color = '#75CE70';
                        selectUsuario.options[selectUsuario.selectedIndex].disabled = true;
                        selectUsuario.selectedIndex = 0;
                        setTimeout(() => {
                            info.textContent = '';
                        }, 1500);
                    }
                } catch (error) {
                    if (error.message.includes('1062 Duplicate entry')) {
                        info.textContent = 'Você já possui uma conversa com esse usuário';
                        info.style.color = '#E65A55';
                    } else {
                        console.error(error);
                    }
                }

            }
        };
    }


}
