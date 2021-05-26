import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;

public class CompareCollections {

    public static void main(String[] args) {
        double[][] testDiagram = new double[][] {
                {1.5, 2.2, 4.6},
                {5.7, 7.1, 8.9},
        };
        //Draw test diagram:
        //drawDiagram(testDiagram, "3x3 test diagram");

        // Filling up time:
        //drawDiagram(FillUpTime.arrayFillUp(7), "SimpleArray filling up time");
        //drawDiagram(FillUpTime.linkedListFillUp(7), "LinkedList filling up time");
        //drawDiagram(FillUpTime.arrayListFillUp(7), "ArrayList filling up time");
        //drawDiagram(FillUpTime.hashSetFillUp(7), "HashSet filling up time");
        //drawDiagram(FillUpTime.treeSetFillUp(7), "TreeSet filling up time");

        // Contains time:
        //drawDiagram(ContainsTime.arrayContains(7), "SimpleArray contains time");
        //drawDiagram(ContainsTime.linkedListContains(7), "LinkedList contains time");
        //drawDiagram(ContainsTime.arrayListContains(7), "ArrayList contains time");
        //drawDiagram(ContainsTime.hashSetContains(7), "HashSet contains time");
        //drawDiagram(ContainsTime.treeSetContains(7), "TreeSet contains time");

        // Remove time:
        //drawDiagram(RemoveTime.arrayListRemove(7), "SimpleArray 'remove' time");
        //drawDiagram(RemoveTime.linkedListRemove(7), "LinkedList remove time");
        //drawDiagram(RemoveTime.arrayListRemove(7), "ArrayList remove time");
        //drawDiagram(RemoveTime.hashSetRemove(7), "HashSet remove time");
        //drawDiagram(RemoveTime.treeSetRemove(7), "TreeSet remove time");

        // Filling up memory:
        //drawDiagram(FillUpMemory.arrayFillUp(7), "SimpleArray filling up memory");
        //drawDiagram(FillUpMemory.linkedListFillUp(7), "LinkedList filling up memory");
        //drawDiagram(FillUpMemory.arrayListFillUp(7), "ArrayList filling up memory");
        //drawDiagram(FillUpMemory.hashSetFillUp(7), "HashSet filling up memory");
        //drawDiagram(FillUpMemory.treeSetFillUp(7), "TreeSet filling up memory");

        // Contains memory:
        //drawDiagram(ContainsMemory.arrayContains(7), "SimpleArray contains memory");
        //drawDiagram(ContainsMemory.linkedListContains(7), "LinkedList contains memory");
        //drawDiagram(ContainsMemory.arrayListContains(7), "ArrayList contains memory");
        //drawDiagram(ContainsMemory.hashSetContains(7), "HashSet contains memory");
        //drawDiagram(ContainsMemory.treeSetContains(7), "TreeSet contains memory");

        // Remove memory:
        //drawDiagram(RemoveMemory.arrayRemove(7), "SimpleArray 'remove' memory");
        //drawDiagram(RemoveMemory.linkedListRemove(7), "LinkedList remove memory");
        //drawDiagram(RemoveMemory.arrayListRemove(7), "ArrayList remove memory");
        //drawDiagram(RemoveMemory.hashSetRemove(7), "HashSet remove memory");
        //drawDiagram(RemoveMemory.treeSetRemove(7), "TreeSet remove memory");

        double[][][] fillUpTimes = {FillUpTime.arrayFillUp(7), FillUpTime.linkedListFillUp(7), FillUpTime.arrayListFillUp(7), FillUpTime.hashSetFillUp(7), FillUpTime.treeSetFillUp(7)};
        double[][][] fillUpMemories = {FillUpMemory.arrayFillUp(7), FillUpMemory.linkedListFillUp(7), FillUpMemory.arrayListFillUp(7), FillUpMemory.hashSetFillUp(7), FillUpMemory.treeSetFillUp(7)};
        double[][][] containsTimes = {ContainsTime.arrayContains(7), ContainsTime.linkedListContains(7), ContainsTime.arrayListContains(7), ContainsTime.hashSetContains(7), ContainsTime.treeSetContains(7)};
        double[][][] containsMemories = {ContainsMemory.arrayContains(7), ContainsMemory.linkedListContains(7), ContainsMemory.arrayListContains(7), ContainsMemory.hashSetContains(7), ContainsMemory.treeSetContains(7)};
        double[][][] removeTimes = {RemoveTime.arrayRemove(7), RemoveTime.linkedListRemove(7), RemoveTime.arrayListRemove(7), RemoveTime.hashSetRemove(7), RemoveTime.treeSetRemove(7)};
        double[][][] removeMemories = {RemoveMemory.arrayRemove(7), RemoveMemory.linkedListRemove(7), RemoveMemory.arrayListRemove(7), RemoveMemory.hashSetRemove(7), RemoveMemory.treeSetRemove(7)};

        // Time diagrams:
        drawDiagram(fillUpTimes, "Filling up times", "Time (milliseconds)");
        drawDiagram(containsTimes, "Contains times", "Time (milliseconds)");
        drawDiagram(removeTimes, "Remove times", "Time (milliseconds)");

        // Memory diagram:
        drawDiagram(fillUpMemories, "Filling up memories", "Memory usage (kilobytes)");
        drawDiagram(containsMemories, "Contains memories", "Memory usage (kilobytes)");
        drawDiagram(removeMemories, "Remove memories", "Memory usage (kilobytes)");

        //Bar chart with all maximum data:
        final BarChartCreator barchart = new BarChartCreator("Bar chart");
        barchart.pack();
        RefineryUtilities.centerFrameOnScreen(barchart);
        barchart.setVisible(true);
    }

    public static void showChart(JFreeChart chart) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Charts");
            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            ChartPanel cp = new ChartPanel(chart);
            frame.getContentPane().add(cp);
        });
    }

   public static void drawDiagram(double[][][] data, String name, String yLabel) {
        DefaultXYDataset ds = new DefaultXYDataset();
        ds.addSeries("SimpleArray", data[0]);
        ds.addSeries("LinkedList", data[1]);
        ds.addSeries("ArrayList", data[2]);
        ds.addSeries("HashSet", data[3]);
        ds.addSeries("TreeSet", data[4]);
        JFreeChart chart = ChartFactory.createXYLineChart(name, "Input size", yLabel, ds,
                PlotOrientation.VERTICAL, true, true, false);
        LogarithmicAxis xAxis = new LogarithmicAxis("Input size");
        XYPlot plot = chart.getXYPlot();
        plot.setDomainAxis(xAxis);
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer)plot.getRenderer();
        renderer.setSeriesShapesVisible(0, true);
        showChart(chart);
    }
}