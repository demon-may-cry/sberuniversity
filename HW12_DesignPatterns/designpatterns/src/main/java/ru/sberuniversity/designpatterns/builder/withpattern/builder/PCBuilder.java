package ru.sberuniversity.designpatterns.builder.withpattern.builder;

import ru.sberuniversity.designpatterns.builder.withpattern.PC;
import ru.sberuniversity.designpatterns.builder.withpattern.components.*;

public class PCBuilder {
    private PC pc;

    public PCBuilder createPC() {
        this.pc = new PC();
        return this;
    }

    public PCBuilder addVendor(String vendor) {
        pc.setVendor(vendor);
        return this;
    }

    public PCBuilder addName(String name) {
        pc.setName(name);
        return this;
    }

    public PCBuilder addCPU(ComponentCPU cpu) {
        pc.setCpu(cpu);
        return this;
    }

    public PCBuilder addRam(ComponentRAM ram) {
        pc.setRam(ram);
        return this;
    }

    public PCBuilder addStorageDevice(ComponentStorage storageDevice) {
        pc.setStorage(storageDevice);
        return this;
    }

    public PCBuilder addScreen(ComponentScreen screen) {
        pc.setScreen(screen);
        return this;
    }

    public PCBuilder addKeyboard(ComponentKeyboard keyboard) {
        pc.setKeyboard(keyboard);
        return this;
    }

    public PC build() {
        return this.pc;
    }
}
