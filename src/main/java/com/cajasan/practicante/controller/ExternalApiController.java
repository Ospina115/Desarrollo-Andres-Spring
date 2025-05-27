package com.cajasan.practicante.controller;

import com.cajasan.practicante.model.EmpresaModel;
import com.cajasan.practicante.service.ExternalApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/externa")
public class ExternalApiController {

    @Autowired
    private ExternalApiService externalApiService;

    @GetMapping("/empresa")
    public EmpresaModel getEmpresa() {
        return externalApiService.getEmpresa();
    }
}