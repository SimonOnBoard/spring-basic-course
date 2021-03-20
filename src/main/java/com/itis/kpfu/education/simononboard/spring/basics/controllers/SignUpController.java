package com.itis.kpfu.education.simononboard.spring.basics.controllers;

import com.itis.kpfu.education.simononboard.spring.basics.dto.UserDto;
import com.itis.kpfu.education.simononboard.spring.basics.dto.forms.SignUpForm;
import com.itis.kpfu.education.simononboard.spring.basics.services.interfaces.MailService;
import com.itis.kpfu.education.simononboard.spring.basics.services.interfaces.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User:  SimonOnBoard
 * Project:  spring-basic-course
 * Package:  com.itis.kpfu.education.simononboard.spring.basics.controllers
 * Date:  26.02.2021
 * Time:  9:36
 */

@Controller
@RequestMapping("/signUp")
@RequiredArgsConstructor
public class SignUpController {
    private final SignUpService signUpService;
    private final MailService mailService;

    @PermitAll
    @GetMapping
    public String getSignUpPage(@RequestParam(value = "error", required = false) String error,
                                Model model) {
        model.addAttribute("error", error);
        return "sign_up_page";
    }

    @PermitAll
    @PostMapping
    public String signUp(@Valid SignUpForm form,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            List<String> errorsList = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            redirectAttributes.addAttribute("error", errorsList.toString());
            return "redirect:/signUp";
        }
        UserDto userDto = null;
        if ((userDto = signUpService.signUp(form)) != null) {
            redirectAttributes.addAttribute("info", "Please confirm your email before continue");
            mailService.sendMail(userDto);
            return "redirect:/signIn";
        } else {
            redirectAttributes.addAttribute("error", "Account with this email already exists");
            return "redirect:/signUp";
        }
    }
}
