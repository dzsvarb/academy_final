package com.academy.academy_final.controller;

import com.academy.academy_final.model.entity.User;
import com.academy.academy_final.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class RedirectController {
    private final CardService cardService;


    @GetMapping(value = "/")
    public String login(Model model) {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getRoles().get(0).name().equals("ROLE_ADMIN")){
            model.addAttribute("cards", cardService.getAllCard());
        return "admin";
        }
         else {
            model.addAttribute("cards", cardService.getCardsByUser(user));
        return"main";
    }

    }
}
