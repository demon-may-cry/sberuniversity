package ru.sberuniversity.designpatterns.chain.withoutpattern;

import java.util.Scanner;

public class PhoneCleanerRegex {

  public static void main(String[] args) {
    System.out.println("***Без паттерна Chain of Responsibility***");

    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("Введите номер телефона (для выхода введите 0): 79123456789");
      String input = scanner.nextLine();
      if (input.equals("0")) {
        scanner.close();
        break;
      }

      String regexPhone = "[^0-9]";
      input = input.replaceAll(regexPhone,"");
      if (input.length() <= 9 || input.length() > 11) {
        System.out.println("Неверный формат номера");
        scanner.close();
        break;
      } else if (input.length() == 10){
        input = "7" + input;
      }
      String codeCountry = input.substring(0, 1);
      if (!codeCountry.equals("7") && !codeCountry.equals("8")){
        System.out.println("Неверный формат номера");
        scanner.close();
        break;
      } else if (codeCountry.equals("8")){
        input = input.replaceFirst("8","7");
      }
      System.out.println(input);
    }
  }

}
