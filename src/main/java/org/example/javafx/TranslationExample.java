package org.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Arrays;

public class TranslationExample extends Application {

    public static double[][] translate(double[][] points, double tx, double ty) {
        double[][] translationMatrix = {{1, 0, tx}, {0, 1, ty}, {0, 0, 1}};

        // Append ones to the points for homogeneous coordinates
        double[][] homogeneousPoints = new double[points.length][points[0].length + 1];
        for (int i = 0; i < points.length; i++) {
            homogeneousPoints[i] = Arrays.copyOf(points[i], points[i].length + 1);
            homogeneousPoints[i][points[i].length] = 1;
        }

        // Apply translation matrix
        double[][] translatedPoints = new double[points.length][2];
        for (int i = 0; i < points.length; i++) {
            double[] point = homogeneousPoints[i];
            double x = point[0] * translationMatrix[0][0] + point[1] * translationMatrix[0][1] + point[2] * translationMatrix[0][2];
            double y = point[0] * translationMatrix[1][0] + point[1] * translationMatrix[1][1] + point[2] * translationMatrix[1][2];
            translatedPoints[i][0] = x;
            translatedPoints[i][1] = y;
        }
        return translatedPoints;
    }


    @Override
    public void start(Stage stage) {
        // Define some points
        double[][] points = {{20, 0}, {60, 0}, {40, 100}};

        // Translation factors
        double tx = 100;
        double ty = 10;

        // Perform translation
        double[][] translatedPoints = translate(points, tx, ty);

        // Print translated points
        System.out.println("Translated points:");
        for (double[] point : translatedPoints) {
            System.out.println(Arrays.toString(point));
        }

        // Create the chart
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("X");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Y");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("2D Translation");

        // Add original points to the chart
        XYChart.Series<Number, Number> originalSeries = new XYChart.Series<>();
        originalSeries.setName("Original");
        for (double[] point : points) {
            originalSeries.getData().add(new XYChart.Data<>(point[0], point[1]));
        }

        // Add translated points to the chart
        XYChart.Series<Number, Number> translatedSeries = new XYChart.Series<>();
        translatedSeries.setName("Translated");
        for (double[] point : translatedPoints) {
            translatedSeries.getData().add(new XYChart.Data<>(point[0], point[1]));
        }

//        lineChart.getData().addAll(originalSeries, translatedSeries);
        lineChart.getData().add(originalSeries);
        lineChart.getData().add(translatedSeries);

        Scene scene = new Scene(lineChart, 800, 600);

        stage.setScene(scene);
        stage.setTitle("2D Translation");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
