import {carregarComponente, request} from "./index.js";
export async function initPerfil() {

    await carregarComponente("Loading.php");

    await carregarComponente("Perfil.php");

    let usuarioLogado = {
        id: document.querySelector(".usuarioLogado").id,
        usuario: document.querySelector(".usuarioLogado").textContent
    };

    let inputUsuario = document.querySelector("#input_usuario");

    let IconEditarUsuario = document.querySelector("#IconEditarUsuario");
    let btnAtualizarUsuario = document.querySelector("#btnAtualizarUsuario");
    let btnCancelar = document.querySelector("#btnCancelar");

    let infoUsuario = document.querySelector("#infoUsuario");

    IconEditarUsuario.addEventListener("click", async e => {
        IconEditarUsuario.hidden = true;
        btnAtualizarUsuario.hidden = false;
        btnCancelar.hidden = false;
        inputUsuario.readOnly = false;
        inputUsuario.focus();
    });

    btnCancelar.addEventListener("click", async e => {
        btnCancelar.hidden = true;
        btnAtualizarUsuario.hidden = true;
        IconEditarUsuario.hidden = false;
        inputUsuario.readOnly = true;
        inputUsuario.value = usuarioLogado.usuario;
        infoUsuario.textContent = '';
        btnAtualizarUsuario.disabled = false;
    })

    btnAtualizarUsuario.addEventListener("click", async e => {
        if (inputUsuario.value.replace(/ /g, '') === "") {
            infoUsuario.style.color = '#E65A55';
            infoUsuario.textContent = 'Usuário inválido';
            inputUsuario.focus();
        } else {

            btnAtualizarUsuario.disabled = true;

            let atualizarUsuario = new FormData();

            atualizarUsuario.append("atualizarUsuario[id]", usuarioLogado.id);
            atualizarUsuario.append("atualizarUsuario[usuario]", inputUsuario.value);

            try {
                let response = await request('../API/UsuarioAPI.php', { method: 'POST', body: atualizarUsuario });
                if (response.success) {
                    infoUsuario.style.color = '#46b640';
                    infoUsuario.textContent = 'Usuário atualizado';

                    let usuarioAtualizado = new FormData();

                    usuarioAtualizado.append('id', usuarioLogado.id);

                    let usuario  = await request('../API/UsuarioAPI.php', { method: 'POST', body: usuarioAtualizado });

                    document.querySelector('.usuarioLogado').textContent = usuario.usuario;

                    usuarioLogado.usuario = usuario.usuario;

                    document.querySelector('#usuario_header').textContent = "Usuário: " + usuarioLogado.usuario;

                    setTimeout(() => {
                        btnCancelar.click();
                    },2000);
                }
                console.log(response);
            } catch (error) {
                console.error(error);
            }
        }
    })

}