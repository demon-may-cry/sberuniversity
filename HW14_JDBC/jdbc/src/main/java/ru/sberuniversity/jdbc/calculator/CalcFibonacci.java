package ru.sberuniversity.jdbc.calculator;

import ru.sberuniversity.jdbc.annotation.Cachable;

import java.util.List;

public interface CalcFibonacci {

    @Cachable
    List<Integer> fibonacci(int i);
}
