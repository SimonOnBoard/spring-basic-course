package com.itis.kpfu.education.simononboard.spring.basics.dto.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * Created by IntelliJ IDEA.
 * User:  SimonOnBoard
 * Project:  spring-basic-course
 * Package:  com.itis.kpfu.education.simononboard.spring.basics.dto.forms
 * Date:  26.02.2021
 * Time:  9:55
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserAuthForm {
    @NotBlank(message = "email is mandatory")
    private String email;
    @NotBlank(message = "password is mandatory")
    private String password;
}
