package com.academy.academy_final.controller;

import com.academy.academy_final.model.entity.User;
import com.academy.academy_final.service.CardService;
import com.academy.academy_final.service.ServiceService;
import com.academy.academy_final.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/main")
public class PaymentController {
    public static final String PAYMENT = "payment";
    private final CardService cardService;
    private final ServiceService serviceService;
    private final TransactionService transactionService;

    @GetMapping(value = "/paymentServiceList")
    String servicesList( Model model) {
        model.addAttribute("allServices", serviceService.getAllService());

        return "paymentServiceList";
    }

    @GetMapping(value = "/paymentChooseCard")
    String paymentChooseCard(Model model, @RequestParam Integer serviceNumber) {
        var user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("cards", cardService.getCardsByUser(user));
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
    String paymentSuccess(Model model, @RequestParam  @Valid Integer senderCardNumber, @RequestParam @Valid Integer serviceNumber) {
        var senderAccount = cardService.getCardByCardNumber(senderCardNumber).getCardAccount();
        var service = serviceService.getServiceByServiceNumber(serviceNumber);
        var recipientAccount = service.getOrganisation().getOrganisationAccount();
        var amount = service.getServicePrice();


        try {transactionService.transaction(PAYMENT, senderAccount, recipientAccount, amount, LocalDateTime.now());
        } catch (Exception e){
            TransferController.errorOut(model,e.getMessage());
            model.addAttribute("allServices", serviceService.getAllService());
            return "paymentServiceList";
        }

        model.addAttribute("serviceDescription", service.getServiceDescription());

        return "paymentSuccess";
    }


}
