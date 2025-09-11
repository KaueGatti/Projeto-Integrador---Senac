
CREATE TABLE Projeto (
	id int pk increments unique
	id_chat int > Chat.id
	id_responsavel int null > Usuario.id
	nome varchar(150) unique
	descricao varchar(255)
	dataCriacao date
	dataInicalConclusao date
	dataAtualConclusao date
	dataConclusao date
	status varchar(30)
)

Tarefa {
	id int pk increments unique
	id_chat int > Chat.id
	id_projeto int null > Projeto.id
	id_equipe int null > Equipe.id
	id_usuario int null > Usuario.id
	nome varchar(150)
	descricao varchar(255)
	dataCriacao date
	dataIncialConclusao date
	dataAtualConclusao date
	dataConclusao date null
	status varchar(30)
}

Usuario {
	id int pk increments unique
	usuario varchar(150)
	senha varchar(255)
	status varchar(30)
}

Equipe {
	id int pk increments unique
	id_chat int > Chat.id
	id_projeto int > Projeto.id
	nome varchar(150)
	descricao varchar(255)
	dataCriacao date
	dataDissolucao date null
	status varchar(30)
}

Usuario_Equipe {
	id_usuario int > Usuario.id
	id_equipe int > Equipe.id
	funcao varchar(255) null
}

Comentario {
	id int pk increments unique
	id_usuario int *> Usuario.id
	id_projeto int null *> Projeto.id
	id_equipe int null *> Equipe.id
	id_tarefa int null *> Tarefa.id
	texto varchar(255)
	data_hora_envio datetime
}

Conversa {
	id integer pk increments unique
	id_usuarioA int *> Usuario.id
	id_usuarioB int *> Usuario.id
}

Chat {
	id integer pk increments unique
}

Mensagem_Chat {
	id integer pk increments unique
	id_chat int > Chat.id
	id_usuario int > Usuario.id
	texto varchar
	data_hora_envio datetime
}

Mensagem_Conversa {
	id integer pk increments unique
	id_conversa int > Conversa.id
	id_usuario int > Usuario.id
	texto varchar
	data_hora_envio datetime
}

Notificacao {
	id int pk increments unique
	id_usuario int > Usuario.id
	texto varchar(255)
	assunto varchar(150)
	status varchar(30)
}