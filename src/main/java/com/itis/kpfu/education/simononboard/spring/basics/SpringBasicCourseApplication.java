package com.itis.kpfu.education.simononboard.spring.basics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.itis.kpfu.education.simononboard.spring.basics.models")
public class SpringBasicCourseApplication {

    public static void main(String[] args){
        SpringApplication.run(SpringBasicCourseApplication.class, args);
    }

}
