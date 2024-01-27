package com.example.s27151bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private BankAccountStorage bankAccountStorage;


    @Test
    void customerRegistration() {
        String result = transactionService.customerRegistration("Jan",2211);
        assertThat(result).isEqualTo("Customer Registered Successfully");
    }

    @Test
    void transferOrder() {
        BankAccount bankAccount = new BankAccount(1, "Jan", 30);
        bankAccountStorage.addBankAccount(bankAccount);
        String result = transactionService.transferOrder(1,40).toString();
        Transaction transaction = transactionService.findTransactionByBankAccountId(1);
        assertThat(result).isEqualTo(transaction.toString());
    }

    @Test
    void depositOrder() {
    }

    @Test
    void returnCustomerData() {
        BankAccount bankAccount = new BankAccount(1, "Jan", 30);
        bankAccountStorage.addBankAccount(bankAccount);
        String result = transactionService.returnCustomerData(1);
        assertThat(result).isEqualTo("ID: 1 AccountName: Jan Balance 30.0");
    }
}