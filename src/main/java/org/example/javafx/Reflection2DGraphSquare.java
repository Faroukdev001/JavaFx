package org.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.awt.geom.Point2D;

public class Reflection2DGraphSquare extends Application {

    // Method to perform reflection along the x-axis
    public static Point2D.Double reflectX(Point2D.Double point) {
        double x = point.getX();
        double y = -point.getY(); // Reflect the y-coordinate
        return new Point2D.Double(x, y);
    }

    @Override
    public void start(Stage stage) {
        // Create x and y axes
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();

        // Create a line chart
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

        // Create series for original and reflected points
        XYChart.Series<Number, Number> originalSeries = new XYChart.Series<>();
        originalSeries.setName("Original Points");

        XYChart.Series<Number, Number> reflectedSeries = new XYChart.Series<>();
        reflectedSeries.setName("Reflected Points");

        // Example points to form a square
        Point2D.Double[] originalPoints = {
                new Point2D.Double(1.0, 1.0),
                new Point2D.Double(1.0, 4.0),
                new Point2D.Double(4.0, 4.0),
                new Point2D.Double(4.0, 1.0)
        };

        // Add original points to series
        for (Point2D.Double point : originalPoints) {
            originalSeries.getData().add(new XYChart.Data<>(point.getX(), point.getY()));
        }

        // Perform reflection for each point and add to reflected series
        for (Point2D.Double point : originalPoints) {
            Point2D.Double reflectedPoint = reflectX(point);
            reflectedSeries.getData().add(new XYChart.Data<>(reflectedPoint.getX(), reflectedPoint.getY()));
        }

        // Add series to line chart
        lineChart.getData().add(originalSeries);
        lineChart.getData().add(reflectedSeries);

        // Create scene and set stage
        Scene scene = new Scene(lineChart, 600, 400);
        stage.setScene(scene);
        stage.setTitle("2D Reflection Graph - Square");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
