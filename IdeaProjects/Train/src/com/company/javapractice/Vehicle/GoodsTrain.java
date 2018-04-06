package com.company.javapractice.Vehicle;

public class GoodsTrain extends Railway {
    private String goods;
    private int quantity;

    public GoodsTrain(String departureStation, String destinationStation, int distance, int averageSpeed, String goods, int quantity) {
        super(departureStation, destinationStation, distance, averageSpeed);
        this.goods = goods;
        this.quantity = quantity;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Goods: " + goods +
                " (quantity: " + + quantity + " tons). " +
                super.toString();
    }
}


