package ru.sberuniversity.designpatterns.builder.withpattern.components;

import lombok.Getter;
import lombok.Setter;
import ru.sberuniversity.designpatterns.builder.withpattern.enums.e_screen.EnumTypeScreen;

@Setter
@Getter
public class ComponentScreen {
    private int diagonalScreen;
    private EnumTypeScreen typeScreen;
    public double weightScreen;

    public String getInfoScreen() {
        return "\nЭкран:\n" +
                "Диагональ: " + diagonalScreen + " дюйм\n" +
                "Тип матрицы: " + typeScreen + "\n" +
                "Вес: " + weightScreen + " кг\n";
    }
}
