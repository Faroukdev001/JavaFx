module org.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
//    requires j3dutils;
//    requires j3dcore;
//    requires vecmath;
    requires commons.math3;
//    requires vecmath;
//    requires j3dutils;
//    requires j3dcore;



    opens org.example.javafx to javafx.fxml;
    exports org.example.javafx;
    exports org.example.javafx._2DTransformations;
    exports org.example.javafx._3DTransformations;
    opens org.example.javafx._3DTransformations to javafx.fxml;
    exports org.example.javafx.LineAlgorithms;
    opens org.example.javafx.LineAlgorithms to javafx.fxml;
}