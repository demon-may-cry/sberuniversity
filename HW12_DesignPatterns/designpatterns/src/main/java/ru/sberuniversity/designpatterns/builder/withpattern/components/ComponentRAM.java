package ru.sberuniversity.designpatterns.builder.withpattern.components;

import lombok.Getter;
import lombok.Setter;
import ru.sberuniversity.designpatterns.builder.withpattern.enums.e_ram.EnumTypeRAM;

@Getter
@Setter
public class ComponentRAM {
    private EnumTypeRAM typeRAM;
    private int volumeRAM;
    public double weightRAM;

    public String getInfoRAM(){
        return "\nОперативная память:\n" +
                "Тип памяти: " + typeRAM + "\n" +
                "Объём: " + volumeRAM + " ГБ\n" +
                "Вес: " + weightRAM + " кг\n";
    }
}
