package com.company.javapractice;

public class Whale extends AquaticAnimal implements Predator {
    public Whale(String name) {
        super(name);
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
