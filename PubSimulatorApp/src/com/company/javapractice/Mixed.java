package com.company.javapractice;

public class Mixed extends Drink {

    private String nameDrink;

    public Mixed(String name, Drink drink1, Drink drink2) {
        setPrice(drink1.getPrice() + drink2.getPrice() / 2);
        setAlcoholCont(drink1.getAlcoholCont() + drink2.getAlcoholCont() / 2);
        nameDrink = name;
    }

    public Mixed(String name, Drink drink1, Drink drink2, Drink drink3) {
        setPrice(drink1.getPrice() + drink2.getPrice() + drink3.getPrice() / 3);
        setAlcoholCont(drink1.getAlcoholCont() + drink2.getAlcoholCont() + drink3.getAlcoholCont() / 3);
        nameDrink = name;
    }

    public Mixed(String name, Drink drink1, Drink drink2, Drink drink3, Drink drink4) {
        setPrice(drink1.getPrice() + drink2.getPrice() + drink3.getPrice() + drink4.getPrice() / 4);
        setAlcoholCont(drink1.getAlcoholCont() + drink2.getAlcoholCont() + drink3.getAlcoholCont() + drink4.getAlcoholCont() / 4);
        nameDrink = name;
    }

    @Override
    public String toString() {
        return nameDrink + " mixed drink contains " +
                getAlcoholCont() + " % of alcohol" +
                ", and its price is " + getPrice() + " dollars.";
    }
}
