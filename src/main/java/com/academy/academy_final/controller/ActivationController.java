package com.academy.academy_final.controller;

import com.academy.academy_final.model.entity.User;
import com.academy.academy_final.service.AccountService;
import com.academy.academy_final.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.academy.academy_final.controller.BlockedController.ACTIVE;


@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/main")
public class ActivationController {

    private final CardService cardService;
    private final AccountService accountService;

    @GetMapping(value = "/activationCardList")
    String cardList( Model model) {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("cards", cardService.getCardsByUsername(user.getUsername()));
        return "activationCardList";
    }


    @GetMapping(value = "/activationRequestSend")
    String activationRequestSend( Model model, @RequestParam Integer cardNumber) {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var card = cardService.getCardByCardNumber(cardNumber);
        if(card.getCardAccount().getAccountStatus().getStatusId().equals(ACTIVE)) {
            model.addAttribute("cards", cardService.getCardsByUsername(user.getUsername()));
            return "activationCardList";
        }
        accountService.setStatusRequestAccountTrue(cardNumber);

        model.addAttribute("cardNumber",cardNumber);

        return "activationRequestSend";
    }

}
