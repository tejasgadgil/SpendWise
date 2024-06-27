package com.example.spendwise.controller;

import com.example.spendwise.model.Budget;
import com.example.spendwise.model.Customer;
import com.example.spendwise.model.Transaction;
import com.example.spendwise.model.TransactionRequest;
import com.example.spendwise.controller.DummyData;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TransactionController {

    // For later usage
    private long transactionIdCounter = 1;


    //Dummy Customers
    Customer cust1 = new Customer(1,"ABC");
    Customer cust2 = new Customer(2,"ABCD");

    Budget cust1_budget1 = new Budget(1,"Apples",cust1,1000,500);
    Budget cust2_budget1 = new Budget(3,"Apples",cust2,1000,500);

    // Dummy Transactions
    Transaction cust1_trans1 = new Transaction(123, "Rent", 10000,cust1_budget1,cust1);
    Transaction cust1_trans2 = new Transaction(456, "Restaurant", 1500,cust1_budget1,cust1);
    Transaction cust2_trans1 = new Transaction(789, "Rent", 20000,cust2_budget1,cust2);


    // Create a transaction list for customers 1 and 2 each
    List<Transaction> customer1Transactions = new ArrayList<>(List.of(cust1_trans1, cust1_trans2));
    List<Transaction> customer2Transactions = new ArrayList<>(List.of(cust2_trans1));

    // Add the list to the repo
    private Map<Long, List<Transaction>> transactionsRepo = new HashMap<>();

    public TransactionController(){
        transactionsRepo.put(1L, customer1Transactions);
        transactionsRepo.put(2L, customer2Transactions);
    }

    @PostMapping("/addTransactions")
    public TransactionRequest addTransaction(@RequestBody TransactionRequest request) {
        transactionsRepo.computeIfAbsent(request.getCustomerId(), k -> new ArrayList<>()).add(request.getTransaction());
        return request;
    }

    @GetMapping("/transactions/{customerId}")
    public List<Transaction> getTransactions(@PathVariable long customerId) {
        return transactionsRepo.getOrDefault(customerId, new ArrayList<>());
    }
}
