package br.tmdev.poc.jdbcclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;
import br.tmdev.poc.jdbcclient.model.Transaction;

import java.util.List;

@Service
public class TransactionService {

    private final JdbcTemplate jdbcTemplate;
    private final JdbcClient jdbcClient;

    @Autowired
    public TransactionService(JdbcTemplate jdbcTemplate, JdbcClient jdbcClient) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcClient = jdbcClient;
    }

    public List<Transaction> getAllTransactions() {
        String sql = "SELECT * FROM transaction";
        return jdbcClient.sql(sql)
                .query(Transaction.class)
                .list();
    }

    public void processTransaction(Transaction transaction) {
        String sql = "CALL process_transaction(?, ?, ?)";
        jdbcTemplate.update(sql, transaction.accountId(), transaction.transactionType(), transaction.amount());
    }
}