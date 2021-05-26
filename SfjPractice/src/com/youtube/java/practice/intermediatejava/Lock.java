package com.youtube.java.practice.intermediatejava;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

class Locker {

    private Object lockOne = new Object();
    private Object lockTwo = new Object();

    public ArrayList<Integer> number1 = new ArrayList<>();
    public ArrayList<Integer> number2 = new ArrayList<>();

    private void doorOne() throws InterruptedException {
        synchronized (lockOne) {
            number1.add(10);
            Thread.sleep(1);
        }
    }

    private void doorTwo() throws InterruptedException {
        synchronized (lockTwo) {
            number2.add(10);
            Thread.sleep(1);
        }
    }

    void doWork() throws InterruptedException {
        for (int i = 0; i < 500; i++) {
            doorOne();
            doorTwo();
        }
    }
}

    public class Lock {
        public static void main(String[] args) throws InterruptedException {
            System.out.println("Starting,..");
            long start = System.currentTimeMillis();
            Locker locker = new Locker();

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        locker.doWork();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Locker.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        locker.doWork();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Locker.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();

            long end = System.currentTimeMillis();
            System.out.println(end - start);

            System.out.println("First array's size: " + locker.number1.size());
            System.out.println("Second array's size: " + locker.number2.size());
        }
    }
