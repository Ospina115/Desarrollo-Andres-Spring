package com.cajasan.demo.repository;

import com.cajasan.demo.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Cliente> obtenerClientes() {
        String sql = "SELECT * FROM CLIENTES";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Cliente(
                rs.getInt("ID"),
                rs.getString("NOMBRE"),
                rs.getString("EMAIL")
        ));
    }
}
