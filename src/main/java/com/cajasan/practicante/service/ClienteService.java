package com.cajasan.practicante.service;

@Service
public class ClienteService {
    private final ClienteRepository repository;
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }
    public List<Cliente> getClientesActivos() {
        return repository.findClientesActivos();
    }
}
