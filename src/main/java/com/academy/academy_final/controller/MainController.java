package com.academy.academy_final.controller;


import com.academy.academy_final.model.entity.User;
import com.academy.academy_final.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final CardService cardService;



    @GetMapping(value = "/main")
    public String main( Model model) {
            var user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("username", user.getUsername());
            model.addAttribute("cards", cardService.getCardsByUser(user));

            return "main";


    }
}
