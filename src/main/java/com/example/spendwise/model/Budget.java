package com.example.spendwise.model;

import java.util.ArrayList;
import java.util.List;
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

//    @OneToMany(mappedBy = "transactionBudget", cascade = CascadeType.ALL)
//    private List<Transaction> transactionList = new ArrayList<>();

    public Budget() {}

    public Budget(String budgetName, Customer budgetOwner, long budgetAllotted) {
        this.budgetName = budgetName;
        this.budgetOwner = budgetOwner;
        this.budgetAllotted = budgetAllotted;
        this.budgetSpent = 0;
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

//    public List<Transaction> getTransactionList() {
//        return transactionList;
//    }
//
//    public void addTransaction(Transaction transaction) {
//        this.transactionList.add(transaction);
//        transaction.setTransactionBudget(this);
//    }
}
