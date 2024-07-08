package com.example.spendwise.controller;

import com.example.spendwise.model.Customer;
import com.example.spendwise.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customerList = customerService.getAllCustomers();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Optional<Customer>> getCustomer(@PathVariable long customerId) {
        Optional<Customer> customer = customerService.getCustomer(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    // Check if customer name exists before adding a new customer
    @PostMapping("/register")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Optional<Customer> existingCustomer = customerService.getCustomerByName(customer.getCustomerName());
        if (existingCustomer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT); // Conflict status if customer already exists
        } else {
            Customer customerToAdd = customerService.addCustomer(customer);
            return new ResponseEntity<>(customerToAdd, HttpStatus.CREATED); // Created status for new customer
        }
    }

    // Check if customer name exists and return customer details
    @PostMapping("/login")
    public ResponseEntity<Optional<Customer>> loginCustomer(@RequestBody Customer customer) {
        Optional<Customer> existingCustomer = customerService.getCustomerByName(customer.getCustomerName());
        if (existingCustomer.isPresent()) {
            return new ResponseEntity<>(existingCustomer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Not found status if customer doesn't exist
        }
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable long customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
