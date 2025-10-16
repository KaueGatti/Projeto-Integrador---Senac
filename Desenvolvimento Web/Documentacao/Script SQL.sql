CREATE DATABASE Workether;

USE Workether;

CREATE TABLE Usuario (
	id VARCHAR(7),
	email VARCHAR(255),
	usuario VARCHAR(150),
	senha VARCHAR(255),
	status VARCHAR(30) DEFAULT 'Ativo',
	PRIMARY KEY (id)
);

CREATE TABLE Conversa (
	id INT AUTO_INCREMENT,
	id_usuarioA VARCHAR(7),
	id_usuarioB VARCHAR(7),
	PRIMARY KEY (id),
	FOREIGN KEY (id_usuarioA) REFERENCES Usuario(id),
	FOREIGN KEY (id_usuarioB) REFERENCES Usuario(id)
);

CREATE TABLE Mensagem_Conversa (
	id INT AUTO_INCREMENT,
	id_conversa INT,
	id_usuario VARCHAR(7),
	texto VARCHAR(255),
	data_hora_envio DATETIME,
	PRIMARY KEY (id),
	FOREIGN KEY (id_conversa) REFERENCES Conversa(id),
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id)
);

CREATE TABLE Chat (
	id INT AUTO_INCREMENT,
	PRIMARY KEY (id)
);

CREATE TABLE Mensagem_Chat (
	id INT AUTO_INCREMENT,
	id_chat INT,
	id_usuario VARCHAR(7),
	texto VARCHAR(255),
	data_hora_envio DATETIME,
	PRIMARY KEY (id),
	FOREIGN KEY (id_chat) REFERENCES Chat(id),
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id)
);

CREATE TABLE Projeto (
	id INT AUTO_INCREMENT,
	id_chat INT NOT NULL,
    id_criador VARCHAR(7) NOT NULL,
	id_responsavel VARCHAR(7) NOT NULL,
	nome VARCHAR(150) NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	dataCriacao DATE NOT NULL,
	dataInicialConclusao DATE NOT NULL,
	dataAtualConclusao DATE NOT NULL,
	dataConclusao DATE,
	status VARCHAR(30) NOT NULL,
    UNIQUE (id_responsavel, nome),
	PRIMARY KEY (id),
	FOREIGN KEY (id_chat) REFERENCES Chat(id),
    FOREIGN KEY (id_criador) REFERENCES Usuario(id),
	FOREIGN KEY (id_responsavel) REFERENCES Usuario(id)
);

CREATE TABLE Usuario_Projeto (
	id_usuario VARCHAR(7) NOT NULL,
	id_projeto INT NOT NULL,
	PRIMARY KEY (id_usuario, id_projeto),
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id),
	FOREIGN KEY (id_projeto) REFERENCES Projeto(id)
);

CREATE TABLE Equipe (
	id INT AUTO_INCREMENT,
	id_chat INT,
	id_projeto INT,
    id_responsavel VARCHAR(7),
	nome VARCHAR(150),
	descricao VARCHAR(255),
	dataCriacao DATE,
	dataDissolucao DATE NULL,
	status VARCHAR(30),
	PRIMARY KEY (id),
	FOREIGN KEY (id_chat) REFERENCES Chat(id),
	FOREIGN KEY (id_projeto) REFERENCES Projeto(id),
    FOREIGN KEY (id_responsavel) REFERENCES Usuario(id)
);

CREATE TABLE Usuario_Equipe (
	id_usuario VARCHAR(7),
	id_equipe INT,
	PRIMARY KEY (id_usuario, id_equipe),
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id),
	FOREIGN KEY (id_equipe) REFERENCES Equipe(id)
);

CREATE TABLE Tarefa (
	id INT AUTO_INCREMENT,
	id_projeto INT NULL,
	id_equipe INT NULL,
	id_usuario VARCHAR(7) NULL,
	nome VARCHAR(150),
	descricao VARCHAR(255),
	dataCriacao DATE,
	dataInicialConclusao DATE,
	dataAtualConclusao DATE,
	dataConclusao DATE NULL,
	status VARCHAR(30),
	PRIMARY KEY (id),
	FOREIGN KEY (id_projeto) REFERENCES Projeto(id),
	FOREIGN KEY (id_equipe) REFERENCES Equipe(id),
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id)
);

