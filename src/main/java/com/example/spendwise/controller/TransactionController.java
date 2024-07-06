//package com.example.spendwise.controller;
//
//import com.example.spendwise.model.Budget;
//import com.example.spendwise.model.Customer;
//import com.example.spendwise.model.Transaction;
////import com.example.spendwise.controller.DummyData;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api")
//public class TransactionController {
//
//    // For later usage
//    private long transactionIdCounter = 1;
//
//
//    //Dummy Customers
//    public static Customer cust1 = new Customer(1,"Jane Doe");
//    public static Customer cust2 = new Customer(2,"John Doe");
//
//    //Dummy Budgets
//    public static Budget cust1_budget1 = new Budget(11,"Groceries",1,3000);
//    public static Budget cust1_budget2 = new Budget(12,"Misc",1,1000);
//    public static Budget cust2_budget1 = new Budget(13,"Travel",2,5000);
//
//    // Dummy Transactions
//    public static Transaction cust1_trans1 = new Transaction(100, "Apples", 250, 11, 1);
//    public static Transaction cust1_trans2 = new Transaction(101, "Laundry", 300,12, 1);
//    public static Transaction cust2_trans1 = new Transaction(102, "Petrol", 1000,13, 2);
//
//
//    // Create a transaction list for customers 1 and 2 each
//    List<Transaction> customer1Transactions = new ArrayList<>(List.of(cust1_trans1, cust1_trans2));
//    List<Transaction> customer2Transactions = new ArrayList<>(List.of(cust2_trans1));
//
//    // Add the list to the repo
//    private Map<Long, List<Transaction>> transactionsRepo = new HashMap<>();
//
//    public TransactionController(){
//        transactionsRepo.put(1L, customer1Transactions);
//        transactionsRepo.put(2L, customer2Transactions);
//    }
//
//    @PostMapping("/addTransactions")
//    public Transaction addTransaction(@RequestBody Transaction transaction) {
//        transactionsRepo.computeIfAbsent(transaction.getTransactionCustomer().getCustomerId(), k -> new ArrayList<>()).add(transaction);
//        return transaction;
//    }
//
//    @GetMapping("/{customerId}/transactions")
//    public List<Transaction> getTransactions(@PathVariable long customerId) {
//        return transactionsRepo.getOrDefault(customerId, new ArrayList<>());
//    }
//}
