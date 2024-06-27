package com.example.spendwise.controller;

import com.example.spendwise.model.Budget;
import com.example.spendwise.model.Customer;
import com.example.spendwise.model.Transaction;

public class DummyData {
    //Dummy Customers
    public static Customer cust1 = new Customer(1,"ABC");
    static Customer cust2 = new Customer(2,"ABCD");

    //Dummy Budgets
    Budget cust1_budget1 = new Budget(1,"Apples",cust1,1000,500);
    Budget cust1_budget2 = new Budget(1,"Oranges",cust1,1000,500);
    Budget cust2_budget1 = new Budget(3,"Apples",cust2,1000,500);

    // Dummy Transactions
    Transaction cust1_trans1 = new Transaction(123, "Rent", 10000,cust1_budget1,cust1);
    Transaction cust1_trans2 = new Transaction(456, "Restaurant", 1500,cust1_budget1,cust1);
    Transaction cust2_trans1 = new Transaction(789, "Rent", 20000,cust2_budget1,cust2);


}
