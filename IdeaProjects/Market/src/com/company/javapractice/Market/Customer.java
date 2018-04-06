package com.company.javapractice.Market;

import com.company.javapractice.Market.Merchandise.Fruit;

import java.util.Arrays;

public class Customer {
    private int basketSize;
    private Fruit[] basket;
    private double money;
    private int fruitCount;

    public Customer(int basketSize, double money) {
        this.basketSize = basketSize;
        this.basket = new Fruit[basketSize];
        this.money = money;
        this.fruitCount = 0;
    }

    public void buyFruit(Fruit fruit) {
        if (getMoney() >= fruit.getPrice() && fruit.getColor().equals("green")) {
            setMoney(getMoney() - fruit.getPrice());
            System.out.println("You have bought some juicy green apples!");
            getBasket()[getFruitCount()] = fruit;
            setFruitCount(getFruitCount() + 1);
        } else if (getMoney() < fruit.getPrice()) {
            System.out.println("You do not have enough money!");
        } else if (fruit.getColor().equals("yellow") || fruit.getColor().equals("red")) {
            System.out.println("Sorry, but I am looking for green apples.");
        }
    }

    public Fruit[] getBasket() {
        return basket;
    }

    public void setBasket(Fruit[] basket) {
        this.basket = basket;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getFruitCount() {
        return fruitCount;
    }

    public void setFruitCount(int fruitCount) {
        this.fruitCount = fruitCount;
    }

    @Override
    public String toString() {
        return "The customer has " +
                fruitCount + " apples in the basket" +
                ", and he/she has " + money + " dollars in the wallet.";
    }
}
