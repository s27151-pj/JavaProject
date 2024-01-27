package com.example.s27151bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class BankAccountStorage {
    private List<BankAccount> bankAccounts;

    public BankAccountStorage() {
        this.bankAccounts = new ArrayList<>();
    }

    public void addBankAccount(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
    }

    public List<BankAccount> getBankAccountsList() {
        return bankAccounts;
    }
    public void clearBankAccountsData() {
        bankAccounts.clear();
    }

}
