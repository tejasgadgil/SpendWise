package com.example.spendwise.model;

import java.util.Map;

public class Budget {
    private long budgetId;
    private String budgetName;
    private long budgetAllotted;
    private long budgetSpent;
    private Map<Long, Transaction> transactionMap;

    public Budget(){

    }

    public Budget(long budgetId, String budgetName, long budgetAllotted, long budgetSpent, Map<Long, Transaction> transactionMap) {
        this.budgetId = budgetId;
        this.budgetName = budgetName;
        this.budgetAllotted = budgetAllotted;
        this.budgetSpent = budgetSpent;
        this.transactionMap = transactionMap;
    }

    public long getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(long budgetId) {
        this.budgetId = budgetId;
    }

    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    public long getBudgetAllotted() {
        return budgetAllotted;
    }

    public void setBudgetAllotted(long budgetAllotted) {
        this.budgetAllotted = budgetAllotted;
    }

    public long getBudgetSpent() {
        return budgetSpent;
    }

    public void setBudgetSpent(long budgetSpent) {
        this.budgetSpent = budgetSpent;
    }

    public Map<Long, Transaction> getTransactionMap() {
        return transactionMap;
    }

    public void setTransactionMap(Map<Long, Transaction> transactionMap) {
        this.transactionMap = transactionMap;
    }

}
