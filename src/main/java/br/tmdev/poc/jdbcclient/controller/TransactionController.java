package br.tmdev.poc.jdbcclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.tmdev.poc.jdbcclient.model.Transaction;
import br.tmdev.poc.jdbcclient.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping
    public String createTransaction(@RequestBody Transaction transactionRequest) {
        transactionService.processTransaction(transactionRequest);
        return "Transação executada com sucesso!";
    }
}
