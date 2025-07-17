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
    _status VARCHAR(15) NOT NULL DEFAULT 'ATIVADO',
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
    _status VARCHAR(15) NOT NULL DEFAULT 'ATIVADO',
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
    _status VARCHAR(15) NOT NULL DEFAULT 'ATIVADO',
    PRIMARY KEY (id_drog)
);

CREATE TABLE venda (
    id_venda INT AUTO_INCREMENT,
    id_drog INT NOT NULL,
    data_venda DATE NOT NULL,
    data_entrega DATE,
    nmr_nota_fiscal VARCHAR(30) NOT NULL,
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
    nmr_nota_fiscal VARCHAR(30) NOT NULL,
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
    CONSTRAINT fk_id_venda FOREIGN KEY (id_venda) REFERENCES venda (id_venda),
    CONSTRAINT fk_id_remedio_venda FOREIGN KEY (id_remedio) REFERENCES remedio (id_remedio)
);

CREATE TABLE item_compra (
	id_item_compra INT AUTO_INCREMENT,
    id_compra INT NOT NULL,
    id_remedio INT NOT NULL,
    quantidade INT NOT NULL,
    PRIMARY KEY (id_item_compra),
    CONSTRAINT fk_id_compra FOREIGN KEY (id_compra) REFERENCES compra (id_compra),
    CONSTRAINT fk_id_remedio_compra FOREIGN KEY (id_remedio) REFERENCES remedio (id_remedio)
);

CREATE PROCEDURE add_remedio(id_lab INT, descricao VARCHAR(20), valor_custo DECIMAL(10,2), valor_venda DECIMAL(10,2))
INSERT INTO remedio (id_lab, descricao, valor_custo, valor_venda)
VALUES (id_lab, descricao, valor_custo, valor_venda);
        
CREATE PROCEDURE delete_remedio(id_remedio INT) 
DELETE FROM remedio
WHERE remedio.id_remedio = id_remedio;

CREATE PROCEDURE update_remedio(id_remedio INT, id_lab INT, descricao VARCHAR(20), valor_custo DECIMAL(10,2), valor_venda DECIMAL(10,2), _status VARCHAR(15))
UPDATE remedio
SET remedio.id_lab = id_lab, remedio.descricao = descricao, remedio.valor_custo = valor_custo, remedio.valor_venda = valor_venda, remedio._status = _status
WHERE remedio.id_remedio = id_remedio;
    
CREATE PROCEDURE add_lab(nome VARCHAR(20), cnpj VARCHAR(18), ie VARCHAR(15), numero VARCHAR(10), rua VARCHAR(20), cep VARCHAR(9), bairro VARCHAR(20), cidade VARCHAR(20), uf CHAR(2), complemento VARCHAR(20))
INSERT INTO laboratorio (nome, cnpj, ie, numero, rua, cep, bairro, cidade, uf, complemento)
VALUES (nome, cnpj, ie, numero, rua, cep, bairro, cidade, uf, complemento);
    
CREATE PROCEDURE delete_lab(id_lab INT)
DELETE FROM laboratorio
WHERE laboratorio.id_lab = id_lab;
    
CREATE PROCEDURE update_lab(id_lab INT, nome VARCHAR(20), cnpj VARCHAR(18), ie VARCHAR(15), numero VARCHAR(10), rua VARCHAR(20), cep VARCHAR(9), bairro VARCHAR(20), cidade VARCHAR(20), uf CHAR(2), complemento VARCHAR(20), _status VARCHAR(15))
UPDATE laboratorio AS l
SET l.nome = nome, l.cnpj = cnpj, l.ie = ie,  l.numero = numero, l.rua = rua, l.cep = cep, l.bairro = bairro, l.cidade = cidade, l.uf = uf, l.complemento = complemento, l._status = _status
WHERE l.id_lab = id_lab;
    
CREATE PROCEDURE add_drog(nome VARCHAR(20), cnpj VARCHAR(18), numero VARCHAR(10), rua VARCHAR(20), cep VARCHAR(9), bairro VARCHAR(20), cidade VARCHAR(20), uf CHAR(2), complemento VARCHAR(20))
INSERT INTO drogaria (nome, cnpj, numero, rua, cep, bairro, cidade, uf, complemento)
VALUES (nome, cnpj, numero, rua, cep, bairro, cidade, uf, complemento);
    
