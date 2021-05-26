package com.itsh.questions.interview.arrays;

import java.util.Arrays;
import java.util.logging.Logger;

public class RemoveDuplicatesFromArray {
    // Removing means changing duplicate numbers to null or empty value or default value.

    public static void main(String[] args) {
        int[][] testArrays = new int[][]{
                {1, 1, 2, 2, 3, 4, 5},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 2, 3, 4, 5, 6, 7},
                {1, 2, 1, 1, 1, 1, 1},};

        for (int[] input : testArrays) {
            System.out.println("Array with duplicates: " + Arrays.toString(input));
            System.out.println("After removing duplicates: " + Arrays.toString(removeDuplicates(input)));
        }
    }

    // Sort the arrays then remove the duplicates and leave the uniqe values.
    public static int[] removeDuplicates(int[] numbersWithDuplicates) {
        // Sorting array to bring duplicates together
        Arrays.sort(numbersWithDuplicates);

        int[] result = new int[numbersWithDuplicates.length];
        int previous = numbersWithDuplicates[0];
        result[0] = previous;

        for (int i = 1; i < numbersWithDuplicates.length; i++) {
            int ch = numbersWithDuplicates[i];

            if (previous != ch) {
                result[i] = ch;
            }
            previous = ch;
        }
        return result;
    }
}
