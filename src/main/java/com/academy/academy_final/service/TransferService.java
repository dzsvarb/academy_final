package com.academy.academy_final.service;

import com.academy.academy_final.model.entity.Account;

import java.time.LocalDateTime;

public interface TransferService {
    void transaction(String transactionType, Account senderAccountNumber, Account recipientAccountNumber, Float amount, LocalDateTime localTime);
}
