package com.itis.kpfu.education.simononboard.spring.basics.controllers;

import com.itis.kpfu.education.simononboard.spring.basics.services.interfaces.ConfirmationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by IntelliJ IDEA.
 * User:  SimonOnBoard
 * Project:  spring-basic-course
 * Package:  com.itis.kpfu.education.simononboard.spring.basics.controllers
 * Date:  26.02.2021
 * Time:  9:37
 */
@Controller
@RequestMapping("/confirm")
@RequiredArgsConstructor
public class ConfirmationController {
    private final ConfirmationService confirmationService;

    @GetMapping("/{key}")
    public String confirmAccount(@PathVariable(name = "key") String code,
                                 RedirectAttributes redirectAttributes) {
        boolean confirmationResult = confirmationService.confirmByCode(code);
        String redirectUrl = confirmationResult ? "redirect:/profile" : "redirect:/signIn";
        String infoMessage = confirmationResult ? "Successfully confirmed" : "Code not found";
        redirectAttributes.addAttribute("info", infoMessage);
        return redirectUrl;
    }
}
