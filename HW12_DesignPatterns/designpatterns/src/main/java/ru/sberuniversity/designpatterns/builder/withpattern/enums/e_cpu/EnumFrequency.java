package ru.sberuniversity.designpatterns.builder.withpattern.enums.e_cpu;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumFrequency {
    ZERO(0.0),
    TWO_POINT_TWO(2.2),
    TWO_POINT_FOUR(2.4),
    TWO_POINT_SIX(2.6),
    TWO_POINT_EIGHT(2.8),
    THREE(3.0),
    THREE_POINT_TWO(3.2),
    THREE_POINT_FOUR(3.4),
    THREE_POINT_SIX(3.6),
    THREE_POINT_EIGHT(3.8),
    FOUR(4.0),
    FOUR_POINT_TWO(4.2),
    FOUR_POINT_FOUR(4.4);

    private final double frequency;
}
