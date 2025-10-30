<?php

require_once __DIR__ . "/Controller/UsuarioController.php";
require_once __DIR__ . "/Controller/ProjetoController.php";
require_once __DIR__ . '/Controller/AmizadeController.php';
require_once __DIR__ . '/Controller/EquipeController.php';
require_once __DIR__ . '/Controller/ComentarioController.php';

include_once 'session.php';

$usuarioController = new UsuarioController();
$projetoController = new ProjetoController();
$amizadeController = new AmizadeController();
$equipeController = new EquipeController();
$comentarioController = new ComentarioController();

$projeto = null;
$responsavel = null;
$isResponsavel = false;

function formatarData($data_hora)
{
    try {
        $data = new DateTime($data_hora, new DateTimeZone('UTC'));
        $data->setTimezone(new DateTimeZone('America/Sao_Paulo'));
        return $data->format('d/m/Y');
    } catch (Exception $e) {
        var_dump($e);
        die();
    }
}

function formatarHora($data_hora)
{
    try {

        $hora = new DateTime($data_hora, new DateTimeZone('UTC'));
        $hora->setTimezone(new DateTimeZone('America/Sao_Paulo'));

        return $hora->format('H:i');
    } catch (Exception $e) {
        var_dump($e);
        die();
    }
}

if ($_SERVER["REQUEST_METHOD"] == "GET") {
    if (isset($_GET["id"])) {
        $projeto = $projetoController->readProjetoByID($_GET["id"])['data'];
        if ($projeto->id_responsavel == $_SESSION["usuario"]->id) {
            $isResponsavel = true;
        }
        $participantes = $usuarioController->readAllUsuarioByProjeto($_GET["id"])['data'];
        $equipes = $equipeController->readAllEquipesByProjeto($_GET["id"])['data'];
        $comentarios = $comentarioController->readComentariosByProjeto($_GET["id"])['data'];
        $responsavel = $usuarioController->readUsuarioByID($projeto->id_responsavel);
        $amizades = $amizadeController->readAllAmizadesByUsuario($_SESSION['usuario']->id);
    } else {
        echo "Não foi possível buscar os detalhes do projeto";
        die();
    }
}

?>

