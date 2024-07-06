package com.example.spendwise.service;

import com.example.spendwise.model.Customer;
import com.example.spendwise.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }


    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(long customerId) {
        customerRepository.deleteById(customerId);
    }

    public Optional<Customer> getCustomer(long customerId) {
        return customerRepository.findById(customerId);
    }
}