CREATE TABLE Comentario (
	id INT AUTO_INCREMENT,
	id_usuario VARCHAR(7),
	id_projeto INT NULL,
	id_equipe INT NULL,
	id_tarefa INT NULL,
	texto VARCHAR(255),
	data_hora_envio DATETIME,
	PRIMARY KEY (id),
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id),
	FOREIGN KEY (id_projeto) REFERENCES Projeto(id),
	FOREIGN KEY (id_equipe) REFERENCES Equipe(id),
	FOREIGN KEY (id_tarefa) REFERENCES Tarefa(id)
);

CREATE TABLE Notificacao (
	id INT AUTO_INCREMENT,
    id_usuario VARCHAR (7),
    assunto VARCHAR (150),
    texto VARCHAR (255),
    data_hora DATETIME,
    status VARCHAR (30),
    PRIMARY KEY (id),
    FOREIGN KEY (id_usuario) REFERENCES Usuario (id)
);

CREATE TABLE Amizade (
	id_usuarioA VARCHAR (7),
    id_usuarioB VARCHAR (7),
    PRIMARY KEY (id_usuarioA, id_usuarioB),
    FOREIGN KEY (id_usuarioA) REFERENCES Usuario (id),
    FOREIGN KEY (id_usuarioB) REFERENCES Usuario (id)
);

CREATE TABLE Pedido_Amizade(
	id INT AUTO_INCREMENT,
    id_notificacao INT NOT NULL,
    id_solicitante VARCHAR (7) NOT NULL,
    id_receptor VARCHAR (7) NOT NULL,
    status VARCHAR(30) NOT NULL DEFAULT "Pendente",
    data_hora DATETIME,
    PRIMARY KEY (id),
    FOREIGN KEY (id_notificacao) REFERENCES Notificacao (id),
    FOREIGN KEY (id_solicitante) REFERENCES Usuario (id),
    FOREIGN KEY (id_receptor) REFERENCES Usuario (id)
);

DELIMITER $
CREATE PROCEDURE CREATE_USUARIO (_id VARCHAR (7), _email VARCHAR (255), _usuario VARCHAR (150), _senha VARCHAR (255))
BEGIN
	INSERT INTO Usuario (id, email, usuario, senha) VALUES (_id, _email, _usuario, _senha); 
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE UPDATE_USUARIO(_id VARCHAR (7), _email VARCHAR (255), _usuario VARCHAR (150), _senha VARCHAR (255), _status VARCHAR (30))
BEGIN
	UPDATE Usuario
    SET email = _email, usuario = _usuario, senha = _senha, status = _status
    WHERE id = _id;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE UPDATE_NOME_USUARIO(_id VARCHAR (7), _usuario VARCHAR (150))
BEGIN
	UPDATE Usuario
    SET usuario = _usuario
    WHERE id = _id;
END $
DELIMITER ;

CREATE VIEW READ_ALL_USUARIO AS
	SELECT * FROM Usuario;
    
DELIMITER $$
CREATE PROCEDURE READ_USUARIO_BY_NOME (_nome VARCHAR (150))
BEGIN
	SELECT * FROM Usuario WHERE usuario LIKE _nome;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE READ_USUARIO_BY_EMAIL (_email VARCHAR (255))
BEGIN
	SELECT * FROM Usuario WHERE email LIKE _email;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE READ_USUARIO_BY_ID (_id VARCHAR (7))
BEGIN
	SELECT * FROM Usuario WHERE id = _id;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE READ_USUARIOS_BY_PROJETO (_id_projeto VARCHAR(7))
BEGIN
    SELECT u.id, u.usuario FROM Usuario u
    JOIN Usuario_Projeto up ON up.id_usuario = u.id
    WHERE up.id_projeto = _id_projeto

    UNION

    SELECT u.id, u.usuario FROM Usuario u
    JOIN Projeto p ON u.id = p.id_responsavel
    WHERE p.id = _id_projeto;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE READ_USUARIOS_BY_EQUIPE (_id_equipe INT)
BEGIN
	SELECT * FROM Usuario_Equipe WHERE id_equipe = _id_equipe;
