package com.exam.pairidentifier.init.db;

import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.exam.pairidentifier.util.MyConstants.PERSONAL_DB_CONNECTION;

@Configuration
public class DatabaseConnectionManager {

    private static Connection connection = null;


    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            initializeConnection();
        }
        return connection;
    }

    private static void initializeConnection() throws SQLException {
        String user = System.getenv("DATABASE_USERNAME");
        String password = System.getenv("DATABASE_PASSWORD");

        connection = DriverManager.getConnection(PERSONAL_DB_CONNECTION, user, password);
    }
}
