import java.util.*;

public class PhoneBook {
    HashMap<String, String> phoneBook = new HashMap<>();

    public void add(String phone, String name) {
        if (phoneBook.containsKey(phone)) {
            phoneBook.replace(phone, phoneBook.get(phone), name);
        } else {
            phoneBook.put(phone, name);
        }
    }

    public Set<String> get(String name) {
        if (phoneBook.containsValue(name)) {
            Set<String> contactByName = new TreeSet<>();
            List<String> list = new ArrayList<>();
            for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                if (entry.getValue().equals(name)) {
                    list.add(entry.getKey());
                }
            }
            if (!list.isEmpty()) {
                contactByName.add(name + " - " + list);
            }
            return contactByName;
        }
        return null;
    }
}
