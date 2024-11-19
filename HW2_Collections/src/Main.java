import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> unique = new HashMap<>();
        String[] array = new String[]{"Milk", "Eggs", "Apple", "Banana", "Potato", "Carrot", "Beet", "Cabbage", "Apple",
                "Orange", "Banana", "Bread", "Rice", "Apple", "Apple", "Tea", "Cheese", "Chocolate", "Coffee", "Tea"};

        for (String s : array) {
            unique.putIfAbsent(s, 0);
            unique.put(s, unique.get(s) + 1);
        }

        unique.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }
}