END $$
DELIMITER ;

DELIMITER $
CREATE PROCEDURE CREATE_PROJETO (_id_criador VARCHAR(7), _id_responsavel VARCHAR(7), _nome VARCHAR(150), _descricao VARCHAR(255), _dataInicialConclusao DATE)
BEGIN
	INSERT INTO Projeto (id_criador, id_responsavel, nome, descricao, dataCriacao, dataInicialConclusao, dataAtualConclusao, dataConclusao, status)
    VALUES (_id_criador, _id_responsavel, _nome, _descricao, CURDATE(), _dataInicialConclusao, _dataInicialConclusao, NULL, 'Em andamento');
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE UPDATE_PROJETO (_id_projeto INT, _id_responsavel VARCHAR(7), _nome VARCHAR(150), _descricao VARCHAR(255), _dataAtualConclusao DATE, _dataConclusao DATE, _status VARCHAR(30))
BEGIN
	UPDATE Projeto
    SET id_responsavel = _id_responsavel, nome = _nome, descricao = _descricao, dataAtualConclusao = _dataAtualConclusao, dataConclusao = _dataConclusao, status = _status
    WHERE Projeto.id = _id_projeto;
END $
DELIMITER ;

CREATE VIEW READ_ALL_PROJETOS AS
	SELECT * FROM Projeto;
    
DELIMITER $$
CREATE PROCEDURE READ_PROJETO_BY_ID (_id INT)
BEGIN
	SELECT * FROM Projeto
	WHERE Projeto.id = _id;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE READ_PROJETOS_BY_USUARIO (_id_usuario VARCHAR(7))
BEGIN
	SELECT * FROM Projeto
	WHERE id IN (
		SELECT id_projeto FROM Usuario_Projeto WHERE id_usuario = _id_usuario
		UNION
		SELECT id FROM Projeto WHERE id_criador = _id_usuario
		UNION
		SELECT id FROM Projeto WHERE id_responsavel = _id_usuario
	);
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE READ_PROJETOS_BY_RESPONSAVEL (_id_usuario VARCHAR (7))
BEGIN
	SELECT * FROM Projeto
	WHERE Projeto.id_responsavel = _id_usuario;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE READ_PROJETOS_BY_NOME (_nome VARCHAR (150))
BEGIN
	SELECT * FROM Projeto
	WHERE Projeto.nome LIKE _nome;
END $$
DELIMITER ;

DELIMITER $
CREATE PROCEDURE CREATE_USUARIO_PROJETO (_id_usuario VARCHAR(7), _id_projeto INT)
BEGIN
	INSERT INTO Usuario_Projeto (id_usuario, id_projeto)
    VALUES (_id_usuario, _id_projeto);
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE DELETE_ALL_USUARIOS_PROJETO (_id_projeto INT)
BEGIN
	DELETE FROM Usuario_Projeto
    WHERE Usuario_Projeto.id_projeto = _id_projeto;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE DELETE_USUARIO_PROJETO (_id_usuario VARCHAR (7), _id_projeto INT)
BEGIN
	DELETE FROM Usuario_Projeto
    WHERE Usuario_Projeto.id_usuario = _id_usuario AND Usuario_Projeto.id_projeto = _id_projeto;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE CREATE_EQUIPE (_id_projeto INT, _id_responsavel VARCHAR(7), _nome VARCHAR (150), _descricao VARCHAR (255))
BEGIN
	INSERT INTO Equipe (id_projeto, id_responsavel, nome, descricao, dataCriacao)
    VALUES (_id_projeto, _id_responsavel, _nome, _descricao, NOW());
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE UPDATE_EQUIPE (_id_equipe INT, _id_responsavel VARCHAR(7), _nome VARCHAR(150), _descricao VARCHAR(255), _dataDissolucao DATE, _status VARCHAR(30))
BEGIN
	UPDATE Equipe
    SET id_responsavel = _id_responsavel, nome = _nome, descricao = _descricao, dataDissolucao = _dataDissolucao, status = _status
    WHERE Equipe.id = _id_equipe;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE CREATE_USUARIO_EQUIPE (_id_usuario VARCHAR(7), _id_equipe INT)
