package ru.sberuniversity.jdbc.dao;

import java.util.List;
import java.util.Map;

public interface CalcFibonacciDAO<DataDTO> {
    void save(DataDTO entity);
    DataDTO getByNumber(int number);
    List<Integer> getAll();
    void deleteAll();
}
