package ru.sberuniversity.serialization.service;

import ru.sberuniversity.serialization.annotation.Cache;

import java.lang.reflect.Method;

public class CacheFabric {
    public CacheService createManager(Cache cache, Method method) {
        switch (cache.cacheType()) {
            case MEMORY -> {
                return new CacheMemoryServiceImpl(cache.identityBy());
            }
            case FILE -> {
                return new CacheFileServiceImpl(cache.identityBy(), method, cache.zip());
            }
            default -> {
                return null;
            }
        }
    }
}
