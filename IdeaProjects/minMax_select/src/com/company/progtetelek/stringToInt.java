package com.company.progtetelek;

public class stringToInt {
    public static void main(String [] args) {
        int [] nums = stringArrayToIntArray(args);
    }
    public static int [] stringArrayToIntArray(String [] strings) {
        int [] numbers = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            numbers[i] = Integer.parseInt(strings[i]);
            System.out.println(strings[i]);
        }
        return numbers;
    }
}

