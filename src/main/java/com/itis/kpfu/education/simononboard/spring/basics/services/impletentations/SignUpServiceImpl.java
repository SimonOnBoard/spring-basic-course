package com.itis.kpfu.education.simononboard.spring.basics.services.impletentations;

import com.itis.kpfu.education.simononboard.spring.basics.dto.UserDto;
import com.itis.kpfu.education.simononboard.spring.basics.dto.forms.SignUpForm;
import com.itis.kpfu.education.simononboard.spring.basics.models.User;
import com.itis.kpfu.education.simononboard.spring.basics.repositories.UsersRepository;
import com.itis.kpfu.education.simononboard.spring.basics.services.interfaces.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User:  SimonOnBoard
 * Project:  spring-basic-course
 * Package:  com.itis.kpfu.education.simononboard.spring.basics.services.impletentations
 * Date:  26.02.2021
 * Time:  10:51
 */
@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {
    private final BCryptPasswordEncoder encoder;
    private final UsersRepository usersRepository;

    @Override
    public UserDto signUp(SignUpForm form) {
        if (usersRepository.existsByEmail(form.getEmail())) return null;
        // TODO: 26.02.2021 mappers либу прикрутить вместо builder и фабричного метода
        User user = User.fromSignUpForm(form);
        user.setCurrentConfirmationCode(UUID.randomUUID().toString());
        user.setPassword(encoder.encode(form.getPassword()));
        usersRepository.save(user);
        return UserDto.fromUser(user);
    }
}
