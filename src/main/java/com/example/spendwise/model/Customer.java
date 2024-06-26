package com.example.spendwise.model;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private long customerId;
    private String customerName;
    private Map<Long, Budget> budgetMap;


    public Customer() {
    }

    public Customer(long customerId, String customerName, Map<Long, Budget> budgetMap) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.budgetMap = budgetMap;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Map<Long, Budget> getBudgetMap() {
        return budgetMap;
    }

    public void setBudgetMap(Map<Long, Budget> budgetMap) {
        this.budgetMap = budgetMap;
    }
}


