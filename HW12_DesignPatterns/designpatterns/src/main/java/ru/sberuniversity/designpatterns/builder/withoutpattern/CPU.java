package ru.sberuniversity.designpatterns.builder.withoutpattern;

public class CPU {
    public enum Cores {
        ZERO(0),
        TWO(2),
        FOUR(4),
        SIX(6),
        EIGHT(8),
        TEN(10),
        TWELVE(12),
        SIXTEEN(16);

        private final int cores;

        Cores(int cores) {
            this.cores = cores;
        }

        public int getCores() {
            return cores;
        }
    }

    public enum Frequency {
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

        Frequency(double frequency) {
            this.frequency = frequency;
        }

        public double getFrequency() {
            return frequency;
        }
    }

    public enum Manufacturer {
        INTEL,
        AMD,
        UNKNOWN;
    }

    private final int cores;
    private final Manufacturer manufacturer;
    private final double frequency;
    public final double weightCPU;

    public CPU(int cores, Manufacturer manufacturer, double frequency, double weightCPU) {
        this.cores = cores;
        this.manufacturer = manufacturer;
        this.frequency = frequency;
        this.weightCPU = weightCPU;
    }

    public String toStringCPU() {
        return "\nПроцессор:\n" +
                "Частота: " + frequency + " ГГц\n" +
                "Количество ядер: " + cores + "\n" +
                "Производитель: " + manufacturer + "\n" +
                "Вес: " + weightCPU + " кг\n";
    }
}