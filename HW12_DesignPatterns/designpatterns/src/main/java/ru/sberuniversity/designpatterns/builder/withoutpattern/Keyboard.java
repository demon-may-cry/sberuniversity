package ru.sberuniversity.designpatterns.builder.withoutpattern;

public class Keyboard {
    public enum TypeKeyboard {
        ANALOGUE_OPTICAL("Аналоговая оптическая"),
        MEMBRANE("Мембранная"),
        MECHANICAL("Механическая"),
        SCISSOR("Ножничная"),
        OPTO_MECHANICAL("Оптомеханическая"),
        PLUG("Плунжерная"),
        UNKNOWN("Неизвестно");

        private final String typeKeyboard;

        TypeKeyboard(String typeKeyboard) {
            this.typeKeyboard = typeKeyboard;
        }

        public String getTypeKeyboard() {
            return typeKeyboard;
        }
    }

    public enum BackLight {
        YES("Есть"),
        NO("Нет"),
        UNKNOWN("Неизвестно");

        private final String backLight;

        BackLight(String backLight) {
            this.backLight = backLight;
        }

        public String getBackLight() {
            return backLight;
        }
    }

    private final String typeKeyboard;
    private final String backLight;
    public final double weightKeyboard;

    public Keyboard(String typeKeyboard, String backLight, double weightKeyboard) {
        this.typeKeyboard = typeKeyboard;
        this.backLight = backLight;
        this.weightKeyboard = weightKeyboard;
    }

    public String toStringKeyboard() {
        return "\nКлавиатура:\n" +
                "Тип: " + typeKeyboard + "\n" +
                "Подсветка: " + backLight + "\n" +
                "Вес: " + weightKeyboard + " кг\n";

    }
}