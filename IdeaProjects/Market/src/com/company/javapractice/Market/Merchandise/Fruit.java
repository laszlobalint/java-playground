package com.company.javapractice.Market.Merchandise;

public class Fruit {
    private double price;
    private String color;
    private String kindOf;

    public Fruit(double price, String color, String kindOf) {
        this.price = price;
        this.color = color;
        this.kindOf = kindOf;
    }

    public double getPrice() { return price; }

    public String getColor() { return color; }

    @Override
    public String toString() { return "This fruit " + "costs " + price + " dollars" + ", it has " + color + " color" + ", and it is " + kindOf + ". "; }
}
