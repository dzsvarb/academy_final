package com.academy.academy_final.service;


import com.academy.academy_final.model.entity.Account;

public interface AccountService {



    void changeAccountStatusToBlocked (Account account);

    void changeAccountStatusToActive (Account account);

    void setStatusRequestAccount(Integer cardNumber);

}
