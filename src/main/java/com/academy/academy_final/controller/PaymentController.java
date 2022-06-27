package com.academy.academy_final.controller;

import com.academy.academy_final.model.entity.User;
import com.academy.academy_final.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class PaymentController {
    public static final String PAYMENT = "payment";
    private final CardService cardService;
    private final ServiceService serviceService;
    private final TransactionService transactionService;

    @GetMapping(value = "/paymentServiceList")
    String servicesList( Model model) {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("username", user.getUsername());
        model.addAttribute("allServices", serviceService.getAllService());

        return "paymentServiceList";
    }

    @GetMapping(value = "/paymentChooseCard")
    String paymentChooseCard(Model model, @RequestParam Integer serviceNumber) {
        var user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("cards", cardService.getCardsByUser(user));
        model.addAttribute("username", user.getUsername());
        model.addAttribute("serviceNumber", serviceNumber);

        return "paymentChooseCard";
    }

    @GetMapping(value = "/paymentConfirm")
    String paymentConfirm(@RequestParam Integer cardNumber, @RequestParam Integer serviceNumber, Model model) {

        model.addAttribute("service", serviceService.getServiceByServiceNumber(serviceNumber));
        model.addAttribute("cardNumber", cardNumber);

        return "paymentConfirm";
    }

    @GetMapping(value = "/paymentSuccess")
    String paymentSuccess(Model model, @RequestParam Integer senderCardNumber, @RequestParam Integer serviceNumber) {
        var senderAccount = cardService.getCardByCardNumber(senderCardNumber).getCardAccount();
        var service = serviceService.getServiceByServiceNumber(serviceNumber);
        var recipientAccount = service.getOrganisation().getOrganisationAccount();
        var amount = service.getServicePrice();

        transactionService.transaction(PAYMENT, senderAccount, recipientAccount, amount, LocalDateTime.now());

        model.addAttribute("serviceDescription", service.getServiceDescription());

        return "paymentSuccess";
    }
}
