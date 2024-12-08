package ru.sberuniversity.exception.service;

import ru.sberuniversity.exception.exception.AccountIsLockedException;
import ru.sberuniversity.exception.model.Account;

import java.util.Scanner;

public class PinValidator {
    Validator validation = new Validator();
    private final static int MAX_ATTEMPT = 3;
    private int FAILS_ATTEMPT = 0;

    public boolean checkPinCode(Account account, TerminalServer server) throws AccountIsLockedException, InterruptedException {
        try {
            while (!account.isBlock()) {
                System.out.println("Пожалуйста, введите пин-код:");
                Scanner scanner = new Scanner(System.in);
                String pin = scanner.nextLine();
                if (validation.checkDigitCharters(pin) && validation.checkNumberCharacters(pin)) {
                    if (server.checkPinCode(pin, account)) {
                        return true;
                    }
                    if (FAILS_ATTEMPT >= MAX_ATTEMPT) {
                        System.err.println("Аккаунт заблокирован!");
                        account.setBlock(true);
                        throw new AccountIsLockedException();
                    } else {
                        System.out.printf("""
                                Введён неправильный пин-код.
                                После ввода 3-х неправильных пин-кодов аккаунт будет заблокирован.
                                Осталось попыток: %d
                                """, (MAX_ATTEMPT - FAILS_ATTEMPT));
                        FAILS_ATTEMPT++;
                    }
                }
            }
        } catch (AccountIsLockedException | InterruptedException ex) {
            int timeBlock = 10_000;
            long start = System.currentTimeMillis();
            while (start + timeBlock > System.currentTimeMillis()) {
                if (new Scanner(System.in).hasNext() && start + timeBlock > System.currentTimeMillis()) {
                    System.err.println("Аккаунт будет разблокирован через " +
                            (((start + timeBlock) - System.currentTimeMillis()) / 1000) +
                            " секунд");
                }
            }
            FAILS_ATTEMPT = 0;
            account.setBlock(false);
            checkPinCode(account, server);
        }
        return true;
    }
}
