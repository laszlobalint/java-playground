package com.company.javapractice.drink;

public class Asu extends Wine {
    private int dorsal;
    private String type = "Aszú";

    public Asu(int vintage, int dorsal) {
        super(vintage);
        this.dorsal = dorsal;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        if (dorsal >= 0) {
            this.dorsal = dorsal;
        }
    }

    @Override
    public String toString() {
        return "This is an " + type +
                ", and it has " + dorsal + " dorsals, " +
                "and its vintage is " + getVintage() +
                ". ";
    }
}
