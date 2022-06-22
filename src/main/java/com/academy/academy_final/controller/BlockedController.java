package com.academy.academy_final.controller;

import com.academy.academy_final.service.BlockedService;
import com.academy.academy_final.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class BlockedController {
    public static final int BLOCKED = 2;
    public static final int ACTIVE = 1;
    private final CardService cardService;
    private final BlockedService blockedService;

    @GetMapping(value = "/blockedChooseCard")
    String blockedChooseCard(@RequestParam String username, Model model){

        showAllUserCards(username, model);

        return "blockedChooseCard";
    }

    private void showAllUserCards(String username, Model model) {
        model.addAttribute("cards", cardService.getCardsByUsername(username));
        model.addAttribute("username", username);
    }

    @GetMapping(value = "/blockedConfirm")
        String blockedConfirm(@RequestParam Integer cardNumber,@RequestParam String username, Model model){
        var card = cardService.getCardByCardNumber(cardNumber);
        if(card.getCardAccount().getAccountStatus().getStatusId().equals(BLOCKED)) {
            showAllUserCards(username, model);
            return "blockedChooseCard";
        }
        model.addAttribute("card",cardService.getCardByCardNumber(cardNumber));
        return "blockedConfirm";
    }
    @GetMapping(value = "/blockedSuccess")
    String blockedSuccess( @RequestParam Integer cardNumber, Model model){
        var card = cardService.getCardByCardNumber(cardNumber);
        model.addAttribute("card", card);
        if(card.getCardAccount().getAccountStatus().getStatusId().equals(ACTIVE)){
            blockedService.block(card.getCardAccount());
            model.addAttribute("card", card);
            return "blockedSuccess";
        }
        return "blockedChooseCard";
    }

}
