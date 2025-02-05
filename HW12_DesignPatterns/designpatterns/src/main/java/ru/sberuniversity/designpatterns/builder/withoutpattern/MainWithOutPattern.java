package ru.sberuniversity.designpatterns.builder.withoutpattern;

public class MainWithOutPattern {
    public static void main(String[] args) {
        System.out.println("***Без паттерна Builder***");

        Computer computer = new Computer("Hewlett-Packard",
                "Тебя я видел во сне",
                new CPU(CPU.Cores.SIXTEEN.getCores(),
                        CPU.Manufacturer.INTEL,
                        CPU.Frequency.FOUR_POINT_FOUR.getFrequency(),
                        0.553),
                new RAM(RAM.TypeRAM.DDR5,
                        RAM.VolumeRAM.ONE_HUNDRED_AND_TWENTY_EIGHT.getVolumeRAM(),
                        0.036),
                new StorageDevice(StorageDevice.TypeStorage.SSD,
                        20000,
                        0.690),
                new Screen(49,
                        Screen.TypeScreen.VA,
                        14.4),
                new Keyboard(Keyboard.TypeKeyboard.OPTO_MECHANICAL.getTypeKeyboard(),
                        Keyboard.BackLight.YES.getBackLight(),
                        1.156));

        System.out.println(computer);
    }
}
