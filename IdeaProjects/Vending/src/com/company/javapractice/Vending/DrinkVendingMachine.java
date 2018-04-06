package com.company.javapractice.Vending;

public class DrinkVendingMachine extends EmptyVending {
    private boolean isCold;

    public DrinkVendingMachine(int cups, boolean isCold) {
        super(0, cups, true);
        this.isCold = isCold;
    }

    @Override
    public void insertCoin(int money) {
        if (super.getCups() == 0) {
            System.out.println("No cups. Please, try again later!");
        }
        if (money < 95) {
            System.out.println("Insufficient funds. Not enough money inserted.");
        } else {
            setInsertedCoins(getInsertedCoins() + money - (money - 95));
            setCups(getCups() - 1);
            System.out.println("Please, take your drink. Enjoy! Your change: " + (money - 95) + " $");
        }
    }

    public boolean getisCold() {
        return isCold;
    }

    public void setisCold(String drinkHotorCold) {
        this.isCold = isCold;
    }

    @Override
    public String toString() {
        return super.toString() +
                "This machine sells " +
                (isCold ? "cold drinks. " : "hot drinks. ");
    }
}
