package com.cajasan.practicante.controller;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService service;
    public ClienteController(ClienteService service) {
        this.service = service;
    }
    @GetMapping("/activos")
    public ResponseEntity<List<Cliente>> getClientesActivos() {
        return ResponseEntity.ok(service.getClientesActivos());
    }
}
