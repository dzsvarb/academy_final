package com.academy.academy_final.service.impl;

import com.academy.academy_final.model.entity.Account;
import com.academy.academy_final.model.entity.Status;
import com.academy.academy_final.model.entity.StatusRequest;
import com.academy.academy_final.model.repository.AccountRepository;
import com.academy.academy_final.service.AccountService;
import com.academy.academy_final.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UnknownFormatConversionException;

import static com.academy.academy_final.controller.BlockedController.ACTIVE;
import static com.academy.academy_final.controller.BlockedController.BLOCKED;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CardService cardService;
    

    
    @Override
    @Transactional
    public void changeAccountStatusToBlocked(Account account) {

        if (account.getAccountStatus().getStatusId().equals(ACTIVE)){
            Status status = new Status();
            status.setStatusId(BLOCKED);
            Account bAccount = new Account();

            bAccount.setAccountStatus(status);
            bAccount.setAccountBalance(account.getAccountBalance());
            bAccount.setAccountNumber(account.getAccountNumber());
            bAccount.setSenderTransactions(account.getSenderTransactions());
            bAccount.setRecipientTransactions(account.getRecipientTransactions());

            accountRepository.saveAndFlush(bAccount);
        }

    }

    @Override
    @Transactional
    public void changeAccountStatusToActive(Account account) {
        if (account.getAccountStatus().getStatusId().equals(BLOCKED)){
            Status status = new Status();
            status.setStatusId(ACTIVE);
            Account bAccount = new Account();

            bAccount.setAccountStatus(status);
            bAccount.setAccountBalance(account.getAccountBalance());
            bAccount.setAccountNumber(account.getAccountNumber());
            bAccount.setSenderTransactions(account.getSenderTransactions());
            bAccount.setRecipientTransactions(account.getRecipientTransactions());

            accountRepository.saveAndFlush(bAccount);
        }
    }

    @Override
    @Transactional
    public void setStatusRequestAccount(Integer cardNumber) {
        var card = cardService.getCardByCardNumber(cardNumber);
        var account = card.getCardAccount();

            Account bAccount = new Account();

            StatusRequest statusRequest = new StatusRequest();
            statusRequest.setStatusRequestId(2);

            bAccount.setAccountStatusRequest(statusRequest);
            bAccount.setAccountNumber(account.getAccountNumber());
            bAccount.setAccountStatus(account.getAccountStatus());
            bAccount.setAccountBalance(account.getAccountBalance());
            bAccount.setSenderTransactions(account.getSenderTransactions());
            bAccount.setRecipientTransactions(account.getRecipientTransactions());

            accountRepository.saveAndFlush(bAccount);

    }


}
