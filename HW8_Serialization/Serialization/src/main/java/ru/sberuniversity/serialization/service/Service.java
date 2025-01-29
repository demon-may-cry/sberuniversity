package ru.sberuniversity.serialization.service;

import ru.sberuniversity.serialization.annotation.Cache;

import java.util.List;

import static ru.sberuniversity.serialization.annotation.CacheType.FILE;
import static ru.sberuniversity.serialization.annotation.CacheType.MEMORY;

public interface Service {

    @Cache(cacheType = MEMORY, identityBy = 0, fileNamePrefix = "hardWork")
    void doHardWork (Object item, Object value) throws InterruptedException;

    @Cache(cacheType = FILE, identityBy = 1, limit = 100, fileNamePrefix = "runWork", zip = true)
    List<String> run (String item, int size);

}
