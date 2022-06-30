package com.academy.academy_final.validation;


import com.academy.academy_final.model.entity.Account;

public interface Validate {

    boolean isActive (Account account);
    boolean resultBalanceIsGreaterNull (Account senderAccount, Float amount);
   boolean isPasswordInvalid (String password,String passwordConf);

}
