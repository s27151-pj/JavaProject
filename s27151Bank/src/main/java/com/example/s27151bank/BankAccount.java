package com.example.s27151bank;

import org.springframework.stereotype.Component;

public class BankAccount {
    int id = 0;
    private int bankAccountId;
    private String accountName;
    private double balance; //saldo

    public BankAccount(int bankAccountId, String accountName, double balance) {
        this.bankAccountId = bankAccountId;
        this.accountName = accountName;
        this.balance = balance;
    }
    public BankAccount(String accountName, double balance) {
        id = id++;
        this.bankAccountId = id;
        this.accountName = accountName;
        this.balance = balance;
    }

    public int getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(int bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
