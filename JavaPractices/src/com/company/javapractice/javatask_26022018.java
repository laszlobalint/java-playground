/*
FELADATOK 1.:
1. Írj egy programot, ami kiírja, hogy "Helló Világ!" !
2. Írj egy programot, ami kiírja egy általad választott vers elsõ versszakát!
3. Írj egy programot, ami kiírja egy általad választott vers elsõ négy versszakát, a versszakokat egy-egy üres sorral elválasztva!
4. Írj egy programot, ami bekér egy egész számot, majd kiírja azt!
5. Írj egy programot, ami bekér egy valós számot, majd kiírja azt!
6. Írj egy programot, ami bekér két egész számot, majd kiírja az összegüket!
7. Írj egy programot, ami bekér két egész számot, majd kiírja a különbségüket (elsõbõl a második)!
8. Írj egy programot, ami bekér két egész számot, majd kiírja a szorzatukat!
9. Írj egy programot, ami bekér két egész számot, majd kiírja az egészosztás szerinti hányadosukat (elsõ per második)!
10. Írj egy programot, ami bekér két egész számot, majd kiírja az egészosztás maradékát (elsõ per második)!
11. Írj egy programot, ami bekér két valós számot, majd kiírja az összegüket!
12. Írj egy programot, ami bekér két valós számot, majd kiírja a különbségüket (elsõbõl a második)!
13. Írj egy programot, ami bekér két valós számot, majd kiírja a szorzatukat!
14. Írj egy programot, ami bekér két valós számot, majd kiírja a hányadosukat (elsõ per második)!
15. Írj egy programot, ami bekér két egész számot, majd kiírja a valós hányadosukat (elsõ per második)!

FELADATOK 2.:
1. Írj egy programot ami az oldalhosszból kiszámítja egy négyzet kerületét és területét!
2. Írj egy programot ami a két oldalhosszból kiszámítja egy téglalap kerületét és területét!
3. Írj egy programot ami a három oldalhosszból kiszámítja egy téglatest felszínét és térfogatát!
4. Írj egy programot ami az átló hosszából kiszámítja egy négyzet kerületét és területét!
5. Írj egy programot ami a sugárból kiszámítja egy kör kerületét és területét!
6. Írj egy programot ami három oldalhosszból kiszámítja egy háromszög kerületét és területét!
7. Írj egy programot ami a két adatból kiszámítja egy négyzet alapú "egyenes" gúla felszínét és térfogatát!
8. Írj egy programot ami a két adatból kiszámítja egy "egyenes" kúp felszínét és térfogatát!
9. Írj egy programot ami egy általad választott adatból kiszámítja egy tetraéder felszínét és térfogatát!
10. Írj egy programot ami egy általad választott adatból kiszámítja egy hexaéder felszínét és térfogatát!
11. Írj egy programot ami egy általad választott adatból kiszámítja egy oktaéder felszínét és térfogatát!
12. Írj egy programot ami egy általad választott adatból kiszámítja egy ikozaéder felszínét és térfogatát!
13. Írj egy programot ami egy általad választott adatból kiszámítja egy dodekaéder felszínét és térfogatát!
14. Írj egy programot ami adott nehézségi gyorsulás (g=9,81 m/s^2) mellett a kilövési szög és a kezdõsebesség alapján kiszámolja, hogy hol lesz a kilõtt test a felhasználó által megadott idõ múlva.
Számítsd ki azt is, hogy mikor és hol éri el a röppálya maximális magasságát. Nem kell számolnod a légellenállással és feltételezd, hogy a terep sík.

FELADATOK 3.:
1. Írj egy programot ami bekéri egy dolgozat lehetséges maximális és aktuális pontszámát, majd kiírja, hogy a dolgozat sikeres vagy sikertelen volt! A dolgozat akkor sikeres, ha az aktuális pontszám legalább a maximális pontszám fele. [a,b,c,d]
2. Írj egy programot ami egy jegyhez (osztályzathoz) megadja a szöveges értékelést, vagy kiírja, ha rossz értéket kapott! [a,b,c,d]
3. Írj egy programot ami leosztályoz egy maximálisan 100 pontos dolgozatot az 50,65,80,90 ponthatárok szerint! A határérték a jobb jegyhez tartozik. Ha a pontszám negatív vagy száznál nagyobb, akkor írja ki, hogy hibás az adat! [a,b,c,d]
4. Írj egy programot, ami egy évszámról eldönti, hogy szökõév-e! [a,b]
5. Írj egy programot ami a hónap sorszáma alapján kiírja a hónap nevét! [a,b,c,d]
*/

package com.company.javapractice;

import java.util.Scanner;
import java.util.Arrays;

