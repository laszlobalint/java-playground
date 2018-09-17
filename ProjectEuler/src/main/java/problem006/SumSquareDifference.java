package problem006;

public class SumSquareDifference {
    private static long HUNDRED = 100L;
    private static long SUM_OF_SQUARE;
    private static long SQUARE_OF_SUM;

    private long sumSquareDifference() {
        for (long i = 1; i <= HUNDRED; i++) {
            SUM_OF_SQUARE += (long) Math.pow(i, 2);
            SQUARE_OF_SUM += i;
        }
        SQUARE_OF_SUM = (long) Math.pow(SQUARE_OF_SUM, 2);
        return SQUARE_OF_SUM - SUM_OF_SQUARE;
    }

    public static void main(String[] args) {
        SumSquareDifference sumSquareDifference = new SumSquareDifference();
        System.out.println("Difference between the sum of the squares of the first one hundred natural numbers and the square of the first one hundred natural numbers and the square of the sum: " + sumSquareDifference.sumSquareDifference());
    }
}
