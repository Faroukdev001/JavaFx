package org.example.javafx._2DTransformations;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Rotation extends Application {

    // Function to rotate points by degrees
    public static List<Point2D.Double> rotate(List<Point2D.Double> points, double degrees) {
        // creates an array of the rotated points
        List<Point2D.Double> rotatedPoints = new ArrayList<>();

        double radian = Math.toRadians(degrees);

        double cosTheta = Math.cos(radian);
        double sinTheta = Math.sin(radian);

        double originX = points.get(0).getX();
        double originY = points.get(0).getY();

        for (Point2D.Double point : points) {
            double x = point.getX();
            double y = point.getY();

            double rotatedX = originX + (x - originX) * cosTheta - (y - originY) * sinTheta;
            double rotatedY = originY + (x - originX) * sinTheta + (y - originY) * cosTheta;

            rotatedPoints.add(new Point2D.Double(rotatedX, rotatedY));
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

        // Rotation angle in degrees
        double degrees = 45;

        // Perform rotation
        List<Point2D.Double> rotatedPoints = rotate(points, degrees);

        // Create JavaFX Polygon for original points (triangle)
        Polygon originalPolygon = new Polygon();
        for (Point2D.Double point : points) {
            originalPolygon.getPoints().addAll(point.getX(), point.getY());
        }
        originalPolygon.setFill(Color.rgb(0, 0, 255, 0.5));

        // Create JavaFX Polygon for rotated points (triangle)
        Polygon rotatedPolygon = new Polygon();
        for (Point2D.Double point : rotatedPoints) {
            rotatedPolygon.getPoints().addAll(point.getX(), point.getY());
        }
        rotatedPolygon.setFill(Color.rgb(255, 0, 0, 0.5));

        Group root = new Group(originalPolygon, rotatedPolygon);
        Scene scene = new Scene(root, 300, 300);

        primaryStage.setScene(scene);
        primaryStage.setTitle("2D Rotation");
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Define some points forming a triangle
        List<Point2D.Double> points = new ArrayList<>();
        points.add(new Point2D.Double(100, 200));
        points.add(new Point2D.Double(50, 100));
        points.add(new Point2D.Double(200, 100));

        // Rotation angle in degrees
        double degrees = 45;

        // Perform rotation
        List<Point2D.Double> rotatedPoints = rotate(points, degrees);

        // Print rotated points
        System.out.println("Rotated Points:");
        for (Point2D.Double point : rotatedPoints) {
            System.out.println("(" + point.getX() + ", " + point.getY() + ")");
        }

        launch(args);
    }
}

