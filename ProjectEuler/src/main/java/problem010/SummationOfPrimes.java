package problem010;

public class SummationOfPrimes {
    private static long primeCount = 0;
    private static long i = 0L;
    private static long num = 0L;

    public static void main(String[] args) {
        SummationOfPrimes summationOfPrimes = new SummationOfPrimes();
        summationOfPrimes.summationPrimes();
    }

    private void summationPrimes() {
        for (i = 1; i <= 2000000L; i++) {
            int counter = 0;
            for (long num = i; num >= 1; num--) {
                if (i % num == 0) {
                    counter += 1;
                }
            }
            if (counter == 2) {
                primeCount += i;
            }
        }
        System.out.println("The sum of all the primes below two million: " + primeCount);
    }
}
