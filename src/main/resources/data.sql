CREATE TABLE receita (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    modo_preparo TEXT,
    tempo_preparo_minutos INT NOT NULL,
    porcoes INT NULL
);

CREATE TABLE ingredientes (
    receita_id INT NOT NULL,
    ingrediente VARCHAR(255) NOT NULL,
    CONSTRAINT fk_receita_ingrediente FOREIGN KEY (receita_id) REFERENCES receita(id) ON DELETE CASCADE
);

INSERT INTO receita (id, nome, descricao, modo_preparo, tempo_preparo_minutos, porcoes) VALUES (
    1,
    'Bolo de Cenoura',
    'Um bolo fofinho com cobertura de chocolate, perfeito para o café da tarde.',
    '1. Bata as cenouras, ovos e óleo no liquidificador. 2. Adicione o açúcar e a farinha e misture bem. 3. Por último, adicione o fermento e leve ao forno pré-aquecido a 180°C por cerca de 40 minutos.',
    60,
    NULL
);

INSERT INTO ingredientes (receita_id, ingrediente) VALUES (1, '3 cenouras médias');
INSERT INTO ingredientes (receita_id, ingrediente) VALUES (1, '4 ovos');
INSERT INTO ingredientes (receita_id, ingrediente) VALUES (1, '1 xícara de óleo');
INSERT INTO ingredientes (receita_id, ingrediente) VALUES (1, '2 xícaras de açúcar');
INSERT INTO ingredientes (receita_id, ingrediente) VALUES (1, '2 e 1/2 xícaras de farinha de trigo');
INSERT INTO ingredientes (receita_id, ingrediente) VALUES (1, '1 colher de sopa de fermento em pó');
