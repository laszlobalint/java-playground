package com.company.javapractice;

public abstract class TerrestrialAnimal extends Animal {
    public TerrestrialAnimal(String name) {
        super(name);
    }

    private int numOfLegs;

    public int getNumOfLegs() {
        return numOfLegs;
    }

    public void setNumOfLegs(int numOfLegs) {
        this.numOfLegs = numOfLegs;
    }
}
