package com.academy.academy_final.controller;


import com.academy.academy_final.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;



@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


}
