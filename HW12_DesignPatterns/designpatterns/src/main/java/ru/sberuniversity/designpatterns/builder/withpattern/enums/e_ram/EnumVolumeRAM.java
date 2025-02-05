package ru.sberuniversity.designpatterns.builder.withpattern.enums.e_ram;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumVolumeRAM {
    ZERO(0),
    ONE(1),
    TWO(2),
    FOUR(4),
    EIGHT(8),
    SIXTEEN(16),
    THIRTY_TWO(32),
    SIXTY_FOUR(64),
    ONE_HUNDRED_AND_TWENTY_EIGHT(128);

    private final int volumeRAM;
}
