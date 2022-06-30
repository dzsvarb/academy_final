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
import static com.academy.academy_final.controller.TransferController.errorOut;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/admin")
public class AdminController {
    private final CardService cardService;
    private final AccountService accountService;

    private final UserService userService;



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

    @GetMapping(value = "/activate")
    public String adminActivate(Model model, @RequestParam Integer cardNumber) {
        var card = cardService.getCardByCardNumber(cardNumber);
        if(card.getCardAccount().getAccountStatus().getStatusId().equals(BLOCKED)
                && card.getCardAccount().getAccountStatusRequest().getStatusRequestName().equals("TRUE")){
            accountService.changeAccountStatusToActive(card.getCardAccount());

        }
        model.addAttribute("card", cardService.getCardByCardNumber(cardNumber));
            return "edit";
    }

    @GetMapping(value = "/addUser")
    public String addUser(Model model){

        return "addUser";
    }
    @GetMapping(value = "/addSuccess")
    public String adminAddUser(Model model, @RequestParam String username, @RequestParam String email, @RequestParam String city, @RequestParam String street,
                               @RequestParam Integer house,@RequestParam Integer room, @RequestParam String password, @RequestParam String passwordConf, @RequestParam String cardPaySystem, @RequestParam Integer cardNumber)
    {

        try{
            userService.addNewUser(username,email,city,street,house,room,password,passwordConf,cardPaySystem,cardNumber);
        }catch (Exception e){
            errorOut(model, e.getMessage());
            return "addUser";
        }
        return "admin";
    }


}
