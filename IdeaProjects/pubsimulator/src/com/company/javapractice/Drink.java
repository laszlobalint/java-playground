package com.company.javapractice;

public class Drink {
    private  String name;
    private int price;
    private int alcoholCont;

    public Drink(String name, int price, int alcoholCont) {
        this.name = name;
        this.price = price;
        this.alcoholCont = alcoholCont;
    }

    public Drink() {
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAlcoholCont() {
        return alcoholCont;
    }

    public void setAlcoholCont(int alcoholCont) {
        this.alcoholCont = alcoholCont;
    }

    @Override
    public String toString() {
        return "This drink " +
                "costs " + price + "dollars" +
                ", and contains " + alcoholCont + "% of alcohol.";
    }
}
