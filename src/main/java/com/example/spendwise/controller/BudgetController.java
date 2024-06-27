package com.example.spendwise.controller;

import com.example.spendwise.model.Budget;
import com.example.spendwise.model.Customer;
//import com.example.spendwise.controller.DummyData;
//import com.example.spendwise.model.Transaction;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BudgetController {



    private Map<Long, List<Budget>> budgetRepo = new HashMap<>();
//    DummyData d = new DummyData();
    //Dummy Customers
    public static Customer cust1 = new Customer(1,"Jane Doe");
    public static Customer cust2 = new Customer(2,"John Doe");

    //Dummy Budgets
    public static Budget cust1_budget1 = new Budget(11,"Groceries",1,3000);
    public static Budget cust1_budget2 = new Budget(12,"Misc",1,1000);
    public static Budget cust2_budget1 = new Budget(13,"Travel",2,5000);

//    // Dummy Transactions
//    public static Transaction cust1_trans1 = new Transaction(100, "Apples", 250, 11, 1);
//    public static Transaction cust1_trans2 = new Transaction(101, "Laundry", 300,12, 1);
//    public static Transaction cust2_trans1 = new Transaction(102, "Petrol", 1000,13, 2);

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