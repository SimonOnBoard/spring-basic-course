package com.itis.kpfu.education.simononboard.spring.basics.repositories;

import com.itis.kpfu.education.simononboard.spring.basics.models.Cookie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * User:  SimonOnBoard
 * Project:  spring-basic-course
 * Package:  com.itis.kpfu.education.simononboard.spring.basics.repositories
 * Date:  26.02.2021
 * Time:  10:00
 */
public interface CookieRepository extends JpaRepository<Cookie, String> {

}
