package com.cajasan.practicante.service;

import com.cajasan.practicante.model.ExampleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Service
public class PlsqlProcedureService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ExampleModel> callPlsqlProcedure(String procedureName, Object... params) {
        return jdbcTemplate.execute(connection -> {
            CallableStatement callableStatement = connection.prepareCall("{call " + procedureName + "(?)}");
            for (int i = 0; i < params.length; i++) {
                callableStatement.setObject(i + 1, params[i]);
            }
            return callableStatement;
        }, (CallableStatement cs) -> {
            cs.execute();
            // Assuming the procedure returns a result set
            return jdbcTemplate.query("SELECT * FROM your_table", new ExampleModelRowMapper());
        });
    }

    private static class ExampleModelRowMapper implements RowMapper<ExampleModel> {
        @Override
        public ExampleModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new ExampleModel(rs.getLong("id"), rs.getString("name"), rs.getString("description"));
        }
    }
}