CREATE PROCEDURE delete_drog(id_drog INT)
DELETE FROM drogaria
WHERE drogaria.id_drog = id_drog;

CREATE PROCEDURE update_drog(id_drog INT, nome VARCHAR(20), cnpj VARCHAR(18), numero VARCHAR(10), rua VARCHAR(20), cep VARCHAR(9), bairro VARCHAR(20), cidade VARCHAR(20), uf CHAR(2), complemento VARCHAR(20), _status VARCHAR(15))
UPDATE drogaria AS d
SET d.nome = nome, d.cnpj = cnpj, d.numero = numero, d.rua = rua, d.cep = cep, d.bairro = bairro, d.cidade = cidade, d.uf = uf, d.complemento = complemento, d._status = _status
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

DELIMITER $$
CREATE PROCEDURE filterRemedioDinamico
(descricao VARCHAR(30), id_lab INT, valor_custo_min DOUBLE, valor_custo_max DOUBLE, valor_venda_min DOUBLE, valor_venda_max DOUBLE, _status VARCHAR(15), orderBy VARCHAR(20), isDesc BOOLEAN)
BEGIN
	SET @sql = CONCAT('SELECT * FROM remedios WHERE valor_custo BETWEEN ', valor_custo_min, ' AND ', valor_custo_max, ' AND valor_venda BETWEEN ', valor_venda_min, ' AND ', valor_venda_max);
    
    IF descricao IS NOT NULL THEN
		SET @sql = CONCAT(@sql, ' AND remedios.descricao LIKE \'', descricao, '\'');
	END IF;
    
    IF id_lab IS NOT NULL THEN
		SET @sql = CONCAT(@sql, ' AND remedios.id_lab = ', id_lab);
	END IF;
    
    IF _status IS NOT NULL THEN
		SET @sql = CONCAT(@sql, ' AND _status = \'', _status, '\'');
    END IF;
    
    IF orderBy IS NOT NULL THEN
		SET @sql = CONCAT(@sql, ' ORDER BY ', orderBy);
		IF isDesc THEN
			SET @sql = CONCAT(@sql, ' DESC');
		END IF;
	END IF;
    
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE filterCompraDinamico
(nNF VARCHAR(30), id_lab INT, pagamento VARCHAR(20), valor_total_min double, valor_total_max double, orderBy VARCHAR(20), isDesc BOOLEAN)
BEGIN
	SET @sql = CONCAT('SELECT * FROM compra WHERE total_nota BETWEEN ', valor_total_min, ' AND ', valor_total_max);
    
    IF nNF IS NOT NULL THEN
		SET @sql = CONCAT(@sql, ' AND compra.nmr_nota_fiscal LIKE \'', nNF, '\'');
	END IF;
    
    IF id_lab IS NOT NULL THEN
		SET @sql = CONCAT(@sql, ' AND compra.id_lab = ', id_lab);
	END IF;
    
    IF pagamento IS NOT NULL THEN
		SET @sql = CONCAT(@sql, ' AND compra.forma_pagamento = \'', pagamento, '\'');
	END IF;
    
    IF orderBy IS NOT NULL THEN
		SET @sql = CONCAT(@sql, ' ORDER BY ', orderBy);
		IF isDesc THEN
			SET @sql = CONCAT(@sql, ' DESC');
		END IF;
	END IF;
    
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE filterVendaDinamico
(nNF VARCHAR(30), id_drog INT, pagamento VARCHAR(20), valor_total_min double, valor_total_max double, orderBy VARCHAR(20), isDesc BOOLEAN)
BEGIN
	SET @sql = CONCAT('SELECT * FROM venda WHERE total_nota BETWEEN ', valor_total_min, ' AND ', valor_total_max);
    
    IF nNF IS NOT NULL THEN
		SET @sql = CONCAT(@sql, ' AND nmr_nota_fiscal LIKE \'', nNF, '\'');
	END IF;
    
    IF id_drog IS NOT NULL THEN
		SET @sql = CONCAT(@sql, ' AND venda.id_drog = ', id_drog);
	END IF;
    
    IF pagamento IS NOT NULL THEN
		SET @sql = CONCAT(@sql, ' AND venda.forma_pagamento = \'', pagamento, '\'');
	END IF;
    
    IF orderBy IS NOT NULL THEN
		SET @sql = CONCAT(@sql, ' ORDER BY ', orderBy);
		IF isDesc THEN
			SET @sql = CONCAT(@sql, ' DESC');
		END IF;
	END IF;
    
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE filterLaboratorioDinamico
(pesquisa VARCHAR(30), tipo INT, estado VARCHAR(2), _status VARCHAR(15), orderBy VARCHAR(20), isDesc BOOLEAN)
BEGIN
	SET @sql = CONCAT('SELECT * FROM laboratorio WHERE ');
    
    IF tipo = 0 THEN
		SET @sql = CONCAT(@sql, 'nome LIKE \'', pesquisa, '\'');
        ELSEIF tipo = 1 THEN
			SET @sql = CONCAT(@sql, 'cnpj LIKE \'', pesquisa, '\'');
		ELSE
			SET @sql = CONCAT(@sql, 'ie LIKE \'', pesquisa, '\'');
	END IF;
    
    IF estado IS NOT NULL THEN
		SET @sql = CONCAT(@sql, ' AND uf = \'', estado, '\'');
	END IF;
    
    IF _status IS NOT NULL THEN
		SET @sql = CONCAT(@sql, ' AND _status = \'', _status, '\'');
    END IF;
    
    IF orderBy IS NOT NULL THEN
		SET @sql = CONCAT(@sql, ' ORDER BY ', orderBy);
		IF isDesc THEN
			SET @sql = CONCAT(@sql, ' DESC');
		END IF;
	END IF;
    
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE filterDrogariaDinamico
(pesquisa VARCHAR(30), tipo INT, estado VARCHAR(2), _status VARCHAR(15), orderBy VARCHAR(20), isDesc BOOLEAN)
BEGIN
	SET @sql = CONCAT('SELECT * FROM drogaria WHERE ');
    
    IF tipo = 0 THEN
		SET @sql = CONCAT(@sql, 'nome LIKE \'', pesquisa, '\'');
        ELSE
			SET @sql = CONCAT(@sql, 'cnpj LIKE \'', pesquisa, '\'');
	END IF;
    
    IF estado IS NOT NULL THEN
		SET @sql = CONCAT(@sql, ' AND uf = \'', estado, '\'');
	END IF;
    
    IF _status IS NOT NULL THEN
		SET @sql = CONCAT(@sql, ' AND _status = \'', _status, '\'');
    END IF;
    
    IF orderBy IS NOT NULL THEN
		SET @sql = CONCAT(@sql, ' ORDER BY ', orderBy);
		IF isDesc THEN
			SET @sql = CONCAT(@sql, ' DESC');
		END IF;
	END IF;
    
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER add_compra_remedio
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
CREATE TRIGGER add_venda_remedio
AFTER INSERT
ON item_venda
FOR EACH ROW
BEGIN
	UPDATE remedio
    SET qntd_armazenada = qntd_armazenada - NEW.quantidade
    WHERE remedio.id_remedio = NEW.id_remedio;
END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER delete_compra_remedio
AFTER DELETE
ON item_compra
FOR EACH ROW
BEGIN
	UPDATE remedio
    SET remedio.qntd_armazenada = remedio.qntd_armazenada - OLD.quantidade
    WHERE remedio.id_remedio = OLD.id_remedio;
END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER delete_venda_remedio
AFTER DELETE
ON item_venda
FOR EACH ROW
BEGIN
	UPDATE remedio
    SET remedio.qntd_armazenada = remedio.qntd_armazenada + OLD.quantidade
    WHERE remedio.id_remedio = OLD.id_remedio;
END $$
DELIMITER ;

CREATE VIEW remedios AS
SELECT remedio.* FROM remedio
INNER JOIN laboratorio ON remedio.id_lab = laboratorio.id_lab
WHERE laboratorio._status = "Ativado";