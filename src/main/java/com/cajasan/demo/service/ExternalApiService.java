package com.cajasan.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class ExternalApiService {

    @Autowired
    private WebClient webClient;

    @Autowired
    private TokenService tokenService;

    public String consultarEmpresa(Map<String, Object> requestBody) {
        String token = tokenService.getBearerToken();

        return webClient.post()
                .uri("https://wsc.cajasan.com/api/compite360/v1/empresa")
                .header("Authorization", "Bearer " + token)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
