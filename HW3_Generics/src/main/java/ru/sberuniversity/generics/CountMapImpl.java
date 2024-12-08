package ru.sberuniversity.generics;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T> {
    private Map<T, Integer> container = new HashMap<>();

    @Override
    public void add(T o) {
        Integer value = container.get(o);
        if (value == null) {
            container.put(o, 1);
        } else {
            container.put(o, ++value);
        }
    }

    @Override
    public int getCount(T o) {
        return container.get(o);
    }

    @Override
    public int remove(T o) {
        Integer value = container.get(o);
        if (value != null) {
            value = container.get(o);
            container.remove(o);
            return value;
        }
        return 0;
    }

    @Override
    public int size() {
        return container.size();
    }

    @Override
    public void addAll(CountMap<T> source) {
        for (Map.Entry<T, Integer> entry : source.toMap().entrySet()) {
            container.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
    }

    @Override
    public Map<T, Integer> toMap() {
        return container;
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        destination.putAll(container);
    }
}
