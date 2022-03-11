CREATE TABLE clientela(
    id serial,
    nome VARCHAR(150),
    cpf VARCHAR(11),
    CONSTRAINT clientela_pk PRIMARY KEY (id)
);

CREATE TABLE produtos(
    id serial,
    descricao VARCHAR(255),
    valor BIGINT,
    CONSTRAINT produtos_pk PRIMARY KEY (id)
);

CREATE TABLE vendas(
    id serial,
    data_venda DATE,
    CONSTRAINT vendas_pk PRIMARY KEY (id)
);

CREATE TABLE item_venda(
    id serial,
    produto int,
    venda int,
    valor_venda BIGINT,
    quantidade int,
    CONSTRAINT item_venda_pk PRIMARY KEY (id),
    CONSTRAINT item_produto_fk FOREIGN KEY (produto)
    REFERENCES produtos(id),
    CONSTRAINT item_venda_fk FOREIGN KEY (venda)
    REFERENCES vendas(id)
);