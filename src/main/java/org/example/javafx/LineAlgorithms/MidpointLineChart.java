package org.example.javafx.LineAlgorithms;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;

public class MidpointLineChart extends Application {

    private final ArrayList<Integer> X_coordinates = new ArrayList<>();
    private final ArrayList<Integer> Y_coordinates = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the starting point of x: ");
        int x1 = scanner.nextInt();
        System.out.println("Enter the starting point of y: ");
        int y1 = scanner.nextInt();
        System.out.println("Enter the end point of x: ");
        int x2 = scanner.nextInt();
        System.out.println("Enter the end point of y: ");
        int y2 = scanner.nextInt();
        scanner.close();

        System.out.println("Midpoint Line Algorithm:");
        System.out.println("Starting point: (" + x1 + ", " + y1 + ")");
        System.out.println("Ending point: (" + x2 + ", " + y2 + ")");
        System.out.println("Calculating iterations:");

        calculateMidpointLine(x1, y1, x2, y2);

        // Create dataset
        XYChart.Series<Number, Number> series = createDataset();

        // Create chart
        LineChart<Number, Number> chart = createChart(series);

        // Create scene with the chart
        Scene scene = new Scene(chart, 800, 600);

        // Set the scene in the stage
        stage.setScene(scene);
        stage.setTitle("Midpoint Line Chart");
        stage.show();
    }

    private XYChart.Series<Number, Number> createDataset() {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        int size = X_coordinates.size();

        for (int i = 0; i < size; i++) {
            series.getData().add(new XYChart.Data<>(X_coordinates.get(i), Y_coordinates.get(i)));
        }

        return series;
    }

    private LineChart<Number, Number> createChart(XYChart.Series<Number, Number> series) {
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("X Axis");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Y Axis");

        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle("Midpoint Line Chart");
        chart.getData().add(series);

        return chart;
    }

    private void calculateMidpointLine(int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        int Pk = 2 * dy - dx;

        System.out.println("Iteration |   Pk   |   X   |   Y  |");
        System.out.println("-----------------------------------");
        System.out.printf("   0      |   %d    |  %d   |  %d  |\n",Pk, x1, y1);

        int x = x1;
        int y = y1;

//        X_coordinates.add(x);
//        Y_coordinates.add(y);

        for (int i = 0; i < dx; i++) {
            int Pkn;
            if (Pk < 0) {
                // moves east
                Pkn = Pk + (2 * dy);
                x = x + 1;
            } else {
                // moves north-east
                Pkn = Pk + (2 * dy - 2 * dx);
                x = x + 1;
                y = y + 1;
            }
            System.out.printf("   %d      |   %d   |  %d   |  %d  |\n", i + 1, Pkn, x, y);
            Pk = Pkn;
            X_coordinates.add(x);
            Y_coordinates.add(y);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

