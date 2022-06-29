package com.academy.academy_final.controller;

import com.academy.academy_final.service.AccountService;
import com.academy.academy_final.service.CardService;
import com.academy.academy_final.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.academy.academy_final.controller.BlockedController.BLOCKED;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/admin")
public class AdminController {
    private final CardService cardService;
    private final AccountService accountService;



    @GetMapping(value = "")
    public String admin(Model model) {
        model.addAttribute("cards", cardService.getAllCard());

        return "admin";
    }


    @GetMapping(value = "/edit")
    public String adminEdit(Model model, @RequestParam Integer cardNumber) {
        model.addAttribute("card", cardService.getCardByCardNumber(cardNumber));

        return "edit";
    }

    @GetMapping(value = "/edit/activate")
    public String adminActivate(Model model, @RequestParam Integer cardNumber) {
        var card = cardService.getCardByCardNumber(cardNumber);
        if(card.getCardAccount().getAccountStatus().getStatusId().equals(BLOCKED)
                && card.getCardAccount().getAccountStatusRequest().getStatusRequestName().equals("TRUE")){
            accountService.changeAccountStatusToActive(card.getCardAccount());

        }
        model.addAttribute("card", cardService.getCardByCardNumber(cardNumber));
            return "admin";
    }

    @GetMapping(value = "/edit/change")
    public String adminEditChange(Model model, @RequestParam Integer cardNumber) {




        return "editRolesuccess";
    }
}
