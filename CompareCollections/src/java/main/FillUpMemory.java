import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class FillUpMemory {

    public static double[][] arrayFillUp(int num) {
        double[] xValues = new double[num];
        double[] yValues = new double[num];
        double x = 1;
        for (int i = 0; i < num; i++) {
            xValues[i] = x;
            x = x * 10;
        }
        double max = 0;
        double number = 1;
        for (int i = 0; i < xValues.length; i++) {
            double[] array = new double[(int) xValues[i]];
            Runtime runtime = Runtime.getRuntime();
            for (int j = 0; j < xValues[i]; j++) {
                array[j] = number;
                number++;
            }
            double memory = runtime.totalMemory() - runtime.freeMemory();
            yValues[i] = memory / 1024;
        }
        for (int counter = 1; counter < yValues.length; counter++) {
            if (yValues[counter] > max) {
                max = yValues[counter];
            }
        }
        System.out.println("Highest time value for Array (case - num=7): " + max);
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
        double number = 1;
        double max = 0;
        for (int i = 0; i < xValues.length; i++) {
            LinkedList<Double> linkedList = new LinkedList <>();
            Runtime runtime = Runtime.getRuntime();
            for (int j = 0; j < xValues[i]; j++) {
                linkedList.add(number);
                number++;
            }
            double memory = runtime.totalMemory() - runtime.freeMemory();
            yValues[i] = memory / 1024;
        }
        for (int counter = 1; counter < yValues.length; counter++) {
            if (yValues[counter] > max) {
                max = yValues[counter];
            }
        }
        System.out.println("Highest time value for Linked List (case - num=7): " + max);
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
        double number = 1;
        double max = 0;
        for (int i = 0; i < xValues.length; i++) {
            ArrayList<Double> arrayList = new ArrayList <>();
            Runtime runtime = Runtime.getRuntime();
            for (int j = 0; j < xValues[i]; j++) {
                arrayList.add(number);
                number++;
            }
            double memory = runtime.totalMemory() - runtime.freeMemory();
            yValues[i] = memory / 1024;
        }
        for (int counter = 1; counter < yValues.length; counter++) {
            if (yValues[counter] > max) {
                max = yValues[counter];
            }
        }
        System.out.println("Highest time value for Array List (case - num=7): " + max);
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
        double max = 0;
        double number = 1;
        for (int i = 0; i < xValues.length; i++) {
            HashSet<Double> hashSet = new HashSet <>();
            Runtime runtime = Runtime.getRuntime();
            for (int j = 0; j < xValues[i]; j++) {
                hashSet.add(number);
                number++;
            }
            double memory = runtime.totalMemory() - runtime.freeMemory();
            yValues[i] = memory / 1024;
        }
        for (int counter = 1; counter < yValues.length; counter++) {
            if (yValues[counter] > max) {
                max = yValues[counter];
            }
        }
        System.out.println("Highest time value for Hash Set (case - num=7): " + max);
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
        double max = 0;
        double number = 1;
        for (int i = 0; i < xValues.length; i++) {
            TreeSet<Double> treeSet = new TreeSet <> ();
            Runtime runtime = Runtime.getRuntime();
            for (int j = 0; j < xValues[i]; j++) {
                treeSet.add(number);
                number++;
            }
            double memory = runtime.totalMemory() - runtime.freeMemory();
            yValues[i] = memory / 1024;
        }
        for (int counter = 1; counter < yValues.length; counter++) {
            if (yValues[counter] > max) {
                max = yValues[counter];
            }
        }
        return new double[][]{xValues, yValues};
    }
}
