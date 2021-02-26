package com.itis.kpfu.education.simononboard.spring.basics.services.impletentations;

import com.itis.kpfu.education.simononboard.spring.basics.models.User;
import com.itis.kpfu.education.simononboard.spring.basics.repositories.CookieRepository;
import com.itis.kpfu.education.simononboard.spring.basics.services.interfaces.CookieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User:  SimonOnBoard
 * Project:  spring-basic-course
 * Package:  com.itis.kpfu.education.simononboard.spring.basics.services.impletentations
 * Date:  26.02.2021
 * Time:  10:23
 */

@Service
@RequiredArgsConstructor
public class CookieServiceImpl implements CookieService {
    private final CookieRepository cookieRepository;

    // TODO: 26.02.2021 Global exception handler - redirect to cookie creation process
    @Override
    public boolean checkCookie(String cookieValue) {
        return cookieValue != null;
    }

    @Override
    public Cookie createCookie(User user) {
        String value = UUID.randomUUID().toString();
        com.itis.kpfu.education.simononboard.spring.basics.models.Cookie cookie = com.itis.kpfu.education.simononboard.spring.basics.models.Cookie
                .fromValueAndUser(value, user);
        cookieRepository.save(cookie);
        return new Cookie("AuthCookie", value);
    }
}
