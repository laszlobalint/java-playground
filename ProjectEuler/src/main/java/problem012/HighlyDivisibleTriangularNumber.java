package problem012;

public class HighlyDivisibleTriangularNumber {

    public static int triangleNumber(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int j = 0;
        int n = 0;
        int numberOfDivisors = 0;

        while (numberOfDivisors <= 500) {
            numberOfDivisors = 0;
            j++;
            n = triangleNumber(j);

            for (int i = 1; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    numberOfDivisors++;
                }
            }
            numberOfDivisors *= 2;
        }

        long finish = System.currentTimeMillis();

        System.out.println(n);
        System.out.println("Time taken: " + (finish - start) + " milliseconds.");
    }
}
