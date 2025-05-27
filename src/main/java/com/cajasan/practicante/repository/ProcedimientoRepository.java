package com.cajasan.practicante.repository;

@Repository
public class ProcedimientoRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Map<String, Object>> ejecutarProcedimiento(String param1) {
        return jdbcTemplate.queryForList("CALL NOMBRE_PROCEDIMIENTO(?)", param1);
    }
}