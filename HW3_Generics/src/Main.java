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
    }

    private static void printMap(CountMap<Integer> countMap) {
        System.out.println(countMap.toMap());
    }
}