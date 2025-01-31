package ru.sberuniversity.multithreadingpart1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {

    public List<Integer> generateNumber(int from, int to) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = from; i <= to; i++) {
            numbers.add(random.nextInt(from, to) + 1);
        }
        return numbers;
    }
}
