package com.cajasan.demo.service;

import com.cajasan.demo.config.AuthProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class TokenService {

    @Autowired
    private WebClient webClient;

    @Autowired
    private AuthProperties authProperties;

    public String getBearerToken() {
        Map<String, String> requestBody = Map.of(
            "username", authProperties.getUsername(),
            "password", authProperties.getPassword()
        );

        return webClient.post()
                .uri(authProperties.getTokenUrl())
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> (String) response.get("access_token"))
                .block();
    }
}
