package com.cajasan.demo.controller;

import com.cajasan.demo.model.Cliente;
import com.cajasan.demo.repository.ProcedimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/procedimiento")
public class ProcedimientoController {

    @Autowired
    private ProcedimientoRepository procedimientoRepository;

    @GetMapping("/{param}")
    public List<Cliente> ejecutar(@PathVariable int param) {
        return procedimientoRepository.ejecutarProcedimiento(param);
    }
}
