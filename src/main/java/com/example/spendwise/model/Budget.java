package com.example.spendwise.model;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.ArrayList;

import jakarta.persistence.*;

@Entity
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long budgetId;
    private String budgetName;

    @ManyToOne
    @JoinColumn(name = "budgetOwnerCustomerId", referencedColumnName = "customerId")
    private Customer budgetOwner;

    private long budgetAllotted;
    private long budgetSpent;

    @OneToMany(mappedBy = "transactionBudget", cascade = CascadeType.ALL)
//    private List<Transaction> transactionList = new ArrayList<>();
    private ArrayList<Transaction> transactionList;

    //public Budget() {}

    public Budget(long budgetId, String budgetName, Customer budgetOwner, long budgetAllotted, long budgetSpent) {
        this.budgetId = budgetId;
        this.budgetName = budgetName;
        this.budgetOwner = budgetOwner;
        this.budgetAllotted = budgetAllotted;
        this.budgetSpent = budgetSpent;
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

    public Customer getBudgetOwner() {
        return budgetOwner;
    }

    public void setBudgetOwner(Customer budgetOwner) {
        this.budgetOwner = budgetOwner;
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