BEGIN
	INSERT INTO Usuario_Equipe (id_usuario, id_equipe)
    VALUES (_id_usuario, _id_equipe);
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE DELETE_ALL_USUARIOS_EQUIPE (_id_equipe INT)
BEGIN
	DELETE FROM Usuario_Equipe
    WHERE Usuario_Equipe.id_equipe = _id_equipe;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE DELETE_USUARIO_EQUIPE (_id_usuario VARCHAR (7), _id_equipe INT)
BEGIN
	DELETE FROM Usuario_Equipe
    WHERE Usuario_Equipe.id_usuario = _id_usuario AND Usuario_Equipe.id_equipe = _id_equipe;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE READ_ALL_EQUIPES_BY_PROJETO (_id_projeto INT)
BEGIN
	SELECT * FROM Equipe
    WHERE Equipe.id_projeto = _id_projeto;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE READ_ALL_EQUIPES_BY_USUARIO (_id_usuario VARCHAR (7))
BEGIN
	SELECT * FROM Equipe
    LEFT JOIN Usuario_Equipe ON Equipe.id = Usuario_Equipe.id_equipe
    WHERE Usuario_Equipe.id_usuario = _id_usuario OR Equipe.id_responsavel = _id_usuario;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE CREATE_TAREFA (_id_projeto INT, _id_equipe INT, _id_usuario VARCHAR(7), 
	_nome VARCHAR(150), _descricao VARCHAR(255), _dataInicialConclusao DATE)
BEGIN
	INSERT INTO Tarefa (id_projeto, id_equipe, id_usuario, nome, descricao, dataCriacao, dataInicialConclusao, dataAtualConclusao, dataConclusao, status)
    VALUES (_id_projeto, _id_equipe, _id_usuario, _nome, _descricao, CURDATE(), _dataInicialConclusao, _dataInicialConclusao, NULL, 'Em andamento');
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE UPDATE_TAREFA (_id_tarefa INT, _nome VARCHAR(150), _descricao VARCHAR(255), _dataAtualConclusao DATE, _status VARCHAR(30))
BEGIN
	UPDATE Tarefa
    SET nome = _nome, descricao = _descricao, dataAtualConclusao = _dataAtualConclusao, status = _status
    WHERE Tarefa.id = _id_tarefa;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE READ_ALL_TAREFAS_BY_USUARIO (_id_usuario VARCHAR (7))
BEGIN
	SELECT * FROM Tarefa
    WHERE Tarefa.id_usuario = _id_usuario;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE READ_ALL_TAREFAS_BY_PROJETO (_id_projeto INT)
BEGIN
	SELECT * FROM Tarefa
    WHERE Tarefa.id_projeto = _id_projeto;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE READ_ALL_TAREFAS_BY_EQUIPE (_id_equipe INT)
BEGIN
	SELECT * FROM Tarefa
    WHERE Tarefa.id_equipe = _id_equipe;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE CREATE_COMENTARIO (_id_usuario VARCHAR(7), _id_projeto INT, _id_equipe INT, _id_tarefa INT, _texto VARCHAR(255))
BEGIN
	INSERT INTO Comentario (id_usuario, id_projeto, id_equipe, id_tarefa, texto, data_hora_envio)
    VALUES (_id_usuario, _id_projeto, _id_equipe, _id_tarefa, _texto, NOW());
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE DELETE_COMENTARIO (_id_comentario INT)
BEGIN
	DELETE FROM Comentario
    WHERE Comentario.id = _id_comentario;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE READ_ALL_COMENTARIOS_BY_TAREFA (_id_tarefa INT)
BEGIN
	SELECT * FROM Comentario
    WHERE Comentario.id_tarefa = _id_tarefa;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE READ_ALL_COMENTARIOS_BY_PROJETO (_id_projeto INT)
BEGIN
	SELECT * FROM Comentario
    WHERE Comentario.id_projeto = _id_projeto;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE READ_ALL_COMENTARIOS_BY_EQUIPE (_id_equipe INT)
BEGIN
	SELECT * FROM Comentario
    WHERE Comentario.id_equipe = _id_equipe;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE CREATE_CONVERSA (_id_usuarioA VARCHAR(7), _id_usuarioB VARCHAR(7))
