package ru.sberuniversity.concurrent.proxy;

import java.util.concurrent.locks.ReentrantLock;

import static java.lang.reflect.Proxy.newProxyInstance;

public class CacheProxy {

    @SuppressWarnings("unchecked")
    public <T> T cache(T service, ReentrantLock lock) {
        return (T) newProxyInstance(
                service.getClass().getClassLoader(),
                service.getClass().getInterfaces(),
                new CacheInvocationHandler(service, lock)
        );
    }
}
