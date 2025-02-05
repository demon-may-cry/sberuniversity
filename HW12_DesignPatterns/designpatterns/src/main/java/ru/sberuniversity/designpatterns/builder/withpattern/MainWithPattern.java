package ru.sberuniversity.designpatterns.builder.withpattern;

import ru.sberuniversity.designpatterns.builder.withpattern.builder.*;
import ru.sberuniversity.designpatterns.builder.withpattern.enums.e_cpu.EnumCores;
import ru.sberuniversity.designpatterns.builder.withpattern.enums.e_cpu.EnumFrequency;
import ru.sberuniversity.designpatterns.builder.withpattern.enums.e_cpu.EnumManufacturer;
import ru.sberuniversity.designpatterns.builder.withpattern.enums.e_keyboard.EnumBackLight;
import ru.sberuniversity.designpatterns.builder.withpattern.enums.e_keyboard.EnumTypeKeyboard;
import ru.sberuniversity.designpatterns.builder.withpattern.enums.e_ram.EnumTypeRAM;
import ru.sberuniversity.designpatterns.builder.withpattern.enums.e_ram.EnumVolumeRAM;
import ru.sberuniversity.designpatterns.builder.withpattern.enums.e_screen.EnumTypeScreen;
import ru.sberuniversity.designpatterns.builder.withpattern.enums.e_storage.EnumTypeStorage;

public class MainWithPattern {
    public static void main(String[] args) {
        System.out.println("***С паттерном Builder***");

        PCBuilder pcBuilder = new PCBuilder();
        CPUBuilder cpuBuilder = new CPUBuilder();
        RAMBuilder ramBuilder = new RAMBuilder();
        StorageBuilder storageBuilder = new StorageBuilder();
        ScreenBuilder screenBuilder = new ScreenBuilder();
        KeyboardBuilder keyboardBuilder = new KeyboardBuilder();

        cpuBuilder
                .createCPU()
                .addCores(EnumCores.SIXTEEN.getCores())
                .addManufacturer(EnumManufacturer.INTEL)
                .addFrequency(EnumFrequency.FOUR_POINT_FOUR.getFrequency())
                .addWeightCPU(0.553);
        ramBuilder
                .createRAM()
                .setTypeRAM(EnumTypeRAM.DDR4)
                .setVolumeRAM(EnumVolumeRAM.ONE_HUNDRED_AND_TWENTY_EIGHT.getVolumeRAM())
                .setWeightRAM(0.036);
        storageBuilder
                .createStorage()
                .setTypeStorage(EnumTypeStorage.SSD)
                .setVolumeStorage(20000)
                .setWeightStorage(0.690);
        screenBuilder
                .createScreen()
                .setDiagonalScreen(49)
                .setTypeScreen(EnumTypeScreen.VA)
                .setWeightScreen(14.4);
        keyboardBuilder
                .createKeyboard()
                .setTypeKeyboard(EnumTypeKeyboard.OPTO_MECHANICAL.getTypeKeyboard())
                .setBacklight(EnumBackLight.YES.getBackLight())
                .setWeightKeyboard(1.156);
        pcBuilder
                .createPC()
                .addVendor("ARDOR")
                .addName("GAMING EVO")
                .addCPU(cpuBuilder.build())
                .addRam(ramBuilder.build())
                .addStorageDevice(storageBuilder.build())
                .addScreen(screenBuilder.build())
                .addKeyboard(keyboardBuilder.build());

        System.out.println(pcBuilder.build().toString());
    }
}
