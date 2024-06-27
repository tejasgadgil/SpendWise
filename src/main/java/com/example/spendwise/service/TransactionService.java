package com.example.spendwise.service;

import com.example.spendwise.model.Budget;
import com.example.spendwise.model.Transaction;
import com.example.spendwise.repository.BudgetRepository;
import com.example.spendwise.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private BudgetRepository budgetRepository;

    public Transaction addTransaction(Transaction transaction){
        long budgetId = transaction.getTransBudgetCategoryId();
        Budget budget = budgetRepository.findById(budgetId).orElseThrow(() ->  new RuntimeException("Budget category doesnt exist"));
        budget.getTransactionList().add(transaction);
        budget.setBudgetSpent(budget.getBudgetSpent() + transaction.getTransAmt());
        budgetRepository.save(budget);
        transactionRepository.save(transaction);
        return transaction;
    }
}
