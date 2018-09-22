package problem015;

public class LatticePaths {

    private static final int GRID_SIZE = 20;

    private void combinatoricSolution() {
        long paths = 1;

        for (int i = 0; i < GRID_SIZE; i++) {
            paths *= (2 * GRID_SIZE) - i;
            paths /= i + 1;
        }
        System.out.println("COMBINATORIC APPROACH: In a 20x20 grid there are " + paths + " possible paths.");
    }

    public static void main(String[] args) {
        LatticePaths latticePaths = new LatticePaths();
        latticePaths.combinatoricSolution();
    }
}
