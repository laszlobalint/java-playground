package com.company.javapractice.vehicle;

abstract class Vehicle {
    private int weight;
    private int maxSpeed;
    private boolean isBroken = false;

    public Vehicle(int weight, int maxSpeed) {
        this.weight = weight;
        this.maxSpeed = maxSpeed;
    }

    abstract void starts() throws BrokenException;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    @Override
    public String toString() {
        return "The vehicle's" +
                " weight is " + weight + " kilograms, " +
                ", maximum speed is " + maxSpeed + " km/h, " +
                (isBroken ? " and its broken now. " : " and its working properly. ");
    }
}
