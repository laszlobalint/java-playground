package com.company.progtetelek;

import java.util.Arrays;

public class ProgTetelek {
        public static void main(String[] args) {
            int[] a = {45, 7, 1, 78, 97, 113, 4, 2};
            int[] b = {56, 889, 23, 556, -3, 66, -34, 2};
            int[] szamok = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                szamok[i] = Integer.parseInt(args[i]);
                System.out.println(args[i]);
            }
            ProgTetelek.forLoop(a);
            System.out.println(Arrays.toString(a)); // forLoop gives back only 'array', so it must be converted 'toString'.
            System.out.println(union(a, b)); // union returns 'Arrays.toString(empty) -> so no need to use Array.toString here.
        }


        protected static int[] forLoop(int[] array) {
            int i;
            int j;
            int min;
            for (i = 0; i < array.length; i++) {
                min = i;
                for (j = i + 1; j < array.length; j++) {
                    if (array[j] < array[min]) {
                        min = j;
                    }
                }
                if (i != min) {
                    int temp = array[i];
                    array[i] = array[min];
                    array[min] = temp;
                }
            }
            return array;
        }

        public static String union(int[] a, int[] b) {
            int i, j, k;
            int[] empty = new int[a.length + b.length]; // not a good solution, because fills the remaining "spots" with 0s.
            for (i = 0; i < a.length; i++) {
                empty[i] = a[i];
            }
            k = a.length;
            for (j = 0; j < b.length; j++) {
                i = 0;
                while (i < a.length && b[j] != a[i]) {
                    i++;
                }
                if (i >= a.length) {
                    empty[k] = b[j];
                    k++;
                }
            }
            return Arrays.toString(empty);
        }
    }
