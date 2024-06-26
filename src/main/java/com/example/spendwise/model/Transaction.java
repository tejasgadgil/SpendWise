package com.example.spendwise.model;

public class Transaction {
    private long transId;
    private String transName;
    private long transBudgetCategoryId;

    public Transaction(){
    }

    public Transaction(long transId, String transName, long transBudgetCategoryId) {
        this.transId = transId;
        this.transName = transName;
        this.transBudgetCategoryId = transBudgetCategoryId;
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

    public long getTransBudgetCategoryId() {
        return transBudgetCategoryId;
    }

    public void setTransBudgetCategoryId(long transBudgetCategoryId) {
        this.transBudgetCategoryId = transBudgetCategoryId;
    }

}
