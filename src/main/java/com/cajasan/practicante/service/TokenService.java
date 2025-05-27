package com.cajasan.practicante.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {

    @Value("${external.auth.url}")
    private String authUrl;

    @Value("${external.auth.username}")
    private String username;

    @Value("${external.auth.password}")
    private String password;

    private String accessToken;
    private long lastFetch = 0;

    public synchronized String getToken() {
        // Si el token es nulo o han pasado más de 14 minutos, renovarlo
        if (accessToken == null || (System.currentTimeMillis() - lastFetch) > (14 * 60 * 1000)) {
            fetchToken();
        }
        return accessToken;
    }

    @Scheduled(fixedDelay = 14 * 60 * 1000)
    public void scheduledTokenRefresh() {
        fetchToken();
    }

    private void fetchToken() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> body = new HashMap<>();
        body.put("username", username);
        body.put("password", password);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(authUrl, entity, Map.class);

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            accessToken = (String) response.getBody().get("access_token");
            lastFetch = System.currentTimeMillis();
        } else {
            throw new RuntimeException("No se pudo obtener el token de autenticación");
        }
    }
}