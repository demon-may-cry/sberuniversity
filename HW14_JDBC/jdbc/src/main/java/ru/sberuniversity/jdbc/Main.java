package ru.sberuniversity.jdbc;

import ru.sberuniversity.jdbc.calculator.CalcFibonacci;
import ru.sberuniversity.jdbc.calculator.CalcFibonacciImpl;
import ru.sberuniversity.jdbc.dao.CalcFibonacciDAOImpl;
import ru.sberuniversity.jdbc.proxy.CalcProxy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalcProxy calcProxy = new CalcProxy();
        CalcFibonacci calcFibonacci = calcProxy.cache(new CalcFibonacciImpl(), new CalcFibonacciDAOImpl());

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a number to calculate its Fibonacci sequence (zero (0) deletes all entries):  ");
            int number = input.nextInt();
            System.out.println("Fibonacci sequence for " + number + ": " + calcFibonacci.fibonacci(number));
        }
    }
}