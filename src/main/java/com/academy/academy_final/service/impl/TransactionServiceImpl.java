package com.academy.academy_final.service.impl;

import com.academy.academy_final.validation.Validate;
import com.academy.academy_final.model.entity.Account;
import com.academy.academy_final.model.entity.Transaction;
import com.academy.academy_final.model.repository.AccountRepository;
import com.academy.academy_final.model.repository.TransactionRepository;
import com.academy.academy_final.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    public static final int ACCOUNT_NUMBER_RESERVE = 10;
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final Validate validate;

    @Override
    public void transaction(String transactionType, Account senderAccountNumber, Account recipientAccountNumber, Float amount, LocalDateTime localTime) {

        Transaction transaction = new Transaction();
        transaction.setTransactionType(transactionType);
        transaction.setSenderAccount(senderAccountNumber);
        transaction.setRecipientAccount(recipientAccountNumber);
        transaction.setTransactionValue(amount);
        transaction.setTransactionTime(localTime);

        save(transaction);
    }

    @Override
    @Transactional
    public void save(Transaction transaction) {
        Account senderAccount = transaction.getSenderAccount();
        Account recipientAccount   = transaction.getRecipientAccount();

        var value = transaction.getTransactionValue();

        if(validate.isActive(senderAccount)&&validate.isActive(recipientAccount)){
            if ( validate.resultBalanceIsGreaterNull(senderAccount,transaction.getTransactionValue())){
                senderAccount.setAccountBalance(senderAccount.getAccountBalance()-value);
                recipientAccount.setAccountBalance(recipientAccount.getAccountBalance()+value);

                accountRepository.saveAndFlush(senderAccount);
                accountRepository.saveAndFlush(recipientAccount);

                transactionRepository.saveAndFlush(transaction);
            }else {
                throw new CannotCreateTransactionException("There are not enough funds on your account to complete the operation!");
            }

        }
        else {
            throw new CannotCreateTransactionException("Recipient account is BLOCKED or not exist!");
        }


    }



}
