package org.example.javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class Scale3DExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Creating a Box
        Box box = new Box(100, 100, 100);

        // Creating a material
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BLUE);

        // Setting material to the box
        box.setMaterial(material);

        // Creating a Group object
        Group root = new Group(box);

        // Scaling the box
        Scale scale = new Scale();
        scale.setX(2); // Scale factor for x-axis
        scale.setY(2); // Scale factor for y-axis
        scale.setZ(2); // Scale factor for z-axis
        box.getTransforms().add(scale);

        // Creating a scene object
        Scene scene = new Scene(root, 600, 400);

        // Setting camera
        PerspectiveCamera camera = new PerspectiveCamera();
        camera.setTranslateZ(-300);

        // Adding camera to the scene
        scene.setCamera(camera);

        // Setting title to the Stage
        primaryStage.setTitle("3D Scaling Example");

        // Adding scene to the stage
        primaryStage.setScene(scene);

        // Displaying the contents of the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
