package com.itsh.questions.interview.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairsThatEqualToNumberInArray {

    public static void main(String[] args) {
        int[] numbers = {2, 4, 3, 5, 7, 8, 9};
        int[] numberWithDuplicates = {2, 4, 3, 5, 6, -2, 4, 7, 8, 9};
        prettyPrint(numbers, 7);
        prettyPrint(numberWithDuplicates, 7);

        prettyBetterPrint(getRandomArray(9), 11);
        prettyBetterPrint(getRandomArray(10), 12);

        prettyInPlacePrint(new int[]{12, 14, 17, 15, 19, 20, -11}, 9);
        prettyInPlacePrint(new int[]{2, 4, 7, 5, 9, 10, -1}, 9);
    }

    // Brute force way to find wto elements in an array thata sum to K.
    public static void printPairs(int[] array, int sum) {
        for (int i = 0; i < array.length; i++) {
            int first = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int second = array[j];

                if ((first + second) == sum) {
                    System.out.printf("(%d, %d) %n", first, second);
                }
            }
        }
    }

    public static void prettyPrint(int[] givenArray, int givenSum) {
        System.out.println("Given array: " + Arrays.toString(givenArray));
        System.out.println("Given sum: " + givenSum);
        System.out.println("Integer numbers, whose sum is equal to value: " + givenSum);
        printPairs(givenArray, givenSum);
        System.out.println();
    }

    // Efficient way to find wto elements in an array thata sum to K.
    public static void printPairsUsingSet(int[] numbers, int n) {
        if (numbers.length < 2) {
            return;
        }
        Set set = new HashSet(numbers.length);

        for (int value :  numbers) {
            int target = n - value;

            // If target number nis not in set then add it
            if (!set.contains(target)) {
                set.add(value);
            } else {
                System.out.printf("(%d, %d) %n", value, target);
            }
        }
    }

    // Utility method to find two elements in an array that sum to K.
    public static void prettyBetterPrint(int[] random, int k) {
        System.out.println("Random integer array: " + Arrays.toString(random));
        System.out.println("Sum: " + k);
        System.out.println("Pair of number from an array whose sum equals " + k);
        printPairsUsingSet(random, k);
        System.out.println();
    }

    // Utility method to return random array of integers in a range o 0 to 15.
    public static int[] getRandomArray(int length) {
        int[] randoms = new int[length];
        for (int i = 0; i < length; i++) {
            randoms[i] = (int) (Math.random() * 15);
        }
        return randoms;
    }

    // In-place solution where you sort an array than scan through it with two moving values.
    public static void printPairsUsingTwoPointers(int[] numbers, int k) {
        if (numbers.length < 2) {
            return;
        }
        Arrays.sort(numbers);

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == k) {
                System.out.printf("(%d, %d) %n", numbers[left], numbers[right]);
                left = left + 1;
                right = right - 1;
            } else if (sum < k) {
                left = left + 1;
            } else if (sum > k) {
                right = right - 1;
            }
        }
    }

    // Utility method to print two elements in an array that sum to K.
    public static void prettyInPlacePrint(int[] random, int k) {
        System.out.println("Input integer array: " + Arrays.toString(random));
        System.out.println("All pairs in an array of integers whose sum is equal to " + k);
        printPairsUsingTwoPointers(random, k);
        System.out.println();
    }
}
