package com.example.spendwise.repository;
import java.util.List;
import java.util.Optional;

//public interface BudgetRepository {
//}

import com.example.spendwise.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
    Optional<List<Budget>> findByBudgetOwnerCustomerId(Long budgetOwnerCustomerId);

}
