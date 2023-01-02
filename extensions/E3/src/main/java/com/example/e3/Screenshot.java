package com.example.e3;

import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Screenshot extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public static void createScreenshot(Pane pane) {

    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.show();
    }
}

