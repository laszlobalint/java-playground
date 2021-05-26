package com.company.javapractice;

public class arrayPract {
    public static void main(String[] args) {
        int twoDmatrix[][] = new int[4][3];
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int k = 0;
        for (int i = 0; i < twoDmatrix.length; i++) {
            for (int j = 0; j < twoDmatrix[i].length; j++) {
                twoDmatrix[i][j] = arr[k];
                k++;
            }
        }
        for (int i = 0; i < twoDmatrix.length; i++) {
                System.out.print("\n");
            for (int j = 0; j < twoDmatrix[i].length; j++) {
                System.out.print(twoDmatrix[i][j] + " ");
            }
        }
    }
}