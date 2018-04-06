package com.company.javapractice;

import com.company.javapractice.Market.Customer;
import com.company.javapractice.Market.SuperGrandMa;
import com.company.javapractice.Market.Merchandise.Fruit;

public class Main {

    public static void main(String[] args) {

            String[] parts = args[0].split("_");
            Customer customer = new Customer(Integer.parseInt(parts[0]), Double.parseDouble(parts[1]));
            System.out.println(customer);
            SuperGrandMa grandMa = new SuperGrandMa(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            System.out.println(grandMa);
            String [] fruitDetails = parts[2].split(",");
            int fruitCount = 0;
            int j = 0;
            Fruit[] fruits = new Fruit[Integer.parseInt(parts[0])];
            for (int i = 0; j < fruitDetails.length; i++) {
                fruits[i] = new Fruit(Double.parseDouble(fruitDetails[j + 2]), fruitDetails[j + 1], fruitDetails[j]);
                j += 3;
                fruitCount++;
                System.out.println(fruits[i]);
            }
            System.out.println("Fruits created: " + fruitCount);

            if (fruitCount >= 3) {
            Main market = new Main();
            double customerSpending = market.shopping(fruits, customer);
            double grandmaSpending = market.shopping(fruits, grandMa);

            System.out.println("Customer spending: " + customerSpending + " dollars. ");
            System.out.println("Customer: " + customer + "dollars. ");
            System.out.println("GrandMa spending: " + grandmaSpending + " dollars. ");
            System.out.println(grandMa);
            if (grandmaSpending < customerSpending) {
                System.out.println("It was worth it to bring granny along.");
            } else {
                System.out.println("The grandma could not save money this day.");
            }
        } else {
            System.err.println("Not enough fruits!");
        }
    }

    public static double shopping (Fruit[] fruits, Customer customer){
        double startMoney = customer.getMoney();
        for (int i = 0; i < fruits.length; i++) {
            customer.buyFruit(fruits[i]);
        }
        double endMoney = customer.getMoney();
        return startMoney - endMoney;
    }
}
