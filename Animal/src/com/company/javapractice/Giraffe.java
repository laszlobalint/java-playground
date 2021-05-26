package com.company.javapractice;

public class Giraffe extends TerrestrialAnimal implements Herbivorous {
    public Giraffe(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "Chap-chap!";
    }

    @Override
    public void eat() {

    }
}
