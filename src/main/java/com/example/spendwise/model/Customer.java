package com.example.spendwise.model;

import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Map;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;
    private String customerName;
    private ArrayList<Budget> budgetList;


    public Customer() {
    }

    public Customer(long customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
//        this.budgetMap = budgetMap;
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

    public ArrayList<Budget> getBudgetList() {
        return budgetList;
    }

    public void setBudgetList(ArrayList<Budget> budgetList) {
        this.budgetList = budgetList;
    }
}


