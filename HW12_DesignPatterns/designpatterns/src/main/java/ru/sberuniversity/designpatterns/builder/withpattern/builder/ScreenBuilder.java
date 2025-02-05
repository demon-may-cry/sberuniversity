package ru.sberuniversity.designpatterns.builder.withpattern.builder;

import ru.sberuniversity.designpatterns.builder.withpattern.components.ComponentScreen;
import ru.sberuniversity.designpatterns.builder.withpattern.enums.e_screen.EnumTypeScreen;

public class ScreenBuilder {
    private ComponentScreen componentScreen;

    public ScreenBuilder createScreen() {
        this.componentScreen = new ComponentScreen();
        return this;
    }

    public ScreenBuilder setDiagonalScreen(int diagonalScreen) {
        componentScreen.setDiagonalScreen(diagonalScreen);
        return this;
    }

    public ScreenBuilder setTypeScreen(EnumTypeScreen typeScreen) {
        componentScreen.setTypeScreen(typeScreen);
        return this;
    }

    public ScreenBuilder setWeightScreen(double weightScreen) {
        componentScreen.setWeightScreen(weightScreen);
        return this;
    }

    public ComponentScreen build() {
        return this.componentScreen;
    }
}
