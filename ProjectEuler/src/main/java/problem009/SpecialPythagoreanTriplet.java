package problem009;

import java.io.Console;

public class SpecialPythagoreanTriplet {
    private static double a;
    private static double b;
    private static double c;
    private static long product;

    public static void main(String[] args) {
        SpecialPythagoreanTriplet specialPythagoreanTriplet = new SpecialPythagoreanTriplet();
        specialPythagoreanTriplet.findProduct();
    }

    private void findProduct() {
        for (a = 1; a < 1000; a++) {
            for (b = a + 1; b < 1000; b++) {
                c = 1000 - a - b;
                if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
                    System.out.println("The product of Pythagorean triplet for which is a+b+c=1000: " + (product = (long) (a * b * c)));
                }
            }
        }
    }
}
