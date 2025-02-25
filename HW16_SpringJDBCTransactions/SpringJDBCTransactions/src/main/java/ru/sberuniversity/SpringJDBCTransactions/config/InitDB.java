package ru.sberuniversity.SpringJDBCTransactions.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitDB {
    private final static String SQL_CHECK_DB = "SELECT FROM pg_database WHERE datname = 'recipe_db'";
    private final static String SQL_CREATE_DB = "CREATE DATABASE recipe_db";

    public InitDB() {
        Logger log = LogManager.getLogger(InitDB.class);
        try {
            var connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/",
                    "postgres",
                    "postgres"
            );
            Statement statement = connection.createStatement();
            if (checkExist(statement)) {
                statement.execute(SQL_CREATE_DB);
                log.info("Database created successfully");
            }
            log.info("Database is exist");
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    private boolean checkExist(Statement statement) throws SQLException {
        return statement != null && !statement.executeQuery(InitDB.SQL_CHECK_DB).next();
    }
}
