package com.example.spendwise.controller;

import com.example.spendwise.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CustomerController {

    Customer cust1=new Customer(1,"ABC");
    Customer cust2=new Customer(2,"ABCD");

    private Map<Long, Customer> customerRepo = new HashMap<>();

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

    @GetMapping("/userTest")
    public String hey(@RequestParam(value = "name", defaultValue = "XYZ") String name) {
        return String.format("Hey %s!", name);
    }
}