package ru.sberuniversity.multithreadingpart2.data;

import java.util.Random;

public class Task {
    public Runnable takeTask(int id) {
        return () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " выполняет задачу " + id);
                Thread.sleep(new Random().nextInt(10000) + 1000);
                System.out.println(Thread.currentThread().getName() + " завершил выполнение задачи " + id);
            } catch (InterruptedException ex) {
                ex.printStackTrace(System.err);
            }
        };
    }
}