<section class="conteudo">
    <link id="link" rel="stylesheet" href="Style/DetalhesProjeto.css">
    <div id="divTitulo">
        <img id="btnVoltar" class="btnBack" src="Icones/Voltar.png" alt="">
        <h1 class="mb-0">Detalhes do projeto</h1>
    </div>
    <section class="sectionDetalhes" id="sectionDetalhes">
        <article class="articleDetalhes" id="articleDetalhes">
            <p id="projetoID" hidden=""><?= $projeto->id ?></p>
            <p id="dataCriacao" hidden=""><?= $projeto->dataCriacao ?></p>
            <p id="status" hidden=""><?= $projeto->status ?></p>
            <p id="id_responsavel" hidden=""><?= $projeto->id_responsavel ?></p>
            <div class="input-group" id="divInputNome">
                <input type="text" id="inputNome" placeholder=" " value="<?= $projeto->nome ?>" readonly>
                <label for="inputNome">Nome</label>
            </div>
            <div class="textArea-group" id="divInputDescricao">
                <textarea id="textArea_descricao" name="descricao" placeholder=" "
                          readonly><?= $projeto->descricao ?></textarea>
                <label for="textArea_descricao">Descrição</label>
            </div>
            <div class="divResponsavel_Participantes_Equipes">
                <div class="select-group">
                    <select id="select_responsavel" disabled>
                        <option selected value="<?= $responsavel->id ?>"><?= $responsavel->usuario ?></option>
                        <?php foreach ($participantes as $participante) : ?>
                            <?php if ($participante->id !== $responsavel->id) : ?>
                                <option value="<?= $participante->id ?>"><?= $participante->usuario ?></option>
                            <?php endif; ?>
                        <?php endforeach; ?>
                    </select>
                    <label for="select_responsavel">Responsável</label>
                </div>
                <button class="buttonOrange" id="btnParticipantes">Participantes</button>
                <button class="buttonOrange" id="btnEquipes">Equipes</button>
            </div>
            <div class="divDataConclusao_Tarefas_Comentarios">
                <div class="input-group" id="input-groupDataConclusao">
                    <input type="date" id="inputDataConclusao" name="dataConclusao" placeholder=" " readonly
                           value="<?= $projeto->dataAtualConclusao ?>">
                    <label for="inputDataConclusao">Data para conclusão</label>
                </div>
                <button class="buttonOrange" id="btnTarefas">Tarefas</button>
                <button class="buttonOrange" id="btnComentarios">Comentários
                </button>
            </div>
            <!-- /*<button class="buttonGray" id="btnChat">Chat</button> -->
            <p id="info"></p>
            <div class="divExcluir_Concluir_Editar_Salvar">
                <button class="buttonRed" id="btnExcluir" <?php if (!$isResponsavel) echo 'hidden' ?>>Excluir
                </button>
                <button class="buttonGreen" id="btnConcluir" <?php if (!$isResponsavel) echo 'hidden' ?>>Concluir
                </button>
                <button id="btnEditar" <?php if (!$isResponsavel) echo 'hidden' ?>>Editar</button>
                <button id="btnSalvar" disabled <?php if (!$isResponsavel) echo 'hidden' ?>>Salvar</button>
            </div>
        </article>
    </section>

    <!-- Novo Projeto -> Participantes -->
    <div class="modal modalParticipantes" id="modalParticipantes">
        <div class="divTitulo">
            <h1>Participantes</h1>
            <img class="btnBack" id="btnFechar" src="Icones/Fechar.png" alt="">
        </div>
        <button class="btnAdicionarParticipantes"
                id="btnAdicionarParticipante" <?php if (!$isResponsavel) echo 'hidden' ?>>+ Adicionar participante
        </button>
        <section class="sectionParticipantes" id="sectionParticipantes">
            <?php foreach ($participantes as $participante) : ?>
                <article class="articleParticipante" id="<?= $participante->id ?>">
                    <p class="usuario_participante"><?= $participante->usuario ?></p>
                    <img class="btnRemover" src="Icones/Remover.png" alt="" <?php if (!$isResponsavel) echo 'hidden' ?>>
                </article>
            <?php endforeach; ?>
        </section>
    </div>
    <div class="modal modalAdicionarParticipante" id="modalAdicionarParticipante">
        <div class="divTitulo">
            <h1>Adicionar participantes</h1>
            <img class="btnBack" id="btnFechar"
                 src="Icones/Fechar.png"
                 alt="">
        </div>
        <div class="select-group">
            <select id="select_participante">
                <option value="" selected disabled>Selecione um participante</option>
                <?php foreach ($amizades as $amizade) : ?>
                    <option value="<?= $amizade->id ?>" <?php foreach ($participantes as $p) {
                        if ($amizade->id === $p->id) echo 'disabled';
                    } ?> ><?php echo $amizade->usuario ?></option>
                <?php endforeach; ?>
            </select>
            <label for="select_participante">Participante</label>
        </div>
        <p id="info"></p>
        <button id="btnAdicionar">Adicionar</button>
    </div>
    <!-- Novo Projeto -> Participantes -->

    <!-- Novo Projeto -> Equipes -->
    <div class="modal modalEquipes" id="modalEquipes">
        <div class="divTitulo">
            <h1>Equipes</h1>
            <img class="btnBack" id="btnFechar" src="Icones/Fechar.png"
                 alt="">
        </div>
        <button class="btnAdicionarEquipe" id="btnAdicionarEquipe" <?php if (!$isResponsavel) echo 'hidden' ?>>+
            Adicionar equipe
        </button>
        <section class="sectionEquipes">
            <?php foreach ($equipes as $equipe) : ?>
                <article class="articleEquipe" id="<?= $equipe->id ?>">
                    <p id="nome_equipe"><?= $equipe->nome ?></p>
                    <img class="btnRemover" src="Icones/Remover.png" alt="" <?php if (!$isResponsavel) echo 'hidden' ?>>
                </article>
            <?php endforeach; ?>
        </section>
    </div>
    <div class="modal modalAdicionarEquipe" id="modalAdicionarEquipe">
        <h1 class="tituloModal">Nova Equipe</h1>
        <div class="input-group input-nome">
            <input type="text" id="input_nome" placeholder=" ">
            <label for="input_nome">Nome</label>
        </div>
        <div class="textArea-group textArea-descricao">
            <textarea type="text" id="textArea_descricao" placeholder=" "></textarea>
            <label for="textArea_descricao">Descrição</label>
        </div>
        <div class="select-group">
            <select id="select_responsavel">
                <option value="" disabled selected>Selecione um responsável</option>
                <option selected value="<?= $responsavel->id ?>"><?= $responsavel->usuario ?></option>
                <?php foreach ($participantes as $participante) : ?>
                    <?php if ($participante->id !== $responsavel->id) : ?>
                        <option value="<?= $participante->id ?>"><?= $participante->usuario ?></option>
                    <?php endif; ?>
                <?php endforeach; ?>
            </select>
            <label for="select_responsavel">Responsável</label>
        </div>
        <p id="info"></p>
        <div class="divCancelar_Concluir">
            <button class="buttonRed" id="btnCancelar">Cancelar</button>
            <button class="buttonGreen" id="btnConcluir">Concluir</button>
        </div>
    </div>
    <!-- Novo Projeto -> Equipes -->

    <!-- Detalhes do Projeto -> Comentários -->
    <div class="modal modalComentarios" id="modalComentarios">
        <div class="divTitulo">
            <h1>Comentários</h1>
            <img id="btnFechar" class="btnBack" src="Icones/Fechar.png" alt="">
        </div>
        <button class="buttonGreen" id="btnAdicionarComentario" <?php if (!$isResponsavel) echo 'hidden' ?>>+ Adicionar
            comentário
        </button>
        <section class="sectionComentarios">
            <?php foreach ($comentarios as $comentario) : ?>
                <article class="articleComentario" id="<?= $comentario->id ?>">
                    <p class="textoComentario"><?= $comentario->texto ?></p>
                    <div class="divInfo">
                        <img id="btnRemover" class="imgRemover btnRemover" src="Icones/Remover.png"
                             alt="" <?php if (!$isResponsavel) echo 'hidden' ?>>
                        <p class="data"><?= formatarData($comentario->data_hora) ?></p>
                        <p class="hora"><?= formatarHora($comentario->data_hora) ?></p>
                        <div class="divUser">
                            <img src="Icones/User.png" alt="">
                            <p><?= $comentario->usuario ?></p>
                        </div>
                    </div>
                </article>
            <?php endforeach; ?>
        </section>
    </div>
    <div class="modal modalAdicionarComentario" id="modalAdicionarComentario">
        <h1 class="tituloModal">Novo comentário</h1>
        <div class="textArea-group">
            <textarea type="text" id="textArea_comentario" placeholder=" "></textArea>
            <label for="textArea_comentario">Comentário</label>
        </div>
        <p id="info"></p>
        <div class="divCancelar_Adicionar">
            <button id="btnCancelar" class="buttonRed">Cancelar</button>
            <button id="btnAdicionar" class="buttonGreen">Adicionar</button>
        </div>
    </div>
    <!-- Detalhes do Projeto -> Comentários -->

    <!-- Novo Projeto -> Equipes -> Participantes -->
    <div class="modal modalParticipantes" id="modalParticipantesEquipe">
        <div class="divTitulo">
            <h1>Participantes</h1>
            <img class="btnBack" id="btnFechar" src="Icones/Fechar.png" alt="">
        </div>
        <button class="btnAdicionarParticipantes" id="btnAdicionarParticipante">+ Adicionar participante</button>
        <section class="sectionParticipantes">
        </section>
    </div>
    <div class="modal modalAdicionarParticipante" id="modalAdicionarParticipanteEquipe">
        <div class="divTitulo">
            <h1>Adicionar participantes</h1>
            <img class="btnBack" id="btnFechar"
                 src="Icones/Fechar.png"
                 alt="">
        </div>
        <div class="select-group">
            <select id="select_participante">
                <option value="" selected disabled>Selecione um participante</option>
            </select>
            <label for="">Participante</label>
        </div>
        <p id="info"></p>
        <button id="btnAdicionar">Adicionar</button>
    </div>
    <!-- Novo Projeto -> Equipes -> Participantes -->

    <!-- Novo Projeto -> Equipes -> Detalhes da Equipe -->
    <div class="modal modalDetalhesEquipe" id="modalDetalhesEquipe">
        <div class="divTitulo">
            <h1>Detalhes da equipe</h1>
            <img class="btnBack" id="btnFechar" src="Icones/Fechar.png"
                 alt="">
        </div>
        <div class="input-group">
            <input id="input_nome" type="text" placeholder=" " readonly>
            <label for="input_nome">Nome</label>
        </div>
        <div class="textArea-group">
            <textarea id="textArea_descricao" placeholder=" " readonly></textarea>
            <label for="textArea_descricao">Descrição</label>
        </div>
        <div class="select-group">
            <select id="select_responsavel" disabled>

            </select>
            <label for="select_responsavel">Responsável</label>
        </div>
        <button class="buttonOrange" id="btnParticipantes">Participantes</button>
        <p id="info"></p>
        <div class="divEditar_Salvar">
            <button class="buttonBlue" id="btnEditarEquipe">Editar</button>
            <button class="buttonGreen" id="btnSalvar" disabled>Salvar</button>
        </div>
    </div>
    <!-- Novo Projeto -> Equipes -> Detalhes da Equipe -->

    <!-- Novo Projeto -> Equipes -> Detalhes da Equipe -> Participantes -->
    <div class="modal modalParticipantes" id="modalParticipantesDetalhesEquipe">
        <div class="divTitulo">
            <h1>Participantes</h1>
            <img class="btnBack" id="btnFechar" src="Icones/Fechar.png" alt="">
        </div>
        <button class="btnAdicionarParticipantes" id="btnAdicionarParticipante">+ Adicionar participante</button>
        <section class="sectionParticipantes">
        </section>
    </div>
    <div class="modal modalAdicionarParticipante" id="modalAdicionarParticipanteDetalhesEquipe">
        <div class="divTitulo">
            <h1>Adicionar participantes</h1>
            <img class="btnBack" id="btnFechar" src="Icones/Fechar.png" alt="">
        </div>
        <div class="select-group">
            <select id="select_participante">
                <option value="" selected disabled>Selecione um participante</option>
                <?php foreach ($participantes as $participante) : ?>
                    <option value="<?= $participante->id ?>"><?= $participante->usuario ?></option>
                <?php endforeach; ?>
            </select>
            <label for="select_participante">Participante</label>
        </div>
        <p id="info"></p>
        <button id="btnAdicionar">Adicionar</button>
    </div>
    <!-- Novo Projeto -> Equipes -> Detalhes da Equipe -> Participantes -->

    <div class="modal" id="modalExcluir">
        <h1>Tem certeza que deseja excluir esse projeto?</h1>
        <div class="divCancelar_Excluir">
            <button class="buttonBlue" id="btnCancelarModalExcluir">Cancelar</button>
            <button class="buttonRed" id="btnExcluirModalExcluir">Excluir</button>
        </div>
    </div>
    <div class="modal" id="modalConcluir">
        <h1>Qual a data de conclusão desse projeto?</h1>
        <div class="input-group" id="divDataModalConcluir">
            <input type="date" id="inputDataModalConcluir">
            <label for="inputDataModalConcluir">Data de conclusão</label>
        </div>
        <div class="divCancelar_Concluir">
            <button class="buttonBlue" id="btnCancelarModalConcluir">Cancelar</button>
            <button class="buttonGreen" id="btnConcluirModalConcluir">Concluir</button>
        </div>
    </div>
</section>
