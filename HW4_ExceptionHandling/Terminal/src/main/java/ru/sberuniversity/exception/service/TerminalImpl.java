package ru.sberuniversity.exception.service;

import ru.sberuniversity.exception.exception.AccountIsLockedException;
import ru.sberuniversity.exception.model.Account;
import ru.sberuniversity.exception.repositories.Terminal;

import java.util.Scanner;

public class TerminalImpl implements Terminal {
    private final TerminalServer server;
    private final PinValidator pinValidator;
    Validator validation = new Validator();

    public TerminalImpl(TerminalServer server, PinValidator pinValidator) {
        this.server = server;
        this.pinValidator = pinValidator;
    }

    @Override
    public void getBalance(Account account) {
        System.out.println("-> Ваш баланс счёта: " + server.balance(account) + " руб.");
    }

    @Override
    public void depositAccount(Account account) {
        int depositAmount;
        while (true) {
            System.out.println("Введите сумму для пополнения:");
            Scanner scanner = new Scanner(System.in);
            String amount = scanner.nextLine();
            if (validation.checkDigitCharters(amount)) {
                depositAmount = Integer.parseInt(amount);
                if (multiple(depositAmount)) {
                    server.deposit(account, depositAmount);
                    break;
                }
            }
        }
    }

    @Override
    public void withdrawAccount(Account account) {
        int withdrawalAmount;
        while (true) {
            System.out.println("Введите сумму для снятия:");
            Scanner scanner = new Scanner(System.in);
            String amount = scanner.nextLine();
            if (validation.checkDigitCharters(amount)) {
                withdrawalAmount = Integer.parseInt(amount);
                if (multiple(withdrawalAmount)) {
                    server.withdraw(account, withdrawalAmount);
                    break;
                }
            }
        }
    }

    public boolean authentication(Account account) throws AccountIsLockedException, InterruptedException {
        return pinValidator.checkPinCode(account, server);
    }

    private boolean multiple(int amount) {
        if (amount % 100 != 0) {
            System.out.println("Введите сумму кратную 100");
            return false;
        }
        return true;
    }
}
