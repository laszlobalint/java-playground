package com.youtube.java.practice.basicjava;

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
    public void makeSound() {
        System.out.println("Meow!");
    }
}
