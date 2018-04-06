package Fibonacci;

import java.sql.Array;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i <= n; i++) {
            System.out.println(i + ". number: " + fibonacci(i) );
        }
        System.out.println(getNumber(40));
        System.out.println(fibonacciArray(30));
    }

    public static long fibonacci(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static long getNumber(int index) {
        long num1 = 0;
        long num2 = 1;
        long result = 0;
        for (int i = 0; i < index; i++) {
            result = num1 + num2;
            num1 = num2;
            num2 = result;

        } return result;
    }

    public static long fibonacciArray(int n) {
        long[] fiboNumbers = new long[n];
        fiboNumbers[0] = 0;
        fiboNumbers[1] = 1;
        for (int i = 2; i < fiboNumbers.length; i++) {
            fiboNumbers[i] = fiboNumbers[i - 1] + fiboNumbers[i - 2];
        }
        return fiboNumbers[n - 1];
    }
}
