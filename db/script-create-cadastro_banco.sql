CREATE DATABASE IF NOT EXISTS cadastro_banco DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;

USE cadastro_banco;

CREATE TABLE pessoa (
	id INT AUTO_INCREMENT NOT NULL,
	nome VARCHAR(45) NOT NULL,
	endereco VARCHAR(65) NOT NULL,
    tipo VARCHAR(1) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE pessoa_fisica (
	id_pessoa INT NOT NULL,
	cpf VARCHAR(14) NOT NULL,
	FOREIGN KEY (id_pessoa) REFERENCES pessoa (id),
	PRIMARY KEY (id_pessoa)
);

CREATE TABLE pessoa_juridica (
	id_pessoa INT NOT NULL,
	cnpj VARCHAR(18) NOT NULL,
	FOREIGN KEY (id_pessoa) REFERENCES pessoa (id),
	PRIMARY KEY (id_pessoa)
);


CREATE TABLE conta (
	id INT AUTO_INCREMENT NOT NULL,
	numero VARCHAR(20) NOT NULL,
	saldo DOUBLE NOT NULL,
	`status` INT(1) NOT NULL,
    senha VARCHAR(32) NOT NULL,
    id_pessoa INT NOT NULL,
    FOREIGN KEY (id_pessoa) REFERENCES pessoa (id),
	PRIMARY KEY (id)
);
