package com.youtube.java.practice.basicjava;

public abstract class Animal {

    public Animal() {
    }

    private String name;
    private int weigth;

    public Animal(String name, int weigth) {
        this.name = name;
        this.weigth = weigth;
    }

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
