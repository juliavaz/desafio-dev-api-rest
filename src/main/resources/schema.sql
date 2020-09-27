CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS tb_conta (
  id_conta bigint NOT NULL,
  data_criacao timestamp NOT NULL,
  flag_ativo boolean NOT NULL,
  limite_saque_diario decimal(19, 2) NOT NULL,
  saldo decimal(19, 2) NOT NULL,
  tipo_conta bigint NOT NULL,
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
  data_transacao timestamp NOT NULL,
  valor decimal(19, 2) NOT NULL,
  id_conta bigint NOT NULL,
  PRIMARY KEY (id_transacao),
  FOREIGN KEY (id_conta) REFERENCES tb_conta
);
