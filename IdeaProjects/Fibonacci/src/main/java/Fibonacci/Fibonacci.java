package Fibonacci;

public class Fibonacci {
    public static void main(String[] args) {

        fibonacciList(5);
        System.out.println();
        //Starting from 1:
        System.out.println(fibonacci(10));
        //Starting from 1:
        System.out.println(getNumber(10));
        //Starting from 0:
        System.out.println(fibonacciArray(10));
        System.out.println();
        testRuntime();
    }

    public static void fibonacciList(int n) {
        for (int i = 0; i <= n; i++) {
            System.out.println(i + ". number: " + fibonacci(i));
        }
    }

    public static long fibonacci(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static long getNumber(int n) {
        long num1 = 0;
        long num2 = 1;
        long result = 0;
        for (int i = 1; i < n; i++) {
            result = num1 + num2;
            num1 = num2;
            num2 = result;
        } return result;
    }

    public static long fibonacciArray(int n) {
        long[] fiboNumbers = new long[n + 1];
        fiboNumbers[0] = 0;
        fiboNumbers[1] = 1;
        fiboNumbers[2] = 1;
        for (int i = 3; i < fiboNumbers.length; i++) {
            fiboNumbers[i] = fiboNumbers[i - 1] + fiboNumbers[i - 2];
        }
        return fiboNumbers[n];
    }

    public static void testRuntime() {
        long startTime = System.nanoTime();
        fibonacci(20);
        long endTime = System.nanoTime();
        System.out.println("First test took " + (endTime - startTime) + " nanoseconds. ");

        startTime = System.nanoTime();
        getNumber(20);
        endTime = System.nanoTime();
        System.out.println("Second test took " + (endTime - startTime) + " nanoseconds. ");

        startTime = System.nanoTime();
        fibonacciArray(20);
        endTime = System.nanoTime();
        System.out.println("Third test took " + (endTime - startTime) + " nanoseconds. ");
    }
}
