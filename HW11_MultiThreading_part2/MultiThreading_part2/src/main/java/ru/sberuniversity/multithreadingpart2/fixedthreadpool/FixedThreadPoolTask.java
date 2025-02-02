package ru.sberuniversity.multithreadingpart2.fixedthreadpool;

import ru.sberuniversity.multithreadingpart2.data.Task;

public class FixedThreadPoolTask {
    FixedThreadPool fixedThreadPool = new FixedThreadPool(5);
    Task task = new Task();

    public void startExecution(int countTask) throws InterruptedException {
        System.out.println("Приступаем к выполнению задач");
        fixedThreadPool.start();

        for (int i = 3; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(1000);
        }

        for (int i = 0; i < countTask; i++) {
            fixedThreadPool.execute(task.takeTask(i));
        }

        fixedThreadPool.taskExecution();
        System.out.println("Задачи выполнены");
        fixedThreadPool.shutdown();
    }
}
