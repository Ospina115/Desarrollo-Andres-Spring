package com.cajasan.practicante.service;

import com.cajasan.practicante.model.ExampleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Service
public class OracleQueryService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ExampleModel> getExampleModels() {
        String sql = "SELECT id, name, description FROM example_table"; // Reemplazar con la tabla real
        try {
            return jdbcTemplate.query(sql, (rs, rowNum) -> new ExampleModel(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("description")
            ));
        } catch (DataAccessException e) {
            // Manejo de excepciones
            throw new RuntimeException("Error al realizar la consulta a la base de datos", e);
        }
    }
}