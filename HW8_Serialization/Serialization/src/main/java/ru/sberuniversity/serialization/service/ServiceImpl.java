package ru.sberuniversity.serialization.service;

import java.util.ArrayList;
import java.util.List;

public class ServiceImpl implements Service {

    @Override
    public void doHardWork(Object item, Object value) {
        System.out.println(item + " : " + value);
    }

    @Override
    public List<String> run(String item, int size) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(item + " : " + i);
        }
        return list;
    }
}
