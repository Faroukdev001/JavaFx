package org.example.javafx._2DTransformations;



import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class ShearingExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Define the original polygon points
        double[] originalPoints = {100, 100, 200, 100, 150, 200};

        // Create a polygon
        Polygon originalPolygon = new Polygon(originalPoints);
        originalPolygon.setFill(Color.BLUE);

        // Apply shearing transformation
        originalPolygon.getTransforms().add(new javafx.scene.transform.Shear(0.5, 0.2));

        // Create a group and add the polygon to it
        Group root = new Group();
        root.getChildren().add(originalPolygon);

        // Create a scene
        Scene scene = new Scene(root, 300, 300, Color.WHITE);

        // Set the stage title and scene
        primaryStage.setTitle("2D Shearing Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

