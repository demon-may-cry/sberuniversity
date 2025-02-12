package ru.sberuniversity.jdbc.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.PropertyConfigurator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
public class DriverPostgreSQL {
    private final static String sqlCheckDB = "SELECT FROM pg_database WHERE datname = 'fibonacci'";
    private final static String sqlCheckTable = "SELECT FROM information_schema.tables WHERE table_name = 'fibonacci_sequnce'";
    private final static String sqlCreateDB = "CREATE DATABASE fibonacci";
    private final static String sqlCreateTable = "CREATE TABLE IF NOT EXISTS fibonacci_sequnce (id SERIAL PRIMARY KEY" +
            ", number INTEGER" +
            ", sequence TEXT" +
            ", sum INTEGER)";

    public DriverPostgreSQL() {
        PropertyConfigurator.configure(LogProperties.LOG_PROPERTIES_FILE);
        try {
            Class.forName("org.postgresql.Driver");
            var connection = DriverManager.getConnection(
                    DataDB.DB_URL,
                    DataDB.DB_USER,
                    DataDB.DB_PASSWORD
            );
            Statement statement = connection.createStatement();
            if (checkExist(statement, sqlCheckDB)) {
                statement.execute(sqlCreateDB);
                log.info("Database created successfully");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    public Connection connection() {
        PropertyConfigurator.configure(LogProperties.LOG_PROPERTIES_FILE);
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    DataDB.DB_URL + DataDB.DB_NAME,
                    DataDB.DB_USER,
                    DataDB.DB_PASSWORD
            );
            log.info("Database connection established successfully");
            Statement statement = connection.createStatement();
            if (checkExist(statement, sqlCheckTable)) {
                statement.execute(sqlCreateTable);
                log.info("Table created successfully");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(System.err);
        }
        return connection;
    }

    private boolean checkExist(Statement statement, String sqlCheck) throws SQLException {
        return statement != null && !statement.executeQuery(sqlCheck).next();
    }
}
