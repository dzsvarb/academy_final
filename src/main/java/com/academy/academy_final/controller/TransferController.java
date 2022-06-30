package com.academy.academy_final.controller;

import com.academy.academy_final.model.entity.Card;
import com.academy.academy_final.model.entity.User;
import com.academy.academy_final.service.CardService;
import com.academy.academy_final.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/main")
public class TransferController {

    public static final String TRANSFER = "transfer";
    private final CardService cardService;
    private final TransactionService transactionService;

    @GetMapping(value = "/transferChooseCard")
    public String transferChooseCard(Model model) {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("cards", cardService.getCardsByUser(user));
        return "transferChooseCard";
    }

    @GetMapping(value = "/transfer")
    public String transfer(@RequestParam  Integer cardNumber, Model model ) {
        Card card = cardService.getCardByCardNumber(cardNumber);
        model.addAttribute("card", card);
        return "transfer";
    }


    @GetMapping(value = "/transferSuccess")
    public String transferSuccess(@RequestParam Integer amount, @RequestParam  Integer recipientCardNumber,
                                  @RequestParam  Integer senderCardNumber, Model model) {
        if(amount<=0||recipientCardNumber==null||senderCardNumber==null||senderCardNumber.equals(recipientCardNumber)){
            var card = cardService.getCardByCardNumber(senderCardNumber);
            model.addAttribute("card", card);
            errorOut(model,"One of parameter is invalid!");
            return "transfer";
        }

        var senderAccount = cardService.getCardByCardNumber(senderCardNumber).getCardAccount();
        var recipientAccount = cardService.getCardByCardNumber(recipientCardNumber).getCardAccount();

        try {
            transactionService.transaction(TRANSFER,senderAccount,recipientAccount,amount.floatValue(),LocalDateTime.now());
        }catch (Exception e){
            errorOut(model, e.getMessage());
            var card = cardService.getCardByCardNumber(senderCardNumber);
            model.addAttribute("card", card);
            return "transfer";
        }



        model.addAttribute("recipientCard", recipientCardNumber);
        model.addAttribute("cardNumber",senderCardNumber);
        model.addAttribute("amount",amount);


        return "transferSuccess";
    }

    public static void errorOut(Model model, String message) {
        model.addAttribute("error",message);
    }


}
