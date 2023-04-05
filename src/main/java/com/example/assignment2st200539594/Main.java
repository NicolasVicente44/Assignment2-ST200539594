package com.example.assignment2st200539594;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Riff-Library.fxml"));
        Scene scene1 = new Scene(root);
        stage.setTitle("Guitar Tab Library");
        stage.setScene(scene1);
        stage.show();


        //guitar icon/logo for the application
        Image icon = new Image(getClass().getResourceAsStream("guitarlogo.png"));
        stage.getIcons().add(icon);
    }

    public static void main(String[] args) {
        launch();
    }
}