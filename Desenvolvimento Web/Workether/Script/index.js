document.addEventListener('DOMContentLoaded', () => {

    let main = document.getElementById('main');
    let logo = document.getElementById("divLogo");
    let btnsAside = document.getElementsByClassName("btnAside");

    let btnNotificacao = document.getElementById("btnNotificacoes");

    logo.addEventListener("click", function () {
        fetch("PaginaInicial.php").then(res => {
            if (!res.ok) throw new Error("Response failed in:" + "PaginaInicial.php");
            return res.text();
        }).then(conteudo => {
            if (main.children.length >= 2) {
                main.children[1].remove();
            }
            main.innerHTML += conteudo;
        }).catch(err => console.log("Erro no fetch de: PaginaInicial.php" + "\n" + err));
    });

    for (let i = 0; i < btnsAside.length; i++) {
        let btn = btnsAside[i];
        btn.addEventListener("click", function () {
            if (btn.classList.contains("Selected")) {
                fetch(btn.getAttribute("name") + ".php").then(res => {
                    if (!res.ok) throw new Error("Response failed in:" + btn.getAttribute("name") + ".php");
                    return res.text();
                }).then(conteudo => {
                    if (main.children.length >= 2) {
                        main.children[1].remove();
                    }
                    main.innerHTML += conteudo;
                }).catch(err => console.log("Erro no fetch de: " + btn.getAttribute("name") + "\n" + err));
            }
        });
    }

    function voltar() {
        logo.click();
    }

    window.onload = function () {
        for (let i = 0; i < btnsAside.length; i++) {
            btnsAside[i].click();
            voltar();
        }
    };

});
