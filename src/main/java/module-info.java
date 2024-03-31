module org.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires j3dutils;
    requires j3dcore;
    requires vecmath;


    opens org.example.javafx to javafx.fxml;
    exports org.example.javafx;
}