package com.flow.pubsimluator;

public class Mixture extends Beverage{
    public Mixture(int price, int alcoholPercent) {
        super(price, alcoholPercent);
    }

    public Mixture (Beverage beverage1, Beverage beverage2) {
        setPrice(beverage1.getPrice() + beverage2.getPrice());
        setAlcoholPercent((beverage1.getAlcoholPercent()
                + beverage2.getAlcoholPercent()) / 2);
    }

    public Mixture (Beverage beverage1, Beverage beverage2, Beverage beverage3) {
        setPrice(beverage1.getPrice() + beverage2.getPrice() + beverage3.getPrice());
        setAlcoholPercent((beverage1.getAlcoholPercent()
                + beverage2.getAlcoholPercent()
                + beverage2.getAlcoholPercent()) / 3);
    }

    public Mixture (Beverage beverage1, Beverage beverage2, Beverage beverage3, Beverage beverage4) {
        setPrice(beverage1.getPrice() + beverage2.getPrice() + beverage3.getPrice() + beverage4.getPrice());
        setAlcoholPercent((beverage1.getAlcoholPercent()
                + beverage2.getAlcoholPercent()
                + beverage3.getAlcoholPercent()
                + beverage4.getAlcoholPercent()) / 4);
    }
}
