package com.company.javapractice.Market;

import com.company.javapractice.Market.Merchandise.Fruit;

public class Customer {
    private Fruit[] basket;
    private double money;
    private int fruitCount;

    public Customer(int basketSize, double money) {
        this.basket = new Fruit[basketSize];
        this.money = money;
        this.fruitCount = 0;
    }

    public void buyFruit(Fruit fruit) {
        if (getMoney() >= fruit.getPrice() && fruit.getColor().equals("green")) {
            buyGreen(fruit);
        } else if (getMoney() < fruit.getPrice()) {
            System.out.println("You do not have enough money!");
        } else if (fruit.getColor().equals("yellow") || fruit.getColor().equals("red")) {
            System.out.println("Sorry, but I am looking for green apples.");
        }
    }

    public void buyGreen(Fruit fruit) {
        setMoney(getMoney() - fruit.getPrice());
        System.out.println("You have bought some juicy green apples!");
        getBasket()[getFruitCount()] = fruit;
        setFruitCount(getFruitCount() + 1);
    }

    Fruit[] getBasket() { return basket; }

    public double getMoney() { return money; }

    void setMoney(double money) { this.money = money; }

    int getFruitCount() { return fruitCount; }

    void setFruitCount(int fruitCount) { this.fruitCount = fruitCount; }

    @Override
    public String toString() { return "The customer has " + fruitCount + " apples in the basket" + ", and he/she has " + money + " dollars in the wallet."; }
}
