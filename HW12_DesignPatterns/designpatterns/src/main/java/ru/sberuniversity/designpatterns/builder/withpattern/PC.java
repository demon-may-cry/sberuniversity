package ru.sberuniversity.designpatterns.builder.withpattern;


import lombok.Setter;
import ru.sberuniversity.designpatterns.builder.withpattern.components.*;

@Setter
public class PC {
    private String vendor;
    private String name;
    private ComponentCPU cpu;
    private ComponentRAM ram;
    private ComponentStorage storage;
    private ComponentScreen screen;
    private ComponentKeyboard keyboard;

    @Override
    public String toString() {
        return "PC {" +
                "\nПроизводитель: " + vendor +
                "\nНаименование : " + name + "\n" +
                cpu.getInfoCPU() +
                ram.getInfoRAM() +
                storage.getInfoStorage() +
                screen.getInfoScreen() +
                keyboard.getInfoKeyboard() +
                "\nСуммарный вес комплектующих: " + getWeightComputer() + " кг\n}";
    }

    private double getWeightComputer() {
        return cpu.getWeightCPU()
                + ram.getWeightRAM()
                + storage.getWeightStorage()
                + screen.getWeightScreen()
                + keyboard.getWeightKeyboard();
    }
}
