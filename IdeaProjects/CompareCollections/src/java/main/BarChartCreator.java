import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class BarChartCreator extends ApplicationFrame {

        public BarChartCreator(final String title) {
            super(title);
            final CategoryDataset dataset1 = createDataset1();

            // create the chart...
            final JFreeChart chart = ChartFactory.createBarChart(
                    "Collections comparison for 1.000.000",
                    "Collection types",
                    "Time (milliseconds)",
                    dataset1,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false
            );

            chart.setBackgroundPaint(Color.white);

            final CategoryPlot plot = chart.getCategoryPlot();
            plot.setBackgroundPaint(new Color(0xEE, 0xEE, 0xFF));
            plot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);

            final CategoryDataset dataset2 = createDataset2();
            plot.setDataset(1, dataset2);
            plot.mapDatasetToRangeAxis(1, 1);

            final CategoryAxis domainAxis = plot.getDomainAxis();
            domainAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
            final ValueAxis axis2 = new NumberAxis("Memory usage (kilobytes)");
            plot.setRangeAxis(1, axis2);

            final LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
            renderer2.setDefaultToolTipGenerator(new StandardCategoryToolTipGenerator());
            plot.setRenderer(1, renderer2);
            plot.setDatasetRenderingOrder(DatasetRenderingOrder.REVERSE);

            final ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new java.awt.Dimension(600, 400));
            setContentPane(chartPanel);

        }

        private CategoryDataset createDataset1() {

            final String series1 = "Filling up";
            final String series2 = "Contains";
            final String series3 = "Remove";

            final String category1 = "SimpleArray";
            final String category2 = "LinkedList";
            final String category3 = "ArrayList";
            final String category4 = "HashSet";
            final String category5 = "TreeSet";

            final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            dataset.addValue(arrayFillUpMaxTime(7), series1, category1);
            dataset.addValue(linkedListFillUpMaxTime(7), series1, category2);
            dataset.addValue(arrayListFillUpMaxTime(7), series1, category3);
            dataset.addValue(hashSetFillUpMaxTime(7), series1, category4);
            dataset.addValue(treeSetFillUpMaxTime(7), series1, category5);

            dataset.addValue(arrayContainsMaxTime(7), series2, category1);
            dataset.addValue(linkedListContainsMaxTime(7), series2, category2);
            dataset.addValue(arrayListContainsMaxTime(7), series2, category3);
            dataset.addValue(hashSetContainsMaxTime(7), series2, category4);
            dataset.addValue(treeSetContainsMaxTime(7), series2, category5);

            dataset.addValue(arrayRemoveMaxTime(7), series3, category1);
            dataset.addValue(linkedListRemoveMaxTime(7), series3, category2);
            dataset.addValue(arrayListRemoveMaxTime(7), series3, category3);
            dataset.addValue(hashSetRemoveMaxTime(7), series3, category4);
            dataset.addValue(treeSetRemoveMaxTime(7), series3, category5);

            return dataset;
        }

        private CategoryDataset createDataset2() {

            final String series1 = "Filling up";
            final String series2 = "Contains";
            final String series3 = "Remove";

            final String category1 = "SimpleArray";
            final String category2 = "LinkedList";
            final String category3 = "ArrayList";
            final String category4 = "HashSet";
            final String category5 = "TreeSet";

            final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            dataset.addValue(arrayFillUpMaxMemory(7), series1, category1);
            dataset.addValue(linkedListFillUpMaxMemory(7), series1, category2);
            dataset.addValue(arrayListFillUpMaxMemory(7), series1, category3);
            dataset.addValue(hashSetFillUpMaxMemory(7), series1, category4);
            dataset.addValue(treeSetFillUpMaxMemory(7), series1, category5);

            dataset.addValue(arrayContainsMaxMemory(7), series2, category1);
            dataset.addValue(linkedListContainsMaxMemory(7), series2, category2);
            dataset.addValue(arrayListContainsMaxMemory(7), series2, category3);
            dataset.addValue(hashSetContainsMaxMemory(7), series2, category4);
            dataset.addValue(treeSetContainsMaxMemory(7), series2, category5);

            dataset.addValue(arrayRemoveMaxMemory(7), series3, category1);
            dataset.addValue(linkedListRemoveMaxMemory(7), series3, category2);
            dataset.addValue(arrayListRemoveMaxMemory(7), series3, category3);
            dataset.addValue(hashSetRemoveMaxMemory(7), series3, category4);
            dataset.addValue(treeSetRemoveMaxMemory(7), series3, category5);

            return dataset;
        }

    public static double arrayFillUpMaxTime(int num) {
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
        double fillMaxTime;
        return fillMaxTime = yValues[yValues.length - 1];
    }

    public static double linkedListFillUpMaxTime(int num) {
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
        double fillMaxTime;
        return fillMaxTime = yValues[yValues.length - 1];
    }

    public static double arrayListFillUpMaxTime(int num) {
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
        double fillMaxTime;
        return fillMaxTime = yValues[yValues.length - 1];
    }

    public static double hashSetFillUpMaxTime(int num) {
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
        double fillMaxTime;
        return fillMaxTime = yValues[yValues.length - 1];
    }

    public static double treeSetFillUpMaxTime(int num) {
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
        double fillMaxTime;
        return fillMaxTime = yValues[yValues.length - 1];
    }

    public static double arrayContainsMaxTime(int num) {
        double[] xValues = new double[num];
        double[] yValues = new double[num];
        long startTime;

        long endTime;
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
            long elapsedTime = 0;
            while (k >= 0) {
                startTime = System.nanoTime();
                for (int j = 0; j < array.length; j++) {
                    if (array[j] == compare) {
                        break;
                    }
                }
                endTime = System.nanoTime();
                elapsedTime += (endTime - startTime);
                k--;
            }
            yValues[i] = (elapsedTime / 100d) / 1000000d;
        }
        double containsMaxTime;
        return containsMaxTime = yValues[yValues.length - 1];
    }

    public static double linkedListContainsMaxTime(int num) {
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
            int k = 100;
            long elapsedTime = 0;
            while (k >= 100) {
                startTime = System.nanoTime();
                linkedList.contains(i);
                endTime = System.nanoTime();
                elapsedTime += (endTime - startTime);
                k--;
            }
            yValues[i] = (elapsedTime / 100d) / 1000000d;
        }
        double containsMaxTime;
        return containsMaxTime = yValues[yValues.length - 1];
    }

    public static double arrayListContainsMaxTime(int num) {
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
            int k = 100;
            long elapsedTime = 0;
            while (k >= 100) {
                startTime = System.nanoTime();
                arrayList.contains(i);
                endTime = System.nanoTime();
                elapsedTime += (endTime -startTime);
                k--;
            }
            yValues[i] = (elapsedTime / 100d) / 1000000d;
        }
        double containsMaxTime;
        return containsMaxTime = yValues[yValues.length - 1];
    }

    public static double hashSetContainsMaxTime(int num) {
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
            int k = 100;
            long elapsedTime = 0;
            while (k >= 100) {
                startTime = System.nanoTime();
                hashSet.contains(i);
                endTime = System.nanoTime();
                elapsedTime += (endTime - startTime);
                k--;
            }
            yValues[i] =  (elapsedTime / 100d) / 1000000d;
        }
        double containsMaxTime;
        return containsMaxTime = yValues[yValues.length - 1];
    }

    public static double treeSetContainsMaxTime(int num) {
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
            int k = 100;
            long elapsedTime = 0;
            while (k >= 100) {
                startTime = System.nanoTime();
                treeSet.contains(i);
                endTime = System.nanoTime();
                elapsedTime += (endTime - startTime);
                k--;
            }
            yValues[i] =  (elapsedTime / 100d) / 1000000d;
        }
        double containsMaxTime;
        return containsMaxTime = yValues[yValues.length - 1];
    }

    public static double arrayRemoveMaxTime(int num) {
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
        double removeMaxTime;
        return removeMaxTime = yValues[yValues.length - 1];
    }

    public static double linkedListRemoveMaxTime(int num) {
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
        double removeMaxTime;
        return removeMaxTime = yValues[yValues.length - 1];
    }

    public static double arrayListRemoveMaxTime(int num) {
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
        double removeMaxTime;
        return removeMaxTime = yValues[yValues.length - 1];
    }

    public static double hashSetRemoveMaxTime(int num) {
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
        double removeMaxTime;
        return removeMaxTime = yValues[yValues.length - 1];
    }

    public static double treeSetRemoveMaxTime(int num) {
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
        double removeMaxTime;
        return removeMaxTime = yValues[yValues.length - 1];
    }

    public static double arrayFillUpMaxMemory(int num) {
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
        double fillMaxMemory;
        return fillMaxMemory = yValues[yValues.length - 1];
    }

    public static double linkedListFillUpMaxMemory(int num) {
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
        double fillMaxMemory;
        return fillMaxMemory = yValues[yValues.length - 1];
    }

    public static double arrayListFillUpMaxMemory(int num) {
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
        double fillMaxMemory;
        return fillMaxMemory = yValues[yValues.length - 1];
    }

    public static double hashSetFillUpMaxMemory(int num) {
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
        double fillMaxMemory;
        return fillMaxMemory = yValues[yValues.length - 1];
    }

    public static double treeSetFillUpMaxMemory(int num) {
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
        double fillMaxMemory;
        return fillMaxMemory = yValues[yValues.length - 1];
    }

    public static double arrayContainsMaxMemory(int num) {
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
        double containsMaxMemory;
        return containsMaxMemory = yValues[yValues.length - 1];
    }

    public static double linkedListContainsMaxMemory(int num) {
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
        double containsMaxMemory;
        return containsMaxMemory = yValues[yValues.length - 1];
    }

    public static double arrayListContainsMaxMemory(int num) {
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
        double containsMaxMemory;
        return containsMaxMemory = yValues[yValues.length - 1];
    }

    public static double hashSetContainsMaxMemory(int num) {
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
        double containsMaxMemory;
        return containsMaxMemory = yValues[yValues.length - 1];
    }

    public static double treeSetContainsMaxMemory(int num) {
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
        double containsMaxMemory;
        return containsMaxMemory = yValues[yValues.length - 1];
    }

    public static double arrayRemoveMaxMemory(int num) {
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
        double removeMaxMemory;
        return removeMaxMemory = yValues[yValues.length - 1];
    }

    public static double linkedListRemoveMaxMemory(int num) {
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
        double removeMaxMemory;
        return removeMaxMemory = yValues[yValues.length - 1];
    }

    public static double arrayListRemoveMaxMemory(int num) {
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
        double removeMaxMemory;
        return removeMaxMemory = yValues[yValues.length - 1];
    }

    public static double hashSetRemoveMaxMemory(int num) {
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
        double removeMaxMemory;
        return removeMaxMemory = yValues[yValues.length - 1];
    }

    public static double treeSetRemoveMaxMemory(int num) {
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
        double removeMaxMemory;
        return removeMaxMemory = yValues[yValues.length - 1];
    }
}
