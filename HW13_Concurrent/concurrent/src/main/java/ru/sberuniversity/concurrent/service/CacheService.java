package ru.sberuniversity.concurrent.service;

import ru.sberuniversity.concurrent.proxy.ArgsKey;

public interface CacheService {
    ArgsKey getValueArgs(Object[] args);

    Object get(Object[] args);

    void put(Object[] args, Object value);

    boolean contains(Object[] args);
}
