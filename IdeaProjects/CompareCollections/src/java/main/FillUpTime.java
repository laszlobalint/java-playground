import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class FillUpTime {

    public static double[][] arrayFillUp(int num) {
        double[] xValues = new double[num];
        double[] yValues = new double[num];
        double x = 1;
        for (int i = 0; i < num; i++) {
            xValues[i] = x;
            x = x * 10;
        }
        long startTime;
        long endTime;
        double number = 1;
        for (int i = 0; i < xValues.length; i++) {
            double[] array = new double[(int) xValues[i]];
            startTime = System.nanoTime();
            for (int j = 0; j < xValues[i]; j++) {
                array[j] = number;
                number++;
            }
            endTime = System.nanoTime();
            yValues[i] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{xValues, yValues};
    }

    public static double[][] linkedListFillUp(int num) {
        double[] xValues = new double[num];
        double[] yValues = new double[num];
        double x = 1;
        for (int i = 0; i < num; i++) {
            xValues[i] = x;
            x = x * 10;
        }
        long startTime;
        long endTime;
        double number = 1;
        for (int i = 0; i < xValues.length; i++) {
            LinkedList<Double> linkedList = new LinkedList <>();
            startTime = System.nanoTime();
            for (int j = 0; j < xValues[i]; j++) {
                linkedList.add(number);
                number++;
            }
            endTime = System.nanoTime();
            yValues[i] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{xValues, yValues};
    }

    public static double[][] arrayListFillUp(int num) {
        double[] xValues = new double[num];
        double[] yValues = new double[num];
        double x = 1;
        for (int i = 0; i < num; i++) {
            xValues[i] = x;
            x = x * 10;
        }
        long startTime;
        long endTime;
        double number = 1;
        for (int i = 0; i < xValues.length; i++) {
            ArrayList<Double> arrayList = new ArrayList <>();
            startTime = System.nanoTime();
            for (int j = 0; j < xValues[i]; j++) {
                arrayList.add(number);
                number++;
            }
            endTime = System.nanoTime();
            yValues[i] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{xValues, yValues};
    }

    public static double[][] hashSetFillUp(int num) {
        double[] xValues = new double[num];
        double[] yValues = new double[num];
        double x = 1;
        for (int i = 0; i < num; i++) {
            xValues[i] = x;
            x = x * 10;
        }
        long startTime;
        long endTime;
        double number = 1;
        for (int i = 0; i < xValues.length; i++) {
            HashSet<Double> hashSet = new HashSet <>();
            startTime = System.nanoTime();
            for (int j = 0; j < xValues[i]; j++) {
                hashSet.add(number);
                number++;
            }
            endTime = System.nanoTime();
            yValues[i] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{xValues, yValues};
    }

    public static double[][] treeSetFillUp(int num) {
        double[] xValues = new double[num];
        double[] yValues = new double[num];
        double x = 1;
        for (int i = 0; i < num; i++) {
            xValues[i] = x;
            x = x * 10;
        }
        long startTime;
        long endTime;
        double number = 1;
        for (int i = 0; i < xValues.length; i++) {
            TreeSet<Double> treeSet = new TreeSet <> ();
            startTime = System.nanoTime();
            for (int j = 0; j < xValues[i]; j++) {
                treeSet.add(number);
                number++;
            }
            endTime = System.nanoTime();
            yValues[i] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{xValues, yValues};
    }
}
