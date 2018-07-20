package com.itsh.questions.interview.arrays;

import java.util.Arrays;
import org.apache.commons.lang.ArrayUtils;

public class ReverseArrays {
    // Reverse order of a string array and an integer array.

    public static void main(String[] args) {
        int[] intArray = new int[]{101, 102, 103, 104, 105};
        String[] strArray = new String[]{"one", "two", "three", "four", "five"};

        System.out.println("Original integer array: " + Arrays.toString(intArray));
        ArrayUtils.reverse(intArray);
        System.out.println("Reversed integer array: " + Arrays.toString(intArray));

        System.out.println("Original string array: " + Arrays.toString(strArray));
        ArrayUtils.reverse(strArray);
        System.out.println("Reversed string array: " + Arrays.toString(strArray));
    }
}
