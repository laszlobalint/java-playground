package com.youtube.java.practice.intermediatejava;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class TaskerClass extends  Thread {

    // Protects against caching effects! (volatile) -> One thread can change the other.
    private volatile boolean runner = true;

    @Override
    public void run() {
        while (runner) {
            try {
                System.out.println("Running...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Logger.getLogger(TaskerClass.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    void kill() {
        this.runner = false;
    }
}

public class VolatilePract {

    public static void main(String[] args) {
        TaskerClass t1 = new TaskerClass();
        t1.start();

        System.out.println("Press enter to pause running: ");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        t1.kill();
    }
}
