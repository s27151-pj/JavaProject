package com.example.s27151bank;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
@Service

public class TransactionService {
    private final TransactionStorage transactionStorage;
    private final BankAccountStorage bankAccountStorage;

    public TransactionService(TransactionStorage transactionStorage, BankAccountStorage bankAccountStorage) {
        this.transactionStorage = transactionStorage;
        this.bankAccountStorage = bankAccountStorage;
    }

    public String customerRegistration(String accountName, double balance) {
        //może być dwuch klientów o tej samej nazwie więc niesprawdzam czy już isnieje
        BankAccount bankAccount = new BankAccount(accountName, balance);
        bankAccountStorage.addBankAccount(bankAccount);
        return "Customer Registered Successfully";
    }
    public Transaction transferOrder(int bankAccountId, double transactionBalance) {
        BankAccount bankAccount = BankAccountById(bankAccountId);

        if (bankAccount.getBalance() >= transactionBalance) {
            double balance = bankAccount.getBalance();
            bankAccount.setBalance(balance - transactionBalance);
            Transaction transaction = new Transaction(bankAccount, TransactionState.ACCEPTED);
            transactionStorage.addTransaction(transaction);
            return transaction;

        }
        else {
            Transaction transaction = new Transaction(bankAccount, TransactionState.DECLINED);
            transactionStorage.addTransaction(transaction);
            return transaction;

        }
    }
    public Transaction depositOrder(int bankAccountId, double depositBalance){
        BankAccount bankAccount = BankAccountById(bankAccountId);
        double balance = bankAccount.getBalance();
        bankAccount.setBalance(balance + depositBalance);
        Transaction transaction = new Transaction(bankAccount, TransactionState.ACCEPTED);
        transactionStorage.addTransaction(transaction);
        return transaction;
    }
    public String returnCustomerData(int bankAccountId) {
        BankAccount b = BankAccountById(bankAccountId);
        return "ID: " + b.getBankAccountId() +
                " AccountName: " + b.getAccountName() +
                " Balance " + b.getBalance();
    }

    public BankAccount BankAccountById(int bankAccountId){
        BankAccount BankAccount = null;
        for (BankAccount b : bankAccountStorage.getBankAccountsList()) {
            if (b.getBankAccountId() == (bankAccountId)) {
                BankAccount = b;
                break;
            }
        }
        if (BankAccount == null) {
            throw new NoSuchElementException();
        } else {
            return BankAccount;
        }
    }
    public Transaction findTransactionByBankAccountId(int bankAccountId){
        Transaction transaction = null;
        BankAccount b = BankAccountById(bankAccountId);
        for (Transaction t : transactionStorage.getTransactionList()) {
            if (t.getBankAccount() == (b)) {
                transaction = t;
                break;
            }
        }
        if (transaction == null) {
            throw new NoSuchElementException();
        } else {
            return transaction;
        }
    }

}
