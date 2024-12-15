package ru.sberuniversity.reflectionproxyannotations.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {

    public void getMethods(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        Method[] methodsParent = clazz.getSuperclass().getDeclaredMethods();
        for (Method m : methods) {
            System.out.printf("Метод класса %s -> %s\n", clazz.getSimpleName(), m.getName());

        }
        for (Method m : methodsParent) {
            System.out.printf("Метод родительского класса %s -> %s\n", clazz.getSuperclass().getSimpleName(), m.getName());
        }
    }

    public void getMethodsGetters(Class<?> clazz) {
        Method[] methodsGet = clazz.getDeclaredMethods();
        for (Method m : methodsGet) {
            if (m.getName().startsWith("get")) {
                System.out.printf("Getter класса %s -> %s\n", clazz.getSimpleName(), m.getName());
            }
        }
    }

    public void checkConstantsValueEqualName(Class<?> clazz) throws IllegalAccessException {
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            String name = f.getName();
            Object value = f.get(null);
            if (name.equals(value)) {
                System.out.printf("Константа %s имеет значение %s = его имени\n", name, value);
            }
        }
    }
}
