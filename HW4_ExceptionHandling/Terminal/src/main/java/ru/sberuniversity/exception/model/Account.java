package ru.sberuniversity.exception.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Account {
    private int balance;
    private final String name;
    private final String pinCode;
    private boolean isBlock;

    public Account(String pinCode) {
        this.pinCode = pinCode;
        this.name = System.getProperty("user.name");
        this.balance = new Random().nextInt(100) * 100;
    }
}
