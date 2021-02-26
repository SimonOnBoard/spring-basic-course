package com.itis.kpfu.education.simononboard.spring.basics.services.impletentations;

import com.itis.kpfu.education.simononboard.spring.basics.dto.forms.UserAuthForm;
import com.itis.kpfu.education.simononboard.spring.basics.exceptions.LoginProcessErrorException;
import com.itis.kpfu.education.simononboard.spring.basics.models.User;
import com.itis.kpfu.education.simononboard.spring.basics.repositories.UsersRepository;
import com.itis.kpfu.education.simononboard.spring.basics.services.interfaces.SignInService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User:  SimonOnBoard
 * Project:  spring-basic-course
 * Package:  com.itis.kpfu.education.simononboard.spring.basics.services.impletentations
 * Date:  26.02.2021
 * Time:  13:19
 */
@Service
@RequiredArgsConstructor
public class SignInServiceImpl implements SignInService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User signIn(UserAuthForm signInForm) throws LoginProcessErrorException {
        User user = usersRepository.findByEmail(signInForm.getEmail())
                .orElseThrow(() -> new LoginProcessErrorException("User not found"));
        boolean passwordResult = passwordEncoder.matches(signInForm.getPassword(), user.getPassword());
        if(passwordResult) return user;
        return null;
    }
}
