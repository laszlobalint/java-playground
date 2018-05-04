package com.company.javapractice;

import com.company.javapractice.Market.Customer;
import com.company.javapractice.Market.SuperGrandMa;
import com.company.javapractice.Market.Merchandise.Fruit;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Main {
    private int fruitCount;
    private int j;
    private Customer customer;
    private SuperGrandMa grandMa;
    private Fruit[] fruits;

    public static void main(String[] args) {
        Main main = new Main();
        main.makeFruits(main.makeCustomers(args));
        main.checkForFruits(main.fruitCount);
    }

    private void checkForFruits(int fruitCount) {
        if (fruitCount >= 3) {
            canGoShopping();
        } else {
            System.err.println("Not enough fruits!");
        }
    }

    private void canGoShopping() {
        double customerSpending = shopping(fruits, customer);
        double grandmaSpending = shopping(fruits, grandMa);
        System.out.println("Customer spending: " + customerSpending + " dollars. ");
        System.out.println("Customer: " + customer + "dollars. ");
        System.out.println("GrandMa spending: " + grandmaSpending + " dollars. ");
        System.out.println(grandMa);
        if (grandmaSpending < customerSpending) {
            System.out.println("It was worth it to bring granny along.");
        } else {
            System.out.println("The grandma could not save money this day.");
        }
    }

    private String[] makeCustomers(String[] args) {
        String[] parts = args[0].split("_");
        customer = new Customer(parseInt(parts[0]), parseDouble(parts[1]));
        System.out.println(customer);
        grandMa = new SuperGrandMa(parseInt(parts[0]), parseInt(parts[1]));
        System.out.println(grandMa);
        return parts;
    }

    private void makeFruits(String[] parts) {
        String [] fruitDetails = parts[2].split(",");
        fruits = new Fruit[parseInt(parts[0])];
        for (int i = 0; j < fruitDetails.length; i++) {
            fruits[i] = new Fruit(parseDouble(fruitDetails[j + 2]), fruitDetails[j + 1], fruitDetails[j]);
            j += 3;
            fruitCount++;
            System.out.println(fruits[i]);
        }
        System.out.println("Fruits created: " + fruitCount);
    }

    private double shopping(Fruit[] fruits, Customer customer){
        double startMoney = customer.getMoney();
        for (Fruit fruit : fruits) {
            customer.buyFruit(fruit);
        }
        double endMoney = customer.getMoney();
        return startMoney - endMoney;
    }
}
