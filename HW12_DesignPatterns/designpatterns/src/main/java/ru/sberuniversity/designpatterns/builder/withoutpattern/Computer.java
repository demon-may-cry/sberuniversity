package ru.sberuniversity.designpatterns.builder.withoutpattern;

public class Computer {
    private final String vendor;
    private final String name;
    private CPU cpu;
    private RAM ram;
    private StorageDevice storageDevice;
    private Screen screen;
    private Keyboard keyboard;

    public Computer(String vendor,
                    String name,
                    CPU cpu,
                    RAM ram,
                    StorageDevice storageDevice,
                    Screen screen,
                    Keyboard keyboard) {
        this.vendor = vendor;
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.storageDevice = storageDevice;
        this.screen = screen;
        this.keyboard = keyboard;
    }

    public void setCpu (int cores, CPU.Manufacturer manufacturer, double frequency, double weightCPU) {
        this.cpu = new CPU(cores, manufacturer, frequency, weightCPU);
    }

    public void setRam (RAM.TypeRAM typeRAM, int volumeRAM, double weightRAM) {
        this.ram = new RAM(typeRAM, volumeRAM, weightRAM);
    }

    public void setStorageDevice (StorageDevice.TypeStorage typeStorage, int volumeStorage, double weightStorage){
        this.storageDevice = new StorageDevice(typeStorage, volumeStorage, weightStorage);
    }

    public void setScreen(int diagonalScreen, Screen.TypeScreen typeScreen, double weightScreen){
        this.screen = new Screen(diagonalScreen, typeScreen, weightScreen);
    }

    public void setKeyboard(String typeKeyboard, String backLight, double weightKeyboard){
        this.keyboard = new Keyboard(typeKeyboard, backLight, weightKeyboard);
    }

    public double getWeightComputer(){
        return cpu.weightCPU +
                ram.weightRAM +
                storageDevice.weightStorage +
                screen.weightScreen +
                keyboard.weightKeyboard;
    }
    public String toString(){
        return "Производитель: " + vendor + "\n" +
                "Наименование: " + name + "\n" +
                cpu.toStringCPU() +
                ram.toStringRAM() +
                storageDevice.toStringStorage() +
                screen.toStringScreen() +
                keyboard.toStringKeyboard() + "\n" +
                "Суммарный вес комплектующих: " + getWeightComputer() + " кг\n";
    }
}