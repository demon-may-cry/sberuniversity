package ru.sberuniversity.generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<T> source, T t) {
        return source.indexOf(t);
    }

    public static <T> List<T> limit(List<T> source, int size) {
        return source.stream().limit(size).collect(Collectors.toList());
    }

    public static <T> void add(List<T> source, T t) {
        source.add(t);
    }

    public static <T> void removeAll(List<T> removeFrom, List<T> c2) {
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<T> c1, List<T> c2) {
        return new HashSet<>(c1).containsAll(c2);
    }

    public static <T> boolean containsAny(List<T> c1, List<T> c2) {
        return c1.stream().anyMatch(c2::contains);
    }

    public static <T extends Comparable<? super T>> List<T> range(List<? extends T> list, T min, T max) {
        List<T> arrayList = new ArrayList<>();
        for (T e : list) {
            if (e.compareTo(min) >= 0 && e.compareTo(max) <= 0) {
                arrayList.add(e);
            }
        }
        return arrayList;
    }

    public static <T> List<T> range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
        List<T> arrayList = new ArrayList<>();
        for (T e : list) {
            if (comparator.compare(e, min) >= 0 && comparator.compare(e, max) <= 0) {
                arrayList.add(e);
            }
        }
        arrayList.sort(comparator);
        return arrayList;
    }
}
