package com.exam.pairidentifier.init;

import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConnectionManager {

    private static Connection connection = null;
    private final static String PERSONAL_DB_CONNECTION = "jdbc:postgresql://localhost:5432/personal";

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            initializeConnection();
        }
        return connection;
    }

//    public static Connection getDBConnection(String dbName) throws SQLException {
//        if (connection == null || connection.isClosed()) {
//            initializeConnection(dbName);
//        }
//        return connection;
//    }

    private static void initializeConnection() throws SQLException {
//        String url = BASE_CONNECTION;

//        if (!dbName.isBlank()) {
//            url += dbName;
//        }

        String user = System.getenv("DATABASE_USERNAME");
        String password = System.getenv("DATABASE_PASSWORD");

        connection = DriverManager.getConnection(PERSONAL_DB_CONNECTION, user, password);
    }
}
