package com.academy.academy_final.service.impl;

import com.academy.academy_final.model.entity.Account;
import com.academy.academy_final.model.entity.Transaction;
import com.academy.academy_final.model.repository.AccountRepository;
import com.academy.academy_final.model.repository.TransactionRepository;
import com.academy.academy_final.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public void save(Transaction transaction) {
        Account senderAccount = transaction.getSenderAccount();
        Account recipientAccount   = transaction.getRecipientAccount();

        var value = transaction.getTransactionValue();

        if(senderAccount.getAccountStatus().getStatusName().equals("ACTIVE")&&recipientAccount.getAccountStatus()
                .getStatusName().equals("ACTIVE")){
            senderAccount.setAccountBalance(senderAccount.getAccountBalance()-value);
            recipientAccount.setAccountBalance(recipientAccount.getAccountBalance()+value);

            accountRepository.saveAndFlush(senderAccount);
            accountRepository.saveAndFlush(recipientAccount);

            transactionRepository.saveAndFlush(transaction);}
        else {
            throw new CannotCreateTransactionException("One of account BLOCKED!");
        }


    }



}
