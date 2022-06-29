package com.academy.academy_final.service.impl;

import com.academy.academy_final.model.entity.User;
import com.academy.academy_final.model.repository.UserRepository;
import com.academy.academy_final.service.CardService;
import com.academy.academy_final.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final CardService cardService;


    @Override
    public User getUserByUsername(String name) {
        return userRepository.getUserByUsername(name);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Integer getUserIdByCard(Integer cardNumber) {
      var user =  userRepository.getUserByUsername(cardService.getCardByCardNumber(cardNumber).getUser().getUsername());
        return user.getId() ;
    }




}
