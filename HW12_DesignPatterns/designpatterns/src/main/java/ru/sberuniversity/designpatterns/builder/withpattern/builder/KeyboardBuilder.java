package ru.sberuniversity.designpatterns.builder.withpattern.builder;

import ru.sberuniversity.designpatterns.builder.withpattern.components.ComponentKeyboard;

public class KeyboardBuilder {
    private ComponentKeyboard componentKeyboard;

    public KeyboardBuilder createKeyboard() {
        this.componentKeyboard = new ComponentKeyboard();
        return this;
    }

    public KeyboardBuilder setTypeKeyboard(String typeKeyboard) {
        this.componentKeyboard.setTypeKeyboard(typeKeyboard);
        return this;
    }

    public KeyboardBuilder setBacklight(String backlight) {
        this.componentKeyboard.setBackLight(backlight);
        return this;
    }

    public KeyboardBuilder setWeightKeyboard(double weightKeyboard) {
        this.componentKeyboard.setWeightKeyboard(weightKeyboard);
        return this;
    }

    public ComponentKeyboard build() {
        return this.componentKeyboard;
    }
}
