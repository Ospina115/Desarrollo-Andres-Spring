package com.cajasan.practicante.service;

import com.ejemplo.config.AuthProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class TokenService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private AuthProperties authProperties;

    public String obtenerToken() {
        Map<String, String> body = Map.of(
            "username", authProperties.getUsername(),
            "password", authProperties.getPassword()
        );

        return webClientBuilder.build()
            .post()
            .uri(authProperties.getUrl())
            .bodyValue(body)
            .retrieve()
            .bodyToMono(Map.class)
            .map(response -> (String) response.get("access_token"))
            .block();
    }
}
