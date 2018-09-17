package problem002;

import java.util.ArrayList;

public class EvenFibonacciNumbers {
    private static int evenFibonacciSum;
    private final int LIMIT = 4000000;
    private static ArrayList<Integer> listOfNum = new ArrayList();
    private static int fibonacciNum;

    private ArrayList<Integer> countEvenFibonacci() {
        if (listOfNum.isEmpty()) {
            listOfNum.add(1);
            listOfNum.add(2);
            listOfNum.add(3);
        }
        while (fibonacciNum <= LIMIT) {
            fibonacciNum = ((listOfNum.get(listOfNum.size() - 1) + (listOfNum.get(listOfNum.size() - 2))));
            if (fibonacciNum < LIMIT) listOfNum.add(fibonacciNum);
        }
        return listOfNum;
    }

    private int countEvenFibonacci(ArrayList<Integer> listOfNum) {
        for (int number : listOfNum) {
            if (number % 2 == 0) {
                evenFibonacciSum += number;
            }
        }
        return evenFibonacciSum;
    }

    public static void main(String[] args) {
        EvenFibonacciNumbers evenFibonacciNumbers = new EvenFibonacciNumbers();
        evenFibonacciNumbers.countEvenFibonacci();
        evenFibonacciNumbers.countEvenFibonacci(listOfNum);
        System.out.println("The sum of even-valued Fibonacci number not exceeding four million: " + evenFibonacciSum);
    }
}
