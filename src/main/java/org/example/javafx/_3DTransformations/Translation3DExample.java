package org.example.javafx._3DTransformations;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class Translation3DExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a box
        Box box = new Box(100, 100, 100);

        // Set the material
        PhongMaterial material = new PhongMaterial(Color.BLUE);
        box.setMaterial(material);

        // Create a translation
        Translate translate = new Translate(200, 0, 0);
        box.getTransforms().add(translate);

        // Create a group and add the box to it
        Group root = new Group(box);

        // Create a scene
        Scene scene = new Scene(root, 400, 400, true);

        // Add a perspective camera
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateX(0);
        camera.setTranslateY(0);
        camera.setTranslateZ(-300);
        scene.setCamera(camera);

        // Set the stage title and scene
        primaryStage.setTitle("3D Translation Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