public class javatask_26022018 {
    public static void main(String[] args) {
        String lyrics1 = "A csitári hegyek alatt régen leesett a hó.\n" +
                "Azt hallottam, kisangyalom, véled esett el a ló.\n" +
                "Azt hallottam, kisangyalom, véled esett el a ló.\n" +
                "Kitörted a kezedet, mivel ölelsz engemet?\n" +
                "Így hát kedves kisangyalom, nem lehetek a tied.\n";

        String lyrics2 = "A csitári hegyek alatt régen leesett a hó.\n" +
                "Azt hallottam, kisangyalom, véled esett el a ló.\n" +
                "Azt hallottam, kisangyalom, véled esett el a ló.\n" +
                "Kitörted a kezedet, mivel ölelsz engemet?\n" +
                "Így hát kedves kisangyalom, nem lehetek a tied.\n" +
                "\n" +
                "Amott látok az ég alatt egy madarat repülni,\n" +
                "De szeretnék a rózsámnak egy levelet küldeni,\n" +
                "Repülj madár, ha lehet, vidd el ezt a levelet,\n" +
                "Mondd meg az én galambomnak, ne sirasson engemet.\n" +
                "\n" +
                "Repülj madár, ha lehet, vidd el ezt a levelet,\n" +
                "Mondd meg az én galambomnak, ne sirasson engemet.\n" +
                "\n" +
                "Arra alá van egy erdő, jajj de nagyon messze van,\n" +
                "kerek erdő közepében két rozmaring bokor van,\n" +
                "egyik hajlik vállamra, másik a babáméra\n" +
                "így hát kedves kisangyalom tiéd leszek valaha.\n" +
                "\n" +
                "Egyik hajlik vállamra, másik a babáméra\n" +
                "így hát kedves kisangyalom tiéd leszek valaha.";

        String[] verse = {"A csitári hegyek alatt régen leesett a hó.",
                "Azt hallottam, kisangyalom, véled esett el a ló.",
                "Azt hallottam, kisangyalom, véled esett el a ló.",
                "Kitörted a kezedet, mivel ölelsz engemet?",
                "Így hát kedves kisangyalom, nem lehetek a tied.",
                "",
                "Amott látok az ég alatt egy madarat repülni,",
                "De szeretnék a rózsámnak egy levelet küldeni,",
                "Repülj madár, ha lehet, vidd el ezt a levelet,",
                "Mondd meg az én galambomnak, ne sirasson engemet.",
                "",
                "Repülj madár, ha lehet, vidd el ezt a levelet,",
                "Mondd meg az én galambomnak, ne sirasson engemet.",
                "",
                "Arra alá van egy erdő, jajj de nagyon messze van,",
                "kerek erdő közepében két rozmaring bokor van,",
                "egyik hajlik vállamra, másik a babáméra",
                "így hát kedves kisangyalom tiéd leszek valaha.",
                "",
                "Egyik hajlik vállamra, másik a babáméra",
                "így hát kedves kisangyalom tiéd leszek valaha."};

        javatask_26022018 showNum = new javatask_26022018();
        showNum.showFloatNum();
        // Calling method if it is not static -> By making a new object (javatask...)

        month();
        leap();
        success();
        greeting();
        poem(lyrics1);
        poem(lyrics2);
        firstRows();
        showIntNum();

        showNum.showFloatNum();

        sumIntNums();
        difIntNums();
        mulIntNums();
        divIntNums();
        sumFloatNums();
        diFloatNums();
        mulFloatNums();
        divFloatNums();
        divRatioIntNums();
        divRealNums();
        square(6);
        rectangle(7, 11);
        cuboid(11, 15, 18);
        squareDiag(16);
        diagonal(3, 4, 5);
        circle(23);
        pyramid(7, 8.96);
        cone(8, 5);
        mark();
        grade();

    }

    public static void greeting() {
        System.out.println("Hello, World!");
    }

    public static void poem(String song) {
        System.out.println(song);
    }

    public static void firstRows() {

    }

    public static void showIntNum() {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter an integer number: ");
        int number = reader.nextInt();
        System.out.println("You entered: " + number);
    }

