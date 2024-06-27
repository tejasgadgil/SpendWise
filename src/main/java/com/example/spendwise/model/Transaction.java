package com.example.spendwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
