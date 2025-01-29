package ru.sberuniversity.serialization.service;

import ru.sberuniversity.serialization.proxy.ArgsKey;

import java.util.HashMap;
import java.util.Map;

public class CacheMemoryServiceImpl implements CacheService {
    private final Map<ArgsKey, Object> argsMap;
    private final int countArgs;

    public CacheMemoryServiceImpl(int countArgs) {
        this.countArgs = countArgs;
        argsMap = new HashMap<>();
    }

    @Override
    public ArgsKey getValueArgs(Object[] args) {
        return switch (countArgs) {
            case 1 -> new ArgsKey(new Object[]{args[0]});
            case 2 -> new ArgsKey(new Object[]{args[1]});
            default -> new ArgsKey(args);
        };
    }

    @Override
    public Object get(Object[] args) {
        return getValueArgs(args).getArgs();
    }

    @Override
    public void put(Object[] args, Object value) {
        if (countArgs == 0) {
            argsMap.put(getValueArgs(args), args[1]);
        } else {
            argsMap.put(getValueArgs(args), value);
        }
    }

    @Override
    public boolean contains(Object[] args) {
        return argsMap.containsKey(getValueArgs(args));
    }
}
