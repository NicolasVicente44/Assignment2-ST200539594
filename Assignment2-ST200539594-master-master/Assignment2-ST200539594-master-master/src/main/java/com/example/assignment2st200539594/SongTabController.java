package com.example.assignment2st200539594;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SongTabController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}