CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS tb_conta (
  id_conta bigint NOT NULL,
  data_criacao timestamp,
  flag_ativo boolean,
  limite_saque_diario decimal(19, 2),
  saldo decimal(19, 2),
  tipo_conta bigint,
  id_pessoa bigint,
  PRIMARY KEY (id_conta),
  FOREIGN KEY (id_pessoa) REFERENCES tb_pessoa
);

CREATE TABLE IF NOT EXISTS tb_pessoa (
  id_pessoa bigint NOT NULL,
  cpf varchar(255) NOT NULL,
  data_nascimento timestamp,
  nome varchar(255) NOT NULL,
  PRIMARY KEY (id_pessoa)
);

CREATE TABLE IF NOT EXISTS tb_transacao (
  id_transacao bigint NOT NULL,
  data_transacao timestamp,
  valor decimal(19, 2),
  id_conta bigint,
  PRIMARY KEY (id_transacao),
  FOREIGN KEY (id_conta) REFERENCES tb_conta
);

/*
ALTER TABLE tb_conta ADD CONSTRAINT FKa4gjm7t3oaybmfyolyfe3o4c2 FOREIGN KEY (id_pessoa) REFERENCES tb_pessoa;
ALTER TABLE tb_transacao ADD CONSTRAINT FKkb9a8m8xrrk7o3hscjw2iyrst FOREIGN KEY (id_conta) REFERENCES tb_conta;
*/