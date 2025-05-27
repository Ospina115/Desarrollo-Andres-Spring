package com.cajasan.practicante.controller;

import com.cajasan.practicante.model.ExampleModel;
import com.cajasan.practicante.service.OracleQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OracleQueryController {

    @Autowired
    private OracleQueryService oracleQueryService;

    @GetMapping("/api/oracle/query")
    public ResponseEntity<List<ExampleModel>> getExampleModels(@RequestParam String query) {
        List<ExampleModel> results = oracleQueryService.executeQuery(query);
        return ResponseEntity.ok(results);
    }
}