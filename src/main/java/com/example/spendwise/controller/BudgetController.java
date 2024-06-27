package com.example.spendwise.controller;

import com.example.spendwise.model.Budget;
import com.example.spendwise.model.Customer;
import com.example.spendwise.controller.DummyData;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BudgetController {



    private Map<Long, List<Budget>> budgetRepo = new HashMap<>();

    //Dummy Customers
    Customer cust1 = new Customer(1,"ABC");
    Customer cust2 = new Customer(2,"ABCD");

    Budget cust1_budget1 = new Budget(1,"Apples",cust1,1000,500);
    Budget cust1_budget2 = new Budget(1,"Oranges",cust1,1000,500);
    Budget cust2_budget1 = new Budget(3,"Apples",cust2,1000,500);


    List<Budget> customer1Budgets = new ArrayList<>(List.of(cust1_budget1, cust1_budget2));
    List<Budget> customer2Budgets = new ArrayList<>(List.of(cust2_budget1));

    public BudgetController(){
        budgetRepo.put(1L,customer1Budgets);
        budgetRepo.put(2L,customer2Budgets);
    }

    private long budgetIdCounter = 3;

    @PostMapping("/budget")
    public Budget setBudget(@RequestBody Budget budget) {
        budget.setBudgetId(budgetIdCounter++);
        budgetRepo.computeIfAbsent(budget.getBudgetOwner().getCustomerId(), k -> new ArrayList<>()).add(budget);
        return budget;
    }

    @GetMapping("/{customerId}/budget")
    public List<Budget> getBudgetStatus(@PathVariable long customerId) {
        return budgetRepo.getOrDefault(customerId, new ArrayList<>());
    }
}