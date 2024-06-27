package com.example.spendwise.repository;

//public interface BudgetRepository {
//}

import com.example.spendwise.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
}
