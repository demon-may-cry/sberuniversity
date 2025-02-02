package ru.sberuniversity.multithreadingpart2.data;

public interface ThreadPool {
    void start();
    void execute(Runnable runnable);
    void shutdown();
}
