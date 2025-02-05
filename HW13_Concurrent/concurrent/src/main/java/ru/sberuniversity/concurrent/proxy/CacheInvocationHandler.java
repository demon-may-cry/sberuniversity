package ru.sberuniversity.concurrent.proxy;

import ru.sberuniversity.concurrent.annotation.Cache;
import ru.sberuniversity.concurrent.service.CacheFabric;
import ru.sberuniversity.concurrent.service.CacheService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheInvocationHandler implements InvocationHandler {
    private static String keyMame;
    private final Object service;
    private Map<String, CacheService> cacheMap;

    public CacheInvocationHandler(Object service) {
        this.service = service;
        initCacheManagers();
    }

    private void initCacheManagers() {
        CacheFabric cacheFabric = new CacheFabric();
        cacheMap = new HashMap<>();
        for (Class<?> inside : service.getClass().getInterfaces()) {
            for (Method method : inside.getMethods()) {
                if (method.isAnnotationPresent(Cache.class)) {
                    Cache namePrefix = method.getAnnotation(Cache.class);
                    keyMame = namePrefix.fileNamePrefix().isEmpty() ? method.getName() : namePrefix.fileNamePrefix();
                    cacheMap.put(keyMame,
                            cacheFabric.createManager(method.getAnnotation(Cache.class), method));
                }
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        try {
            Cache cache = method.getAnnotation(Cache.class);
            if (cache == null) {
                System.out.println("Выполнение метода без кэширования");
                return method.invoke(service, args);
            }
            CacheService cacheService = cacheMap.get(keyMame);
            if (cacheService.contains(args)) {
                System.out.printf("Значение имеется в памяти/файле %s -> %s\n", keyMame, cacheService.get(args));
                return cacheService.get(args);
            }
            Object result = method.invoke(service, args);
            isList(result, method);
            cacheService.put(args, result);
            System.out.printf("Закэшировано в памяти/файле %s -> %s\n", keyMame, cacheService.get(args));
            return result;
        } catch (ReflectiveOperationException ex) {
            ex.printStackTrace(System.err);
        }
        return null;
    }

    private void isList(Object value, Method method) {
        if (value instanceof List<?> limitList) {
            System.out.println("Использование списка для хранения кэшированных значений");
            limit(method, limitList);
        } else {
            System.out.println("Использование обычного значения для хранения кэшированных значений");
        }
    }

    private void limit(Method method, List<?> list) {
        Cache cache = method.getAnnotation(Cache.class);
        if (cache.limit() == 0) {
            System.out.println("Без ограничения на кэширование");
        } else if (list.size() > cache.limit()) {
            System.out.printf("Ограничение на кэширование: %d\n", cache.limit());
            System.out.println(list.size() - cache.limit() + " значений удалены");
            list.subList(cache.limit(), list.size()).clear();
        }
    }
}
