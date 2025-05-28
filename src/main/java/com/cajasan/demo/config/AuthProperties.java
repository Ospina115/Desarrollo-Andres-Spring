package com.cajasan.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "auth")
public class AuthProperties {
    private String username;
    private String password;
    private String tokenUrl;

    // Getters y Setters
}
