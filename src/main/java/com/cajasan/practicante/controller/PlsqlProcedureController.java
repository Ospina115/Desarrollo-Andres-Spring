package com.cajasan.practicante.controller;

import com.cajasan.practicante.model.ExampleModel;
import com.cajasan.practicante.service.PlsqlProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plsql")
public class PlsqlProcedureController {

    @Autowired
    private PlsqlProcedureService plsqlProcedureService;

    @PostMapping("/call")
    public ResponseEntity<List<ExampleModel>> callPlsqlProcedure(@RequestBody ExampleModel request) {
        try {
            List<ExampleModel> result = plsqlProcedureService.callProcedure(request);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null); // Handle exceptions appropriately
        }
    }
}