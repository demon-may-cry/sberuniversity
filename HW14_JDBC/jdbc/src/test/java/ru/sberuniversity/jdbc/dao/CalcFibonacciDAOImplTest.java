package ru.sberuniversity.jdbc.dao;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.sberuniversity.jdbc.calculator.CalcFibonacciImpl;
import ru.sberuniversity.jdbc.config.DriverPostgreSQL;
import ru.sberuniversity.jdbc.entity.EntityDTO;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalcFibonacciDAOImplTest {

    DriverPostgreSQL driverPostgreSQL = new DriverPostgreSQL();
    EntityDTO entity;
    CalcFibonacciImpl fibonacci;
    static CalcFibonacciDAOImpl fibonacciDAO;

    @BeforeEach
    void setUp() {
        driverPostgreSQL.connection();
        fibonacci = new CalcFibonacciImpl();
        entity = new EntityDTO();
        fibonacciDAO = new CalcFibonacciDAOImpl();
    }

    @AfterAll
    static void tearDown() {
        fibonacciDAO.deleteAll();
    }

    @Order(1)
    @ParameterizedTest(name = "Test saveDB with number {0} to the database")
    @CsvSource(value = {"5", "10", "15", "20"})
    @DisplayName("Test saveDB")
    void saveDBTest(int value) throws SQLException {
        String expected = "SELECT * FROM fibonacci_sequnce WHERE number = " + value;

        entity.setNumber(value);
        entity.setSequence(fibonacci.fibonacci(value));
        entity.setSum(entity.getSequence().stream().mapToInt(Integer::intValue).sum());
        fibonacciDAO.save(entity);

        boolean actual = driverPostgreSQL.connection().createStatement().execute(expected);

        assertTrue(actual);
    }

    @Order(2)
    @Test
    @DisplayName("Test getByNumber")
    void getByNumber() {
        int number = 10;
        entity.setNumber(number);
        entity.setSequence(fibonacci.fibonacci(number));
        entity.setSum(entity.getSequence().stream().mapToInt(Integer::intValue).sum());
        EntityDTO actual = fibonacciDAO.getByNumber(number);

        assertEquals(entity, actual);
    }

    @Order(3)
    @Test
    @DisplayName("Test getAll")
    void getAllTest() {
        int number = 15;
        List<Integer> actual = fibonacciDAO.getAll();

        assertTrue(actual.contains(number));
    }
}