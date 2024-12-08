package ru.sberuniversity.exception;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ReadContent readContent = new ReadContent();
        while (true) {
            System.out.println("Введите URL:");
            String input = new Scanner(System.in).nextLine();
            readContent.readContent(input);
        }
    }
}