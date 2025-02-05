package ru.sberuniversity.designpatterns.builder.withpattern.components;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ComponentKeyboard {
    private String typeKeyboard;
    private String backLight;
    public double weightKeyboard;

    public String getInfoKeyboard() {
        return "\nКлавиатура:\n" +
                "Тип: " + typeKeyboard + "\n" +
                "Подсветка: " + backLight + "\n" +
                "Вес: " + weightKeyboard + " кг\n";
    }
}
