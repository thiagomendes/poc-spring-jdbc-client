package br.tmdev.poc.jdbcclient.model;

public record Account(
    int accountId,
    String accountHolder,
    double balance,
    java.sql.Timestamp createdAt
) {
}
