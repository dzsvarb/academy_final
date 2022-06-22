package com.academy.academy_final.service.impl;

import com.academy.academy_final.model.entity.Card;
import com.academy.academy_final.model.entity.User;
import com.academy.academy_final.model.repository.CardRepository;
import com.academy.academy_final.model.repository.UserRepository;
import com.academy.academy_final.service.CardService;
import com.academy.academy_final.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    @Override
    public Card getCardByUser(User user) {
        return cardRepository.getCardByUser(user);
    }
    @Override
    public List<Card> getCardsByUser(User user) {

        return cardRepository.getCardsByUser(user);
    }

    @Override
    public List<Card> getCardsByUsername(String username) {
        return cardRepository.getCardsByUser(userRepository.getUserByUsername(username));
    }

    @Override
    public Card getCardByCardNumber(Integer cardNumber) {
        return cardRepository.getCardByCardNumber(cardNumber);
    }



    @Override
    public Card getCardByUsername(String username) {
        return  cardRepository.getCardByUser(userRepository.getUserByUsername(username));
    }
}
