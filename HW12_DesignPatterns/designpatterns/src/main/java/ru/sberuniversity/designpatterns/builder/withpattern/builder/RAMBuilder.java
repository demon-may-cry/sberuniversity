package ru.sberuniversity.designpatterns.builder.withpattern.builder;

import ru.sberuniversity.designpatterns.builder.withpattern.components.ComponentRAM;
import ru.sberuniversity.designpatterns.builder.withpattern.enums.e_ram.EnumTypeRAM;

public class RAMBuilder {
    private ComponentRAM componentRAM;

    public RAMBuilder createRAM() {
        this.componentRAM = new ComponentRAM();
        return this;
    }

    public RAMBuilder setTypeRAM(EnumTypeRAM typeRAM) {
        this.componentRAM.setTypeRAM(typeRAM);
        return this;
    }

    public RAMBuilder setVolumeRAM(int volumeRAM) {
        this.componentRAM.setVolumeRAM(volumeRAM);
        return this;
    }

    public RAMBuilder setWeightRAM(double weightRAM) {
        this.componentRAM.setWeightRAM(weightRAM);
        return this;
    }

    public ComponentRAM build() {
        return this.componentRAM;
    }
}
