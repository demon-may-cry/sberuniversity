package ru.sberuniversity.designpatterns.builder.withpattern.components;

import lombok.Getter;
import lombok.Setter;
import ru.sberuniversity.designpatterns.builder.withpattern.enums.e_storage.EnumTypeStorage;

@Setter
@Getter
public class ComponentStorage {
    private EnumTypeStorage typeStorage;
    private int volumeStorage;
    public double weightStorage;

    public String getInfoStorage() {
        return "\nНакопитель:\n" +
                "Тип: " + typeStorage + "\n" +
                "Объём: " + volumeStorage + " ГБ\n" +
                "Вес: " + weightStorage + " кг\n";
    }
}
