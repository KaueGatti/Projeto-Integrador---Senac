import {request} from "./request.js";

let inputEmail = document.querySelector("#input_email");
let inputSenha = document.querySelector("#input_senha");
let info = document.querySelector("#info");
let btnEntrar = document.querySelector("#btnEntrar");

btnEntrar.addEventListener("click", async function () {

    info.textContent = '';

    let form = new FormData();
    form.append("login[email]", inputEmail.value);
    form.append("login[senha]", inputSenha.value);

    let responseLogin = await request('../API/Usuario/loginUsuario.php', {method: 'POST', body: form});

    if (responseLogin.sucesso) {
        document.location.href = 'index.php';
    } else {
        info.textContent = responseLogin.message;
    }

});