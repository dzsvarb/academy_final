package com.academy.academy_final.service.impl;

import com.academy.academy_final.model.entity.Account;
import com.academy.academy_final.model.entity.Status;
import com.academy.academy_final.model.repository.AccountRepository;
import com.academy.academy_final.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public Account getById(Integer id) {
        return  accountRepository.getById(id);
    }

    @Override
    public Account getByAccountNumber(Integer accountNumber) {
        return accountRepository.getAccountByAccountNumber(accountNumber);
    }
    @Override
    @Transactional
    public void changeAccountStatusToBlocked(Account account) {

        if (account.getAccountStatus().getStatusId().equals(1)){
            Status status = new Status();
            status.setStatusId(2);
            Account bAccount = new Account();

            bAccount.setAccountStatus(status);
            bAccount.setAccountBalance(account.getAccountBalance());
            bAccount.setAccountNumber(account.getAccountNumber());
            bAccount.setSenderTransactions(account.getSenderTransactions());
            bAccount.setRecipientTransactions(account.getRecipientTransactions());

            accountRepository.saveAndFlush(bAccount);
        }

    }


}
