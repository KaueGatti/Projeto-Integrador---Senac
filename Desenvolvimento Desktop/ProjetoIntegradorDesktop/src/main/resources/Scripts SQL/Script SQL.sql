CREATE DATABASE distribuidora_cfa;

#drop database distribuidora_cfa;

USE distribuidora_cfa;

CREATE TABLE laboratorio (
    id_lab INT AUTO_INCREMENT,
    nome VARCHAR(20) NOT NULL,
	cnpj VARCHAR(18) UNIQUE NOT NULL,
	ie VARCHAR(15) UNIQUE NOT NULL,
    numero VARCHAR(10) NOT NULL,
    rua VARCHAR(20) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    bairro VARCHAR(20) NOT NULL,
    cidade varchar(20) NOT NULL,
    uf CHAR(2) NOT NULL,
    complemento VARCHAR(20) NOT NULL,
    PRIMARY KEY (id_lab)
);

CREATE TABLE remedio (
    id_remedio INT AUTO_INCREMENT,
    id_lab INT NOT NULL,
    descricao VARCHAR(20) NOT NULL,
    data_ultima_compra DATE,
	valor_custo DECIMAL(10,2) NOT NULL,
	valor_venda DECIMAL(10,2) NOT NULL,
    qntd_armazenada INT NOT NULL DEFAULT 0,
    PRIMARY KEY (id_remedio),
    CONSTRAINT fk_id_lab FOREIGN KEY (id_lab) REFERENCES laboratorio (id_lab)
);

CREATE TABLE drogaria (
    id_drog INT AUTO_INCREMENT,
    nome VARCHAR(20) NOT NULL,
    cnpj VARCHAR(18) UNIQUE,
    numero VARCHAR(10) NOT NULL,
    rua VARCHAR(20) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    bairro VARCHAR(20) NOT NULL,
    cidade VARCHAR(20) NOT NULL,
    uf CHAR(2) NOT NULL,
    complemento VARCHAR(20) NOT NULL,
    PRIMARY KEY (id_drog)
);

CREATE TABLE venda (
    id_venda INT AUTO_INCREMENT,
    id_drog INT NOT NULL,
    data_venda DATE NOT NULL,
    data_entrega DATE,
    nmr_nota_fiscal VARCHAR(10) NOT NULL UNIQUE,
    total_nota DECIMAL(10,2) NOT NULL,
    forma_pagamento VARCHAR(20) NOT NULL,
    PRIMARY KEY (id_venda),
    CONSTRAINT fk_drogaria_venda FOREIGN KEY (id_drog) REFERENCES drogaria (id_drog)
);

CREATE TABLE compra (
    id_compra INT AUTO_INCREMENT,
    id_lab INT NOT NULL,
    data_compra DATE NOT NULL,
    data_entrega DATE,
    nmr_nota_fiscal VARCHAR(10) NOT NULL UNIQUE,
    total_nota DECIMAL(10,2) NOT NULL,
    forma_pagamento VARCHAR(20) NOT NULL,
    PRIMARY KEY (id_compra),
    CONSTRAINT fk_compra_laboratorio FOREIGN KEY (id_lab) REFERENCES laboratorio(id_lab)
);

CREATE TABLE item_venda (
	id_item_venda INT AUTO_INCREMENT,
    id_venda INT NOT NULL,
    id_remedio INT NOT NULL,
    quantidade INT NOT NULL,
    PRIMARY KEY (id_item_venda),
    CONSTRAINT fk_id_venda FOREIGN KEY (id_venda) REFERENCES venda (id_venda) ON DELETE CASCADE,
    CONSTRAINT fk_id_remedio_venda FOREIGN KEY (id_remedio) REFERENCES remedio (id_remedio)
);

CREATE TABLE item_compra (
	id_item_compra INT AUTO_INCREMENT,
    id_compra INT NOT NULL,
    id_remedio INT NOT NULL,
    quantidade INT NOT NULL,
    PRIMARY KEY (id_item_compra),
    CONSTRAINT fk_id_compra FOREIGN KEY (id_compra) REFERENCES compra (id_compra) ON DELETE CASCADE,
    CONSTRAINT fk_id_remedio_compra FOREIGN KEY (id_remedio) REFERENCES remedio (id_remedio)
);

