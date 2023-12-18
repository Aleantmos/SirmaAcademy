package com.exam.pairidentifier.init;

import com.exam.pairidentifier.io.CustomReader;
import com.exam.pairidentifier.io.impl.SqlScriptReader;
import com.exam.pairidentifier.util.MyConstants;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.*;
import java.util.List;

import static com.exam.pairidentifier.util.MyConstants.DATABASE_NAME;
import static com.exam.pairidentifier.util.MyConstants.GET_DB_COUNT_WITH_DB_NAME;

@Component
public class InitDB implements CommandLineRunner {

    //todo -> hide credentials
    @Override
    public void run(String... args) {
        if (checkIfDatabaseExists()) {
            CustomReader scriptReader = new SqlScriptReader();


            List<? extends Serializable> commands =
                    getScriptCCommands(scriptReader);

            initDatabase();


            initTables(commands);
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

    private static List<? extends Serializable> getScriptCCommands(CustomReader scriptReader) {
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

    private void initTables(List<? extends Serializable> commands) {
        try (Connection connection = DatabaseConnectionManager.getDBConnection("personal")) {
            for (Serializable command : commands) {
                String strCommand = command.toString();
                Statement statement = connection.createStatement();
                statement.executeUpdate(strCommand);
            }
        } catch (SQLException e) {
            //todo exception handle
            throw new RuntimeException(e);
        }
    }

}
