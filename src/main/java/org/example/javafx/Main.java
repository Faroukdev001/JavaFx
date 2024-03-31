package org.example.javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Define points for a cube
        double[][] points = {
                {0, 0, 0},
                {1, 0, 0},
                {1, 1, 0},
                {0, 1, 0},
                {0, 0, 1},
                {1, 0, 1},
                {1, 1, 1},
                {0, 1, 1}
        };

        // Define the rotation angle (in radians) and axis (as a unit vector)
        double angle = Math.PI / 4; // Rotate by 45 degrees
        double[] axis = {1, 1, 1};   // Rotate around the diagonal axis

        // Perform rotation
        double[][] rotatedPoints = rotate3D(points, angle, axis);

        // Create a 3D scene
        Group root = new Group();
        Scene scene = new Scene(root, 600, 400, true);
        scene.setFill(Color.LIGHTGRAY);
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-10);
        scene.setCamera(camera);
        // Create boxes for points
        for (double[] point : rotatedPoints) {
            Box box = new Box(0.1, 0.1, 0.1);
            box.setMaterial(new PhongMaterial(Color.RED));
            // Adjust translation so that the center of the box corresponds to the point's coordinates
            box.setTranslateX(point[0]);
            box.setTranslateY(point[1]);
            box.setTranslateZ(point[2]);
            root.getChildren().add(box);
        }

        // Set up the stage
        primaryStage.setTitle("3D Rotation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Function to perform 3D rotation
    public static double[][] rotate3D(double[][] points, double angle, double[] axis) {
        double[][] rotatedPoints = new double[points.length][3];

        // Convert axis to unit vector
        double norm = Math.sqrt(axis[0] * axis[0] + axis[1] * axis[1] + axis[2] * axis[2]);
        double x = axis[0] / norm;
        double y = axis[1] / norm;
        double z = axis[2] / norm;

        // Rotation matrix components
        double cosA = Math.cos(angle);
        double sinA = Math.sin(angle);
        double oneMinusCosA = 1 - cosA;

        // Compute rotation matrix
        double[][] rotationMatrix = {
                {cosA + x * x * oneMinusCosA, x * y * oneMinusCosA - z * sinA, x * z * oneMinusCosA + y * sinA},
                {y * x * oneMinusCosA + z * sinA, cosA + y * y * oneMinusCosA, y * z * oneMinusCosA - x * sinA},
                {z * x * oneMinusCosA - y * sinA, z * y * oneMinusCosA + x * sinA, cosA + z * z * oneMinusCosA}
        };

        // Apply rotation matrix to each point
        for (int i = 0; i < points.length; i++) {
            double x0 = points[i][0];
            double y0 = points[i][1];
            double z0 = points[i][2];

            rotatedPoints[i][0] = rotationMatrix[0][0] * x0 + rotationMatrix[0][1] * y0 + rotationMatrix[0][2] * z0;
            rotatedPoints[i][1] = rotationMatrix[1][0] * x0 + rotationMatrix[1][1] * y0 + rotationMatrix[1][2] * z0;
            rotatedPoints[i][2] = rotationMatrix[2][0] * x0 + rotationMatrix[2][1] * y0 + rotationMatrix[2][2] * z0;
        }

        return rotatedPoints;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
