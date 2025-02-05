package ru.sberuniversity.designpatterns.builder.withoutpattern;

public class RAM {
    public enum TypeRAM {
        DDR2,
        DDR3,
        DDR3L,
        DDR4,
        DDR5,
        UNKNOWN;
    }

    public enum VolumeRAM {
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

        VolumeRAM(int volumeRAM) {
            this.volumeRAM = volumeRAM;
        }

        public int getVolumeRAM() {
            return volumeRAM;
        }
    }

    private final TypeRAM typeRAM;
    private final int volumeRAM;
    public final double weightRAM;

    public RAM(TypeRAM typeRAM, int volumeRAM, double weightRAM) {
        this.typeRAM = typeRAM;
        this.volumeRAM = volumeRAM;
        this.weightRAM = weightRAM;
    }

    public String toStringRAM (){
        return "\nОперативная память:\n" +
                "Тип памяти: " + typeRAM + "\n" +
                "Объём: " + volumeRAM + " ГБ\n" +
                "Вес: " + weightRAM + " кг\n";
    }
}