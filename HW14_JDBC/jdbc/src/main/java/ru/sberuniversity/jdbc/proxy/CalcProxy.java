package ru.sberuniversity.jdbc.proxy;

import ru.sberuniversity.jdbc.dao.CalcFibonacciDAO;
import ru.sberuniversity.jdbc.entity.EntityDTO;

import static java.lang.reflect.Proxy.newProxyInstance;

public class CalcProxy {

    @SuppressWarnings("unchecked")
    public <T> T cache(T fibonacci, CalcFibonacciDAO<EntityDTO> fibonacciDAO) {
        return (T) newProxyInstance(
                fibonacci.getClass().getClassLoader(),
                fibonacci.getClass().getInterfaces(),
                new CalcInvocationHandler(fibonacci, fibonacciDAO)
        );
    }
}
