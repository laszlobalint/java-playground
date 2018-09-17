package problem005;

import java.math.BigInteger;

public class SmallestMultiple implements Runnable {
    private static long number = 1L;
    private static final long n = 20L;

    public static void main(String[] args) {
        new Thread(null, new SmallestMultiple(), "memory", 1<<26).start();
        SmallestMultiple smallestMultiple = new SmallestMultiple();
    }

    public void run() {
        SmallestMultiple smallestMultiple = new SmallestMultiple();
        System.out.println("The smallest positive number that is evenly divisible by all of the numbers from 1 to 20: " + smallestMultiple.getSmallest());
    }

    private long getSmallest() {
        for (long i = 1; i <= n; i++) {
            if (number % i != 0) {
            number = (number * i) / gcdFormula(number, i);
            }
        }
        return number;
    }

    private long gcdFormula(long a, long b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.longValue();
    }
}
