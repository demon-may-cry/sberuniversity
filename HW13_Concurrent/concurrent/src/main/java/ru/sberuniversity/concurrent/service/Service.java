package ru.sberuniversity.concurrent.service;

import ru.sberuniversity.concurrent.annotation.Cache;

import java.util.List;

import static ru.sberuniversity.concurrent.annotation.CacheType.FILE;
import static ru.sberuniversity.concurrent.annotation.CacheType.MEMORY;

public interface Service {

    @Cache(cacheType = MEMORY, identityBy = 0, fileNamePrefix = "hardWork")
    void doHardWork (Object item, Object value) throws InterruptedException;

    @Cache(cacheType = FILE, identityBy = 1, limit = 100, fileNamePrefix = "runWork", zip = true)
    List<String> run (String item, int size);

}
