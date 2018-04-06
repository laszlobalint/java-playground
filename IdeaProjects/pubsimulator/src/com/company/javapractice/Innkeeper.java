package com.company.javapractice;

public class Innkeeper extends Human {
    String name;
    private static int dirtyCup;
    private int money;

    public Innkeeper(String name, int age, boolean gender, int money, int drunkenness, boolean inPub) {
        super(name, age, gender, money, drunkenness, inPub);
        this.name = name;
        this.money = money;
    }

    public void washCup() {
        if (getDirtyCup() > 0) {
            dirtyCup--;
            System.out.println("The innkeeper washed one cup, and there are " + dirtyCup + " dirty cups left.");
        } else {
            System.out.println("Fine! All cups are clean.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDirtyCup() {
        return dirtyCup;
    }

    public void setDirtyCup(int dirtyCup) {
        this.dirtyCup = dirtyCup;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "The innkeeper's " +
                "name is " + name +
                ", has in the cashier " + money + " dollars." +
                "There are " + dirtyCup + " dirty cups at the bar." +
                super.toString();
    }
}

