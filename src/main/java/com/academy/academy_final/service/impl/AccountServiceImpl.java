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

    public static final int STATUS_REQUEST_TRUE = 2;
    public static final int STATUS_REQUEST_FALSE = 1;
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
            bAccount.setAccountStatusRequest(account.getAccountStatusRequest());

            accountRepository.saveAndFlush(bAccount);
        }

    }

    @Override
    @Transactional
    public void changeAccountStatusToActive(Account account) {
        if (account.getAccountStatus().getStatusId().equals(BLOCKED)){
            Status status = new Status();
            status.setStatusId(ACTIVE);

            StatusRequest statusRequestFalse = new StatusRequest();
            statusRequestFalse.setStatusRequestId(STATUS_REQUEST_FALSE);

            Account bAccount = new Account();
            bAccount.setAccountStatus(status);
            bAccount.setAccountBalance(account.getAccountBalance());
            bAccount.setAccountNumber(account.getAccountNumber());
            bAccount.setSenderTransactions(account.getSenderTransactions());
            bAccount.setRecipientTransactions(account.getRecipientTransactions());
            bAccount.setAccountStatusRequest(statusRequestFalse);

            accountRepository.saveAndFlush(bAccount);
        }
    }

    @Override
    @Transactional
    public void setStatusRequestAccountTrue(Integer cardNumber) {
        var card = cardService.getCardByCardNumber(cardNumber);
        var account = card.getCardAccount();

            Account bAccount = new Account();

            StatusRequest statusRequestTrue = new StatusRequest();
            statusRequestTrue.setStatusRequestId(STATUS_REQUEST_TRUE);

            bAccount.setAccountStatusRequest(statusRequestTrue);
            bAccount.setAccountNumber(account.getAccountNumber());
            bAccount.setAccountStatus(account.getAccountStatus());
            bAccount.setAccountBalance(account.getAccountBalance());
            bAccount.setSenderTransactions(account.getSenderTransactions());
            bAccount.setRecipientTransactions(account.getRecipientTransactions());

            accountRepository.saveAndFlush(bAccount);

    }


}
