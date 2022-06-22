package com.academy.academy_final.service.impl;


import com.academy.academy_final.model.entity.Account;
import com.academy.academy_final.model.entity.Transaction;
import com.academy.academy_final.service.CardService;
import com.academy.academy_final.service.TransferService;
import com.academy.academy_final.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {

    private final TransactionService transactionService;
    private final CardService cardService;



    @Override
    public void transaction(String transactionType, Account senderAccountNumber, Account recipientAccountNumber, Float amount, LocalDateTime localTime) {
        Transaction transaction = new Transaction();
        transaction.setTransactionType(transactionType);
        transaction.setSenderAccount(senderAccountNumber);
        transaction.setRecipientAccount(recipientAccountNumber);
        transaction.setTransactionValue(amount);
        transaction.setTransactionTime(localTime);

        transactionService.save(transaction);
    }
}
