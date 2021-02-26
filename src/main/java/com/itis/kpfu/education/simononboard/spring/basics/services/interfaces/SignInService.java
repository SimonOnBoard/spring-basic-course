package com.itis.kpfu.education.simononboard.spring.basics.services.interfaces;

import com.itis.kpfu.education.simononboard.spring.basics.dto.forms.UserAuthForm;
import com.itis.kpfu.education.simononboard.spring.basics.exceptions.LoginProcessErrorException;
import com.itis.kpfu.education.simononboard.spring.basics.models.User;

/**
 * Created by IntelliJ IDEA.
 * User:  SimonOnBoard
 * Project:  spring-basic-course
 * Package:  com.itis.kpfu.education.simononboard.spring.basics.services.interfaces
 * Date:  26.02.2021
 * Time:  10:03
 */
public interface SignInService {
    User signIn(UserAuthForm signInForm) throws LoginProcessErrorException;
}
