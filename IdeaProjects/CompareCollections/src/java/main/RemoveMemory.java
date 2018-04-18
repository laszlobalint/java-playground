import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class RemoveMemory {

    public static double[][] arrayRemove(int num) {
        double[] xValues = new double[num];
        double[] yValues = new double[num];
        double x = 1;
        for (int i = 0; i < num; i++) {
            xValues[i] = x;
            x = x * 10;
        }
        double number = 1;
        for (int i = 0; i < xValues.length; i++) {
            double[] array = new double[(int) xValues[i]];
            Runtime runtime = Runtime.getRuntime();
            for (int j = 0; j < xValues[i]; j++) {
                array[j] = number;
                number++;
            }
            array[array.length - 1] = 0;
            double memory = runtime.totalMemory() - runtime.freeMemory();
            yValues[i] = memory / 1024;
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
        double number = 1;
        for (int i = 0; i < xValues.length; i++) {
            LinkedList<Double> linkedList = new LinkedList <>();
            for (int j = 0; j < xValues[i]; j++) {
                linkedList.add(number);
                number++;
            }
            Runtime runtime = Runtime.getRuntime();
            linkedList.remove(xValues[i] - 1);
            double memory = runtime.totalMemory() - runtime.freeMemory();
            yValues[i] = memory / 1024;
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
        double number = 1;
        for (int i = 0; i < xValues.length; i++) {
            ArrayList<Double> arrayList = new ArrayList <> ();
            for (int j = 0; j < xValues[i]; j++) {
                arrayList.add(number);
                number++;
            }
            Runtime runtime = Runtime.getRuntime();
            arrayList.remove(xValues[i] - 1);
            double memory = runtime.totalMemory() - runtime.freeMemory();
            yValues[i] = memory / 1024;
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
        double number = 1;
        for (int i = 0; i < xValues.length; i++) {
            HashSet<Double> hashSet = new HashSet<> ();
            for (int j = 0; j < xValues[i]; j++) {
                hashSet.add(number);
                number++;
            }
            Runtime runtime = Runtime.getRuntime();
            hashSet.remove(xValues[i] - 1);
            double memory = runtime.totalMemory() - runtime.freeMemory();
            yValues[i] = memory / 1024;
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
        double number = 1;
        for (int i = 0; i < xValues.length; i++) {
            TreeSet<Double> treeSet = new TreeSet <>();
            for (int j = 0; j < xValues[i]; j++) {
                treeSet.add(number);
                number++;
            }
            Runtime runtime = Runtime.getRuntime();
            treeSet.remove(xValues[i] - 1);
            double memory = runtime.totalMemory() - runtime.freeMemory();
            yValues[i] = memory / 1024;
        }
        return new double[][]{xValues, yValues};
    }
}
