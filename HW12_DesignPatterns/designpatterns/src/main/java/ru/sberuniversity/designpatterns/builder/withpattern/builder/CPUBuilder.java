package ru.sberuniversity.designpatterns.builder.withpattern.builder;

import ru.sberuniversity.designpatterns.builder.withpattern.components.ComponentCPU;
import ru.sberuniversity.designpatterns.builder.withpattern.enums.e_cpu.EnumManufacturer;

public class CPUBuilder {
    private ComponentCPU componentCPU;

    public CPUBuilder createCPU() {
        this.componentCPU = new ComponentCPU();
        return this;
    }

    public CPUBuilder addCores(int cores) {
        this.componentCPU.setCores(cores);
        return this;
    }

    public CPUBuilder addManufacturer(EnumManufacturer manufacturer) {
        this.componentCPU.setManufacturer(manufacturer);
        return this;
    }

    public CPUBuilder addFrequency(double frequency) {
        this.componentCPU.setFrequency(frequency);
        return this;
    }

    public CPUBuilder addWeightCPU(double weightCPU) {
        this.componentCPU.setWeightCPU(weightCPU);
        return this;
    }

    public ComponentCPU build() {
        return this.componentCPU;
    }
}
