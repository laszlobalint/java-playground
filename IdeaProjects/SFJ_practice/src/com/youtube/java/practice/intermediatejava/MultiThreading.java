package com.youtube.java.practice.intermediatejava;

class Tasker extends  Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Subthread " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TaskerRun implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Subthread " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MultiThreading {

    public static void main(String[] args) {
        // Implementing Thread class
        Tasker run1 = new Tasker();
        run1.start();
        Tasker run2 = new Tasker();
        run2.start();

        // Implementing Runnable class
        Thread task1 = new Thread(new TaskerRun());
        task1.start();
        Thread task2 = new Thread(new TaskerRun());
        task2.start();
    }
}
