package com.company.javapractice;

public class bubbleSort {
    public static void main (String [] args) {
        int[] array = new int[]{55, 20, 0, -4, 666, 413, 1};
        for (int a :
                bubbleSort(array)) {
            System.out.println("Next item is: " + a);
        }
        int[] items = new int[]{55, 20, 0, -4, 666, 413, 1};
        for (int b :
                bubbleSort2(items)) {
            System.out.println("Sorted item: " + b);
        }
    }

    public static int [] bubbleSort (int [] array) {
        int n = array.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] =   array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static int [] bubbleSort2 (int [] items) {
        int n = items.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (items[j] > items[j + 1]) {
                    int temp = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = temp;
                }
            }
        }
        return items;
    }
}
