package org.example.javafx._2DTransformations;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.awt.geom.Point2D;

public class ScalingExample extends Application {

    private Point2D[] scale(Point2D[] points, double sx, double sy) {
        Point2D[] scaledPoints = new Point2D[points.length];

        for (int i = 0; i < points.length; i++) {
            scaledPoints[i] = new Point2D.Double(points[i].getX() * sx, points[i].getY() * sy);
        }
        // Print the coordinates of scaled points
        System.out.println("Scaled Points:");
        for (Point2D p : scaledPoints) {
            System.out.println("(" + p.getX() + ", " + p.getY() + ")");
        }
        return scaledPoints;
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

        // Scaling factors
        double sx = 2;
        double sy = 1.5;

        // Perform scaling
        Point2D[] scaledPoints = scale(points, sx, sy);

        // Create a pane to hold the lines
        Pane pane = new Pane();

        // Plot original points
        for (int i = 0; i < points.length - 1; i++) {
            Line line = new Line(points[i].getX(), points[i].getY(), points[i + 1].getX(), points[i + 1].getY());
            line.setStroke(Color.BLUE);
            pane.getChildren().add(line);
        }

        // Plot scaled points
        for (int i = 0; i < scaledPoints.length - 1; i++) {
            Line line = new Line(scaledPoints[i].getX(), scaledPoints[i].getY(),
                    scaledPoints[i + 1].getX(), scaledPoints[i + 1].getY());
            line.setStroke(Color.RED);
            pane.getChildren().add(line);
        }

        // Create a scene and set it in the stage
        Scene scene = new Scene(pane, 500, 400);
        primaryStage.setTitle("2D Scaling");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

