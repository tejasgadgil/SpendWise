package com.example.spendwise.model;

import java.util.Map;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long budgetId;
    private String budgetName;
    private long budgetOwnerCustomerId;
    private long budgetAllotted;
    private long budgetSpent;
    private ArrayList<Transaction> transactionList;


    public Budget(){

    }

    public Budget(long budgetId, String budgetName,long budgetOwnerCustomerId, long budgetAllotted, long budgetSpent) {
        this.budgetId = budgetId;
        this.budgetName = budgetName;
        this.budgetOwnerCustomerId = budgetOwnerCustomerId;
        this.budgetAllotted = budgetAllotted;
        this.budgetSpent = budgetSpent;
//        this.transactionMap = transactionMap;
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

    public long getBudgetOwnerCustomerId() {
        return budgetOwnerCustomerId;
    }

    public void setBudgetOwnerCustomerId(long budgetOwnerCustomerId) {
        this.budgetOwnerCustomerId = budgetOwnerCustomerId;
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

    public ArrayList<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(ArrayList<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
