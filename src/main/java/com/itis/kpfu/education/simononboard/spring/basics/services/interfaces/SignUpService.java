package com.itis.kpfu.education.simononboard.spring.basics.services.interfaces;

import com.itis.kpfu.education.simononboard.spring.basics.dto.UserDto;
import com.itis.kpfu.education.simononboard.spring.basics.dto.forms.SignUpForm;

/**
 * Created by IntelliJ IDEA.
 * User:  SimonOnBoard
 * Project:  spring-basic-course
 * Package:  com.itis.kpfu.education.simononboard.spring.basics.services.interfaces
 * Date:  26.02.2021
 * Time:  10:37
 */
public interface SignUpService {
    UserDto signUp(SignUpForm form);
}
