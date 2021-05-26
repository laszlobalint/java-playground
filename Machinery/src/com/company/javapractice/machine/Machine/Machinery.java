package com.company.javapractice.machine.Machine;

import java.io.Serializable;

abstract class Machinery implements Serializable {
    protected int weight;
    protected String type;

    public Machinery(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    protected Machinery() {
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "\n";
    }
}
