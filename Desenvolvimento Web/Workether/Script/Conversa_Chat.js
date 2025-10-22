import {carregarComponente, interactModal, request} from "./index.js";
import {initConversas} from "./Conversas.js";

function articleMensagem(tipo, mensagem) {

    let data_horaFormatada = new Date(mensagem.data_hora.replace(' ', 'T') + 'Z');
    let horaFormatada = data_horaFormatada.toLocaleTimeString('pt-BR', {
        hour: '2-digit',
        minute: '2-digit',
        timeZone: 'America/Sao_Paulo',
    });
    let dataFormatada = data_horaFormatada.toLocaleDateString('pt-BR', {
        timeZone: 'America/Sao_Paulo',
    });

    if (tipo == 'Enviada') {
        return `<article class="mensagem enviada">
            <p class="texto">${mensagem.texto}</p>
            <p class="hora">${horaFormatada}</p>
        </article>`;
    } else {
        return `<article class="mensagem">
            <p class="usuario">${mensagem.usuario}</p>
            <p class="texto">${mensagem.texto}</p>
            <p class="hora">${horaFormatada}</p>
        </article>`;
    }
}

function conectar() {
    const socket = new WebSocket("ws://localhost:8080");

    socket.onopen = () => console.log("Conectado ao WebSocket");
    socket.onclose = () => console.log("Desconectado do WebSocket");

    socket.onmessage = async (e) => {
        let sectionMensagens = document.querySelector('.sectionMensagens');
        let message = typeof e.data === 'string' ? e.data : await e.data.text();
        message = JSON.parse(message);
        if (message.id_usuario != document.querySelector('.usuarioLogado').id) {
            sectionMensagens.insertAdjacentHTML('beforeend', articleMensagem('', message));
        }
        sectionMensagens.scrollTop = sectionMensagens.scrollHeight;
    };

    return socket;
}


export async function initConversa_Chat(tipo, id) {

    await carregarComponente('Loading.php');

    await carregarComponente('Conversa_Chat.php');

    const socket = conectar();

    let usuarioLogado = document.querySelector('.usuarioLogado');

    document.querySelector('#btnVoltar').onclick = async () => {
        await initConversas();
    };

    let sectionMensagens = document.querySelector('.sectionMensagens');

    let inputMensagem = document.querySelector('#input_mensagem');
    let btnEnviarMensagem = document.querySelector('#btnEnviarMensagem');

    let conversa;
    let mensagens;

    let form = new FormData();
    form.append('id_conversa', id);
    form.append('id_usuario', usuarioLogado.id);

    let responseConversa = await request('../API/Conversa/readConversaByID.php', {method: 'POST', body: form});

    if (responseConversa.success) {

        conversa = responseConversa.data;

        document.querySelector('#divTitulo h1').innerHTML = conversa.usuario;

        let form = new FormData();
        form.append('id_conversa', id);

        let responseMensagens = await request('../API/Conversa/readMensagensConversa.php', {
            method: 'POST',
            body: form
        });

        if (responseMensagens.success) {
            mensagens = responseMensagens.data;

            mensagens.forEach((mensagem) => {
                if (mensagem.id_usuario == usuarioLogado.id) {
                    sectionMensagens.insertAdjacentHTML('beforeend', articleMensagem('Enviada', mensagem));
                } else {
                    sectionMensagens.insertAdjacentHTML('beforeend', articleMensagem('', mensagem));
                }
            });

            sectionMensagens.scrollTop = sectionMensagens.scrollHeight;
        }
    }

    btnEnviarMensagem.onclick = async () => {

        if (inputMensagem.value.replace(/ /g, '') == '') return;

        let mensagem = {
            id_conversa: id,
            id_usuario: usuarioLogado.id,
            texto: inputMensagem.value
        }

        let form = new FormData();
        form.append('mensagem[id_conversa]', mensagem.id_conversa);
        form.append('mensagem[id_usuario]', mensagem.id_usuario);
        form.append('mensagem[texto]', mensagem.texto);

        let responseEnviarMensagem = await request('../API/Mensagem/createMensagemConversa.php', {
            method: 'POST',
            body: form
        });

        if (responseEnviarMensagem.success) {

            mensagem = responseEnviarMensagem.data;

            sectionMensagens.insertAdjacentHTML('beforeend', articleMensagem('Enviada', mensagem));
            sectionMensagens.scrollTop = sectionMensagens.scrollHeight;

            socket.send(JSON.stringify(mensagem));

            inputMensagem.value = '';
        }

        console.log(responseEnviarMensagem);
    }

    document.addEventListener('keydown', (e) => {
        if (e.key === 'Enter' && sectionMensagens) {
            btnEnviarMensagem.click();
        }
    });
}
