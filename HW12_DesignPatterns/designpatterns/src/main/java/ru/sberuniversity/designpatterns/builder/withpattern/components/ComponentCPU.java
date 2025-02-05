package ru.sberuniversity.designpatterns.builder.withpattern.components;

import lombok.Getter;
import lombok.Setter;
import ru.sberuniversity.designpatterns.builder.withpattern.enums.e_cpu.EnumManufacturer;

@Getter
@Setter
public class ComponentCPU {
    private int cores;
    private double frequency;
    private EnumManufacturer manufacturer;
    private double weightCPU;

    public String getInfoCPU() {
        return "\nПроцессор:\n" +
                "Частота: " + frequency + " ГГц\n" +
                "Количество ядер: " + cores + "\n" +
                "Производитель: " + manufacturer + "\n" +
                "Вес: " + weightCPU + " кг\n";
    }
}
