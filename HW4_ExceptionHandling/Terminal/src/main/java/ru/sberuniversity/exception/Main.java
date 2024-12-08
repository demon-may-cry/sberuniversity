package ru.sberuniversity.exception;

import ru.sberuniversity.exception.exception.AccountIsLockedException;
import ru.sberuniversity.exception.model.Account;
import ru.sberuniversity.exception.service.PinValidator;
import ru.sberuniversity.exception.service.TerminalImpl;
import ru.sberuniversity.exception.service.TerminalServer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws AccountIsLockedException, InterruptedException{
        TerminalImpl terminal = new TerminalImpl(new TerminalServer(), new PinValidator());
        Account account = new Account("1234");

        System.out.println("Добро пожаловать в Terminal, " + account.getName());
        while (true) {
            if (terminal.authentication(account)) {
                while (true) {
                    System.out.println("""
                            Выберите действие:
                            1. Показать баланс;
                            2. Снять со счёта;
                            3. Пополнить счёт;
                            4. Выход.""");
                    Scanner scanner = new Scanner(System.in);
                    String input = scanner.nextLine();
                    switch (input) {
                        case ("1"):
                            terminal.getBalance(account);
                            break;
                        case ("2"):
                            terminal.withdrawAccount(account);
                            break;
                        case ("3"):
                            terminal.depositAccount(account);
                            break;
                        case ("4"):
                            System.out.println("До свидания, " + account.getName());
                            System.exit(0);
                        default:
                            System.out.println("Введите номер действия");
                    }
                }
            }
        }
    }
}