CREATE DATABASE Workether;

USE Workether;

CREATE TABLE Usuario (
	id VARCHAR(7),
	email VARCHAR(255),
	usuario VARCHAR(150),
	senha VARCHAR(255),
	status VARCHAR(30),
	PRIMARY KEY (id)
);

CREATE TABLE Projeto (
	id INT AUTO_INCREMENT,
	id_chat INT,
	id_responsavel VARCHAR(7) NULL,
	nome VARCHAR(150) UNIQUE,
	descricao VARCHAR(255),
	dataCriacao DATE,
	dataInicalConclusao DATE,
	dataAtualConclusao DATE,
	dataConclusao DATE,
	status VARCHAR(30),
	PRIMARY KEY (id),
	FOREIGN KEY (id_chat) REFERENCES Chat(id),
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
	nome VARCHAR(150),
	descricao VARCHAR(255),
	dataCriacao DATE,
	dataDissolucao DATE NULL,
	status VARCHAR(30),
	PRIMARY KEY (id),
	FOREIGN KEY (id_chat) REFERENCES Chat(id),
	FOREIGN KEY (id_projeto) REFERENCES Projeto(id)
);

CREATE TABLE Usuario_Equipe (
	id_usuario VARCHAR(7),
	id_equipe INT,
	funcao VARCHAR(255) NULL,
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
	dataIncialConclusao DATE,
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

CREATE VIEW READ_ALL_USUARIO AS
	SELECT * FROM Usuario;