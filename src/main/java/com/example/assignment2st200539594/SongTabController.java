package com.example.assignment2st200539594;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

public class SongTabController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;


    /**
     * these two methods switch between scenes
     */
    //scene 1
    public void switchToSceneOne(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Riff-Library.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    //scene 2
    public void switchToSceneTwo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreateNew.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




    //song list
    private List<Riff> riffList;
    private int currentRiffIndex = 0;







    /*
    view 1's methods and view content
     */

    @FXML
    private Label albumLabel;

    @FXML
    private Label authorLabel;

    @FXML
    private Label beatsPerMinuteLabel;

    @FXML
    private Label capoPositionLabel;

    @FXML
    private Label difficultyLabel;

    @FXML
    private Label genreLabel;

    @FXML
    private Label releaseYearLabel;

    @FXML
    private Label riffNumberLabel;

    @FXML
    private Button sceneSwitcherButton;

    @FXML
    private Label songKeyLabel;

    @FXML
    private ListView<Riff> songsListView;

    @FXML
    private ImageView tabImageView;

    @FXML
    private Label titleLabel;




    /**
     * this method switchs the song and riff displayed
     */
    public void switchSong (Riff riff) {

        if(riff == null) {
            riff = riffList.get(0);
        }


        //riff object cycler in the list view
        Riff currentRiff = riff;

        tabImageView.setPreserveRatio(true); // Preserve aspect ratio of the image


        //change the riff values displayed
        beatsPerMinuteLabel.setText(String.valueOf(currentRiff.getBeatsPerMinute()));
        capoPositionLabel.setText(currentRiff.getCapoPosition());
        difficultyLabel.setText(currentRiff.getDifficulty());
        riffNumberLabel.setText(String.valueOf(currentRiff.getRiffNumber()));

        titleLabel.setText(currentRiff.getTitle());
        albumLabel.setText(currentRiff.getAlbum());
        authorLabel.setText(currentRiff.getAuthor());
        genreLabel.setText(currentRiff.getGenre());
        releaseYearLabel.setText(String.valueOf(currentRiff.getReleaseYear()));
        songKeyLabel.setText(currentRiff.getSongKey());

        //image
        Image img = new Image(getClass().getResourceAsStream(currentRiff.getRiffImagePath()));
        tabImageView.setImage(img);




    }







    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        //first song
        Song songOne = new Song("Crazy Train", "Ozzy Osbourne", "Blizzard of Oz", 1978, "Metal", "F#");
        Riff riffOne = new Riff(songOne, "crazyTrainRiff1.png", "Medium", "0", 138, 1);

        // Second song
        Song songTwo = new Song("Stairway to Heaven", "Led Zeppelin", "Led Zeppelin IV", 1971, "Rock", "A");
        Riff riffTwo = new Riff(songTwo, "stairwayToHeavenRiff1.png", "Easy", "0", 63, 1);



        riffList = new ArrayList<>();
        riffList.add(riffOne);
        riffList.add(riffTwo);



        //adds the list of the riffs to the list view
        songsListView.getItems().addAll(riffList);






    }
}