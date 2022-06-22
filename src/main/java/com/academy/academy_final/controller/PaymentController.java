package com.academy.academy_final.controller;

import com.academy.academy_final.model.entity.User;
import com.academy.academy_final.service.CardService;
import com.academy.academy_final.service.ServiceService;
import com.academy.academy_final.service.TransferService;
import com.academy.academy_final.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class PaymentController {
    private final CardService cardService;
    private final ServiceService serviceService;
    private final TransferService transferService;
    private final UserService userService;

    @GetMapping(value = "/paymentServiceList")
    String servicesList( Model model, @RequestParam String username) {
        model.addAttribute("username", username);
        model.addAttribute("allServices", serviceService.getAllService());

        return "paymentServiceList";
    }

    @GetMapping(value = "/paymentChooseCard")
    String paymentChooseCard(Model model, @RequestParam Integer serviceNumber, @RequestParam String username) {
        User user = userService.getUserByUsername(username);
        model.addAttribute("cards", cardService.getCardsByUser(user));
        model.addAttribute("username", username);
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
        String transactionType = "payment";
        var senderAccount = cardService.getCardByCardNumber(senderCardNumber).getCardAccount();
        var service = serviceService.getServiceByServiceNumber(serviceNumber);
        var recipientAccount = service.getOrganisation().getOrganisationAccount();
        var amount = service.getServicePrice();

        transferService.transaction(transactionType, senderAccount, recipientAccount, amount, LocalDateTime.now());

        model.addAttribute("serviceDescription", service.getServiceDescription());

        return "paymentSuccess";
    }
}
