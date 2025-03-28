package com.cajasan.practicante.controller;

import com.cajasan.practicante.service.ExternalApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExternalApiController {

    @Autowired
    private ExternalApiService externalApiService;

    @GetMapping("/api/external")
    public ResponseEntity<String> callExternalApi(@RequestParam String token) {
        String url = "https://api.externa.com/endpoint"; // Cambia esto por la URL de la API externa
        String response = externalApiService.callExternalApi(url, token);
        return ResponseEntity.ok(response);
    }
}