package com.cajasan.demo.controller;

import com.cajasan.demo.service.ExternalApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/externa")
public class ExternalApiController {

    @Autowired
    private ExternalApiService externalApiService;

    @PostMapping("/empresa")
    public String consultarEmpresa(@RequestBody Map<String, Object> datosEmpresa) {
        return externalApiService.consultarEmpresa(datosEmpresa);
    }
}
