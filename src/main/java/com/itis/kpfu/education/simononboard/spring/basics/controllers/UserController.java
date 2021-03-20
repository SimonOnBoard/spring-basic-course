package com.itis.kpfu.education.simononboard.spring.basics.controllers;

import com.itis.kpfu.education.simononboard.spring.basics.models.User;
import com.itis.kpfu.education.simononboard.spring.basics.security.details.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * User:  SimonOnBoard
 * Project:  spring-basic-course
 * Package:  com.itis.kpfu.education.simononboard.spring.basics.controllers
 * Date:  26.02.2021
 * Time:  9:37
 */
@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class UserController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public String getUserProfile(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority(User.Role.ADMIN.toString())))
            model.addAttribute("role", "admin");
        return "profile";
    }
}
