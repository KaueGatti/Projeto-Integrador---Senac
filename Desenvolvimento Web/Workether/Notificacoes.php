<?php

header('Content-Type: text/html; charset=utf-8');

require_once __DIR__ . "/Controller/NotificacaoController.php";

if (session_status() === PHP_SESSION_NONE) {
    session_start();
}

$controller = new NotificacaoController();

$notificacoes = $controller->readNotificacoesByUsuario($_SESSION['usuario']->id);

ob_start();

?>


<?php foreach ($notificacoes as $notificacao) : ?>
    <article class="articleNotificacao">
        <p id="idNotificacao" hidden><?= $notificacao->id ?></p>
        <div class="divImg">
            <img src="Icones/Fechar.png" alt="">
        </div>
        <h1><?= $notificacao->assunto ?></h1>
        <p class="pTexto"><?= $notificacao->texto ?></p>
        <?php if ($notificacao->assunto === 'Pedido de Amizade') : ?>
            <div class="divBtns">
                <button class="btnRecusar">Recusar</button>
                <button class="btnAceitar">Aceitar</button>
            </div>
        <?php endif; ?>
        <p class="pData"><?= date("d/m/Y", strtotime($notificacao->data_hora)) ?></p>
        <p class="pHora"><?= date("H:i", strtotime($notificacao->data_hora)) ?></p>
    </article>
<?php endforeach; ?>

<?php
echo ob_get_clean();
