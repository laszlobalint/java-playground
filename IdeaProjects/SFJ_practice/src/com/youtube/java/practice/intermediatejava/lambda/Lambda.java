package com.youtube.java.practice.intermediatejava.lambda;

public class Lambda {

    public static void main(String[] args) {
        String init = "";
        try {
            init = args[0];
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex);
        }

        FeatureAdd ft = new FeatureAdd();
        if (init.equals("new"))
            ft.doSomething("s", "t", "r", "i", true);
        else
            ft.doSomething("s", "t", "r", "i");

        // Lambda expression
        Growl grownling = () -> System.out.println("Ghrrrrrr...!");


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running using Inner Class");
            }
        });

        Thread t2 = new Thread(() -> System.out.println("Running using Lambda Expression"));

        t1.start();
        t2.start();
    }
}
