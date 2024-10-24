-- Inserir contas de teste
INSERT INTO account (account_holder, balance) VALUES ('Carlos Silva', 1500.00);
INSERT INTO account (account_holder, balance) VALUES ('Maria Souza', 800.00);
INSERT INTO account (account_holder, balance) VALUES ('João Pereira', 1200.00);

-- Simular algumas transações
CALL process_transaction(1, 'CREDIT', 500.00);  -- Carlos Silva recebe um crédito de 500 (depósito ou pagamento)
CALL process_transaction(1, 'DEBIT', 200.00);   -- Carlos Silva faz um débito de 200 (saque ou pagamento de conta)
CALL process_transaction(2, 'DEBIT', 300.00);   -- Maria Souza faz um débito de 300 (compra ou pagamento de conta)
CALL process_transaction(2, 'CREDIT', 150.00);  -- Maria Souza recebe um crédito de 150 (reembolso ou transferência)
CALL process_transaction(3, 'CREDIT', 600.00);  -- João Pereira recebe um crédito de 600 (salário ou transferência)
CALL process_transaction(3, 'DEBIT', 100.00);   -- João Pereira faz um débito de 100 (pagamento de serviços)