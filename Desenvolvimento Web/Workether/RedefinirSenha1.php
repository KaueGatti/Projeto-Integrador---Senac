<?php

use GmailAPI\GmailClient;

require_once __DIR__ . '/Controller/UsuarioController.php';
require_once __DIR__ . '/GmailAPI/GmailClient.php';

session_start();

$controller = new UsuarioController();
$response = ["success" => false, "data" => null, "error" => null];

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    header('Content-Type: application/json');
    if (isset($_POST["email"])) {
        $response = $controller->readUsuarioByEmail($_POST["email"]);
        if ($response) {
            $gmailClient = new GmailClient();
            $codigo = $controller->gerarCodigo();
            $_SESSION['codigo'] = 1;
            #$gmailClient->sendEmail($response->email, "Codigo de redefinicao de senha", "Código: " . $codigo);
            $response = [
                    "success" => true,
                    "data" => $response,
                    "error" => null
            ];
            $_SESSION["usuarioUpdated"] = $response["data"];
        } else {
            $response = [
                    "success" => false,
                    "data" => null,
                    "error" => "E-mail não cadastrado"];
        }
    }
    echo json_encode($response);
    exit();
} else if ($_SERVER['REQUEST_METHOD'] == 'GET' && !isset($_GET["js"])) {
    header('Location: RedefinirSenha.php');
}
?>

<link rel="stylesheet" href="Style/RedefinirSenha1.css">

<form id="form-passo1" method="post">
    <div id="divTitulo">
        <h1>Redefinir senha</h1>
    </div>
    <p>Insira o e-mail cadastrado</p>
    <p id="pErro"></p>
    <input type="email" name="email" placeholder="email@gmail.com" id="inputEmail" required>
    <button id="btnEnviar">Enviar código</button>
    <div id="divProgresso">
        <div id="Etapa1"></div>
        <div id="Etapa2"></div>
        <div id="Etapa3"></div>
    </div>
</form>