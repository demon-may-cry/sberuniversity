package ru.sberuniversity.jdbc.dao;

import lombok.extern.slf4j.Slf4j;
import ru.sberuniversity.jdbc.config.DriverPostgreSQL;
import ru.sberuniversity.jdbc.entity.EntityDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class CalcFibonacciDAOImpl implements CalcFibonacciDAO<EntityDTO> {
    private static final String SQL_SAVE = "INSERT INTO fibonacci_sequnce (number, sequence, sum) VALUES (?, ?, ?)";
    private static final String SQL_DELETE = "DROP TABLE fibonacci_sequnce";
    private static final String SQL_GET_ALL_NUMBER = "SELECT number FROM fibonacci_sequnce";
    private static final String SQL_GET_BY_NUMBER = "SELECT * FROM fibonacci_sequnce WHERE number =?";

    DriverPostgreSQL driverPostgreSQL;

    public CalcFibonacciDAOImpl() {
        driverPostgreSQL = new DriverPostgreSQL();
        driverPostgreSQL.connection();
    }

    @Override
    public void save(EntityDTO entity) {
        try {
            var prepared = driverPostgreSQL.connection().prepareStatement(SQL_SAVE);
            prepared.setInt(1, entity.getNumber());
            prepared.setString(2, entity.getSequence().toString());
            prepared.setInt(3, entity.getSum());
            prepared.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    @Override
    public EntityDTO getByNumber(int number) {
        EntityDTO entity = new EntityDTO();
        try {
            var prepared = driverPostgreSQL.connection().prepareStatement(SQL_GET_BY_NUMBER);
            prepared.setInt(1, number);
            var resultSet = prepared.executeQuery();
            if (resultSet.next()) {
                entity.setNumber(resultSet.getInt("number"));
                entity.setSequence(Arrays.stream(resultSet
                                .getString("sequence")
                                .replace("[", "")
                                .replace("]", "")
                                .split(",\\s"))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toList()));
                entity.setSum(resultSet.getInt("sum"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            return new EntityDTO();
        }
        return entity;
    }

    @Override
    public List<Integer> getAll() {
        List<Integer> result = new ArrayList<>();
        try {
            var prepared = driverPostgreSQL.connection().prepareStatement(SQL_GET_ALL_NUMBER);
            var resultSet = prepared.executeQuery();
            while (resultSet.next()) {
                result.add(resultSet.getInt("number"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            return new ArrayList<>();
        }
        return result;
    }

    @Override
    public void deleteAll() {
        try {
            driverPostgreSQL.connection().createStatement().executeUpdate(SQL_DELETE);
        } catch (SQLException e) {
            log.error("Error deleting table from the database: {}", e.getMessage());
        }
    }
}
