package com.exam.pairidentifier.init.db;

import com.exam.pairidentifier.io.CustomReader;
import com.exam.pairidentifier.io.impl.SqlScriptReader;
import com.exam.pairidentifier.util.MyConstants;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.*;
import java.util.List;

import static com.exam.pairidentifier.util.MyConstants.*;

@Component
public class InitDB {

    //todo -> hide credentials

    public void createDatabase(String... args) {

        if (checkIfDatabaseExists()) {
            initDatabase();
        }

        if (checkIfTablesDoNotExist()) {
            initTables();
        }

    }

    private boolean checkIfTablesDoNotExist() {
        try (Connection connection = DatabaseConnectionManager.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement
                    .executeQuery(String.format(GET_FOR_DB_WITH_NAME_TABLES_COUNT));

            resultSet.next();

            int count = resultSet.getInt(1);

            return count == 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean checkIfDatabaseExists() {

        try (Connection connection = DatabaseConnectionManager.getConnection()) {
            Statement statement = connection.createStatement();


            ResultSet resultSet = statement
                    .executeQuery(String.format(GET_DB_COUNT_WITH_DB_NAME, DATABASE_NAME));

            resultSet.next();
            int count = resultSet.getInt(1);
            return count == 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static List<? extends Serializable> getScriptCommands() {
        CustomReader scriptReader = new SqlScriptReader();

        return scriptReader.read(MyConstants.DB_INIT_SCRIPT_FILE_PATH);
    }

    private void initDatabase() {
        try (Connection connection = DatabaseConnectionManager.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("create database personal");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void initTables() {
        try (Connection connection = DatabaseConnectionManager.getConnection()) {
            List<? extends Serializable> scriptCommands = getScriptCommands();
            for (Serializable command : scriptCommands) {
                String strCommand = command.toString();
                Statement statement = connection.createStatement();
                statement.executeUpdate(strCommand);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
