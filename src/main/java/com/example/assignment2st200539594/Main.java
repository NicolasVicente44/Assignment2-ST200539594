package com.example.assignment2st200539594;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static ObservableList<Riff> riffList = FXCollections.observableArrayList();

    public static ObservableList<Riff> getRiffList() {
        return riffList;
    }

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
        // Initialize the riffList with sample data this is done in the main method so that i can share the listview between the two viewes and dynamically have the items displayed regardless of the view
        //first song
        Song songOne = new Song("Crazy Train", "Ozzy Osbourne", "Blizzard of Oz", 1978, "Metal", "F#");
        Riff riffOne = new Riff(songOne, "crazyTrainRiff1.png", "Medium", "0", 138, 1);

        // Second song
        Song songTwo = new Song("Stairway to Heaven", "Led Zeppelin", "Led Zeppelin IV", 1971, "Rock", "A");
        Riff riffTwo = new Riff(songTwo, "stairwayToHeavenRiff1.png", "Easy", "0", 63, 1);

        //THird song
        Song songThree = new Song("Bohemian Rhapsody", "Queen", "A Night at the Opera", 1975, "Rock", "Bb");
        Riff riffThree = new Riff(songThree, "bohemianRhapsodyRiff3.png", "Hard", "3", 72, 3);





        riffList = FXCollections.observableArrayList();
        riffList.add(riffOne);
        riffList.add(riffTwo);
        riffList.add(riffThree);


        launch();
    }
}
