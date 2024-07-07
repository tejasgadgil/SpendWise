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

    public List<Transaction> getAllTransactionsByCustomerId(long customerId) {
        return transactionRepository.findByTransactionCustomerCustomerId(customerId);
    }

    public Optional<Transaction> getTransactionByCustomerId(long customerId, long transId) {
        return transactionRepository.findByTransactionCustomerCustomerIdAndTransId(customerId, transId);
    }

    public Transaction addTransaction(long customerId, Transaction transaction) {
        // Assuming transactionCustomer is set in the transaction object
        return transactionRepository.saveAndFlush(transaction);
    }

    public Optional<Transaction> updateTransaction(long customerId, long transId, Transaction transactionDetails) {
        Optional<Transaction> transactionOptional = transactionRepository.findByTransactionCustomerCustomerIdAndTransId(customerId, transId);
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

    public boolean deleteTransaction(long customerId, long transId) {
        Optional<Transaction> transactionOptional = transactionRepository.findByTransactionCustomerCustomerIdAndTransId(customerId, transId);
        if (transactionOptional.isPresent()) {
            transactionRepository.delete(transactionOptional.get());
            return true;
        } else {
            return false;
        }
    }
}
