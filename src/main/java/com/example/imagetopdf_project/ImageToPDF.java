package com.example.imagetopdf_project;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane; // +
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public final class ImageToPDF extends Application {

    private Desktop desktop = Desktop.getDesktop();

    @Override
    public void start(final Stage stage) {
        stage.setTitle("Image to PDF convert");

        final FileChooser fileChooser = new FileChooser();
        final Button mainButton = new Button("Select JPG Images");

        mainButton.setPrefWidth(300);
        mainButton.setPrefHeight(90);
        mainButton.setStyle("-fx-background-color: #343434; -fx-font-size: 30; -fx-text-fill: white");

        mainButton.setOnAction(
        new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                configureFileChooser(fileChooser);
                List<File> list = fileChooser.showOpenMultipleDialog(stage);
                if (list != null) {
                    for (File file : list) {
                        String file_path = file.toString();
                        System.out.println("Processing...");
                        //openFile(file);
                        try {
                            InsertImagePDF.insert(file_path);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

        final GridPane inputGridPane = new GridPane();
        GridPane.setConstraints(mainButton, 0, 1);
        inputGridPane.getChildren().addAll(mainButton);

        final Pane rootGroup = new VBox(2);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(200, 200, 200, 200));

        stage.setScene(new Scene(rootGroup));
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private static void configureFileChooser(final FileChooser fileChooser) {
        fileChooser.setTitle("View Pictures");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
    }

    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(ImageToPDF.class.getName()).log(
                    Level.SEVERE, null, ex
            );
        }
    }

}