package com.cajasan.practicante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ActividadandresApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActividadandresApplication.class, args);
    }
}