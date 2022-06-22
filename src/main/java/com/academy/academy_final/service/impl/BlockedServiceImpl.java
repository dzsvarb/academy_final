package com.academy.academy_final.service.impl;

import com.academy.academy_final.model.entity.Account;
import com.academy.academy_final.service.AccountService;
import com.academy.academy_final.service.BlockedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BlockedServiceImpl implements BlockedService {
    private final AccountService accountService;
    @Override

    public void block(Account account) {
    accountService.changeAccountStatusToBlocked(account);
    }
}
