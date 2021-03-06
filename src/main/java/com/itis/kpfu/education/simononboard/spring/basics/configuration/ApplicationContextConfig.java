package com.itis.kpfu.education.simononboard.spring.basics.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.
 * User:  SimonOnBoard
 * Project:  spring-basic-course
 * Package:  com.itis.kpfu.education.simononboard.spring.basics.configuration
 * Date:  26.02.2021
 * Time:  10:55
 */

@Configuration
@PropertySource(value = "classpath:/application.properties")
@RequiredArgsConstructor
public class ApplicationContextConfig {
    private final Environment environment;

    // TODO: 26.02.2021 - посмореть разницу между шаблонным и абстрактным методом
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    // TODO: 26.02.2021 - добавить hikari connection pool

    @Bean
    public ExecutorService executorService() {
        int i = Runtime.getRuntime().availableProcessors();
        return Executors.newFixedThreadPool(i);
    }

    @Bean
    public Map<String, String> templateParameters() {
        Map<String, String> model = new HashMap<>();
        model.put("location", environment.getProperty("location"));
        model.put("signature", environment.getProperty("link"));
        return model;
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("testsamplexx@gmail.com");
        mailSender.setPassword("qwertsdfghcvbnm");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
