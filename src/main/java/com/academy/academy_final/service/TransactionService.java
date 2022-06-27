package com.academy.academy_final.service;

import com.academy.academy_final.model.entity.Account;
import com.academy.academy_final.model.entity.Transaction;

import java.time.LocalDateTime;

public interface TransactionService {

 void save(Transaction transaction);

 void transaction(String transactionType, Account senderAccountNumber, Account recipientAccountNumber, Float amount, LocalDateTime localTime);


}
