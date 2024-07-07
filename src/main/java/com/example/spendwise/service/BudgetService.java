package com.example.spendwise.service;

import com.example.spendwise.model.Budget;
import com.example.spendwise.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;


    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }


    public Budget addBudget(long customerId, Budget budget) {
        return budgetRepository.save(budget);
    }

    public void deleteBudget(long budgetId) {
        budgetRepository.deleteById(budgetId);
    }

    public Optional<Budget> getBudget(long budgetId) {
        return budgetRepository.findById(budgetId);
    }

    public Optional<List<Budget>> getBudgetsByCustomerId(Long customerId) {
        return budgetRepository.findByBudgetOwnerCustomerId(customerId);
    }

    public Budget updateBudget(long budgetId, Budget updatedBudget){
        Optional<Budget> oldBudget = budgetRepository.findById(budgetId);
        if(oldBudget.isPresent()){
            Budget existingBudget=oldBudget.get();
            existingBudget.setBudgetAllotted(updatedBudget.getBudgetAllotted());
            existingBudget.setBudgetName(updatedBudget.getBudgetName());
            updatedBudget=budgetRepository.saveAndFlush(existingBudget);
            return budgetRepository.findById(budgetId).get();
        }
        else {
            throw new RuntimeException("Budget not found with id " + budgetId);
        }
    }

}
