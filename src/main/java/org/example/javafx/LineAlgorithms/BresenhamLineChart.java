package org.example.javafx.LineAlgorithms;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;

public class BresenhamLineChart extends Application {

    private final ArrayList<Integer> X_coordinates = new ArrayList<>();
    private final ArrayList<Integer> Y_coordinates = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("STARTING POINTS");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        System.out.println("ENDING POINTS");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        scanner.close();

        System.out.println("Bresenham Line Algorithm:");
        System.out.println("Starting point: (" + x1 + ", " + y1 + ")");
        System.out.println("Ending point: (" + x2 + ", " + y2 + ")");
        System.out.println("Calculating iterations:");

        drawBresenhamLine(x1, y1, x2, y2);

        // Create dataset
        XYChart.Series<Number, Number> series = createDataset();

        // Create chart
        LineChart<Number, Number> chart = createChart(series);

        // Create scene with the chart
        Scene scene = new Scene(chart, 800, 600);

        // Set the scene in the stage
        stage.setScene(scene);
        stage.setTitle("Bresenham Line Chart");
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
        xAxis.setLabel("X");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Y");

        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle("Bresenham Line Chart");
        chart.getData().add(series);

        return chart;
    }

    private void drawBresenhamLine(int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int Pk = 2 * dy - dx;
        int xIncrement = x1 < x2 ? 1 : -1;
        int yIncrement = y1 < y2 ? 1 : -1;
        int x = x1;
        int y = y1;

        System.out.println("1     |   PK   |   Pk+1   |  Xk+1  |   Yk+1  |  Plot  ");
        System.out.println("      |        |     " + x1 + "   |  " + y1 + "    |   (" + x1 + "," + y1 + ")     ");

        for (int i = 0; i < dx; i++) {
            if (Pk < 0) {
                Pk += 2 * dy;
            } else {
                Pk += 2 * dy - 2 * dx;
                y += yIncrement;
            }
            x += xIncrement;
            System.out.println("   " + i + "   |   " + Pk + "   |    " + (Pk + 2 * dy) + "    |     " + x + "   |  " + y + "    |   (" + x + "," + y + ")     ");
            X_coordinates.add(x);
            Y_coordinates.add(y);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

