package com.company.javapractice.Vehicle;

public class Car {
    private int power;
    private int maxSpeed;
    private String type;

    public Car(int power, int maxSpeed, String type) {
        this.power = power;
        this.maxSpeed = maxSpeed;
        this.type = type;
    }

    public double competitiveness() {
        return power + maxSpeed;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "The car " +
                "has " + power + " HP" +
                ", it's maximum speed is " + maxSpeed + " km/h, " +
                ", and the type is " + type + ". " + '\n';
    }
}
