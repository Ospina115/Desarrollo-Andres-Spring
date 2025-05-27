package com.cajasan.practicante.service;

@Service
public class ProcedimientoService {
    private final ProcedimientoRepository repository;
    public ProcedimientoService(ProcedimientoRepository repository) {
        this.repository = repository;
    }
    public List<Map<String, Object>> obtenerDatos(String param1) {
        return repository.ejecutarProcedimiento(param1);
    }
}