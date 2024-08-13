
package com.proyecto.proytecobd.Classes;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnection {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    public Connection getConnection(String username, String password) throws SQLException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource.getConnection();
    }
}