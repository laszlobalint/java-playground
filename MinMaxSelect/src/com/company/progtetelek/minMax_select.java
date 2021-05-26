package com.company.progtetelek;

import java.util.Arrays;

public class minMax_select {
    public static void main(String[] args) {
        int[] myIntArray1 = new int[]{34, 56, 3, 7, 15, 30};
        int[] myIntArray2 = {10, 30, 3, 8, 2, 34};
        System.out.println(kiv(sorting(myIntArray1)));
        System.out.println(kiv(myIntArray1));
    }

    public static int kiv(int[] array) {
        int i;
        int minimum = array[0];
        for (i = 0; i < array.length; i++) {
            if (array[i] < minimum) {
                minimum = array[i];
            }
        }
        return minimum;
    }

    public static int[] sorting(int[] a) {
        int i, j, min;
        for (i = 0; i < a.length; i++) {
            min = i;
            for (j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            if (i != min) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
        return a;
    }
}
