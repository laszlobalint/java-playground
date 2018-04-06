package com.company.javapractice.Market;

import com.company.javapractice.Market.Merchandise.Fruit;
import java.util.Random;

public class SuperGrandMa extends Customer {
    private long haggle;

    public SuperGrandMa(int basketSize, double money) {
        super(basketSize, money);
        this.haggle = Math.round(Math.random());
        super.setMoney(getMoney() * 0.8);
    }

    @Override
    public void buyFruit(Fruit fruit) {
        if (this.haggle == 1 && Math.random() < 0.75f) {
            if (getMoney() >= (fruit.getPrice() * 0.9f) && (fruit.getColor().equals("green") || fruit.getColor().equals("yellow"))) {
                setMoney(getMoney() - fruit.getPrice() * 0.9f);
                System.out.println("You have bought some juicy apples!");
                getBasket()[getFruitCount()] = fruit;
                setFruitCount(getFruitCount() + 1);
                iToldYou();
            }
        } else if (getMoney() >= fruit.getPrice() && (fruit.getColor().equals("green") || fruit.getColor().equals("yellow"))) {
                setMoney(getMoney() - fruit.getPrice());
                System.out.println("You have bought some juicy apples!");
                getBasket()[getFruitCount()] = fruit;
                setFruitCount(getFruitCount() + 1);
        } else if (getMoney() < fruit.getPrice()) {
            System.out.println("You do not have enough money!");
        } else if (fruit.getColor().equals("red")) {
            System.out.println("Sorry, but I am looking for green or yellow apples.");
        }
    }

    public void iToldYou() {
        System.out.println("I told you, my son, that we can haggle at this vendor!");
    }

    public long isHaggle() {
        return haggle;
    }

    public void setHaggle(long haggle) {
        this.haggle = haggle;
    }

    @Override
    public String toString() {
        return "She is a super grandma. " + super.toString();
    }
}
