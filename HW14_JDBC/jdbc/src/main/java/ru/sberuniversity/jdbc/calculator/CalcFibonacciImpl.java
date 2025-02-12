package ru.sberuniversity.jdbc.calculator;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.PropertyConfigurator;
import ru.sberuniversity.jdbc.config.LogProperties;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CalcFibonacciImpl implements CalcFibonacci {

    @Override
    public List<Integer> fibonacci(int i) {
        PropertyConfigurator.configure(LogProperties.LOG_PROPERTIES_FILE);
        if (i < 0) {
            System.err.println("Input must be a positive integer");
            log.error("Input must be a positive integer");
            return List.of();
        }
        List<Integer> fibonacciNumbers = new ArrayList<>();
        fibonacciNumbers.add(0);
        if (i > 0) {
            fibonacciNumbers.add(1);
        }
        for (int j = 2; j <= i; j++) {
            fibonacciNumbers.add(fibonacciNumbers.get(j - 1) + fibonacciNumbers.get(j - 2));
        }
        log.info("Fibonacci sequence up to {}th number: {}", i, fibonacciNumbers);
        return fibonacciNumbers;
    }
}
