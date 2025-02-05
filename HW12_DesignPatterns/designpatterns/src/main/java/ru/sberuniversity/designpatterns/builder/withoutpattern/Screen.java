package ru.sberuniversity.designpatterns.builder.withoutpattern;

public class Screen {
    public enum TypeScreen {
        IPS,
        TN,
        VA,
        UNKNOWN;
    }

    private final int diagonalScreen;
    private final TypeScreen typeScreen;
    public final double weightScreen;

    public Screen(int diagonalScreen, TypeScreen typeScreen, double weightScreen) {
        this.diagonalScreen = diagonalScreen;
        this.typeScreen = typeScreen;
        this.weightScreen = weightScreen;
    }

    public String toStringScreen() {
        return "\nЭкран:\n" +
                "Диагональ: " + diagonalScreen + " дюйм\n" +
                "Тип матрицы: " + typeScreen + "\n" +
                "Вес: " + weightScreen + " кг\n";
    }
}