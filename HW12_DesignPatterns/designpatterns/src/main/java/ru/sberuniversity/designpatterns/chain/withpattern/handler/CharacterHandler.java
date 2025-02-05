package ru.sberuniversity.designpatterns.chain.withpattern.handler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CharacterHandler implements Handler{
    private final Handler nextHandler;

    @Override
    public String handle(String input) {
        String regex = "[0-9]+";
        return input.matches(regex) ? nextHandler.handle(input) : "Введён некорректный символ. Укажите номер с помощью цифр 0-9.";
    }
}