BEGIN
	INSERT INTO Conversa (id_usuarioA, id_usuarioB)
    VALUES (LEAST(_id_usuarioA, _id_usuarioB), GREATEST(_id_usuarioA, _id_usuarioB));
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE READ_ALL_CONVERSAS_BY_USUARIO (_id_usuario VARCHAR (7))
BEGIN
	SELECT * FROM Conversa
    WHERE Conversa.id_usuarioA = _id_usuario OR Conversa.id_usuarioB = _id_usuario;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE READ_CONVERSAS_BY_NOME (_id_usuario VARCHAR (7), _nome VARCHAR (150))
BEGIN
	SELECT Conversa.*, Usuario.usuario FROM Conversa
    LEFT JOIN Usuario ON (Usuario.id IN (Conversa.id_usuarioA, Conversa.id_usuarioB))
    WHERE (_id_usuario IN (Conversa.id_usuarioA, Conversa.id_usuarioB)) AND Usuario.id != _id_usuario AND Usuario.usuario LIKE _nome;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE CREATE_MENSAGEM_CONVERSA (_id_conversa INT, _id_usuario VARCHAR(7), _texto VARCHAR(255))
BEGIN
	INSERT INTO Mensagem_Conversa (id_conversa, id_usuario, texto, data_hora_envio)
    VALUES (_id_conversa, _id_usuario, _texto, NOW());
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE READ_ALL_MENSAGENS_BY_CONVERSA (_id_conversa INT)
BEGIN
	SELECT * FROM Mensagem_Conversa
    WHERE Mensagem_Conversa.id_conversa = _id_conversa;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE CREATE_CHAT()
BEGIN
	INSERT INTO Chat VALUES (NULL);
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE READ_ALL_CHATS_BY_USUARIO (_id_usuario VARCHAR (7))
BEGIN
	SELECT * FROM Chat
    LEFT JOIN Projeto ON Chat.id = Projeto.id_chat
    LEFT JOIN Usuario_Projeto ON Usuario_Projeto.id_projeto = Projeto.id AND Usuario_Projeto.id_usuario = _id_usuario
    LEFT JOIN Equipe ON Chat.id = Equipe.id_chat
    LEFT JOIN Usuario_Equipe ON Usuario_Equipe.id_equipe = Equipe.id AND Usuario_Equipe.id_usuario = _id_usuario
    WHERE Usuario_Equipe.id_usuario IS NOT NULL OR Usuario_Projeto.id_usuario = _id_usuario;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE CREATE_MENSAGEM_CHAT(_id_chat INT, _id_usuario VARCHAR(7), _texto VARCHAR(255))
BEGIN
	INSERT INTO Mensagem_Chat (id_chat, id_usuario, texto, data_hora_envio)
    VALUES (_id_chat, _id_usuario, _texto, NOW());
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE READ_ALL_MENSAGENS_BY_CHAT (_id_chat INT)
BEGIN
	SELECT * FROM Mensagem_Chat
    WHERE Mensagem_Chat.id_chat = _id_chat;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE CREATE_NOTIFICACAO(_id_usuario VARCHAR (7), _assunto VARCHAR (150), _texto VARCHAR (255))
BEGIN
	INSERT INTO Notificacao (id_usuario, assunto, texto, data_hora, status)
    VALUES (_id_usuario, _assunto, _texto, NOW(), 'Não visualizada');
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE UPDATE_NOTIFICACAO(_id_notificacao INT, _status VARCHAR (30))
BEGIN
	UPDATE Notificacao
    SET status = _status
    WHERE Notificacao.id = _id_notificacao;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE READ_ALL_NOTIFICACOES_BY_USUARIO (_id_usuario VARCHAR (7))
BEGIN
	SELECT * FROM Notificacao
    WHERE Notificacao.id_usuario = _id_usuario AND Notificacao.status = "Não visualizada"
    ORDER BY data_hora DESC;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE CREATE_AMIZADE (_id_usuarioA VARCHAR(7), _id_usuarioB VARCHAR(7))
