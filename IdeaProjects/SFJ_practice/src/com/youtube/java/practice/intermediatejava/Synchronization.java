package com.youtube.java.practice.intermediatejava;

public class Synchronization {

    private static int count;

    public static synchronized void addCount() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 12000; i++) {
                    addCount();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 12000; i++) {
                    addCount();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t1.join();

        System.out.println("Count result: " + count);
    }
}
