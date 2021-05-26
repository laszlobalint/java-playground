package com.youtube.java.practice.intermediatejava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TaskUnit implements Runnable {
    private int id;

    TaskUnit(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task has started with ID: " + id);
    try {
        Thread.sleep(300);
    } catch (InterruptedException ex) {
        System.out.println("" + ex);
    }
        System.out.println("Task finished with ID: " + id);
    }
}

class Executor {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 1; i < 5; i++) {
            executor.submit(new TaskUnit(i));
        }
        executor.shutdown();
        System.out.println("All tasks have been allocated.");
        executor.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println("All tasks are done.");
    }
}
