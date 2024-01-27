package com.example.s27151bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component

public class TransactionStorage {
    private List<Transaction> transactionsList;

    public TransactionStorage() {
        this.transactionsList = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactionsList.add(transaction);
    }

    public List<Transaction> getTransactionList() {
        return transactionsList;
    }
    public void clearTransactionData() {
        transactionsList.clear();
    }
}
