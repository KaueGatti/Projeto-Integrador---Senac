import { request, interactModal, carregarComponente } from "./index.js";

export function initAmigos() {

    document.querySelector('#btnVoltar').onclick = async () => {
        await carregarComponente('PaginaInicial.php');
        let btnAmigos = document.querySelector('#btnAmigos');
        let srcImg = btnAmigos.firstElementChild.getAttribute('src');
        btnAmigos.classList.toggle('Selected');
        btnAmigos.firstElementChild.setAttribute('src', srcImg.replace("Selected", ""));
    }

    document.querySelector('#btnAddAmigo').onclick = () => {

        interactModal('modalAmigos', 'sectionAmigos');

        document.querySelector('.modal #btnFechar').onclick = () => {
            interactModal('modalAmigos', 'sectionAmigos');
            document.querySelector('.modal #info').textContent = "";
        }

        document.querySelector('#btnEnviarConvite').onclick = async function () {

            let btn = this;

            let info = document.querySelector('#modalAmigos #info');

            let id_solicitante = document.querySelector('#id_usuario').textContent;
            let id_receptor = document.querySelector('#inputIdUsuario').value;

            if (id_solicitante === id_receptor) {
                info.textContent = "Usuário inválido";
                info.style.color = "#E65A55";
                return;
            }

            btn.disabled = true;

            btn.querySelector('p').textContent = 'Enviando...';
            let progressBar = btn.querySelector('#progress_bar');
            let progresso = 0;
            let progessoMax = 90;
            let animating = true;

            function animar() {
                progresso += (progessoMax - progresso) * 0.02;
                progressBar.style.width = `${progresso}%`;

                if (animating) {
                    requestAnimationFrame(animar);
                } else {
                    progressBar.style.width = `100%`;
                    setTimeout(() => {
                        progressBar.style.width = '0';
                        btn.querySelector('p').textContent = 'Enviar pedido';
                    }, 500);
                }
            }

            requestAnimationFrame(animar);

            let pedidoAmizade = new FormData();

            pedidoAmizade.append('pedidoAmizade[id_solicitante]', id_solicitante);
            pedidoAmizade.append('pedidoAmizade[id_receptor]', id_receptor);

            try {
                let response = await request('/../API/PedidoAmizadeAPI.php', {method: "POST", body: pedidoAmizade});
                if (response.success) {
                    info.textContent = "Pedido de amizade enviado!";
                    info.style.color = "#75CE70";
                }
            } catch (error) {
                if (error.message.includes('Integrity constraint violation: 1452')) {
                    info.textContent = "Usuário não encontrado!";
                } else if (error.message.includes('[45000]')) {
                    info.textContent = "Você e esse usuário já são amigos";
                } else if (error.message.includes('[45001]')) {
                    info.textContent = "Já existe um pedido de amizade ativo entre você e esse usuário";
                } else {
                    console.error(error);
                }
                info.style.color = "#E65A55";
            }
            animating = false;
            btn.disabled = false;
        }

    }
}