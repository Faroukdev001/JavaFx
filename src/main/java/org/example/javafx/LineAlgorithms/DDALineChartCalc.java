package org.example.javafx.LineAlgorithms;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class DDALineChartCalc extends Application {

    @Override
    public void start(Stage stage) {
        int x1 = 0, y1 = 0;
        int x2 = 4, y2 = 6;
        System.out.println("DDA Line Algorithm:");
        System.out.println("Starting point: (" + x1 + ", " + y1 + ")");
        System.out.println("Ending point: (" + x2 + ", " + y2 + ")");
        System.out.println("Calculating iterations:");

        // creates a dataset
        XYChart.Series<Number, Number> series = createDataset(x1, y1, x2, y2);

        // creates a chart
        LineChart<Number, Number> chart = createChart(series);

        // Create a scene with the chart
        Scene scene = new Scene(chart, 800, 600);

        // Set the scene in the stage
        stage.setScene(scene);
        stage.setTitle("DDA Line Chart");
        stage.show();
    }

    private XYChart.Series<Number, Number> createDataset(int x1, int y1, int x2, int y2) {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        int dx = x2 - x1;
        int dy = y2 - y1;
        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        double xinc = (double) dx / steps;
        double yinc = (double) dy / steps;

        double x = x1;
        double y = y1;

        // this loop calculate the coordinates of all the points
        for (int i = 0; i <= steps; i++) {
            series.getData().add(new XYChart.Data<>(Math.round(x), Math.round(y)));
            x += xinc;
            y += yinc;
            System.out.println("Iteration " + (i + 1) + ": (" + Math.round(x) + ", " + Math.round(y) + ")");
        }
        return series;
    }

    private LineChart<Number, Number> createChart(XYChart.Series<Number, Number> series) {
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("X");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Y");

        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle("DDA Line Chart");
        chart.getData().add(series);

        return chart;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
