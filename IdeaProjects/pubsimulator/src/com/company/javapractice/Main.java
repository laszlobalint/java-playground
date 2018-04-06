package com.company.javapractice;

import java.util.*;
import com.company.javapractice.drink.Asu;
import com.company.javapractice.drink.Wine;

public class Main {

    public static void logOutWine(Wine wine) {
        System.out.println(wine);
    }

    public static void main(String[] args) {
        Human papilion = new Human("Papilion", 24, true, 1000, 0, false);
        Innkeeper erdelyi = new Innkeeper("Erdélyi", 40, true, 0, 0, true);
        Security szabo = new Security("Szabó", 28, true, 300, 0, false, false);
        Human ratgeber = new Human("Renáta", 32, false, 600, 5, false);
        Human tankaranka = new Human("Tamara", 29, false, 100, 10, false);
        Student barat = new Student("Barát", 16, false, 50, 0, false, 0);

        Drink whiskey = new Drink ("Whiskey", 15, 10);
        Drink beer = new Drink("Beer", 8, 5);
        Drink pelinkovac = new Drink("Pelinkovac", 12, 5);
        Drink cola = new Drink("Coca-Cola", 5, 0);
        Asu szurkebarat = new Asu(1998, 5);

        Mixed mixed1 = new Mixed("Mixed Shit", whiskey, beer);
        Mixed mixed2 = new Mixed("Dirty Mind", whiskey, beer, pelinkovac);
        Mixed mixed3 = new Mixed("Nasty Shot", whiskey, beer, pelinkovac, cola);

        System.out.println(papilion);
        System.out.println(erdelyi);
        papilion.goPub();
        papilion.drink(erdelyi);
        papilion.drink(erdelyi, whiskey);
        papilion.drink(erdelyi, pelinkovac);
        papilion.drink(erdelyi, beer);
        erdelyi.washCup();
        papilion.goHome();
        System.out.println(papilion);

        szabo.isOnDuty();
        szabo.goPub();
        szabo.drink(erdelyi, cola);
        szabo.drink(erdelyi, whiskey);
        System.out.println(szabo);

        ratgeber.goPub();
        ratgeber.drink(erdelyi, pelinkovac);
        szabo.isOffDuty();
        tankaranka.goPub();
        tankaranka.banter(ratgeber);
        tankaranka.drink(erdelyi, mixed1);

        barat.learn(100);
        barat.learn(100, 12);
        System.out.println(barat);

        System.out.println(szurkebarat);
        logOutWine(szurkebarat);

        System.out.println(mixed1);
        System.out.println(mixed2);
        System.out.println(mixed3);
    }
}
