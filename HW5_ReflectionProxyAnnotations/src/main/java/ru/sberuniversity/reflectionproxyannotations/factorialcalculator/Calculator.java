package ru.sberuniversity.reflectionproxyannotations.factorialcalculator;

import ru.sberuniversity.reflectionproxyannotations.cachingproxy.Cache;
import ru.sberuniversity.reflectionproxyannotations.performanceproxy.Metric;

public interface Calculator {
    /**
     * Расчет факториала числа.
     * @param number число для расчёта факториала
     */
    @Cache
    @Metric
    int calc (int number);
}
