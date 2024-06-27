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
        long budgetId = transaction.getTransactionBudget().getBudgetId();
        Budget budget = budgetRepository.findById(budgetId).orElseThrow(() -> new RuntimeException("Budget category doesn't exist"));
        budget.getTransactionList().add(transaction);
        budget.setBudgetSpent(budget.getBudgetSpent() + transaction.getTransAmt());
        budgetRepository.save(budget);
        return transactionRepository.save(transaction);
    }
}
