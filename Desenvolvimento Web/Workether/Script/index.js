var header = fetch("Header.php").then(res => {
    if (!res.ok) throw new Error("Erro ao carregar header!");
    return res.text();
}).then(header => {
    document.getElementsByTagName("main")[0].innerHTML = header;
}).catch(err => console.log("Erro no header:" + err));

function showProjetos() {
    fetch("Projetos.php")
}

function showTarefas() {

}

function showConversas() {
    fetch("Conversas.php").then(res => {
        if (!res.ok) throw new Error("Erro ao carregar conversas!");
        return res.text();
    }).then(conversas => {
        document.getElementsByTagName("main")[0].innerHTML = header.then(res => {
            return res.text();
        }) + conversas;
    }).catch(err => console.log("Erro nas conversas:" + err));
}

function showAmigos() {

}

function showPerfil() {

}

document.getElementById("btnConversas").addEventListener("click", function () {
    showConversas();
});
