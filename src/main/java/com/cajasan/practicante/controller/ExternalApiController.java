package com.cajasan.practicante.controller;

import com.cajasan.practicante.model.ExampleModel;
import com.cajasan.practicante.service.ExternalApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/external")
public class ExternalApiController {

    @Autowired
    private ExternalApiService externalApiService;

    @GetMapping("/data")
    public ResponseEntity<ExampleModel> getExternalData(@RequestHeader("Authorization") String bearerToken) {
        ExampleModel responseData = externalApiService.callExternalApi(bearerToken);
        return ResponseEntity.ok(responseData);
    }
}