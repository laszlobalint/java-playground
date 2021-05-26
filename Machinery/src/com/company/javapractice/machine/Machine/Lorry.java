package com.company.javapractice.machine.Machine;

import com.company.javapractice.machine.Transporter;

public class Lorry extends Machinery implements Transporter {
    private int carryingCapacity;
    private int levelOfLoad;

    public Lorry(int weight, String type, int carryingCapacity) {
        super(weight, type);
        this.carryingCapacity = carryingCapacity;
        this.levelOfLoad = 0;
    }

    public Lorry() {
    }

    @Override
    public double transport(int distance) throws Exception {
        if (levelOfLoad == 0) {
            throw new Exception("No cargo!");
        } else {
            levelOfLoad = 0;
            double speed = (weight + levelOfLoad) * Math.random();
            return distance / speed;
        }
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public int getLevelOfLoad() {
        return levelOfLoad;
    }

    public void setLevelOfLoad(int levelOfLoad) {
        this.levelOfLoad = levelOfLoad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lorry lorry = (Lorry) o;

        if (carryingCapacity != lorry.carryingCapacity) return false;
        return levelOfLoad == lorry.levelOfLoad;
    }

    @Override
    public int hashCode() {
        int result = carryingCapacity;
        result = 31 * result + levelOfLoad;
        return result;
    }

    @Override
    public String toString() {
        return "Lorry information - " +
                " Carrying capacity: " + carryingCapacity +
                "; Level of load: " + levelOfLoad +
                "; Weight of lorry: " + weight +
                ", Type of truck: " + type +
                ". " + super.toString();
    }
}