    public void showFloatNum() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a float number: ");
        float number = scanner.nextFloat();
        System.out.println("The number is: " + number);
    }

    public static void sumIntNums() {
        Scanner reader1 = new Scanner(System.in);
        System.out.print("Enter the A number: ");
        int number1 = reader1.nextInt();
        Scanner reader2 = new Scanner(System.in);
        System.out.print("Enter the B number: ");
        int number2 = reader2.nextInt();
        System.out.println("Summery of A and B number: " + (number1 + number2));
    }

    public static void difIntNums() {
        Scanner reader1 = new Scanner(System.in);
        System.out.print("Enter the A number: ");
        int number1 = reader1.nextInt();
        Scanner reader2 = new Scanner(System.in);
        System.out.print("Enter the B number: ");
        int number2 = reader2.nextInt();
        System.out.println("Difference of A and B number: " + (number1 - number2));
    }

    public static void mulIntNums() {
        Scanner reader1 = new Scanner(System.in);
        System.out.print("Enter the A number: ");
        int number1 = reader1.nextInt();
        Scanner reader2 = new Scanner(System.in);
        System.out.print("Enter the B number: ");
        int number2 = reader2.nextInt();
        System.out.println("Multiplication of A and B number: " + (number1 * number2));
    }

    public static void divIntNums() {
        Scanner reader1 = new Scanner(System.in);
        System.out.print("Enter the A number: ");
        int number1 = reader1.nextInt();
        Scanner reader2 = new Scanner(System.in);
        System.out.print("Enter the B number: ");
        int number2 = reader2.nextInt();
        int result = number1 / number2;
        System.out.println("Dividation of A and B number: " + result);
    }

    public static void divRatioIntNums() {
        Scanner reader1 = new Scanner(System.in);
        System.out.print("Enter the A number: ");
        int number1 = reader1.nextInt();
        Scanner reader2 = new Scanner(System.in);
        System.out.print("Enter the B number: ");
        int number2 = reader2.nextInt();
        int result = number1 % number2;
        System.out.println("The ratio of A and B number: " + (result));
    }

    public static void sumFloatNums() {
        Scanner reader1 = new Scanner(System.in);
        System.out.print("Enter the A number: ");
        float number1 = reader1.nextFloat();
        Scanner reader2 = new Scanner(System.in);
        System.out.print("Enter the B number: ");
        float number2 = reader2.nextFloat();
        System.out.println("Summery of A and B number: " + (number1 + number2));
    }

    public static void diFloatNums() {
        Scanner reader1 = new Scanner(System.in);
        System.out.print("Enter the A number: ");
        float number1 = reader1.nextFloat();
        Scanner reader2 = new Scanner(System.in);
        System.out.print("Enter the B number: ");
        float number2 = reader2.nextFloat();
        System.out.println("Difference of A and B number: " + (number1 - number2));
    }

    public static void mulFloatNums() {
        Scanner reader1 = new Scanner(System.in);
        System.out.print("Enter the A number: ");
        float number1 = reader1.nextFloat();
        Scanner reader2 = new Scanner(System.in);
        System.out.print("Enter the B number: ");
        float number2 = reader2.nextFloat();
        System.out.println("Multiplication of A and B number: " + (number1 * number2));
    }

    public static void divFloatNums() {
        Scanner reader1 = new Scanner(System.in);
        System.out.print("Enter the A number: ");
        float number1 = reader1.nextFloat();
        Scanner reader2 = new Scanner(System.in);
        System.out.print("Enter the B number: ");
        float number2 = reader2.nextFloat();
        float result = number1 / number2;
        System.out.println("Dividation of A and B number: " + result);
    }

    public static void divRealNums() {
        Scanner reader1 = new Scanner(System.in);
        System.out.println("Enter the A number: ");
        double number1 = reader1.nextDouble();
        Scanner reader2 = new Scanner(System.in);
        System.out.println("Enter the B number: ");
        double number2 = reader2.nextDouble();
        double result = number1 / number2;
        System.out.println("Result of A divided by B: " + result);
    }

    public static void square(double a) {
        double district = a * 4;
        double area = a * a;
        System.out.println("District of the square is: " + district);
        System.out.println("Area of the square is: " + area);
    }

    public static void rectangle(double a, double b) {
        double district = a + b;
        double area = a * b;
        System.out.println("District of the rectangle is: " + district);
        System.out.println("District of the rectangle is: " + area);
    }

    public static void cuboid(double a, double b, double c) {
        double surface = 6 * (a * a);
        double volume = a * b * c;
        System.out.println("Surface of the cuboid is: " + surface);
        System.out.println("Volume of the rectangle is: " + volume);
    }

    public static void squareDiag(double d) {
        double district = d * 2 * Math.sqrt(2);
        double area = d * d / 2;
        System.out.println("District of the cuboid is: " + district);
        System.out.println("Volume of the cuboid is: " + area);
    }

    public static void diagonal(double a, double b, double c) {
        double district = a + b + c;
        double s = district / 2;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        System.out.println("District of the triangle is " + district);
        System.out.println("Area of the triangle is " + area);
    }

    public static void circle(double r) {
        double district = 2 * r * Math.PI;
        double area = r * r * Math.PI;
        System.out.println("District of the circle is " + district);
        System.out.println("Area of the circle is " + area);
    }

    public static void pyramid(double a, double s) {
        double a1 = a / 2;
        double am = Math.sqrt(Math.pow(a1, 2) - Math.pow(s, 2));
        double surface = Math.pow(a, 2) + 4 * (a * am / 2);
        double b = a * Math.sqrt(2) / 2;
        double m = Math.sqrt(Math.pow(s, 2) - Math.pow(b, 2));
        double volume = Math.pow(a, 2) * m / 3;
        System.out.println("Surface of the pyramid: " + surface); //NEM MŰKÖDIK! 164-NEK KELLENE LENNIE.
        System.out.println("Volume of the pyramid: " + volume);
    }

    public static void cone(double h, double r) {
        double a = Math.sqrt(Math.pow(r, 2) + Math.pow(h, 2));
        double surface = Math.PI * Math.pow(r, 2) + Math.PI * r * a;
        double volume = (Math.PI * Math.pow(r, 2) * h) / 3;
        System.out.println("Surface of the cone: " + surface);
        System.out.println("Volume of the cone: " + volume);
    }

    public static void success() {
        Scanner reader1 = new Scanner(System.in);
        System.out.println("How many points could you get maximum on the test? ");
        int maxPoints = reader1.nextInt();
        Scanner reader2 = new Scanner(System.in);
        System.out.println("How many points did you get for your test? ");
        int points = reader2.nextInt();
        if (points > (maxPoints * 0.5)) {
            System.out.println("Success!");
        } else {
            System.out.println("Unsuccessful!");
        }
    }

    public static void mark() {
        Scanner reader1 = new Scanner(System.in);
        System.out.println("How many points could you get maximum on the test? ");
        int maxPoints = reader1.nextInt();
        Scanner reader2 = new Scanner(System.in);
        System.out.println("How many points did you get for your test? ");
        int points = reader2.nextInt();
        if (points < (maxPoints * 0.5)) {
            System.out.println("Fail (1)!");
        } else {
            if (points >= (maxPoints * 0.5) && points < (maxPoints * 0.65)) {
                System.out.println("Pass! (2)");
            } else {
                if (points >= (maxPoints * 0.65) && points < (maxPoints * 0.80)) {
                    System.out.println("Satisfactory! (3)");
                } else {
                    if (points >= (maxPoints * 0.80) && points < (maxPoints * 0.90)) {
                        System.out.println("Good! (4)");
                    } else {
                        if (points >= (maxPoints * 0.90)) {
                            System.out.println("Excellent! (5)");
                        }
                    }
                }
            }
        }
    }

    public static void grade() {
        Scanner reader = new Scanner(System.in);
        System.out.println("How many points did you get for your test? (0-100) ");
        int points = reader.nextInt();
        while (true) {
            if (points < 0 || points > 100) {
                System.out.println("Wrong data input!");
                continue;
            }
            break;
        }
        if (points < 50 && points >= 0) {
            System.out.println("Fail! (1)");
        } else {
            if (points >= 50 && points < 65) {
                System.out.println("Pass! (2)");
            } else {
                if (points >= 65 && points < 80) {
                    System.out.println("Satisfactory! (3)");
                } else {
                    if (points >= 80 && points < 90) {
                        System.out.println("Good! (4)");
                    } else {
                        if (points >= 90 && points <= 100) {
                            System.out.println("Excellent! (5)");
                        }
                    }
                }
            }
        }
    }

    public static void leap() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Type a year, please: ");
        int year = reader.nextInt();
        if ((year % 4 == 0) && (year % 100 != 0) || year % 400 == 0) {
            System.out.println("It is a leap year!");
        } else {
            System.out.println(("It is not a leap year!"));
        }
    }

    public static void month() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Which month do you choose? Give a number, please: ");
        int month = reader.nextInt();
            switch (month) {
                case 1:
                    System.out.println("January");
                    break;
                case 2:
                    System.out.println("February");
                    break;
                case 3:
                    System.out.println("March");
                    break;
                case 4:
                    System.out.println("April");
                    break;
                case 5:
                    System.out.println("May");
                    break;
                case 6:
                    System.out.println("June");
                    break;
                case 7:
                    System.out.println("July");
                    break;
                case 8:
                    System.out.println("August");
                    break;
                case 9:
                    System.out.println("September");
                    break;
                case 10:
                    System.out.println("October");
                    break;
                case 11:
                    System.out.println("November");
                    break;
                case 12:
                    System.out.println("December");
                    break;
                default:
                    System.out.println("Wrong number!");
                    break;
            }
        }
    }
