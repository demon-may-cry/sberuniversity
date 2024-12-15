package ru.sberuniversity.reflectionproxyannotations.factorialcalculator;

public class CalculatorImpl implements Calculator{

    @Override
    public int calc(int number) {
        if (number < 0) {
            throw new ArithmeticException("Факториал отрицательного числа нельзя вычислить.");
        } if (number == 0) {
            return 0;
        }
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result = result * i;
        }
        return result;
    }
}
