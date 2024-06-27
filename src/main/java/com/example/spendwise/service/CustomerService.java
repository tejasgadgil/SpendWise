package com.example.spendwise.service;

import com.example.spendwise.model.Budget;
import com.example.spendwise.model.Customer;
import com.example.spendwise.model.Transaction;
import com.example.spendwise.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void setBudget(long customerId, Budget budget) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            customer.getBudgetList().add(budget);
            customerRepository.save(customer);
        } else {
            throw new RuntimeException("Customer not found");
        }
    }
    public void addTransaction(long customerId, Transaction transaction) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            for (Budget budget : customer.getBudgetList()) {
                if (budget.getBudgetId() == transaction.getTransBudgetCategoryId()) {
                    budget.getTransactionList().add(transaction);
                    budget.setBudgetSpent(budget.getBudgetSpent() + transaction.getTransAmt());
                    break;
                }
            }
            customerRepository.save(customer);
        } else {
            throw new RuntimeException("Customer not found");
        }
    }

    public Optional<Customer> getCustomerById(long customerId) {
        return customerRepository.findById(customerId);
    }
}
