package ru.sberuniversity.SpringJDBCTransactions.config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
public class DataSource extends DriverManagerDataSource {

    public DataSource() {
        this.setUrl("jdbc:postgresql://localhost:5432/recipe_db");
        this.setUsername("postgres");
        this.setPassword("postgres");
    }
}
