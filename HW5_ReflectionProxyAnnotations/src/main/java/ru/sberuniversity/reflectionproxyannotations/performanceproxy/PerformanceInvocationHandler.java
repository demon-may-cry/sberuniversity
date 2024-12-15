package ru.sberuniversity.reflectionproxyannotations.performanceproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceInvocationHandler implements InvocationHandler {
    private final Object delegate;

    public PerformanceInvocationHandler(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!method.isAnnotationPresent(Metric.class)) {
            return method.invoke(delegate, args);
        }
        long start = System.nanoTime();
        Object result = method.invoke(delegate, args);
        long end = System.nanoTime();
        System.out.printf("Время работы метода составило %d наносекунд\n", (end - start));
        return result;
    }
}
