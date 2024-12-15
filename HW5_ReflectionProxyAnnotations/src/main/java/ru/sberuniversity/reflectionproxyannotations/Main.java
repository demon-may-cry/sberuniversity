package ru.sberuniversity.reflectionproxyannotations;

import ru.sberuniversity.reflectionproxyannotations.beanutils.BeanUtils;
import ru.sberuniversity.reflectionproxyannotations.beanutils.domain.ObjectFrom;
import ru.sberuniversity.reflectionproxyannotations.beanutils.domain.ObjectTo;
import ru.sberuniversity.reflectionproxyannotations.cachingproxy.CachedInvocationHandler;
import ru.sberuniversity.reflectionproxyannotations.factorialcalculator.Calculator;
import ru.sberuniversity.reflectionproxyannotations.factorialcalculator.CalculatorImpl;
import ru.sberuniversity.reflectionproxyannotations.performanceproxy.PerformanceInvocationHandler;
import ru.sberuniversity.reflectionproxyannotations.reflection.Reflection;
import ru.sberuniversity.reflectionproxyannotations.reflection.getters.Person;
import ru.sberuniversity.reflectionproxyannotations.reflection.inheritance.ClassB;
import ru.sberuniversity.reflectionproxyannotations.reflection.weekday.Weekday;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Calculator calculator = new CalculatorImpl();
        Calculator delegate = new CalculatorImpl();
        Reflection reflection = new Reflection();
        BeanUtils beanUtils = new BeanUtils();

        System.out.println("Расчет факториала числа");
        System.out.println(calculator.calc(5));

        System.out.println("\nВсе методы класса, включая все родительские методы (включая приватные)");
        reflection.getMethods(ClassB.class);

        System.out.println("\nВсе геттеры класса");
        reflection.getMethodsGetters(Person.class);

        System.out.println("\nВсе String константы имеют значение = их имени");
        reflection.checkConstantsValueEqualName(Weekday.class);

        System.out.println("\nКэшированный прокси");
        Calculator calcCache = (Calculator) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new CachedInvocationHandler(delegate));
        runCalcCache(calcCache);

        System.out.println("\nАннотация Metric");
        Calculator calcMetric = (Calculator) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new PerformanceInvocationHandler(delegate));
        runCalcMetric(calcMetric, 10);

        System.out.println("\nРеализация класса BeanUtils");
        ObjectFrom from = new ObjectFrom("Ростов-на-Дону", "Большая Садовая", 21, 34, "Иванов");
        ObjectTo to = new ObjectTo("Ростов-на-Дону", "Красноармейская", 101, 5, "Петров");
        beanUtils.assign(from, to);
    }

    private static void runCalcMetric(Calculator calcMetric, int count) {
        for (int i = 0; i <= count; i++) {
            System.out.println(calcMetric.calc(i));
        }
    }

    private static void runCalcCache(Calculator calculator) {
        System.out.println(calculator.calc(0));
        System.out.println(calculator.calc(2));
        System.out.println(calculator.calc(0));
        System.out.println(calculator.calc(4));
        System.out.println(calculator.calc(0));
        System.out.println(calculator.calc(2));
        System.out.println(calculator.calc(0));
    }
}