package com.company.javapractice.Market;

import com.company.javapractice.Market.Merchandise.Fruit;

public class SuperGrandMa extends Customer {
    private long haggle;

    public SuperGrandMa(int basketSize, double money) {
        super(basketSize, money);
        this.haggle = Math.round(Math.random());
        super.setMoney(getMoney() * 0.8);
    }

    public void buyWithHaggleGreenOrYellow(Fruit fruit) {
        setMoney(getMoney() - fruit.getPrice() * 0.9f);
        System.out.println("You have bought some juicy apples!");
        getBasket()[getFruitCount()] = fruit;
        setFruitCount(getFruitCount() + 1);
        iToldYou();
    }

    public void buyGreenOrYellow(Fruit fruit) {
        setMoney(getMoney() - fruit.getPrice());
        System.out.println("You have bought some juicy apples!");
        getBasket()[getFruitCount()] = fruit;
        setFruitCount(getFruitCount() + 1);
    }

    @Override
    public void buyFruit(Fruit fruit) {
        if (this.haggle == 1 && Math.random() < 0.75f) {
            if (getMoney() >= (fruit.getPrice() * 0.9f) && (fruit.getColor().equals("green") || fruit.getColor().equals("yellow"))) {
                buyWithHaggleGreenOrYellow(fruit);
            }
        } else if (getMoney() >= fruit.getPrice() && (fruit.getColor().equals("green") || fruit.getColor().equals("yellow"))) {
            buyGreenOrYellow(fruit);

        } else if (getMoney() < fruit.getPrice()) {
            System.out.println("You do not have enough money!");
        } else if (fruit.getColor().equals("red")) {
            System.out.println("Sorry, but I am looking for green or yellow apples.");
        }
    }

    public void iToldYou() { System.out.println("I told you, my son, that we can haggle at this vendor!"); }

    @Override
    public String toString() { return "She is a super grandma. " + super.toString(); }
}
