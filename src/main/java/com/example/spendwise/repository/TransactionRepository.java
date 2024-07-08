package com.example.spendwise.repository;

import com.example.spendwise.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByTransactionCustomerCustomerId(long customerId);
    Optional<Transaction> findByTransactionCustomerCustomerIdAndTransId(long customerId, long transId);

    // New methods for operations based on budgetId

    List<Transaction> findByTransactionCustomerCustomerIdAndTransactionBudgetBudgetId(long customerId, long budgetId);
    Optional<Transaction> findByTransactionCustomerCustomerIdAndTransactionBudgetBudgetIdAndTransId(long customerId, long budgetId, long transId);
}
