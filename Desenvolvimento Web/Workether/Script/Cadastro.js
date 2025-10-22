import {request} from "./request.js";

let inputUsuario = document.querySelector("#input_usuario");
let inputEmail = document.querySelector("#input_email");
let inputSenha = document.querySelector("#input_senha");
let inputConfirmarSenha = document.querySelector("#input_confirmar_senha");
let info = document.querySelector("#info");
let btnCadastrar = document.querySelector("#btnCadastrar");

function usuarioValido() {
    if (inputUsuario.value.replace(/ /g, "") == "") {
        return {
            success: false,
            message: 'Campo de usuário não pode estar vázio!'
        }
    }

    let regexEmail = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

    if (!regexEmail.test(inputEmail.value)) {
        return {
            success: false,
            message: 'E-mail inválido'
        }
    }

    if (inputSenha.value.length < 6) {
        return {
            success: false,
            message: 'Senha muito curta, deve conter pelo menos 6 caracteres!'
        }
    }

    if (inputConfirmarSenha.value != inputSenha.value) {
        return {
            success: false,
            message: 'As senhas estão diferentes'
        }
    }

    return {
        success: true
    };
}

btnCadastrar.addEventListener("click", async function () {

    info.textContent = '';

    let validacao = usuarioValido();

    if (validacao.success) {
        let form = new FormData();
        form.append("usuario[usuario]", inputUsuario.value);
        form.append("usuario[email]", inputEmail.value);
        form.append("usuario[senha]", inputSenha.value);

        try {

            let responseCadastro = await request('../API/Usuario/createUsuario.php', {method: 'POST', body: form});

            if (responseCadastro.success) {
                document.location.href = 'Login.php';
            }

        } catch (error) {
            if (error.message.includes('1062 Duplicate entry')) {
                info.textContent = "E-mail já cadastrado";
            }
        }
    } else {
        info.textContent = validacao.message;
    }
});