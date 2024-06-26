package com.example.spendwise.model;

public class Transaction {
    private long transId;
    private String transName;
    private long transAmt;
    private long transBudgetCategoryId;

    public Transaction(){
    }

    public Transaction(long transId, String transName,long transAmt,long transBudgetCategoryId ) {
        this.transId = transId;
        this.transName = transName;
        this.transAmt = transAmt;
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

    public long getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(long transAmt) {
        this.transAmt = transAmt;
    }

    public long getTransBudgetCategoryId() {
        return transBudgetCategoryId;
    }

    public void setTransBudgetCategoryId(long transBudgetCategoryId) {
        this.transBudgetCategoryId = transBudgetCategoryId;
    }

}
