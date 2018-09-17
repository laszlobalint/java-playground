package problem001;

import java.awt.*;
import java.util.ArrayList;

public class MultiplesOfThreeAndFive {
    private final int LIMIT = 1000;
    private static int sumOfNums;
    private static ArrayList<Integer> numList = new ArrayList<>();

    private int multipliesCounter() {
        int i = 0;
        while (i < LIMIT) {
            if ((i % 3 == 0) || (i % 5 == 0)) {
                sumOfNums += i;
                numList.add(i);
            }
            i++;
        }
        return sumOfNums;
    }

    public static void main(String[] args) {
        MultiplesOfThreeAndFive multiplesOfThreeAndFive = new MultiplesOfThreeAndFive();
        multiplesOfThreeAndFive.multipliesCounter();
        System.out.println("The sum of all the multiples of 3 or 5 below 1000: " + sumOfNums);
        System.out.println("The actual numbers are: " + numList);;
    }
}
