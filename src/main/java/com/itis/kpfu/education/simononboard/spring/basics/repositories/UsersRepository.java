package com.itis.kpfu.education.simononboard.spring.basics.repositories;

import com.itis.kpfu.education.simononboard.spring.basics.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User:  SimonOnBoard
 * Project:  spring-basic-course
 * Package:  com.itis.kpfu.education.simononboard.spring.basics.repositories
 * Date:  26.02.2021
 * Time:  10:01
 */

public interface UsersRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);

    Optional<User> findByCurrentConfirmationCode(String code);
}
