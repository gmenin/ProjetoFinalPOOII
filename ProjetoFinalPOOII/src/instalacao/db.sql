CREATE SCHEMA pooIITrabalhoFinal;
USE pooIITrabalhoFinal;

CREATE USER admUser identified by 'admPassword';
grant all privileges on pooIITrabalhoFinal.* to 'admUser';
flush privileges;

CREATE TABLE usuario(
	id INTEGER NOT NULL AUTO_INCREMENT,
    nomeUsuario VARCHAR(50) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    PRIMARY KEY(id));
    
CREATE TABLE requisicao(
	id INTEGER NOT NULL AUTO_INCREMENT, 
    usuarioId INTEGER NOT NULL, 
    solicitante VARCHAR(50) NOT NULL, 
    telefone VARCHAR(50) NOT NULL, 
    email VARCHAR(50) NOT NULL, 
    numeroAlunos INTEGER NOT NULL, 
    atividade VARCHAR(50) NOT NULL, 
    modalidade VARCHAR(50) NOT NULL, 
    curso VARCHAR(50) NOT NULL, 
    equipamentos VARCHAR(200),
    PRIMARY KEY(id),
    FOREIGN KEY(usuarioId) 
		REFERENCES usuario(id) ON DELETE CASCADE);
        
CREATE TABLE reserva(
	id INTEGER NOT NULL AUTO_INCREMENT, 
    requisicaoId INTEGER NOT NULL, 
    dia DATE NOT NULL, 
    horarioInicial INTEGER NOT NULL, 
    horarioFinal INTEGER NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(requisicaoId) 
		REFERENCES requisicao(id) ON DELETE CASCADE);
