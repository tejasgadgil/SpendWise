package com.example.spendwise.service;

import com.example.spendwise.model.Transaction;
import com.example.spendwise.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactionsByCustomerIdAndBudgetId(long customerId, long budgetId) {
        return transactionRepository.findByTransactionCustomerCustomerIdAndTransactionBudgetBudgetId(customerId, budgetId);
    }

    public Optional<Transaction> getTransactionByCustomerIdAndBudgetId(long customerId, long budgetId, long transId) {
        return transactionRepository.findByTransactionCustomerCustomerIdAndTransactionBudgetBudgetIdAndTransId(customerId, budgetId, transId);
    }

    public Transaction addTransaction(long customerId, long budgetId, Transaction transaction) {
        // Set the customer and budget for the transaction
        // transaction.setTransactionCustomer(customer); // Assuming setter method exists
        // transaction.setTransactionBudget(budget); // Assuming setter method exists
        return transactionRepository.saveAndFlush(transaction);
    }

    public Optional<Transaction> updateTransaction(long customerId, long budgetId, long transId, Transaction transactionDetails) {
        Optional<Transaction> transactionOptional = transactionRepository.findByTransactionCustomerCustomerIdAndTransactionBudgetBudgetIdAndTransId(customerId, budgetId, transId);
        if (transactionOptional.isPresent()) {
            Transaction transaction = transactionOptional.get();
            transaction.setTransName(transactionDetails.getTransName());
            transaction.setTransAmt(transactionDetails.getTransAmt());
            // Update other fields as needed
            return Optional.of(transactionRepository.saveAndFlush(transaction));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteTransaction(long customerId, long budgetId, long transId) {
        Optional<Transaction> transactionOptional = transactionRepository.findByTransactionCustomerCustomerIdAndTransactionBudgetBudgetIdAndTransId(customerId, budgetId, transId);
        if (transactionOptional.isPresent()) {
            transactionRepository.delete(transactionOptional.get());
            return true;
        } else {
            return false;
        }
    }
}

//package com.example.spendwise.service;
//
//import com.example.spendwise.model.Transaction;
//import com.example.spendwise.repository.TransactionRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class TransactionService {
//
//    @Autowired
//    private TransactionRepository transactionRepository;
//
//    public List<Transaction> getAllTransactionsByCustomerId(long customerId) {
//        return transactionRepository.findByTransactionCustomerCustomerId(customerId);
//    }
//
//    public Optional<Transaction> getTransactionByCustomerId(long customerId, long transId) {
//        return transactionRepository.findByTransactionCustomerCustomerIdAndTransId(customerId, transId);
//    }
//
//    public Transaction addTransaction(long customerId, Transaction transaction) {
//        // Assuming transactionCustomer is set in the transaction object
//        return transactionRepository.saveAndFlush(transaction);
//    }
//
//    public Optional<Transaction> updateTransaction(long customerId, long transId, Transaction transactionDetails) {
//        Optional<Transaction> transactionOptional = transactionRepository.findByTransactionCustomerCustomerIdAndTransId(customerId, transId);
//        if (transactionOptional.isPresent()) {
//            Transaction transaction = transactionOptional.get();
//            transaction.setTransName(transactionDetails.getTransName());
//            transaction.setTransAmt(transactionDetails.getTransAmt());
//            // Update other fields as needed
//            return Optional.of(transactionRepository.saveAndFlush(transaction));
//        } else {
//            return Optional.empty();
//        }
//    }
//
//    public boolean deleteTransaction(long customerId, long transId) {
//        Optional<Transaction> transactionOptional = transactionRepository.findByTransactionCustomerCustomerIdAndTransId(customerId, transId);
//        if (transactionOptional.isPresent()) {
//            transactionRepository.delete(transactionOptional.get());
//            return true;
//        } else {
//            return false;
//        }
//    }
//}