CREATE PROCEDURE add_remedio(id_lab INT, descricao VARCHAR(20), valor_custo DECIMAL(10,2), valor_venda DECIMAL(10,2))
INSERT INTO remedio (id_lab, descricao, valor_custo, valor_venda)
VALUES (id_lab, descricao, valor_custo, valor_venda);
        
CREATE PROCEDURE delete_remedio(id_remedio INT) 
DELETE FROM remedio
WHERE remedio.id_remedio = id_remedio;

CREATE PROCEDURE update_remedio(id_remedio INT, id_lab INT, descricao VARCHAR(20), valor_custo DECIMAL(10,2), valor_venda DECIMAL(10,2))
UPDATE remedio
SET remedio.id_lab = id_lab, remedio.descricao = descricao, remedio.valor_custo = valor_custo, remedio.valor_venda = valor_venda
WHERE remedio.id_remedio = id_remedio;
    
CREATE PROCEDURE add_lab(nome VARCHAR(20), cnpj VARCHAR(18), ie VARCHAR(15), numero VARCHAR(10), rua VARCHAR(20), cep VARCHAR(9), bairro VARCHAR(20), cidade VARCHAR(20), uf CHAR(2), complemento VARCHAR(20))
INSERT INTO laboratorio (nome, cnpj, ie, numero, rua, cep, bairro, cidade, uf, complemento)
VALUES (nome, cnpj, ie, numero, rua, cep, bairro, cidade, uf, complemento);
    
CREATE PROCEDURE delete_lab(id_lab INT)
DELETE FROM laboratorio
WHERE laboratorio.id_lab = id_lab;
    
CREATE PROCEDURE update_lab(id_lab INT, nome VARCHAR(20), cnpj VARCHAR(18), ie VARCHAR(15), numero VARCHAR(10), rua VARCHAR(20), cep VARCHAR(9), bairro VARCHAR(20), cidade VARCHAR(20), uf CHAR(2), complemento VARCHAR(20))
UPDATE laboratorio AS l
SET l.nome = nome, l.cnpj = cnpj, l.ie = ie,  l.numero = numero, l.rua = rua, l.cep = cep, l.bairro = bairro, l.cidade = cidade, l.uf = uf, l.complemento = complemento
WHERE l.id_lab = id_lab;
    
CREATE PROCEDURE add_drog(nome VARCHAR(20), cnpj VARCHAR(18), numero VARCHAR(10), rua VARCHAR(20), cep VARCHAR(9), bairro VARCHAR(20), cidade VARCHAR(20), uf CHAR(2), complemento VARCHAR(20))
INSERT INTO drogaria (nome, cnpj, numero, rua, cep, bairro, cidade, uf, complemento)
VALUES (nome, cnpj, numero, rua, cep, bairro, cidade, uf, complemento);
    
CREATE PROCEDURE delete_drog(id_drog INT)
DELETE FROM drogaria
WHERE drogaria.id_drog = id_drog;

CREATE PROCEDURE update_drog(id_drog INT, nome VARCHAR(20), cnpj VARCHAR(18), numero VARCHAR(10), rua VARCHAR(20), cep VARCHAR(9), bairro VARCHAR(20), cidade VARCHAR(20), uf CHAR(2), complemento VARCHAR(20))
UPDATE drogaria AS d
SET d.nome = nome, d.cnpj = cnpj, d.numero = numero, d.rua = rua, d.cep = cep, d.bairro = bairro, d.cidade = cidade, d.uf = uf, d.complemento = complemento
WHERE d.id_drog = id_drog;

DELIMITER $$
CREATE PROCEDURE add_compra(id_lab INT, data_compra DATE, nmr_nota_fiscal VARCHAR(10), total_nota DECIMAL(10,2), forma_pagamento VARCHAR(20))
BEGIN
INSERT INTO compra (id_lab, data_compra, nmr_nota_fiscal, total_nota, forma_pagamento)
VALUES (id_lab, data_compra, nmr_nota_fiscal, total_nota, forma_pagamento);
SELECT LAST_INSERT_ID();
END $$
DELIMITER ;
    
CREATE PROCEDURE delete_compra(id_compra INT)
DELETE FROM compra
WHERE compra.id_compra = id_compra;

