package com.itis.kpfu.education.simononboard.spring.basics.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * User:  SimonOnBoard
 * Project:  spring-basic-course
 * Package:  com.itis.kpfu.education.simononboard.spring.basics.models
 * Date:  26.02.2021
 * Time:  9:37
 */
@Entity
@Table(name = "cookie")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cookie {
    @Id
    private String uuid;

    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    public static Cookie fromValueAndUser(String value, User user) {
        return Cookie.builder()
                .uuid(value)
                .createdAt(LocalDateTime.now())
                .user(user)
                .build();
    }
}
