package com.academy.academy_final.service;

import com.academy.academy_final.model.entity.Card;
import com.academy.academy_final.model.entity.User;

import java.util.List;

public interface CardService {
    List<Card> getCardsByUser(User user);

    List<Card> getCardsByUsername (String username);
    Card getCardByCardNumber (Integer cardNumber);

    List<Card> getAllCard ();



}