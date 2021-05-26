package com.company.javapractice;

import com.company.javapractice.Vending.*;

public class Distributor {

    public static void main(String[] args) {
        DrinkVendingMachine machine = new DrinkVendingMachine(20, false);
        machine.insertCoin(100);
        information(machine);

        EmptyVending empty = new EmptyVending(10, 10, true);
        empty.insertCoin(95);
    }

    public static void information(DrinkVendingMachine machine) {
        System.out.println("Times can be used: " + machine.getCups() + "\n" + "Money in the vending machine: " + machine.getInsertedCoins() + " $");
    }
}
