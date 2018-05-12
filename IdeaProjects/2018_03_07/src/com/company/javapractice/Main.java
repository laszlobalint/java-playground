/*
0.Írj egy programot ami adott nehézségi gyorsulás (g=9,81 m/s^2) mellett a kilövési szög és a kezdõsebesség alapján kiszámolja, hogy hol lesz a kilõtt test a felhasználó által megadott idõ múlva.
Számítsd ki azt is, hogy mikor és hol éri el a röppálya maximálismagasságát. Nem kell számolnod a légellenállással és feltételezd, hogy a terep sík.
1. Készíts programot, ami ha megadunk két nem negatív számot parancsori paraméterként, akkor a kisebbik négyzetgyökét kiírja a képernyőre!
2. Készíts programot, amely bekér két számot és kiírja, hogy melyik a nagyobb illetve ha egyenlők, akkor azt.
3. Készíts programot, amely 1-től 10-ig kiírja egymásmellé, vesszővel elválasztva a számok négyzetét!
4. Készítsen egy olyan programot, amely a másodfokú egyenlet megoldó képlete alapján a valós számkörben megadja egy ax2+bx+c alakú másodfokú egyenlet gyökeit! A bemenő adatokat (a,b,c) a felhasználótól kérje be!
5. Készíts programot, amely bekér egy számot, majd kiírja, hogy osztható-e 2-vel vagy 3-mal!
6. Készíts programot, amely két adott sztringet megjelenít, az egyiket kisbetűs, a másikat nagybetűs formában!
7. Készíts programot, ami bemut	atja a normál és a maradékos osztás közötti különbséget.
8. Készíts programot, amely 10-től 20-ig generál két véletlen egész számot! Majd kiírja a két szám összegét, valamint szorzatát.
9.  Készíts programot, ami generál két véletlen egész számot [0;100] intervallumban. A nagyobbik számból vonja ki a kisebbet, és írja ki a végeredményt.
10. Készítsen egy olyan programot, amely véletlen számokkal tölt fel egy 100 elemű egész típusú tömböt, majd megkeresi és kiírja a konzolra a tömbben levő legnagyobb és legkisebb számot!
 */
