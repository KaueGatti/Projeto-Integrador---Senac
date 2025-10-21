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
            <p class="usuario">${mensagem.usuario}</p>
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

export async function initConversa_Chat(tipo, id) {

    await carregarComponente('Loading.php');

    await carregarComponente('Conversa_Chat.php');

    let usuarioLogado = document.querySelector('.usuarioLogado');

    document.querySelector('#btnVoltar').onclick = async () => {
        await initConversas();
    };

    let sectionMensagens = document.querySelector('.sectionMensagens');

    let conversa;
    let mensagens;

    let form = new FormData();
    form.append('id_conversa', id);
    form.append('id_usuario', usuarioLogado.id);

    let responseConversa = await request('../API/Conversa/readConversaByID.php', {method: 'POST', body: form});

    if (responseConversa.success) {
        conversa = responseConversa.data;

        let form = new FormData();
        form.append('id_conversa', id);

        let responseMensagens = await request('../API/Conversa/readMensagensConversa.php', {method: 'POST', body: form});

        if (responseMensagens.success) {
            mensagens = responseMensagens.data;

            mensagens.forEach((mensagem) => {
                if (mensagem.id_usuario == usuarioLogado.id) {
                    sectionMensagens.insertAdjacentHTML('beforeend', articleMensagem('Enviada', mensagem));
                } else {
                    sectionMensagens.insertAdjacentHTML('beforeend', articleMensagem('', mensagem));
                }
            })
        }
        console.log(responseMensagens);
    }

    console.log(responseConversa);

    document.querySelector('#divTitulo h1').innerHTML = conversa.usuario;
}
