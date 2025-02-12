package ru.sberuniversity.jdbc.proxy;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.PropertyConfigurator;
import ru.sberuniversity.jdbc.annotation.Cachable;
import ru.sberuniversity.jdbc.dao.CalcFibonacciDAO;
import ru.sberuniversity.jdbc.config.LogProperties;
import ru.sberuniversity.jdbc.entity.EntityDTO;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

@Slf4j
public class CalcInvocationHandler implements InvocationHandler {
    private final EntityDTO entity;
    private final CalcFibonacciDAO<EntityDTO> fibonacciDAO;
    private final Object fibonacci;

    public <T> CalcInvocationHandler(T fibonacci, CalcFibonacciDAO<EntityDTO> fibonacciDAO) {
        this.fibonacci = fibonacci;
        this.fibonacciDAO = fibonacciDAO;
        this.entity = new EntityDTO();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PropertyConfigurator.configure(LogProperties.LOG_PROPERTIES_FILE);
        if (!method.isAnnotationPresent(Cachable.class)) {
            log.info("Method not annotated with @Cachable. The data is not saved to the database");
            return method.invoke(fibonacci, args);
        }
        if ((int) args[0] == 0) {
            fibonacciDAO.deleteAll();
            log.info("Table deleted successfully");
            return null;
        }
        List<Integer> number = fibonacciDAO.getAll();
        if (!number.isEmpty() && number.contains((int) args[0])) {
            log.info("Number {} is exist in database. Fetching data from the database", args[0]);
            return fibonacciDAO.getByNumber((int) args[0]).getSequence();
        }
        log.info("Number {} is not exist in database. Calculating fibonacci sequence", args[0]);
        dataResult((List<Integer>) method.invoke(fibonacci, args), args);
        return method.invoke(fibonacci, args);
    }

    private void dataResult(List<Integer> result, Object[] args) {
        entity.setNumber((int) args[0]);
        entity.setSequence(result);
        entity.setSum(result.stream().mapToInt(Integer::intValue).sum());
        fibonacciDAO.save(entity);
        log.info("Data saved successfully: {}", entity);
    }
}
