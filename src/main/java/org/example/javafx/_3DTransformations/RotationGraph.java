package org.example.javafx._3DTransformations;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class RotationGraph extends Application {

    // Function to rotate points by degrees
    public static List<Point2D.Double> rotate(List<Point2D.Double> points, double degrees) {

        // creates an array of the rotated points
        List<Point2D.Double> rotatedPoints = new ArrayList<>();

        AffineTransform transform = new AffineTransform();

        // rotate about the points
        transform.rotate(Math.toRadians(degrees), points.get(0).getX(), points.get(0).getY());

        for (Point2D.Double point : points) {
            Point2D.Double rotatedPoint = new Point2D.Double();
            transform.transform(point, rotatedPoint);
            rotatedPoints.add(rotatedPoint);
        }
        return rotatedPoints;
    }

    @Override
    public void start(Stage primaryStage) {
        // Define some points forming a triangle
        List<Point2D.Double> points = new ArrayList<>();
        points.add(new Point2D.Double(100, 200));
        points.add(new Point2D.Double(50, 100));
        points.add(new Point2D.Double(200, 100));
        points.add(points.get(0)); // Adding the first point again to close the shape

        // Rotation angle in degrees
        double degrees = 45;

        // Perform rotation
        List<Point2D.Double> rotatedPoints = rotate(points, degrees);

        // Create the x and y axes
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();

        // Create the line chart
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

        // Create the series for original points
        XYChart.Series<Number, Number> originalSeries = new XYChart.Series<>();
        originalSeries.setName("Original Points");
        for (Point2D.Double point : points) {
            originalSeries.getData().add(new XYChart.Data<>(point.getX(), point.getY()));
        }

        // Create the series for rotated points
        XYChart.Series<Number, Number> rotatedSeries = new XYChart.Series<>();
        rotatedSeries.setName("Rotated Points");
        for (Point2D.Double point : rotatedPoints) {
            rotatedSeries.getData().add(new XYChart.Data<>(point.getX(), point.getY()));
        }

        // Add series to the line chart
        lineChart.getData().add(originalSeries);
        lineChart.getData().add(rotatedSeries);

        // Create the scene and set it to the stage
        Scene scene = new Scene(lineChart, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("2D Rotation Graph");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
