package ru.sberuniversity.serialization.proxy;

import static java.lang.reflect.Proxy.newProxyInstance;

public class CacheProxy {

    @SuppressWarnings("unchecked")
    public <T> T cache(T service) {
        return (T) newProxyInstance(
                service.getClass().getClassLoader(),
                service.getClass().getInterfaces(),
                new CacheInvocationHandler(service)
        );
    }
}
