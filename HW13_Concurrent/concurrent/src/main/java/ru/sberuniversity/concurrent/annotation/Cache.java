package ru.sberuniversity.concurrent.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Cache {

    /**
     * Тип кэша (файловый или в памяти).
     * <p> По умолчанию в памяти.
     *
     * @return CacheType
     */
    CacheType cacheType() default CacheType.MEMORY;

    /**
     * Префикс имени файла для кэширования.
     * <p>Если не задано - используется имя метода.
     *
     * @return String
     */
    String fileNamePrefix() default "";

    /**
     * Запаковывать данные в zip архив.
     * <p>По умолчанию false
     *
     * @return boolean
     */
    boolean zip() default false;

    /**
     * Аргумент метода, по которому определяется уникальность результата. Указывается номер аргумента, начиная с 1.
     * По умолчанию 0 - все аргументы учитываются.
     *
     * @return int
     */
    int identityBy() default 0;

    /**
     * Если возвращаемый тип List, то возможно указывать максимальное количество элементов в нем.
     * <p>По умолчанию 0 - Integer.MAX_VALUE.
     *
     * @return int
     */
    int limit() default 0;
}
