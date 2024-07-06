package com.example.spendwise.model;

import jakarta.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transId;
    private String transName;
    private long transAmt;

    @ManyToOne
    @JoinColumn(name = "transactionBudgetId", referencedColumnName = "budgetId")
    private Budget transactionBudget;

    @ManyToOne
    @JoinColumn(name = "transactionCustomerId", referencedColumnName = "customerId")
    private Customer transactionCustomer;

    public Transaction() {}

    public Transaction(String transName, long transAmt, Budget transactionBudget, Customer transactionCustomer) {
        this.transName = transName;
        this.transAmt = transAmt;
        this.transactionBudget = transactionBudget;
        this.transactionCustomer = transactionCustomer;
    }

    public long getTransId() {
        return transId;
    }

    public void setTransId(long transId) {
        this.transId = transId;
    }

    public String getTransName() {
        return transName;
    }

    public void setTransName(String transName) {
        this.transName = transName;
    }

    public long getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(long transAmt) {
        this.transAmt = transAmt;
    }

    public Budget getTransactionBudget() {
        return transactionBudget;
    }

    public void setTransactionBudget(Budget transactionBudget) {
        this.transactionBudget = transactionBudget;
    }

    public Customer getTransactionCustomer() {
        return transactionCustomer;
    }

    public void setTransactionCustomer(Customer transactionCustomer) {
        this.transactionCustomer = transactionCustomer;
    }
}
