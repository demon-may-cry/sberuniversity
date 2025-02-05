package ru.sberuniversity.designpatterns.chain.withpattern;

import ru.sberuniversity.designpatterns.chain.withpattern.handler.*;

import java.util.Scanner;

public class MainWithPattern {
    public static void main(String[] args) {
        System.out.println("***С паттерном Chain of Responsibility***");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите номер телефона (пример: 79123456789):");
            String input = scanner.nextLine();
            Handler handler = new CharacterHandler(new LengthHandle(new CountryHandler()));
            System.out.println(handler.handle(input));
        }
    }
}
