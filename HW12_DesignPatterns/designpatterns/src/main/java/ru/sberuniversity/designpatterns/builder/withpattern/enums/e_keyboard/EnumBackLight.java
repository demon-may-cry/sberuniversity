package ru.sberuniversity.designpatterns.builder.withpattern.enums.e_keyboard;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumBackLight {
    YES("Есть"),
    NO("Нет"),
    UNKNOWN("Неизвестно");

    private final String backLight;
}
