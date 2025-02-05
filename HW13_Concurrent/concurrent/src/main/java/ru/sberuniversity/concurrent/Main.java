package ru.sberuniversity.concurrent;

import ru.sberuniversity.concurrent.service.*;
import ru.sberuniversity.concurrent.proxy.*;

public class Main {
    public static void main(String[] args) {
        try {
            CacheProxy cacheProxy = new CacheProxy();
            Service service = cacheProxy.cache(new ServiceImpl());

            service.doHardWork("work1", 1);
            service.doHardWork("work2", 2);
            System.out.println("*******************");
            service.doHardWork("work1", 1);
            service.doHardWork("work2", 2);
            System.out.println("*******************");
            service.run("work", 1000);
            service.run("work", 1000);
            System.out.println("*******************");

        } catch (ClassCastException | InterruptedException ex) {
            ex.printStackTrace(System.err);
        }
    }
}