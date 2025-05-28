package com.cajasan.demo.repository;

import com.cajasan.demo.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProcedimientoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Cliente> ejecutarProcedimiento(int parametro) {
        String call = "BEGIN PROCEDIMIENTO_CLIENTES(?, ?); END;";
        return jdbcTemplate.query(con -> {
            var cs = con.prepareCall(call);
            cs.setInt(1, parametro);
            cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
            return cs;
        }, (rs, rowNum) -> new Cliente(
                rs.getInt("ID"),
                rs.getString("NOMBRE"),
                rs.getString("EMAIL")
        ));
    }
}
