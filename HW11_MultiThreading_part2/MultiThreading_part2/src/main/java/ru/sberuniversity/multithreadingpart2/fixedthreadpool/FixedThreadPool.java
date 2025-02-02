package ru.sberuniversity.multithreadingpart2.fixedthreadpool;

import lombok.RequiredArgsConstructor;
import ru.sberuniversity.multithreadingpart2.data.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

@RequiredArgsConstructor
public class FixedThreadPool implements ThreadPool {
    private final int countThreads;
    private final BlockingDeque<Runnable> queue = new LinkedBlockingDeque<>();
    private final List<Work> workers = new ArrayList<>();
    Work work;

    @Override
    public void start() {
        addWorkers(countThreads);
        for (Work worker : workers) {
            worker.start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        queue.offer(runnable);
    }

    @Override
    public void shutdown() {
        for (Work worker : workers) {
            worker.interrupt();
        }
    }

    public void taskExecution() {
        while (!queue.isEmpty()) {
            while (checkThreadIsWorking()) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }

    private boolean checkThreadIsWorking() {
        for (Work worker : workers) {
            if (worker.isWorking()) {
                return true;
            }
        }
        return false;
    }

    public void addWorkers(int count) {
        for (int i = 0; i < count; i++) {
            work = new Work(queue);
            workers.add(work);
        }
    }

    @RequiredArgsConstructor
    static class Work extends Thread {
        private final BlockingQueue<Runnable> queue;
        boolean isWorking = false;

        @Override
        public void run() {
            while (!isInterrupted()) {
                isWorking = false;
                System.out.println("Поток " + Thread.currentThread().getName() + " работает");
                try {
                    Runnable task = queue.take();
                    isWorking = true;
                    task.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Поток " + Thread.currentThread().getName() + " был прерван");
                    break;
                }
            }
        }

        public boolean isWorking() {
            return isWorking;
        }
    }
}
