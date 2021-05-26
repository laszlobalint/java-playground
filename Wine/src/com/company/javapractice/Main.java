package com.company.javapractice;

import com.company.javapractice.drink.Asu;
import com.company.javapractice.drink.Wine;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("aszu") || args[i].equals("Aszú")) {
                Asu asu = new Asu(Integer.parseInt(args[i + 2]), Integer.parseInt(args[i + 1]));
                displayWine(asu);
                i += 2;
            } else {
                Wine wine = new Wine(args[i], Integer.parseInt(args[i + 1]));
                displayWine(wine)   ;
                i += 1;
            }
        }
    }

    private static void displayWine (Wine wine) {
        System.out.println(wine);
    }

    public static void displayWine(int vintage, int dorsal) {
        System.out.println("This wine was made in " + vintage + ", and it has " + dorsal + " dorsals.");
    }
}
