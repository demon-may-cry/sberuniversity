package ru.sberuniversity.exception.service;

import ru.sberuniversity.exception.exception.LessZeroException;
import ru.sberuniversity.exception.exception.NotEnoughMoney;
import ru.sberuniversity.exception.model.Account;

public class TerminalServer {
    public boolean checkPinCode(String pinCode, Account account) {
        return pinCode.equals(account.getPinCode());
    }

    public int balance(Account account) {
        return account.getBalance();
    }

    public void withdraw(Account account, Integer withdrawAmount) {
        try {
            if (withdrawAmount <= 0) {
                throw new LessZeroException();
            }
            if (withdrawAmount > account.getBalance()) {
                throw new NotEnoughMoney();
            }
            account.setBalance(account.getBalance() - withdrawAmount);
            System.out.println("-> Со счёта снято " + withdrawAmount + " руб.");
        } catch (NotEnoughMoney ex) {
            System.err.println("Недостаточно средств для снятия. Введите меньшую сумму");
        } catch (LessZeroException ex) {
            System.err.println("Указанная сумма меньше или равна 0");
        }
    }

    public void deposit(Account account, int depositAmount) {
        try {
            if (depositAmount <= 0) {
                throw new LessZeroException();
            } else {
                account.setBalance(account.getBalance() + depositAmount);
                System.out.println("-> Счёт пополнен на сумму " + depositAmount + " руб.");
            }
        } catch (LessZeroException ex) {
            System.err.println("Указанная сумма меньше или равна 0");
        }
    }
}
