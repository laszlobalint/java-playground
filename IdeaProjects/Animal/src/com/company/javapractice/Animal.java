package com.company.javapractice;

public abstract class Animal {
    private String name;
    private int wellFed;
    private int power;

    public Animal(String name) {
        this.name = name;
        this.wellFed = 100;
        this.power = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWellFed() {
        return wellFed;
    }

    public void setWellFed(int wellFed) {
        this.wellFed = wellFed;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public abstract String makeSound();

    @Override
    public String toString() {
        return "The animal's " +
                "specie is " + name +
                ", its well fed level is " + wellFed +
                ", and power is " + power +
                '.';
    }
}

