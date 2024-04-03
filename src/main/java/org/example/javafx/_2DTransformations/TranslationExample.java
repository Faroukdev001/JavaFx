package org.example.javafx._2DTransformations;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.awt.geom.Point2D;

public class TranslationExample extends Application {

    private Point2D[] translate(Point2D[] points, double tx, double ty) {
        Point2D[] translatedPoints = new Point2D[points.length];

        for (int i = 0; i < points.length; i++) {
            double x = points[i].getX() + tx;
            double y = points[i].getY() + ty;
            translatedPoints[i] = new Point2D.Double(x, y);
        }

        // Print the coordinates of translated points
        System.out.println("Translated Points:");
        for (Point2D p : translatedPoints) {
            System.out.println("(" + p.getX() + ", " + p.getY() + ")");
        }

        return translatedPoints;
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

        // Perform translation
        Point2D[] translatedPoints = translate(points, 50, 50); // Translate by (50, 50)

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

        // Plot translated points and lines
        for (int i = 0; i < translatedPoints.length - 1; i++) {
            Line translatedLine = new Line(translatedPoints[i].getX(), translatedPoints[i].getY(),
                    translatedPoints[i + 1].getX(), translatedPoints[i + 1].getY());
            translatedLine.setStroke(Color.RED);
            pane.getChildren().add(translatedLine);
        }
        // Connect last translated point with the first to close the translated triangle
        Line translatedLine = new Line(translatedPoints[translatedPoints.length - 1].getX(),
                translatedPoints[translatedPoints.length - 1].getY(),
                translatedPoints[0].getX(), translatedPoints[0].getY());
        translatedLine.setStroke(Color.RED);
        pane.getChildren().add(translatedLine);

        // Create a scene and set it in the stage
        Scene scene = new Scene(pane, 500, 400);
        primaryStage.setTitle("2D Translation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

