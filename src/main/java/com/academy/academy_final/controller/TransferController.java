package com.academy.academy_final.controller;

import com.academy.academy_final.model.entity.Card;
import com.academy.academy_final.model.entity.User;
import com.academy.academy_final.service.CardService;
import com.academy.academy_final.service.TransferService;
import com.academy.academy_final.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;


@Controller
@RequiredArgsConstructor
public class TransferController {

    private final CardService cardService;
    private final TransferService transferService;
private  final UserService userService;

    @GetMapping(value = "/transferChooseCard")
    public String transferChooseCard(Model model, @RequestParam String username) {
        User user = userService.getUserByUsername(username);
        model.addAttribute("cards", cardService.getCardsByUser(user));
        model.addAttribute("username",username);
        return "transferChooseCard";
    }

    @GetMapping(value = "/transfer")
    public String transfer(@RequestParam Integer cardNumber, Model model ) {

        Card card = cardService.getCardByCardNumber(cardNumber);
        model.addAttribute("card", card);

        return "transfer";
    }


    @GetMapping(value = "/transferSuccess")
    public String transferSuccess(@RequestParam Integer amount, @RequestParam Integer recipientCardNumber,@RequestParam Integer senderCardNumber, Model model) {
        if(senderCardNumber.equals(recipientCardNumber)||amount<=0|| recipientCardNumber == null){ //вынести обязательно!!
            var card = cardService.getCardByCardNumber(senderCardNumber);
            model.addAttribute("card", card);                        //всю валидацию!!
            return "transfer";
        }
        String transactionType = "transfer";
        var senderAccount = cardService.getCardByCardNumber(senderCardNumber).getCardAccount();
        var recipientAccount = cardService.getCardByCardNumber(recipientCardNumber).getCardAccount();

        transferService.transaction(transactionType,senderAccount,recipientAccount,amount.floatValue(),LocalDateTime.now());


        model.addAttribute("recipientCard", recipientCardNumber);
        model.addAttribute("cardNumber",senderCardNumber);
        model.addAttribute("amount",amount);


        return "transferSuccess";
    }


}
