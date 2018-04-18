import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class ContainsMemory {

    public static double[][] arrayContains(int num) {
        double[] xValues = new double[num];
        double[] yValues = new double[num];
        double x = 1;
        for (int i = 0; i < num; i++) {
            xValues[i] = x;
            x = x * 10;
        }
        for (int i = 0; i < xValues.length; i++) {
            double[] array = new double[(int) xValues[i]];
            for (int j = 0; j < xValues[i]; j++) {
                array[j] = j+1;
            }
            double compare = array[array.length-1];
            int k = 100;
            Runtime runtime = Runtime.getRuntime();
            double memory = 0.0;
            while (k >= 0) {
                for (int j = 0; j < array.length; j++) {
                    if (array[j] == compare) {
                        break;
                    }
                }
                memory = runtime.totalMemory() - runtime.freeMemory();
                k--;
            }
            yValues[i] = memory / 1024;
        }
        return new double[][]{xValues, yValues};
    }

    public static double[][] linkedListContains(int num) {
        double[] xValues = new double[num];
        double[] yValues = new double[num];
        double x = 1;
        for (int i = 0; i < num; i++) {
            xValues[i] = x;
            x = x * 10;
        }
        double number = 1;
        for (int i = 0; i < xValues.length; i++) {
            LinkedList<Double> linkedList = new LinkedList <>();
            for (int j = 0; j < xValues[i]; j++) {
                linkedList.add(number);
                number++;
            }
            int k = 100;
            Runtime runtime = Runtime.getRuntime();
            double memory = 0.0;
            while (k >= 100) {
                linkedList.contains(i);
                memory = runtime.totalMemory() - runtime.freeMemory();
                k--;
            }
            yValues[i] = memory / 1024;
        }
        return new double[][]{xValues, yValues};
    }

    public static double[][] arrayListContains(int num) {
        double[] xValues = new double[num];
        double[] yValues = new double[num];
        double x = 1;
        for (int i = 0; i < num; i++) {
            xValues[i] = x;
            x = x * 10;
        }
        double number = 1;
        for (int i = 0; i < xValues.length; i++) {
            ArrayList<Double> arrayList = new ArrayList <> ();
            for (int j = 0; j < xValues[i]; j++) {
                arrayList.add(number);
                number++;
            }
            int k = 100;
            Runtime runtime = Runtime.getRuntime();
            double memory = 0.0;
            while (k >= 100) {
                arrayList.contains(i);
                memory = runtime.totalMemory() - runtime.freeMemory();
                k--;
            }
            yValues[i] = memory / 1024;
        }
        return new double[][]{xValues, yValues};
    }

    public static double[][] hashSetContains(int num) {
        double[] xValues = new double[num];
        double[] yValues = new double[num];
        double x = 1;
        for (int i = 0; i < num; i++) {
            xValues[i] = x;
            x = x * 10;
        }
        double number = 1;
        for (int i = 0; i < xValues.length; i++) {
            HashSet<Double> hashSet = new HashSet<> ();
            for (int j = 0; j < xValues[i]; j++) {
                hashSet.add(number);
                number++;
            }
            int k = 100;
            Runtime runtime = Runtime.getRuntime();
            double memory = 0.0;
            while (k >= 100) {
                hashSet.contains(i);
                memory = runtime.totalMemory() - runtime.freeMemory();
                k--;
            }
            yValues[i] = memory / 1024;
        }
        return new double[][]{xValues, yValues};
    }

    public static double[][] treeSetContains(int num) {
        double[] xValues = new double[num];
        double[] yValues = new double[num];
        double x = 1;
        for (int i = 0; i < num; i++) {
            xValues[i] = x;
            x = x * 10;
        }
        double number = 1;
        for (int i = 0; i < xValues.length; i++) {
            TreeSet<Integer> treeSet = new TreeSet <>();
            for (int j = 0; j < xValues[i]; j++) {
                treeSet.add((int)number);
                number++;
            }
            int k = 100;
            Runtime runtime = Runtime.getRuntime();
            double memory = 0.0;
            while (k >= 100) {
                treeSet.contains(i);
                memory = runtime.totalMemory() - runtime.freeMemory();
                k--;
            }
            yValues[i] = memory / 1024;
        }
        return new double[][]{xValues, yValues};
    }
}
