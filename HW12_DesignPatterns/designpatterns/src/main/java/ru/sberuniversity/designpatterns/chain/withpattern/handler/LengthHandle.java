package ru.sberuniversity.designpatterns.chain.withpattern.handler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LengthHandle implements Handler{
    private final Handler nextHandler;

    @Override
    public String handle(String input) {
        if (input.length() < 11) {
            return "Номер телефона слишком короткий. Укажите номер с помощью 11 цифр.";
        }
        if (input.length() > 11) {
            return "Номер телефона слишком длинный. Укажите номер с помощью 11 цифр.";
        }
        return nextHandler.handle(input);
    }
}
