import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class RemoveTime {

    public static double[][] arrayRemove(int num) {
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
            for (int j = 0; j < xValues[i]; j++) {
                array[j] = number;
                number++;
            }
            startTime = System.nanoTime();
            array[array.length - 1] = 0;
            endTime = System.nanoTime();
            yValues[i] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{xValues, yValues};
    }

    public static double[][] linkedListRemove(int num) {
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
            for (int j = 0; j < xValues[i]; j++) {
                linkedList.add(number);
                number++;
            }
            startTime = System.nanoTime();
            linkedList.remove(xValues[i] - 1);
            endTime = System.nanoTime();
            yValues[i] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{xValues, yValues};
    }

    public static double[][] arrayListRemove(int num) {
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
            ArrayList<Double> arrayList = new ArrayList <> ();
            for (int j = 0; j < xValues[i]; j++) {
                arrayList.add(number);
                number++;
            }
            startTime = System.nanoTime();
            arrayList.remove((double) xValues[i] - 1);
            endTime = System.nanoTime();
            yValues[i] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{xValues, yValues};
    }

    public static double[][] hashSetRemove(int num) {
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
            HashSet<Double> hashSet = new HashSet<> ();
            for (int j = 0; j < xValues[i]; j++) {
                hashSet.add(number);
                number++;
            }
            startTime = System.nanoTime();
            hashSet.remove(xValues[i] - 1);
            endTime = System.nanoTime();
            yValues[i] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{xValues, yValues};
    }

    public static double[][] treeSetRemove(int num) {
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
            TreeSet<Double> treeSet = new TreeSet <>();
            for (int j = 0; j < xValues[i]; j++) {
                treeSet.add(number);
                number++;
            }
            startTime = System.nanoTime();
            treeSet.remove(xValues[i] - 1);
            endTime = System.nanoTime();
            yValues[i] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{xValues, yValues};
    }
}
