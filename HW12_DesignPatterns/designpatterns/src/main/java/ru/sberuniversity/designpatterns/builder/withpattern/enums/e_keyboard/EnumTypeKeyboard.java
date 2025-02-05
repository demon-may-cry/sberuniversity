package ru.sberuniversity.designpatterns.builder.withpattern.enums.e_keyboard;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumTypeKeyboard {
    ANALOGUE_OPTICAL("Аналоговая оптическая"),
    MEMBRANE("Мембранная"),
    MECHANICAL("Механическая"),
    SCISSOR("Ножничная"),
    OPTO_MECHANICAL("Оптомеханическая"),
    PLUG("Плунжерная"),
    UNKNOWN("Неизвестно");

    private final String typeKeyboard;
}
