package ru.sberuniversity.designpatterns.builder.withpattern.enums.e_cpu;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumCores {
    ZERO(0),
    TWO(2),
    FOUR(4),
    SIX(6),
    EIGHT(8),
    TEN(10),
    TWELVE(12),
    SIXTEEN(16);

    private final int cores;
}
