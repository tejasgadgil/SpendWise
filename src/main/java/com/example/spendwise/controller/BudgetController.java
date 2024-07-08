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
@RequestMapping("/api/{customerId}/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @GetMapping
    public ResponseEntity<Optional<List<Budget>>> getBudgetList(@PathVariable long customerId) {
        Optional<List<Budget>> budgetList = budgetService.getBudgetsByCustomerId(customerId);
        return new ResponseEntity<>(budgetList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Budget> addBudget(@PathVariable long customerId, @RequestBody Budget budget) {
        Budget budgetToAdd = budgetService.addBudget(customerId, budget);
        return new ResponseEntity<>(budgetToAdd, HttpStatus.CREATED);
    }

    @PutMapping("/{budgetId}")
    public ResponseEntity<Budget> updateBudget(@PathVariable long customerId, @PathVariable long budgetId, @RequestBody Budget budget) {
        Budget updatedBudget = budgetService.updateBudget(customerId, budgetId, budget);
        return new ResponseEntity<>(updatedBudget, HttpStatus.OK);
    }
}


//package com.example.spendwise.controller;
//
//import com.example.spendwise.model.Customer;
//import com.example.spendwise.model.Budget;
//import com.example.spendwise.service.CustomerService;
//import com.example.spendwise.service.BudgetService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/{customerId}/budgets")
//public class BudgetController {
//
//    @Autowired
//    private BudgetService budgetService;
//
//    @GetMapping
//    public ResponseEntity<Optional<List<Budget>>> getBudgetList(@PathVariable long customerId){
//        Optional<List<Budget>> budgetList = budgetService.getBudgetsByCustomerId(customerId);
//        return new ResponseEntity<>(budgetList, HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<Budget> addBudget(@PathVariable long customerId, @RequestBody Budget budget){
//        Budget budgetToAdd = budgetService.addBudget(customerId, budget);
//        return new ResponseEntity<>(budgetToAdd, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{budgetId}")
//    public ResponseEntity<Budget> updateBudget(@PathVariable long customerId, @PathVariable long budgetId, @RequestBody Budget budget){
//        Budget updatedBudget = budgetService.updateBudget(customerId,budgetId,budget);
//        return new ResponseEntity<>(updatedBudget,HttpStatus.OK);
//    }
//
//}
