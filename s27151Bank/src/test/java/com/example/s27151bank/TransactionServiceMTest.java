package com.example.s27151bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class TransactionServiceMTest {
    @Mock
    private TransactionStorage transactionStorage;
    @InjectMocks
    private TransactionService transactionService;



    @Test
    void testDepositOrder() {
    }
}