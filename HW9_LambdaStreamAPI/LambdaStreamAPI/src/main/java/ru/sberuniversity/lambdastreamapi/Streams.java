package ru.sberuniversity.lambdastreamapi;

import lombok.AllArgsConstructor;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@AllArgsConstructor
public class Streams <T>{
    private Collection<T> collection;

    public static <T> Streams<T> of(Collection<T> collection) {
        return new Streams<>(collection);
    }

    public Streams<T> filter(Predicate<T> predicate) {
        Predicate<T> filteredPredicate = predicate.and(t -> !Objects.isNull(t));
        return new Streams<>(collection.stream().filter(filteredPredicate).collect(Collectors.toList()));
    }

    public Streams<T> transform(Function<T, T> function) {
        return new Streams<>(collection.stream().map(function).collect(Collectors.toList()));
    }

    public <K, V> Map<K, V> toMap(Function<? super T, ? extends K> keyMapper,
                                  Function<? super T, ? extends V> valueMapper) {
        Map<K, V> resultMap = new HashMap<>();
        collection.forEach(t -> {
            K key = keyMapper.apply(t);
            V value = valueMapper.apply(t);
            resultMap.put(key, value);
        });
        return resultMap;
    }
}
