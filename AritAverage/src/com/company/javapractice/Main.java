/*
1. Készíts futtatható programot, amely a parancssori paraméterben kapott egész számokkal dolgozik a következő módon. A parancssorban kapott minden x-edik szám számtani átlagát kell meghatározni, de úgy, hogy a feldolgozást a számsor végéről kezdjük. A legutolsó szám adja meg x értékét (pozitív egész), az átlagba beleszámító első szám az utolsó előtti. Feltételezhető, hogy legalább két szám érkezik a parancssorról.
Példa:
> java Atlag 3 4 7 8 12 10 3
Átlag: 8.5 // (10 + 7)/2
 */

package com.company.javapractice;

public class Main {

    public static void main(String[] args) {
        int scale = Integer.parseInt(args[args.length - 1]);
        int counter = 0;
        float sum = 0;
        for (int i = args.length - 2; i >= 0; i -= scale) {
            sum += Integer.parseInt(args[i]);
            counter++;
        }
        System.out.println("Arithmetical average: " + (sum / counter));
    }
}
