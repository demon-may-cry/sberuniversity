package ru.sberuniversity.multithreadingpart1;

public class Main {
    private static final String FILE_NAME = "example.txt";
    public static void main(String[] args) {
        FileRandomNumbers fileRandomNumbers = new FileRandomNumbers("");
        NumberGenerator numberGenerator = new NumberGenerator();
        Factorial factorial = new Factorial();

        fileRandomNumbers.createAndWritingFile(FILE_NAME, numberGenerator.generateNumber(1, 50));
        factorial.calculateFactorialInParallel(fileRandomNumbers.readFile(FILE_NAME));
    }
}