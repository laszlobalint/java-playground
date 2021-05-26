package com.company.javapractice.Vending;

public class EmptyVending {
    private int insertedCoins;
    private int cups;
    private boolean isInOrder;

    public EmptyVending(int insertedCoins, int cups, boolean isInOrder) {
        this.insertedCoins = insertedCoins;
        this.cups = cups;
        this.isInOrder = isInOrder;
    }

    public void insertCoin(int money) {
        System.out.println("This vending machine is not filled up, therefore it cannot be used!");
    }

    public int getInsertedCoins() {
        return insertedCoins;
    }

    public void setInsertedCoins(int insertedCoins) {
        this.insertedCoins = insertedCoins;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public boolean isInOrder() {
        return isInOrder;
    }

    public void setInOrder(boolean inOrder) {
        isInOrder = inOrder;
    }

    @Override
    public String toString() {
        return "The vending machine " +
                (isInOrder ? "is in order. " : "is out of order. ") +
                " The amount of money: " + insertedCoins + " $. ";
    }
}