CREATE PROCEDURE update_compra(id_compra INT, id_lab INT, data_compra DATE, data_entrega DATE, nmr_nota_fiscal VARCHAR(10), total_nota DECIMAL(10,2), forma_pagamento VARCHAR(20))
UPDATE compra AS c
SET c.id_lab = id_lab, c.data_compra = data_compra, c.data_entrega = data_entrega, c.nmr_nota_fiscal = nmr_nota_fiscal, c.total_nota = total_nota, c.forma_pagamento = forma_pagamento
WHERE c.id_compra = id_compra;

DELIMITER $$
CREATE PROCEDURE add_venda(id_drog INT,  data_venda DATE, nmr_nota_fiscal VARCHAR(10), total_nota DECIMAL(10,2), forma_pagamento VARCHAR(20))
BEGIN
INSERT INTO venda (id_drog, data_venda, nmr_nota_fiscal, total_nota, forma_pagamento)
VALUES (id_drog, data_venda, nmr_nota_fiscal, total_nota, forma_pagamento);
SELECT LAST_INSERT_ID();
END $$
DELIMITER ;
    
CREATE PROCEDURE delete_venda(id_venda INT)
DELETE FROM venda
WHERE venda.id_venda = id_venda;

CREATE PROCEDURE update_venda(id_venda INT, id_drog INT)
UPDATE venda AS v
SET v.id_drog = id_drog
WHERE v.id_venda = id_venda;

CREATE PROCEDURE add_item_compra(id_compra INT, id_remedio INT, quantidade INT)
INSERT INTO item_compra (id_compra, id_remedio, quantidade)
VALUES (id_compra, id_remedio, quantidade);
    
CREATE PROCEDURE delete_item_compra(id_item_compra INT)
DELETE FROM item_compra
WHERE item_compra.id_item_compra = id_item_compra;

CREATE PROCEDURE add_item_venda(id_venda INT, id_remedio INT, quantidade INT)
INSERT INTO item_venda (id_venda, id_remedio, quantidade)
VALUES (id_venda, id_remedio, quantidade);
    
CREATE PROCEDURE delete_item_venda(id_item_venda INT)
DELETE FROM item_venda
WHERE item_venda.id_item_venda = id_item_venda;

CREATE PROCEDURE filterRemedio(descricao varchar(30), id_lab int, valor_custo_min double, valor_custo_max double, valor_venda_min double, valor_venda_max double)
SELECT * FROM remedio
WHERE remedio.descricao LIKE descricao AND 
remedio.id_lab = id_lab AND
valor_custo BETWEEN valor_custo_min AND valor_custo_max AND 
valor_venda BETWEEN valor_venda_min AND valor_venda_max;

CREATE PROCEDURE filterRemedioValor(descricao varchar(30), valor_custo_min double, valor_custo_max double, valor_venda_min double, valor_venda_max double)
SELECT * FROM remedio
WHERE remedio.descricao LIKE descricao AND 
valor_custo BETWEEN valor_custo_min AND valor_custo_max AND 
valor_venda BETWEEN valor_venda_min AND valor_venda_max;

CREATE PROCEDURE filterRemedioDinamico
(descricao VARCHAR(30), id_lab INT, valor_custo_min DOUBLE, valor_custo_max DOUBLE, valor_venda_min DOUBLE, valor_venda_max DOUBLE, orderBy VARCHAR(15), isDesc BOOLEAN)
SELECT * FROM remedio
WHERE
	remedio.descricao LIKE CONCAT('%', descricao, '%') AND
    (id_lab IS NULL OR remedio.id_lab = id_lab) AND
    valor_custo BETWEEN valor_custo_min AND valor_custo_max AND 
	valor_venda BETWEEN valor_venda_min AND valor_venda_max AND
    (orderBy IS NULL OR ORDER BY orderBy)
    (isDesc = FALSE OR DESC);
    

DELIMITER $$
CREATE TRIGGER compra_remedio
AFTER INSERT
ON item_compra
FOR EACH ROW
BEGIN
	UPDATE remedio
    SET qntd_armazenada = qntd_armazenada + NEW.quantidade, data_ultima_compra = CURDATE()
    WHERE remedio.id_remedio = NEW.id_remedio;
END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER venda_remedio
AFTER INSERT
ON item_venda
FOR EACH ROW
BEGIN
	UPDATE remedio
    SET qntd_armazenada = qntd_armazenada - NEW.quantidade
    WHERE remedio.id_remedio = NEW.id_remedio;
END $$
DELIMITER ;