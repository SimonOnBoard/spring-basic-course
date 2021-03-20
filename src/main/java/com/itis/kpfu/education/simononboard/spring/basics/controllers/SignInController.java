package com.itis.kpfu.education.simononboard.spring.basics.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.PermitAll;

@Controller
@RequestMapping("/signIn")
@RequiredArgsConstructor
public class SignInController {

    @PermitAll
    @GetMapping
    public String getSignInPage(@RequestParam(value = "error", required = false) String error,
                                @RequestParam(value = "info", required = false) String info,
                                Model model) {
        model.addAttribute("error", error);
        model.addAttribute("info", info);
        return "sign_in_page";
    }
}
