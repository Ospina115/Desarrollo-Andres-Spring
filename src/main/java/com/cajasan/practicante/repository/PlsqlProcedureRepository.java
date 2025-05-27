package com.cajasan.practicante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlsqlProcedureRepository extends JpaRepository<ExampleModel, Long> {
    // Métodos para llamar a procedimientos PL/SQL se pueden definir aquí
}