package com.company.javapractice;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        projectileMotion(55, 30, 5.01);
        System.out.println("Number of searches: " + search("ojnaenfonfownefonwefwrgpijj", 'o'));
        stringPract();
        smallerSquareRoot(args);
        compareNums();
        squareTen();
        secondDegreeEquation();
        dividableByTwoOrThree(6);
        caseLowerUpper("GaMeOfThRoNeS");
        divideNormalRest(7, 5);
        randomSumMult();
        randomBigger();
        hundredRandMaxMin();
    }

    private static void projectileMotion(int degree, double speed, double time) {
        double angleInDegree = degree;
        double angleInRadian = Math.toRadians(angleInDegree);
        double g = 9.81;
        double cos = Math.cos(angleInRadian);
        double sin = Math.sin(angleInRadian);
        double te = (time * sin) * g;
        System.out.println("Time of raising: " + te + " second");
        double h = (Math.pow(speed, 2) * Math.pow(sin, 2)) / (2 * g);
        System.out.println("Highest point of projectile: " + h + " meters");
        double d = speed * time * cos;
        System.out.println("Traveled distance at a given time: " + d + " meters");
    }

    private static void smallerSquareRoot(String[] args) {
        double arg1 = Double.parseDouble(args[0]);
        double arg2 = Double.parseDouble(args[1]);
        if (arg1 > arg2) {
            System.out.println("Square root of " + arg2 + " is equal to " + Math.sqrt(arg2));
        } else {
            System.out.println("Square root of " + arg1 + " is equal to " + Math.sqrt(arg1));
        }
    }

    private static void compareNums() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int num1 = sc1.nextInt();
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter the second number: ");
        int num2 = sc2.nextInt();
        if (num1 > num2) {
            System.out.println("The first number is bigger!");
        } else if (num1 < num2) {
            System.out.println("The second number is bigger!");
        } else {
            System.out.println("The two numbers are equal!");
        }
    }

    private static void squareTen() {
        double[] oneToTen = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double[] oneToTenSquare = new double[10];
        for (int i = 0; i < oneToTen.length; i++) {
            oneToTenSquare[i] = Math.pow(oneToTen[i], 2);
        }
        for (int i = 0; i < oneToTen.length; i++) {
            System.out.print(oneToTenSquare[i] + ", ");
        }
    }


    // String - Java String:
    private static void stringPract() {
        String s1 = "Welcome";
        String s2 = "Welcome";
        String s3 = new String("Welcome");

        boolean compare1 = (s1 == s2);
        System.out.println(compare1);
        boolean compare2 = (s1 == s3);
        System.out.println(compare2);
        s1 = "Hello";
        compare1 = (s1 == s2);
        System.out.println(compare1);

        String s4 = new String("Laszlo");
        String s5 = new String("Balint");
        s4.concat(s5);
        System.out.println(s4);
        s4 = s4.concat(s5);
        System.out.println(s4);

        String s6 = new String("Patika");
        String s7 = new String("Fatima");
        String s8 = new String("Kakika");
        System.out.println(s6.compareTo(s7));
        System.out.println(s6.compareTo(s8));
        System.out.println(s7.compareTo(s8));

        String s9 = 50 + 30 + "Balint" + 40 + 40;
        System.out.println(s9);

        System.out.println(s8.charAt(2));
        System.out.println(Character.isUpperCase(s7.charAt(0)));
        System.out.println(Character.isUpperCase(s7.charAt(s7.length() - 1)));

        String split = new String("This is an awful practice.");
        char[] ch = new char[20];
        split.getChars(8, split.length(), ch, 2);
        System.out.println(ch);

        String str = new String("hello javatpoint how r u");
        int index = str.indexOf('j');
        str.getChars(index, index + 10, ch, 0);
        System.out.println(ch);

        String java = new String("Jesus was not a jealous holy spirit.");
        int indexJ = 0;
        int num = 0;
        System.out.println(java.indexOf('j', indexJ));
        while (java.indexOf('j', indexJ) != -1) {
            indexJ = java.indexOf('j', indexJ) + 1;
            System.out.println(indexJ);
        }
    }

    private static Integer search(String string, Character character) {
        int index = 0;
        int counter = 0;
        while (string.indexOf(character, index) != -1) {
            index = string.indexOf(character, index) + 1;
            counter++;
        }
        return counter;
    }

    private static void secondDegreeEquation() {
        Scanner a = new Scanner(System.in);
        System.out.println("Enter the number 'a': ");
        double num1 = a.nextDouble();
        Scanner b = new Scanner(System.in);
        System.out.println("Enter the number 'b': ");
        double num2 = a.nextDouble();
        Scanner c = new Scanner(System.in);
        System.out.println("Enter the number 'c': ");
        double num3 = a.nextDouble();
        double x;
        double y;
        x = ((-num2) + Math.sqrt(Math.pow(num2, 2) - 4 * num1 * num3)) / (2 * num1);
        y = ((-num2) - Math.sqrt(Math.pow(num2, 2) - 4 * num1 * num3)) / (2 * num1);
        System.out.println("X: " + x);
        System.out.println("Y: " + y);
    }

    private static void dividableByTwoOrThree(int a) {
        if (a % 2 == 0) {
            System.out.println(a + " can be divided by 2.");
        } else {
            System.out.println(a + " cannot be divided by 2.");
        }
        if (a % 3 == 0) {
            System.out.println(a + " can be divided by 3.");
        } else {
            System.out.println(a + " cannot be divided by 3.");
        }
    }

    private static void caseLowerUpper(String string) {
        System.out.println(string.toLowerCase());
        System.out.println(string.toUpperCase());
    }

    private static void divideNormalRest(int a, int b) {
        double result = (a / b) - (a % b);
        System.out.println("Difference of normal and rest divison: " + result);
    }

    private static void randomSumMult() {
        int a = (int)(Math.random() * 11 + 10);
        int b = (int)(Math.random() * 11 + 10);
        System.out.println("Summary of number " + a + " and " + b + ": " + (a + b));
        System.out.println("Multiplication of number " + a + " and " + b + ": " + (a * b));
    }

    private static void randomBigger() {
        int a = (int)(Math.random() * 101);
        int b = (int)(Math.random() * 101);
        if (a > b) {
            System.out.println("A - B equals: " + (a - b));
        } else {
            System.out.println("B - A equals: " + (b - a));
        }
    }

    private static void hundredRandMaxMin() {
        Integer[] intArray = new Integer[100];
        for (int i = 0; i < intArray.length; i++) {
            int rand = (int)(Math.random() * 101);
            intArray[i] = rand;
            System.out.print(intArray[i] + ", ");
        }
        int min = 100;
        int max = 0;
        for (Integer anIntArray : intArray) {
            if (anIntArray > max) {
                max = anIntArray;
            }
            if (anIntArray < min) {
                min = anIntArray;
            }
        }
        System.out.println("Smallest number: " + min);
        System.out.println("Biggest number: " + max);
    }
}

