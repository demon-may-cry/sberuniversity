package ru.sberuniversity.generics;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CountMap countMap = new CountMapImpl();
        CountMap countMap1 = new CountMapImpl();
        CountMap countMap2 = new CountMapImpl();

        countMap.add(10);
        countMap.add(10);
        countMap.add(5);
        countMap.add(6);
        countMap.add(5);
        countMap.add(10);

        countMap1.add(15);
        countMap1.add(15);
        countMap1.add(12);
        countMap1.add(8);
        countMap1.add(12);
        countMap1.add(15);

        countMap2.add(20);

        System.out.println("Возвращает количество добавлений данного элемента: " + countMap.getCount(10));

        System.out.println("Удаляет элемент из контейнера и возвращает количество его добавлений(до удаления): " + countMap.remove(5));
        System.out.println("Количество разных элементов: ");
        printMap(countMap);

        System.out.println("Добавить все элементы из source в текущий контейнер,при совпадении ключей, суммировать значения: ");
        countMap.addAll(countMap1);
        printMap(countMap);

        System.out.println("Вернуть Map ключ - добавленный элемент, значение - количество его добавлений: ");
        countMap.toMap(countMap2.toMap());
        printMap(countMap2);

        List<Integer> list = CollectionUtils.newArrayList();
        List<Integer> list2 = CollectionUtils.newArrayList();
        List<Integer> list3 = CollectionUtils.newArrayList();

        list.add(1);
        list.add(7);
        list.add(5);
        list.add(3);
        list.add(9);

        list2.add(9);
        list2.add(2);
        list2.add(4);
        list2.add(6);
        list2.add(1);

        list3.add(9);
        list3.add(2);
        list3.add(4);
        list3.add(6);
        list3.add(1);

        System.out.println("Вернуть индекс по значению: " + CollectionUtils.indexOf(list, 7));
        System.out.println("Вернуть значения по лимиту: " + CollectionUtils.limit(list, 3));
        CollectionUtils.removeAll(list, list2);
        System.out.println("Удалить все совпадающие элементы: " + list);
        CollectionUtils.addAll(list3, list);
        System.out.println("Добавить все элементы из одного списка в другой: " + list);
        System.out.println("Вернуть true, если первый лист содержит хотя бы 1 элемент второго: "
                + CollectionUtils.containsAny(list, list2));
        System.out.println("Вернуть true, если первый лист содержит все элементы второго: "
                + CollectionUtils.containsAll(list, list3));
        System.out.println("Вернуть лист, содержащий элементы из входного листа в диапазоне от min до max: "
                + CollectionUtils.range(list, 3, 6));
        System.out.println("Вернуть отсортированный лист, содержащий элементы из входного листа в диапазоне от min до max: "
                + CollectionUtils.range(list, 2, 7, Integer::compareTo));
    }

    private static void printMap(CountMap<Integer> countMap) {
        System.out.println(countMap.toMap());
    }
}