BEGIN
	INSERT INTO Amizade (id_usuarioA, id_usuarioB)
    VALUES (LEAST(_id_usuarioA, _id_usuarioB), GREATEST(_id_usuarioA, _id_usuarioB));
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE READ_ALL_AMIZADES_BY_USER (_id_usuario VARCHAR(7))
BEGIN
	SELECT id, usuario FROM Usuario
    JOIN Amizade ON (Usuario.id = Amizade.id_usuarioA OR Usuario.id = Amizade.id_usuarioB)
    WHERE _id_usuario IN (Amizade.id_usuarioA, Amizade.id_usuarioB) AND Usuario.id != _id_usuario;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE CREATE_PEDIDO_AMIZADE(_id_solicitante VARCHAR(7), _id_receptor VARCHAR(7))
BEGIN
	INSERT INTO Pedido_Amizade (id_solicitante, id_receptor, data_hora)
    VALUES (_id_solicitante, _id_receptor, NOW());
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE UPDATE_PEDIDO_AMIZADE(_id_pedido_amizade INT, _status VARCHAR(30))
BEGIN
	UPDATE Pedido_Amizade
    SET status = _status
    WHERE id = _id_pedido_amizade;
END $
DELIMITER ;

DELIMITER $
CREATE PROCEDURE READ_PEDIDO_AMIZADE_BY_NOTIFICACAO (_id_notificacao INT)
BEGIN
	SELECT * FROM PEDIDO_AMIZADE
    WHERE id_notificacao = _id_notificacao;
END $
DELIMITER ;

DELIMITER $
CREATE TRIGGER NOVO_CHAT_PROJETO
BEFORE INSERT ON Projeto
FOR EACH ROW
BEGIN
	DECLARE id_chat INT;
    
	CALL CREATE_CHAT();
    
    SET id_chat = LAST_INSERT_ID();
    
    SET NEW.id_chat = id_chat;
    
END $
DELIMITER ;

DELIMITER $
CREATE TRIGGER NOVO_CHAT_EQUIPE
BEFORE INSERT ON Equipe
FOR EACH ROW
BEGIN
	DECLARE id_chat INT;
    
	CALL CREATE_CHAT();
    
    SET id_chat = LAST_INSERT_ID();
    
    SET NEW.id_chat = id_chat;
    
END $
DELIMITER ;

DELIMITER $$
CREATE TRIGGER NOVO_PEDIDO_AMIZADE
BEFORE INSERT ON Pedido_Amizade
FOR EACH ROW
BEGIN

	DECLARE amigos INT;
    DECLARE existe INT;
    DECLARE usuario_solicitante VARCHAR(150);
    DECLARE id_notificacao INT;
    
    SELECT COUNT(*) INTO amigos
    FROM Amizade
    WHERE (id_usuarioA = NEW.id_solicitante AND id_usuarioB = NEW.id_receptor) OR (id_usuarioB = NEW.id_receptor AND id_usuarioA = NEW.id_solicitante);

    IF amigos > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Você e esse usuário já são amigos.'; 
    END IF;

    SELECT COUNT(*) INTO existe
    FROM Pedido_Amizade
    WHERE 
        (
            (id_solicitante = NEW.id_solicitante AND id_receptor = NEW.id_receptor)
            OR
            (id_solicitante = NEW.id_receptor AND id_receptor = NEW.id_solicitante)
        )
        AND status = 'Pendente';

    IF existe > 0 THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Já existe um pedido de amizade ativo entre você e esse usuário.';
    END IF;
    
    SELECT usuario INTO usuario_solicitante
    FROM Usuario
    WHERE id = NEW.id_solicitante;
	
	CALL CREATE_NOTIFICACAO(NEW.id_receptor, 'Pedido de Amizade', CONCAT('Você recebeu um pedido de amizade de ', usuario_solicitante, ' (ID: ', NEW.id_solicitante, ')'));
    
    SET id_notificacao = LAST_INSERT_ID();
    
    SET NEW.id_notificacao = id_notificacao;
    
END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER RESPOSTA_PEDIDO_AMIZADE
AFTER UPDATE ON Pedido_Amizade
FOR EACH ROW
BEGIN
    
    IF NEW.status = 'Aceito' THEN
		CALL CREATE_AMIZADE(NEW.id_solicitante, NEW.id_receptor);
	END IF;
    
    CALL UPDATE_NOTIFICACAO(NEW.id_notificacao, 'Visualizada');
    
END $$
DELIMITER ;