package com.company.javapractice;

public class primitiveTypes {
    public static void main(String[] args) {
        boolean bo = true; // logikai tipus
        char c1 = 'a'; // karakter tipus
        char c2 = '\u0054'; // ket bajtos, unicode karaktereket tarol!
        byte b1 = 127; // 8 bites egesz tipus
        byte b2 = -128; // minden egesz tipus elojeles!
        short s = 1024; // 16 bites egesz
        int i = 0x7fffffff; // 32 bites egesz
        long l = 0x7fffffffffffffffL; // 64 bites egesz
        float f = 123.123f; // 32 bites lebegopontos tipus
        double d = 5.0; // 64 bites lebegopontos

        //Kiíratás konzolra:
        System.out.println(bo);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);

    sum(args);
    }

    public static void sum(String[] args) {
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            sum += Integer.parseInt(args[i]);
        }
        System.out.println("Summery of the parameters: " + sum);
    }
}

