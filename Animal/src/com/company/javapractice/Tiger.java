package com.company.javapractice;

public class Tiger extends TerrestrialAnimal implements Predator {
    public Tiger(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "Roar!";
    }

    @Override
    public void eat(Animal who) {

    }

    @Override
    public void rest(int howMuch) {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
