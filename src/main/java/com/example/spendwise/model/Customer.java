package com.example.spendwise.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;
    private String customerName;

//    @OneToMany(mappedBy = "budgetOwner", cascade = CascadeType.ALL)
//    private List<Budget> budgetList = new ArrayList<>();

    public Customer() {}

    public Customer(String customerName) {
        this.customerName = customerName;
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

//    public List<Budget> getBudgetList() {
//        return budgetList;
//    }
//
//    public void addBudget(Budget budget) {
//        this.budgetList.add(budget);
//        budget.setBudgetOwner(this);
//    }
}
