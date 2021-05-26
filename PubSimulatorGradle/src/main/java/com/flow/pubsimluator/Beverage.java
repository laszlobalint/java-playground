package com.flow.pubsimluator;

public class Beverage {
    private int price;
    private int alcoholPercent;

    public Beverage() {
    }

    public Beverage(int price, int alcoholPercent) {
        this.price = price;
        this.alcoholPercent = alcoholPercent;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAlcoholPercent() {
        return alcoholPercent;
    }

    public void setAlcoholPercent(int alcoholPercent) {
        this.alcoholPercent = alcoholPercent;
    }

    public String toString() {
        return "Price: " + price +
                ", alcoholPercent: " + alcoholPercent;
    }
}
