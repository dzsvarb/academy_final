package com.academy.academy_final.service;


import com.academy.academy_final.model.entity.Account;

public interface AccountService {
    Account getById(Integer id);

    Account getByAccountNumber (Integer accountNumber);


    void changeAccountStatusToBlocked (Account account);

}
