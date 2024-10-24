package br.tmdev.poc.jdbcclient.model;

public record Transaction(
    int transactionId,
    int accountId,
    String transactionType,
    double amount,
    java.sql.Timestamp transactionDate
) {}
