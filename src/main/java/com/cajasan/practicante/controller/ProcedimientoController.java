package com.cajasan.practicante.controller;

@RestController
@RequestMapping("/api/procedimiento")
public class ProcedimientoController {
    private final ProcedimientoService service;
    public ProcedimientoController(ProcedimientoService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> ejecutar(@RequestParam String param1) {
        return ResponseEntity.ok(service.obtenerDatos(param1));
    }
}