package com.cajasan.practicante.repository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("SELECT c FROM Cliente c WHERE c.estado = 'ACTIVO'")
    List<Cliente> findClientesActivos();
}