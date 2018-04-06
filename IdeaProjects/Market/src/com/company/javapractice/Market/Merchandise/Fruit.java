package com.company.javapractice.Market.Merchandise;

import java.util.Arrays;

public class Fruit {
    private double price;
    private String color;
    private String kindOf;

    public Fruit(double price, String color, String kindOf) {
        this.price = price;
        this.color = color;
        this.kindOf = kindOf;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getKindOf() {
        return kindOf;
    }

    public void setKindOf(String kindOf) {
        this.kindOf = kindOf;
    }

    @Override
    public String toString() {
        return "This fruit " +
                "costs " + price + " dollars" +
                ", it has " + color + " color" +
                ", and it is " + kindOf + ". ";
    }
}
