export async function request(url, options = {}) {
    let res = await fetch(url, options);
    let text = await res.text();

    let json;

    try {
        json = JSON.parse(text);
    } catch (e) {
        console.error("Erro ao parsear JSON:", e);
        console.log("Resposta bruta do PHP:", text);
        throw new Error("Resposta inválida do servidor (não é JSON)");
    }

    if (!res.ok || json.success === false) {
        throw new Error(json.message || "Erro desconhecido");
    }

    return json;
}