package com.academy.academy_final.service;

import com.academy.academy_final.model.entity.User;

import java.util.List;


public interface UserService {

    User getUserByUsername (String name);
    User getUserById (Integer id);

    List<User> getAllUsers ();

    Integer getUserIdByCard (Integer cardNumber);


}
