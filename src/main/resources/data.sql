DELETE FROM tb_transacao;
DELETE FROM tb_conta;
DELETE FROM tb_pessoa;

INSERT INTO tb_pessoa (id_pessoa, cpf, nome)
    VALUES
        (1, '000.000.000-00', 'Júlia Vaz'),
        (2, '111.111.111-11', 'Odilon Alves');

INSERT INTO tb_conta (id_conta, id_pessoa, data_criacao, flag_ativo, limite_saque_diario, saldo, tipo_conta)
    VALUES
        (1, 1, '2020-09-26 23:00:00', true, '5000.00', '3500.00', 1),
        (2, 2, '2020-10-25 19:00:00', true, '5000.00', '10500.00', 2);

INSERT INTO tb_transacao (id_transacao, data_transacao, valor, id_conta)
    VALUES (1, '2020-09-27 12:00:00', '2000.00', 1), (2, '2020-10-27 18:00:00', '-3000.00', 2);