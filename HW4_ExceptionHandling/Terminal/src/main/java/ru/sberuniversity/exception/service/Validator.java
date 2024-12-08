package ru.sberuniversity.exception.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public boolean checkDigitCharters(String pin) {
        String regexPin = "\\D+";
        Pattern pattern = Pattern.compile(regexPin);
        Matcher matcher = pattern.matcher(pin);
        if (matcher.matches()) {
            System.out.println("Введён нецифровой символ! Введите пин-код на цифровой клавиатуре.");
            return false;
        }
        return true;
    }

    public boolean checkNumberCharacters(String pin) {
        String regexPin = "[0-9]{4}";
        Pattern pattern = Pattern.compile(regexPin);
        Matcher matcher = pattern.matcher(pin);
        if (!matcher.matches()) {
            System.out.println("Пин-код должен состоять из 4-х цифр");
            return false;
        }
        return matcher.matches();
    }
}
