package problem004;

import java.util.ArrayList;

public class LargestPalindromeProduct {
    private static ArrayList<String> palindromeStringed = new ArrayList<>();
    private static ArrayList<Long> digitsAsChars = new ArrayList<>();
    private static long number1 = 1;
    private static long number2 = 1;



    private void checkForPalindrome() {
        for (long i = 100; i < 1000; i++) {
            for (long j = 100; j < 1000; j++) {
                number1 = i * j;
                if (Long.toString(number1).length() == 6 && Long.toString(number1).charAt(0) == Long.toString(number1).charAt(5) && Long.toString(number1).charAt(1) == Long.toString(number1).charAt(4) && Long.toString(number1).charAt(2) == Long.toString(number1).charAt(3) && number1 > number2) {
                    number2 = number1;
                }
            }
        }
    }

    public static void main(String[] args) {
        LargestPalindromeProduct largestPalindromeProduct = new LargestPalindromeProduct();
        largestPalindromeProduct.checkForPalindrome();
        System.out.println("The largest palindrome made from the product of two 3-digit numbers: " + number2);
        }
    }
