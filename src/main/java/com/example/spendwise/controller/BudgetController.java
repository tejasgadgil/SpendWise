package com.example.spendwise.controller;

import com.example.spendwise.model.Customer;
import com.example.spendwise.model.Budget;
import com.example.spendwise.service.CustomerService;
import com.example.spendwise.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;


//    @GetMapping
//    public ResponseEntity<List<Budget>> getAllBudgets(){
//        List<Budget> budgetList = budgetService.getAllBudgets();
//        return new ResponseEntity<>(budgetList, HttpStatus.OK);
//    }

//    @GetMapping("/{budgetId}")
//    public ResponseEntity<Optional<Budget>> getBudget(@PathVariable long budgetId){
//        Optional<Budget> budget = budgetService.getBudget(budgetId);
//        return new ResponseEntity<>(budget, HttpStatus.OK);
//    }

//    @PostMapping
//    public ResponseEntity<Budget> addBudget(@RequestBody Budget budget){
//        Budget budgetToAdd = budgetService.addBudget(budget);
//        return new ResponseEntity<>(budgetToAdd, HttpStatus.OK);
//    }

//    @DeleteMapping("/{budgetId}")
//    public ResponseEntity<Void> deleteBudget(@PathVariable long budgetId){
//        budgetService.deleteBudget(budgetId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

    @GetMapping("/listBudget/{customerId}")
    public ResponseEntity<Optional<List<Budget>>> getBudgetList(@PathVariable long customerId){
        Optional<List<Budget>> budgetList = budgetService.getBudgetsByCustomerId(customerId);
        return new ResponseEntity<>(budgetList, HttpStatus.OK);
    }

    @PostMapping("/addBudget")
    public ResponseEntity<Budget> addBudget(@RequestBody Budget budget){
        Budget budgetToAdd = budgetService.addBudget(budget);
        return new ResponseEntity<>(budgetToAdd, HttpStatus.OK);
    }

}
