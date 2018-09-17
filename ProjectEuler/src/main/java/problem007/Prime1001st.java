package problem007;

import java.math.BigInteger;

public class Prime1001st {
    private static final long PRIME_1001ST = 10001L;
    private static long counter = 0L;
    private static BigInteger prime = new BigInteger("1");
    private static BigInteger result;


    private void getBigPrime() {
        for (long i = 0; counter < PRIME_1001ST; i++) {
           prime = prime.nextProbablePrime();
           counter++;
           }
           result = prime;
        }

    public static void main(String[] args) {
        Prime1001st prime1001st = new Prime1001st();
        prime1001st.getBigPrime();
        System.out.println("The " + counter + "'st prime number: " + result);
    }
}
