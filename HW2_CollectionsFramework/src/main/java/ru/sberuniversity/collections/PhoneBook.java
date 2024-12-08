package ru.sberuniversity.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    HashMap<String, List<String>> phoneBook = new HashMap<>();

    public void add(String name, String phone) {
        if (phoneBook.containsKey(name)) {
            List<String> phoneList = phoneBook.get(name);
            phoneList.add(phone);
        } else {
            List<String> phoneList = new ArrayList<>();
            phoneList.add(phone);
            phoneBook.put(name, phoneList);
        }
    }

    public List<String> get(String name) {
        List<String> contactByName = new ArrayList<>();
        if (phoneBook.containsKey(name)) {
            contactByName.add(name + " - " + phoneBook.get(name));
            return contactByName;
        }
        return new ArrayList<>();
    }
}
