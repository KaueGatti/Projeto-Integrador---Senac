document.addEventListener("DOMContentLoaded", function () {
    function carregarPasso(passo) {
        fetch("RedefinirSenha" + passo + ".php?js=1").then(res => {
            if (!res.ok) throw new Error("Erro ao carregar passo: " + passo);
            return res.text();
        }).then(html => {
            document.getElementById('conteudo-passo').innerHTML = html;

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
                                setTimeout(redirect => {
                                    window.location.href = "index.php";
                                }, 3000);
                            }
                        }
                        document.getElementById('pErro').innerHTML = data.error;
                    }).catch(err => console.log("Erro no fetch POST do Passo: " + passo + "\n" + err));
            })
        })
            .catch(err => { console.log("Erro no fetch GET do Passo: " + passo + "\n" + err)})

    }

    window.onload = function () {
        carregarPasso(1);
    }
});