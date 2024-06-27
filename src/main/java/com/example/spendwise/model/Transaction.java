package com.example.spendwise.model;

import jakarta.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transId;
    private String transName;
    private long transAmt;

    public long getTransactionBudgetId() {
        return transactionBudgetId;
    }

    public void setTransactionBudgetId(long transactionBudgetId) {
        this.transactionBudgetId = transactionBudgetId;
    }

    public long getTransactionCustomerId() {
        return transactionCustomerId;
    }

    public void setTransactionCustomerId(long transactionCustomerId) {
        this.transactionCustomerId = transactionCustomerId;
    }

    @ManyToOne
//    @JoinColumn(name = "transBudgetCategoryId", referencedColumnName = "budgetId")
//    private Budget transactionBudget;
    private long transactionBudgetId;

    @ManyToOne
//    @JoinColumn(name = "transCustomerId", referencedColumnName = "customerId")
//    private Customer transactionCustomer;
    private long transactionCustomerId;

    public Transaction() {}

    public Transaction(long transId, String transName, long transAmt, long transactionBudgetId, long transactionCustomerId) {
        this.transId = transId;
        this.transName = transName;
        this.transAmt = transAmt;
        this.transactionBudgetId = transactionBudgetId;
        this.transactionCustomerId = transactionCustomerId;
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

//    public Budget getTransactionBudget() {
//        return transactionBudget;
//    }
//
//    public void setTransactionBudget(Budget transactionBudget) {
//        this.transactionBudget = transactionBudget;
//    }
//
//    public Customer getTransactionCustomer() {
//        return transactionCustomer;
//    }
//
//    public void setTransactionCustomer(Customer transactionCustomer) {
//        this.transactionCustomer = transactionCustomer;
//    }
}
