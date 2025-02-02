package ru.sberuniversity.multithreadingpart2.scalablethreadpool;

import ru.sberuniversity.multithreadingpart2.data.Task;

public class ScalableThreadPoolTask {
    ScalableThreadPool scalableThreadPool = new ScalableThreadPool(2, 10);
    Task task = new Task();

    public void startExecution(int countTask) throws InterruptedException {
        System.out.println("Приступаем к выполнению задач");
        scalableThreadPool.start();

        for (int i = 3; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(1000);
        }

        for (int i = 0; i < countTask; i++) {
            scalableThreadPool.execute(task.takeTask(i));
        }

        scalableThreadPool.taskExecution();
        System.out.println("Задачи выполнены");
        scalableThreadPool.shutdown();
    }
}
