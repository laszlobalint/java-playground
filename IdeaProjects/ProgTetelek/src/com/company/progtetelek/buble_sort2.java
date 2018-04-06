package com.company.progtetelek;

public class buble_sort2 {
    public static void main (String [] args) {
        int[] items = new int[]{55, 20, 0, -4, 666, 413, 1};
        for (int a :
                bubleSort2(item s)) {
            System.out.println("Item a is: " + a);
        }
    }

    public static int [] bubleSort2 (int [] items) {
        int n = items.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (items[j] > items[j + 1]) {
                    int temp = items[j];
                    items[j] = items[j +1];
                    items[j + 11] = temp;
                }
            }
        }
        return items;
    }
}
