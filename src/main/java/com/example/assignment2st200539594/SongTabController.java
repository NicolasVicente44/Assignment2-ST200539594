package com.example.assignment2st200539594;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.binding.ObjectExpression;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ObservableList<Riff> riffList;
    private int currentRiffIndex = 0;



    // this method reloads the list view by emptying it then setting it with the riffLisT
    //it also gets the sharded list view between the two views from the main class
    public void refreshListView() {
        songsListView.setItems(null);
        songsListView.setItems(Main.getRiffList());
    }






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
















    //view 2's fxml variables and methods

    @FXML
    private TextField albumInput;

    @FXML
    private TextField authorInput;

    @FXML
    private TextField bpmInput;

    @FXML
    private TextField capoPositionInput;

    @FXML
    private Button createNewButton;

    @FXML
    private TextField difficultyInput;

    @FXML
    private TextField genreInput;

    @FXML
    private TextField releaseYearInput;

    @FXML
    private TextField riffNumberInput;

    @FXML
    private TextField songKeyInput;
    @FXML
    private TextField titleInput;

    @FXML
    private TextField riffImagePath;





    @FXML
    private void createNewRiff() {
        String title = titleInput.getText();
        String author = authorInput.getText();
        String album = albumInput.getText();
        String genre = genreInput.getText();
        int releaseYear = Integer.parseInt(releaseYearInput.getText());
        int bpm = Integer.parseInt(bpmInput.getText());
        int capoPosition = 0; // default value

        if (!capoPositionInput.getText().isEmpty()) {
            capoPosition = Integer.parseInt(capoPositionInput.getText());
        }

        String songKey = songKeyInput.getText();
        int riffNumber = Integer.parseInt(riffNumberInput.getText());
        String difficulty = difficultyInput.getText();
        String imagePath = riffImagePath.getText();

        Song song = new Song(title, author, album, releaseYear, genre, songKey);
        Riff riff = new Riff(song, imagePath, difficulty, String.valueOf(capoPosition), bpm, riffNumber);

        Main.getRiffList().add(riff); //to the shared listview

        refreshListView();
    }


















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

        riffList = FXCollections.observableArrayList();
        riffList.add(riffOne);
        riffList.add(riffTwo);





        //adds the list of the riffs to the list view
        songsListView.getItems().addAll(Main.getRiffList());














        /**
         * this method changes the riff displayed if the user clicks on the song in the list view and also makes the names disapleyd in the listview the titles of the riffs songs
         */
        songsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Riff>() {
            @Override
            public void changed(ObservableValue<? extends Riff> observable, Riff oldValue, Riff newValue) {
                if (newValue != null) {
                    switchSong(newValue);
                }
            }
        });

        songsListView.setCellFactory(new Callback<ListView<Riff>, ListCell<Riff>>() {
            @Override
            public ListCell<Riff> call(ListView<Riff> listView) {
                return new ListCell<Riff>() {
                    @Override
                    protected void updateItem(Riff riff, boolean empty) {
                        super.updateItem(riff, empty);
                        if (riff != null) {
                            setText(riff.getTitle());
                        } else {
                            setText(null);
                        }
                    }
                };
            }
        });



    }
}