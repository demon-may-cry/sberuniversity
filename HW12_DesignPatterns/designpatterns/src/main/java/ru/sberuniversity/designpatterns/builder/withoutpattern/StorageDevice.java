package ru.sberuniversity.designpatterns.builder.withoutpattern;

public class StorageDevice {
    public enum TypeStorage {
        HDD,
        SSD,
        UNKNOWN;
    }

    private final TypeStorage typeStorage;
    private final int volumeStorage;
    public final double weightStorage;

    public StorageDevice(TypeStorage typeStorage, int volumeStorage, double weightStorage) {
        this.typeStorage = typeStorage;
        this.volumeStorage = volumeStorage;
        this.weightStorage = weightStorage;
    }

    public String toStringStorage() {
        return "\nНакопитель:\n" +
                "Тип: " + typeStorage + "\n" +
                "Объём: " + volumeStorage + " ГБ\n" +
                "Вес: " + weightStorage + " кг\n";
    }
}