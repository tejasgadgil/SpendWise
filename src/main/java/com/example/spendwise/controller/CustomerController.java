package com.example.spendwise.controller;

//import com.example.spendwise.model.Budget;
import com.example.spendwise.model.Customer;
//import com.example.spendwise.model.Transaction;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CustomerController {

    //Dummy Customers
    public static Customer cust1 = new Customer(1,"Jane Doe");
    public static Customer cust2 = new Customer(2,"John Doe");

//    //Dummy Budgets
//    public static Budget cust1_budget1 = new Budget(11,"Groceries",1,3000);
//    public static Budget cust1_budget2 = new Budget(12,"Misc",1,1000);
//    public static Budget cust2_budget1 = new Budget(13,"Travel",2,5000);
//
//    // Dummy Transactions
//    public static Transaction cust1_trans1 = new Transaction(100, "Apples", 250, 11, 1);
//    public static Transaction cust1_trans2 = new Transaction(101, "Laundry", 300,12, 1);
//    public static Transaction cust2_trans1 = new Transaction(102, "Petrol", 1000,13, 2);

    private Map<Long, Customer> customerRepo = new HashMap<>(); //add to service

    public CustomerController(){
        customerRepo.put(1L,cust1);
        customerRepo.put(2L,cust2);
    };
    private long customerIdCounter = cust2.getCustomerId();

    @PostMapping("/register")
    public String registerUser(@RequestBody Customer customer) {

        if(customerRepo.containsKey(customer.getCustomerId())){
            return "User already exists...";
        }

        customer.setCustomerId(customerIdCounter+1);
        customerRepo.put(customer.getCustomerId(), customer);
        return "User registered successfully :)";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody Customer customer) {
        // LOGIC HERE
        if(customerRepo.containsKey(customer.getCustomerId())){
            return "User logged in successfully :)";
        }
        return "User does not exist :(";

    }

    @GetMapping("/{id}/user")
    public Customer getUser(@PathVariable long id) {
        return customerRepo.get(id);
    }

//    @GetMapping("/userTest")
//    public String hey(@RequestParam(value = "name", defaultValue = "XYZ") String name) {
//        return String.format("Hey %s!", name);
//    }
}