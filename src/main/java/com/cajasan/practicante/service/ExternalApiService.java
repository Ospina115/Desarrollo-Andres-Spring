package com.cajasan.practicante.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

@Service
public class ExternalApiService {

    @Value("${external.api.url}")
    private String apiUrl;

    @Value("${external.api.token}")
    private String apiToken;

    private final RestTemplate restTemplate;

    public ExternalApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ExampleModel callExternalApi() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiToken);
        
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        ResponseEntity<ExampleModel> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, ExampleModel.class);
        
        return response.getBody();
    }
}