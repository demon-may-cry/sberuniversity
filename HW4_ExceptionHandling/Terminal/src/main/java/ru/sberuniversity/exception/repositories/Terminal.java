package ru.sberuniversity.exception.repositories;

import ru.sberuniversity.exception.exception.NotEnoughMoney;
import ru.sberuniversity.exception.model.Account;

public interface Terminal {
    void getBalance(Account account);
    void depositAccount(Account account);
    void withdrawAccount(Account account) throws NotEnoughMoney;
}
