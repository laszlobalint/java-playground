import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.util.ArrayUtils;
import org.jfree.data.xy.DefaultXYDataset;
import javax.swing.*;
import java.util.*;
import java.util.stream.DoubleStream;

public class CompareCollections {

    public static void main(String[] args) {
        double[][] testDiagram = new double[][] {
                {1.5, 2.2, 4.6},
                {5.7, 7.1, 8.9},
        };
        drawDiagram(testDiagram, "3x3 matrix test diagram");
        drawDiagram(create2DArray(7), "Array filling up"); //Double diagram drawer works with 0-9.
        drawDiagram(linkedListGraph(7), "Linked List filling up");
        drawDiagram(arrayListGraph(7), "Array List filling up");
        drawDiagram(hashSetGraph(7), "Hash Set filling up");
        drawDiagram(treeSetGraph(7), "Tree Set filling up");
        drawDiagram(arrayContains(7), "Array contains");
        drawDiagram(linkedListContains(7), "Linked List contains");
        drawDiagram(arrayListContains(7), "Array List contains");
        drawDiagram(hashSetContains(7), "Hash Set contains");
        drawDiagram(treeSetContains(7), "Tree Set contains");
        drawDiagram(arrayListDelete(7), " Array set to null");
        drawDiagram(linkedListDelete(7), "Linked List delete");
        drawDiagram(arrayListDelete(7), "Array List delete");
        drawDiagram(hashSetDelete(7), "Hash Set delete");
        drawDiagram(treeSetDelete(7), "Tree Set delete");
    }

    public static double[][] create2DArray(int num) {
        double[] xValues = new double[num];
        double[] yValues = new double[num];
        double x = 1;
        for (int i = 0; i < num; i++) {
            xValues[i] = x;
            x = x * 10;
        }
        long startTime;
        long endTime;
        double max = 0;
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
        for (int counter = 1; counter < yValues.length; counter++) {
            if (yValues[counter] > max) {
                max = yValues[counter];
            }
        }
        System.out.println("Highest time value for Array (case - num=7): " + max);
        return new double[][]{xValues, yValues};
    }

    public static double[][] arrayContains(int num) {
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
            for (int k = 0; k < xValues[i]; k++) {
                if (array[k] == xValues[i] - 1) {
                    break;
                }
                endTime = System.nanoTime();
                yValues[i] = (endTime - startTime) / 1000000d;
            }
        }
        return new double[][]{xValues, yValues};
    }

    public static double[][] arrayDelete(int num) {
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
            xValues[i - 1] = Double.parseDouble(null);
            endTime = System.nanoTime();
            yValues[i] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{xValues, yValues};
    }

    public static double[][] linkedListGraph(int num) {
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
        double max = 0;
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
        for (int counter = 1; counter < yValues.length; counter++) {
            if (yValues[counter] > max) {
                max = yValues[counter];
            }
        }
        System.out.println("Highest time value for Linked List (case - num=7): " + max);
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
            linkedList.contains(i);
            endTime = System.nanoTime();
            yValues[i] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{xValues, yValues};
    }

    public static double[][] linkedListDelete(int num) {
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
            linkedList.remove(0);
            endTime = System.nanoTime();
            yValues[i] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{xValues, yValues};
    }

    public static double[][] arrayListGraph(int num) {
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
        double max = 0;
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
        for (int counter = 1; counter < yValues.length; counter++) {
            if (yValues[counter] > max) {
                max = yValues[counter];
            }
        }
        System.out.println("Highest time value for Array List (case - num=7): " + max);
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
            arrayList.contains(i);
            endTime = System.nanoTime();
            yValues[i] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{xValues, yValues};
    }

    public static double[][] arrayListDelete(int num) {
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
            arrayList.remove(0);
            endTime = System.nanoTime();
            yValues[i] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{xValues, yValues};
    }

    public static double[][] hashSetGraph(int num) {
        double[] xValues = new double[num];
        double[] yValues = new double[num];
        double x = 1;
        for (int i = 0; i < num; i++) {
            xValues[i] = x;
            x = x * 10;
        }
        long startTime;
        long endTime;
        double max = 0;
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
        for (int counter = 1; counter < yValues.length; counter++) {
            if (yValues[counter] > max) {
                max = yValues[counter];
            }
        }
        System.out.println("Highest time value for Hash Set (case - num=7): " + max);
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
            hashSet.contains(i);
            endTime = System.nanoTime();
            yValues[i] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{xValues, yValues};
    }

    public static double[][] hashSetDelete(int num) {
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
            hashSet.remove(1);
            endTime = System.nanoTime();
            yValues[i] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{xValues, yValues};
    }

    public static double[][] treeSetGraph(int num) {
        double[] xValues = new double[num];
        double[] yValues = new double[num];
        double x = 1;
        for (int i = 0; i < num; i++) {
            xValues[i] = x;
            x = x * 10;
        }
        long startTime;
        long endTime;
        double max = 0;
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
        for (int counter = 1; counter < yValues.length; counter++) {
            if (yValues[counter] > max) {
                max = yValues[counter];
            }
        }
        System.out.println("Highest time value for Tree Set (case - num=7): " + max);
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
        long startTime;
        long endTime;
        double number = 1;
        for (int i = 0; i < xValues.length; i++) {
            TreeSet<Integer> treeSet = new TreeSet <>();
            for (int j = 0; j < xValues[i]; j++) {
                treeSet.add((int)number);
                number++;
            }
            startTime = System.nanoTime();
            treeSet.contains(i);
            endTime = System.nanoTime();
            yValues[i] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{xValues, yValues};
    }

    public static double[][] treeSetDelete(int num) {
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
            treeSet.remove(1d);
            endTime = System.nanoTime();
            yValues[i] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{xValues, yValues};
    }

    public static void showChart(JFreeChart chart) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Charts");

                frame.setSize(600, 400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

                ChartPanel cp = new ChartPanel(chart);

                frame.getContentPane().add(cp);
            }
        });
    }

    public static void drawDiagram(double[][] data, String title) {
        DefaultXYDataset ds = new DefaultXYDataset();
        ds.addSeries("Binary search", data);
        JFreeChart chart = ChartFactory.createXYLineChart(title, "input size", "time", ds,
                PlotOrientation.VERTICAL, true, true, false);

        LogarithmicAxis xAxis = new LogarithmicAxis("input size");

        XYPlot plot = chart.getXYPlot();
        plot.setDomainAxis(xAxis);

        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer)plot.getRenderer();
        renderer.setSeriesShapesVisible(0, true);

        // Show diagram:
        showChart(chart);
    }
}