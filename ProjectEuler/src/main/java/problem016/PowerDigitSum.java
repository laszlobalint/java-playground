package problem016;

import java.math.BigInteger;

public class PowerDigitSum {
    private static int sum = 0;

    public static void main(String[] args) {
        String temp = BigInteger.ONE.shiftLeft(1000).toString();
        for (int i = 0; i < temp.length(); i++)
            sum += temp.charAt(i) - '0';
        System.out.println(Integer.toString(sum));
    }
}
