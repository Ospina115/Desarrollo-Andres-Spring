package com.cajasan.practicante.repository;

import com.cajasan.practicante.model.ExampleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OracleQueryRepository extends JpaRepository<ExampleModel, Long> {
    // Aquí se pueden definir métodos personalizados para consultas específicas si es necesario
}