package com.example.s27151bank;

import org.springframework.stereotype.Component;

public class Transaction {
    int id = 0;
    private int transactionId;
    private BankAccount bankAccount;
    private TransactionState transactionState;

    public Transaction(int transactionId, BankAccount bankAccount, TransactionState transactionState) {
        this.transactionId = transactionId;
        this.bankAccount = bankAccount;
        this.transactionState = transactionState;
    }
    public Transaction(BankAccount bankAccount, TransactionState transactionState) {
        id = id++;
        this.transactionId = id;
        this.bankAccount = bankAccount;
        this.transactionState = transactionState;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public TransactionState getTransactionState() {
        return transactionState;
    }

    public void setTransactionState(TransactionState transactionState) {
        this.transactionState = transactionState;
    }
}
