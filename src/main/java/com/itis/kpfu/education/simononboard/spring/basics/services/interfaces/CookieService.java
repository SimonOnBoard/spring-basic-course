package com.itis.kpfu.education.simononboard.spring.basics.services.interfaces;

import com.itis.kpfu.education.simononboard.spring.basics.models.User;

import javax.servlet.http.Cookie;

/**
 * Created by IntelliJ IDEA.
 * User:  SimonOnBoard
 * Project:  spring-basic-course
 * Package:  com.itis.kpfu.education.simononboard.spring.basics.services.interfaces
 * Date:  26.02.2021
 * Time:  10:02
 */
public interface CookieService {
    boolean checkCookie(String cookieValue);

    Cookie createCookie(User userDto);
}
