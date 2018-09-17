package problem003;

import java.math.BigInteger;
import java.util.ArrayList;

public class LargestPrimeFactor {
    private static BigInteger number = new BigInteger("600851475143");
    private static ArrayList<BigInteger> primeNumbers = new ArrayList<>();
    private static ArrayList<BigInteger> primeFactors = new ArrayList<>();
    private static BigInteger prime = new BigInteger("2");

    private void calculatePrimeFactor() {
        BigInteger remainder;
        remainder = number.remainder(prime);
        while (!number.equals(BigInteger.ONE)) {
            if (remainder.equals(BigInteger.ZERO)) {
                number = number.divide(prime);
                primeFactors.add(prime);
                calculatePrimeFactor();
            } else {
                prime = prime.nextProbablePrime();
                calculatePrimeFactor();
            }
        }
    }

    public static void main(String[] args) {
        LargestPrimeFactor largestPrimeFactor = new LargestPrimeFactor();
        largestPrimeFactor.calculatePrimeFactor();
        System.out.println("Largest prime factor of the number 600851475143: " + primeFactors.get(primeFactors.size() - 1));
    }
}
