package org.example.javafx._2DTransformations;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.awt.geom.Point2D;

public class ReflectionExample extends Application {

    private Point2D[] reflect(Point2D[] points, boolean xReflect, boolean yReflect) {
        Point2D[] reflectedPoints = new Point2D[points.length];

        for (int i = 0; i < points.length; i++) {
            double x = xReflect ? -points[i].getX() : points[i].getX();
            double y = yReflect ? -points[i].getY() : points[i].getY();
            reflectedPoints[i] = new Point2D.Double(x, y);
        }

        // Print the coordinates of reflected points
        System.out.println("Reflected Points:");
        for (Point2D p : reflectedPoints) {
            System.out.println("(" + p.getX() + ", " + p.getY() + ")");
        }

        return reflectedPoints;
    }

    @Override
    public void start(Stage primaryStage) {
        // Define some points
        Point2D[] points = {
                new Point2D.Double(100, 200),
                new Point2D.Double(100, 100),
                new Point2D.Double(200, 100),
                new Point2D.Double(100, 200)
        };

        // Perform reflection
        Point2D[] reflectedPoints = reflect(points, true, false); // Reflect along x-axis

        // Create a pane to hold the lines
        Pane pane = new Pane();

        // Plot original points and lines
        for (int i = 0; i < points.length - 1; i++) {
            Line line = new Line(points[i].getX(), points[i].getY(), points[i + 1].getX(), points[i + 1].getY());
            line.setStroke(Color.BLUE);
            pane.getChildren().add(line);
        }
        // Connect last point with the first to close the triangle
        Line line = new Line(points[points.length - 1].getX(), points[points.length - 1].getY(),
                points[0].getX(), points[0].getY());
        line.setStroke(Color.BLUE);
        pane.getChildren().add(line);

        // Plot reflected points and lines
        for (int i = 0; i < reflectedPoints.length - 1; i++) {
            Line reflectedLine = new Line(reflectedPoints[i].getX(), reflectedPoints[i].getY(),
                    reflectedPoints[i + 1].getX(), reflectedPoints[i + 1].getY());
            reflectedLine.setStroke(Color.RED);
            pane.getChildren().add(reflectedLine);
        }
        // Connect last reflected point with the first to close the reflected triangle
        Line reflectedLine = new Line(reflectedPoints[reflectedPoints.length - 1].getX(),
                reflectedPoints[reflectedPoints.length - 1].getY(),
                reflectedPoints[0].getX(), reflectedPoints[0].getY());
        reflectedLine.setStroke(Color.RED);
        pane.getChildren().add(reflectedLine);

        // Create a scene and set it in the stage
        Scene scene = new Scene(pane, 500, 400);
        primaryStage.setTitle("2D Reflection");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
