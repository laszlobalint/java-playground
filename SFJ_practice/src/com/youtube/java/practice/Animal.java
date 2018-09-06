package com.youtube.java.practice;

public class Animal {
    private String name;
    private int weigth;

    protected void makeSound() {
        System.out.println("Animal sounds...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeigth() {
        return weigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }
}
