package com.cajasan.practicante.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class OracleConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@//<HOST>:<PORT>/<SERVICE_NAME>");
        dataSource.setUsername("<USERNAME>");
        dataSource.setPassword("<PASSWORD>");
        return dataSource;
    }
}