package com.itis.kpfu.education.simononboard.spring.basics.services.interfaces;

import com.itis.kpfu.education.simononboard.spring.basics.dto.UserDto;

/**
 * Created by IntelliJ IDEA.
 * User:  SimonOnBoard
 * Project:  spring-basic-course
 * Package:  com.itis.kpfu.education.simononboard.spring.basics.services.interfaces
 * Date:  26.02.2021
 * Time:  20:07
 */
public interface MailService {
    void sendMail(UserDto userDto);
}
