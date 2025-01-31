package ru.sberuniversity.multithreadingpart1;

import com.google.common.math.BigIntegerMath;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Factorial {

    private BigInteger calculateFactorial(int number) {
        return BigIntegerMath.factorial(number);
    }

    public void calculateFactorialInParallel(List<Integer> number) {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (Integer num : number) {
            executor.submit(() -> System.out.printf("%s : Факториал числа %d -> %d\n",
                    Thread.currentThread().getName(), num, calculateFactorial(num)));
        }
        executor.shutdown();
    }
}
