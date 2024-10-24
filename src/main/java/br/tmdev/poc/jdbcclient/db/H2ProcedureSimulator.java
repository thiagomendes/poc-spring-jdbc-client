package br.tmdev.poc.jdbcclient.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class H2ProcedureSimulator {

    // Implementação da procedure process_transaction
    public static void processTransaction(Connection conn, int accountId, String transactionType, double amount) throws SQLException {
        // Buscar o saldo atual da conta
        ResultSet rs = conn.createStatement().executeQuery("SELECT balance FROM account WHERE account_id = " + accountId);
        if (!rs.next()) {
            throw new SQLException("Account not found");
        }
        double currentBalance = rs.getDouble("balance");

        // Atualizar o saldo com base no tipo de transação
        if ("CREDIT".equals(transactionType)) {
            currentBalance += amount;
        } else if ("DEBIT".equals(transactionType)) {
            if (currentBalance < amount) {
                throw new SQLException("Insufficient balance");
            }
            currentBalance -= amount;
        } else {
            throw new SQLException("Invalid transaction type");
        }

        // Atualizar saldo da conta
        conn.createStatement().execute("UPDATE account SET balance = " + currentBalance + " WHERE account_id = " + accountId);

        // Registrar a transação
        conn.createStatement().execute("INSERT INTO transaction (account_id, transaction_type, amount) VALUES (" +
                accountId + ", '" + transactionType + "', " + amount + ")");
    }
}
