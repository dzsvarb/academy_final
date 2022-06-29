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


@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/main")
public class BlockedController {
    public static final int BLOCKED = 2;
    public static final int ACTIVE = 1;
    private final CardService cardService;
    private final AccountService accountService;

    @GetMapping(value = "/blockedChooseCard")
    String blockedChooseCard( Model model){
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        showAllUserCards(user.getUsername(), model);

        return "blockedChooseCard";
    }

    private void showAllUserCards(String username, Model model) {
        model.addAttribute("cards", cardService.getCardsByUsername(username));
        model.addAttribute("username", username);
    }

    @GetMapping(value = "/blockedConfirm")
        String blockedConfirm(@RequestParam Integer cardNumber, Model model){
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var card = cardService.getCardByCardNumber(cardNumber);
        if(card.getCardAccount().getAccountStatus().getStatusId().equals(BLOCKED)) {
            showAllUserCards(user.getUsername(), model);
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
            accountService.changeAccountStatusToBlocked(card.getCardAccount());
            model.addAttribute("card", card);
            return "blockedSuccess";
        }
        return "blockedChooseCard";
    }

}
