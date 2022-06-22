package com.academy.academy_final.controller;


import com.academy.academy_final.model.entity.Card;
import com.academy.academy_final.model.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CardController {
    private final CardRepository cardRepository;

    @GetMapping(value = "/cards")
    public String card() {
        List<Card> cards = cardRepository.findAll();

        return "cards";
    }
}
