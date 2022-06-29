package com.academy.academy_final.model.repository;

import com.academy.academy_final.model.entity.Card;
import com.academy.academy_final.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

    List<Card> getCardsByUser(User user);

    Card getCardByCardNumber(Integer cardNumber);



}
