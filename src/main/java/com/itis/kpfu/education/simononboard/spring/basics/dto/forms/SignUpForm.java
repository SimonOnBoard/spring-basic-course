package com.itis.kpfu.education.simononboard.spring.basics.dto.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * Created by IntelliJ IDEA.
 * User:  SimonOnBoard
 * Project:  spring-basic-course
 * Package:  com.itis.kpfu.education.simononboard.spring.basics.dto.forms
 * Date:  26.02.2021
 * Time:  10:36
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class SignUpForm extends UserAuthForm{
    @NotBlank(message = "username is mandatory")
    private String username;
}
