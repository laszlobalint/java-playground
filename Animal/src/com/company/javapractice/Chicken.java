package com.company.javapractice;

public class Chicken extends TerrestrialAnimal implements Herbivorous, Predator {

    public Chicken(String name) {
        super(name);
        setNumOfLegs(2);
    }

    @Override
    public void eat() {
        System.out.println(this.getName() + " is well fed with seeds.");
        this.setWellFed(100);
    }

    public void eat(Animal who) {
        System.out.println(this.getName() + " is well fed with " + who + ".");
        this.setWellFed(100);
    }

    @Override
    public void rest(int howMuch) {
        System.out.println(this.getName() + " had a rest of " + howMuch + ".");
    }

    @Override
    public String makeSound() {
        return "Twit-twit!";
    }
}
