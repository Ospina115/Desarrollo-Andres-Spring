package com.cajasan.practicante.service;

import com.cajasan.practicante.model.EmpresaModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalApiService {

    @Value("${external.api.url}")
    private String apiUrl;

    private final TokenService tokenService;

    public ExternalApiService(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public EmpresaModel getEmpresa() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(tokenService.getToken());
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<EmpresaModel> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                EmpresaModel.class
        );

        return response.getBody();
    }
}