package com.academy.academy_final.service.impl;

import com.academy.academy_final.model.entity.User;
import com.academy.academy_final.model.repository.UserRepository;
import com.academy.academy_final.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public User getUserByUsername(String name) {
        return userRepository.getUserByUsername(name);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.getById(id);
    }


}
