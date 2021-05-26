package com.company.javapractice.vehicle;

public final class Car extends Vehicle implements Motorized {

    private int fuel;

    public Car(int weight, int maxSpeed) {
        super(weight, maxSpeed);
        this.fuel = 50;
    }

    @Override
    void starts() throws BrokenException {
        if (isBroken()) {
            throw new BrokenException("Your car is broken.");
        }
        if (getFuel() <= 0) {
            throw new NoFuelException("You have no fuel in the car.");
        } else {
            System.out.println("Your car is on the way.");
            fuel = fuel - 10;
        }
    }

    @Override
    public int fillingFuel(int addFuel) {
        return fuel + addFuel;
    }

    @Override
    public int getFuel() {
        return fuel;
    }
}
