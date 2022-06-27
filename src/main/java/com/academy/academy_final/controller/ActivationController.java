package com.academy.academy_final.controller;

import com.academy.academy_final.model.entity.User;
import com.academy.academy_final.service.AccountService;
import com.academy.academy_final.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.academy.academy_final.controller.BlockedController.ACTIVE;


@Controller
@RequiredArgsConstructor
public class ActivationController {

    private final CardService cardService;
    private final AccountService accountService;

    @GetMapping(value = "/activationCardList")
    String cardList( Model model) {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        showAllUserCards(model, user.getUsername());

        return "activationCardList";
    }

    private void showAllUserCards(Model model, String username) {
        model.addAttribute("username", username);
        model.addAttribute("cards", cardService.getCardsByUsername(username));
    }

    @GetMapping(value = "/activationRequestSend")
    String activationRequestSend( Model model, @RequestParam Integer cardNumber) {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var card = cardService.getCardByCardNumber(cardNumber);
        if(card.getCardAccount().getAccountStatus().getStatusId().equals(ACTIVE)) {
            showAllUserCards(model, user.getUsername());
            return "activationCardList";
        }
        accountService.setStatusRequestAccount(cardNumber);

        showAllUserCards(model, user.getUsername());

        return "activationRequestSend";
    }

}
