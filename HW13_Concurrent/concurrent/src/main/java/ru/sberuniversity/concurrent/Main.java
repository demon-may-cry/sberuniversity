package ru.sberuniversity.concurrent;

import ru.sberuniversity.concurrent.proxy.CacheProxy;
import ru.sberuniversity.concurrent.service.Service;
import ru.sberuniversity.concurrent.service.ServiceImpl;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        CacheProxy cacheProxy = new CacheProxy();
        Service service = cacheProxy.cache(new ServiceImpl());

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                lock.lock();
                try {
                    for (int j = 0; j < 5; j++) {
                        service.doHardWork("work", 1);
                        System.out.println(Thread.currentThread().getName() + " завершенной итерации " + j);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace(System.err);
                } finally {
                    lock.unlock();
                }
            });
            thread.setName("Thread " + i);
            thread.start();
        }
    }
}