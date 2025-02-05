package ru.sberuniversity.designpatterns.builder.withpattern.builder;

import ru.sberuniversity.designpatterns.builder.withpattern.components.ComponentStorage;
import ru.sberuniversity.designpatterns.builder.withpattern.enums.e_storage.EnumTypeStorage;

public class StorageBuilder {
    private ComponentStorage componentStorage;
    public StorageBuilder createStorage() {
        this.componentStorage = new ComponentStorage();
        return this;
    }

    public StorageBuilder setTypeStorage(EnumTypeStorage typeStorage) {
        this.componentStorage.setTypeStorage(typeStorage);
        return this;
    }

    public StorageBuilder setVolumeStorage(int volumeStorage) {
        this.componentStorage.setVolumeStorage(volumeStorage);
        return this;
    }

    public StorageBuilder setWeightStorage(double weightStorage) {
        this.componentStorage.setWeightStorage(weightStorage);
        return this;
    }

    public ComponentStorage build() {
        return this.componentStorage;
    }
}
