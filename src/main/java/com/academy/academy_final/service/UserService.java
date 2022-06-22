package com.academy.academy_final.service;

import com.academy.academy_final.model.entity.User;


public interface UserService {

    User getUserByUsername (String name);
    User getUserById (Integer id);

}
