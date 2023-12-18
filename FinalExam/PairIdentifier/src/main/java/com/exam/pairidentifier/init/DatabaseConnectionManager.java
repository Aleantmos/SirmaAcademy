package com.exam.pairidentifier.init;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConnectionManager {

    private static Connection connection = null;
    private final static String BASE_CONNECTION = "jdbc:postgresql://localhost:5432/";

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            initializeConnection("");
        }
        return connection;
    }

    public static Connection getDBConnection(String dbName) throws SQLException {
        if (connection == null || connection.isClosed()) {
            initializeConnection(dbName);
        }
        return connection;
    }

    private static void initializeConnection(String dbName) throws SQLException {
        String url = BASE_CONNECTION;

        if (!dbName.isBlank()) {
            url += dbName;
        }

        String user = System.getenv("DATABASE_USERNAME");
        String password = System.getenv("DATABASE_PASSWORD");

        connection = DriverManager.getConnection(url, user, password);
    }
}
