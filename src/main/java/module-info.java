module com.example.imagetopdf_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;
    requires io;
    requires kernel;
    requires layout;


    opens com.example.imagetopdf_project to javafx.fxml;
    exports com.example.imagetopdf_project;
}