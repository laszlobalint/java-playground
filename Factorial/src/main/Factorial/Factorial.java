package Factorial;

public class Factorial {

    public static void main(String[] args) {
        System.out.println("Factorial result (iteration) for number 5 is " + factorialIter(5));
        System.out.println("Factorial result (iteration) for number 10 is " + factorialIter(10));
        System.out.println("Factorial result (iteration) for number 20 is " + factorialIter(20));
        System.out.println();
        System.out.println("Factorial result (recursion) for number 5 is " + factorialRecu(5));
        System.out.println("Factorial result (recursion) for number 10 is " + factorialRecu(10));
        System.out.println("Factorial result (recursion) for number 20 is " + factorialRecu(20));
        System.out.println();
        testFactorial();
    }

    public static long factorialIter(int n) {
        long factResult = 1;
        for (int i = 1; i <= n; i++) {
            factResult = factResult * i;
        }
        return factResult;
    }

    public static long factorialRecu(int n) {
        long result;
        if (n <= 1) {
            return 1;
        } else {
            result = factorialRecu(n - 1) * n;
            return result;
        }
    }

    public static void testFactorial() {
            long startTime = System.nanoTime();
            factorialRecu(20);
            long endTime = System.nanoTime();
            System.out.println("Iteration factorial method for number 20 took " + (endTime - startTime) + " nanoseconds. ");

            startTime = System.nanoTime();
            factorialIter(20);
            endTime = System.nanoTime();
            System.out.println("Recursive factorial method for number 20 took " + (endTime - startTime) + " nanoseconds. ");
    }
}
