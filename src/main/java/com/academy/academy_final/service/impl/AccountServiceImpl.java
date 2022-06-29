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

    public static final int STATUS_REQUEST_FALSE = 1;
    public static final int STATUS_REQUEST_TRUE = 2;
    private final AccountRepository accountRepository;
    private final CardService cardService;
    

    
    @Override
    @Transactional
    public void changeAccountStatusToBlocked(Account account) {

        if (account.getAccountStatus().getStatusId().equals(ACTIVE)){
            account.setAccountStatus(BLOCKED);
            accountRepository.saveAndFlush(account);
        }

    }

    @Override
    @Transactional
    public void changeAccountStatusToActive(Account account) {
        if (account.getAccountStatus().getStatusId().equals(BLOCKED)){
            account.setAccountStatus(ACTIVE);
            account.setAccountStatusRequest(STATUS_REQUEST_FALSE);
            accountRepository.saveAndFlush(account);
        }
    }

    @Override
    @Transactional
    public void setStatusRequestAccountTrue(Integer cardNumber) {
        var card = cardService.getCardByCardNumber(cardNumber);
        var account = card.getCardAccount();
        account.setAccountStatusRequest(STATUS_REQUEST_TRUE);

            accountRepository.saveAndFlush(account);

    }


}
