package com.company.javapractice.vehicle;

public class Bicycle extends Vehicle {

    public Bicycle(int weight, int maxSpeed) {
        super(weight, maxSpeed);
        super.setMaxSpeed(40);
    }

    @Override
    void starts() throws BrokenException {
        if (isBroken()) {
            throw new BrokenException("Your bike is broken.");
        } else {
            System.out.println("You can ride your bicycle.");
        }
    }

    @Override
    public String toString() {
        return "This is a bicycle, " +
                "its maximum speed is " + getMaxSpeed() +
                ", its weight is " + getWeight() +
                (isBroken() ? ", and its broken now. " : ", and its working properly. ");
    }
}
