package ru.sberuniversity.multithreadingpart2;

import ru.sberuniversity.multithreadingpart2.fixedthreadpool.FixedThreadPoolTask;
import ru.sberuniversity.multithreadingpart2.scalablethreadpool.ScalableThreadPoolTask;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        FixedThreadPoolTask fixedThreadPoolTask = new FixedThreadPoolTask();
        ScalableThreadPoolTask scalableThreadPoolTask = new ScalableThreadPoolTask();

        fixedThreadPoolTask.startExecution(100);
        System.out.println("********************");
        scalableThreadPoolTask.startExecution(100);
    }
}