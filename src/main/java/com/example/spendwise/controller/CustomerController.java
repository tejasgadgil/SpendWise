package com.example.spendwise.controller;

import com.example.spendwise.model.Budget;
import com.example.spendwise.model.Customer;
import com.example.spendwise.model.Transaction;
import com.example.spendwise.service.CustomerService;
import com.example.spendwise.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


public class CustomerController {

}



//@RestController
//@RequestMapping("/api/customers")
//public class CustomerController {
//
//    @Autowired
//    private CustomerService customerService;
//
//    @Autowired
//    private TransactionService transactionService;
//
//    @PostMapping
//    public Customer addCustomer(@RequestBody Customer customer) {
//        return customerService.addCustomer(customer);
//    }
//
//    @GetMapping("/{customerId}")
//    public Optional<Customer> getCustomer(@PathVariable long customerId) {
//        return customerService.getCustomerById(customerId);
//    }
//
//    @PostMapping("/{customerId}/transactions")
//    public void addTransaction(@PathVariable long customerId, @RequestBody Transaction transaction) {
//        customerService.addTransaction(customerId, transaction);
//    }
//
//    @PostMapping("/{customerId}/budgets")
//    public void setBudget(@PathVariable long customerId, @RequestBody Budget budget) {
//        customerService.setBudget(customerId, budget);
//    }
//}
