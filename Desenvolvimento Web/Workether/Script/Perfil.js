import {carregarComponente} from "./index.js";
export async function initPerfil() {

    await carregarComponente("Loading.php");

    await carregarComponente("Perfil.php");

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
    })

    btnAtualizarUsuario.addEventListener("click", async e => {
        if (inputUsuario.value.replace(/ /g, '') === "") {
            infoUsuario.style.color = '#E65A55';
            infoUsuario.textContent = 'Usuário inválido';
            inputUsuario.focus();

        } else {
            infoUsuario.style.color = '#46b640';
            infoUsuario.textContent = 'Usuário atualizado';
            setTimeout(() => {
                infoUsuario.textContent = '';
                btnCancelar.click();
            },2000);
        }
    })

}