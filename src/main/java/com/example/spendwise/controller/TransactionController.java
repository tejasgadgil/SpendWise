package com.example.spendwise.controller;

import com.example.spendwise.model.Transaction;
import com.example.spendwise.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/{customerId}/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions(@PathVariable long customerId) {
        List<Transaction> transactionList = transactionService.getAllTransactionsByCustomerId(customerId);
        return new ResponseEntity<>(transactionList, HttpStatus.OK);
    }

    @GetMapping("/{transId}")
    public ResponseEntity<Optional<Transaction>> getTransaction(@PathVariable long customerId, @PathVariable long transId) {
        Optional<Transaction> transaction = transactionService.getTransactionByCustomerId(customerId, transId);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Transaction> addTransaction(@PathVariable long customerId, @RequestBody Transaction transaction) {
        Transaction transactionToAdd = transactionService.addTransaction(customerId, transaction);
        return new ResponseEntity<>(transactionToAdd, HttpStatus.CREATED);
    }

    @PutMapping("/{transId}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable long customerId, @PathVariable long transId, @RequestBody Transaction transactionDetails) {
        Optional<Transaction> updatedTransaction = transactionService.updateTransaction(customerId, transId, transactionDetails);
        return updatedTransaction.map(transaction -> new ResponseEntity<>(transaction, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{transId}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable long customerId, @PathVariable long transId) {
        boolean isDeleted = transactionService.deleteTransaction(customerId, transId);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
