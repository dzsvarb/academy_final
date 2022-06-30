package com.academy.academy_final.validation.impl;

import com.academy.academy_final.validation.Validate;
import com.academy.academy_final.model.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidateImpl implements Validate {


    @Override
    public boolean isActive(Account account) {
        return account.getAccountStatus().getStatusName().equals("ACTIVE");
    }

    @Override
    public boolean resultBalanceIsGreaterNull(Account senderAccount, Float amount) {
        return (senderAccount.getAccountBalance() - amount) >= 0;
    }
}
