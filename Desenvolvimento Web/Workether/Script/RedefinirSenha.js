function carregarPasso(passo) {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'RedefinirSenha' + passo + '.php', true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {

            document.getElementById('conteudo-passo').innerHTML = xhr.responseText;

            document.getElementById('form-passo' + passo).addEventListener('submit', (e) => {
                e.preventDefault();

                let form = new FormData(e.target);

                fetch("RedefinirSenha" + passo + ".php", {
                    method: "POST",
                    body: form
                }).then(res => res.json())
                    .then(data => {
                        if (data.success) {
                            if (passo < 3) {
                                carregarPasso(passo + 1);
                            } else {
                                document.getElementById('btnRedefinir').disabled = true;
                                document.getElementById('pErro').innerHTML = data.error;
                                document.getElementById('pErro').style.color = "green";
                            }
                        }
                        document.getElementById('pErro').innerHTML = data.error;
                    }).catch(err => console.log("Erro no fetch: " + err));
            })
        }
    }
    xhr.send();
}

window.onload = function () {
    carregarPasso(1);
}