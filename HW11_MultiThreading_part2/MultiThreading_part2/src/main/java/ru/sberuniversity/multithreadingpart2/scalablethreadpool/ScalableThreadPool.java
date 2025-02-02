package ru.sberuniversity.multithreadingpart2.scalablethreadpool;

import lombok.RequiredArgsConstructor;
import ru.sberuniversity.multithreadingpart2.data.ThreadPool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;


public class ScalableThreadPool implements ThreadPool {
    private final List<Work> workers = Collections.synchronizedList(new ArrayList<>());
    private final BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();
    private final Object lock = new Object();
    private final AtomicInteger currentSizeThread;
    private final int min;
    private final int max;
    public Work work;

    public ScalableThreadPool(int min, int max) {
        this.min = min;
        this.max = max;
        currentSizeThread = new AtomicInteger(min);
    }

    @Override
    public void start() {
        addWorkers();
        for (Work worker : workers) {
            worker.start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        if (workers.size() <= max) {
            work = new Work(queue, currentSizeThread);
            workers.add(work);
            currentSizeThread.incrementAndGet();
            work.start();
            System.out.println(work.getName() + " добавлен в поток");
        }
        queue.offer(runnable);
    }

    @Override
    public void shutdown() {
        for (Work worker : workers) {
            worker.interrupt();
        }
    }

    public void addWorkers() {
        for (int i = 0; i < min; i++) {
            work = new Work(queue, currentSizeThread);
            workers.add(work);
        }
    }

    public void taskExecution() {
        while (!queue.isEmpty()) {
            while (currentSizeThread.get() != workers.size()) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }

    private void removeWorker() {
        if (queue.isEmpty()) {
            synchronized (lock) {
                if (workers.size() > min) {
                    workers.remove((Work) Thread.currentThread());
                    currentSizeThread.decrementAndGet();
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread() + " удален из потока");
                }
            }
        }
    }

    @RequiredArgsConstructor
    class Work extends Thread {
        private final BlockingQueue<Runnable> queue;
        private final AtomicInteger currentSizeThread;
        boolean isWorking = false;

        @Override
        public void run() {
            while (!isInterrupted()) {
                isWorking = false;
                System.out.println("Поток " + Thread.currentThread().getName() + " работает");
                try {
                    Runnable task = queue.take();
                    isWorking = true;
                    currentSizeThread.decrementAndGet();
                    task.run();
                    currentSizeThread.incrementAndGet();
                    isWorking = false;
                    removeWorker();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Поток " + Thread.currentThread().getName() + " был прерван");
                    break;
                }
            }
        }
    }
}