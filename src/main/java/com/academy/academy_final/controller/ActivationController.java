package com.academy.academy_final.controller;

import com.academy.academy_final.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.academy.academy_final.controller.BlockedController.ACTIVE;


@Controller
@RequiredArgsConstructor
public class ActivationController {

    private final CardService cardService;

    @GetMapping(value = "/activationCardList")
    String cardList( Model model, @RequestParam String username) {
        showAllUserCards(model, username);

        return "activationCardList";
    }

    private void showAllUserCards(Model model, String username) {
        model.addAttribute("username", username);
        model.addAttribute("cards", cardService.getCardsByUsername(username));
    }

    @GetMapping(value = "/activationRequestSend")
    String activationRequestSend( Model model, @RequestParam String username, @RequestParam Integer cardNumber) {
        var card = cardService.getCardByCardNumber(cardNumber);
        if(card.getCardAccount().getAccountStatus().getStatusId().equals(ACTIVE)) {
            showAllUserCards(model, username);
            return "activationCardList";
        }
        //send.request
        return "activationRequestSend";
    }

}
