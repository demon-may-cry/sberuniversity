package ru.sberuniversity.serialization.service;

import ru.sberuniversity.serialization.proxy.ArgsKey;

public interface CacheService {
    ArgsKey getValueArgs(Object[] args);

    Object get(Object[] args);

    void put(Object[] args, Object value);

    boolean contains(Object[] args);
}
