package com.company.progtetelek;

public class buble_sort {
    public static void main (String [] args) {
        int[] items = new int[]{55, 20, 0, -4, 666, 413, 1};
        for (int a :
                bubleSort(items)) {
            System.out.println("Item a is: " + a);
        }
    }

    public static int [] bubleSort (int [] array) {

        int n = array.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}

