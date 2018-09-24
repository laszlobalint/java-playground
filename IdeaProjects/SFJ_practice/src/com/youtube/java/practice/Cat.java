package com.youtube.java.practice;

public class Cat extends Feline implements Pet {

    public Cat(String black_cat) {
        super();
    }

    @Override
    public void cuddle() {
        System.out.println("Cuddling...");

    }

    @Override
    public void sit() {

    }

    @Override
    protected void makeSound() {
        System.out.println("Meow!");
    }
}
