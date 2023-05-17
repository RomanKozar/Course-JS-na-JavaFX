package com.example.app;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Video2Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button appExitButton;

    @FXML
    private Button back10SecondButton;

    @FXML
    private Button back5SecondButton;

    @FXML
    private Button backButton;

    @FXML
    private Button forumButton;

    @FXML
    private Button forward10SecondButton;

    @FXML
    private Button forward5SecondButton;

    @FXML
    private MediaView mediaView;

    @FXML
    private Button pauseButton;

    @FXML
    private Button playButton;

    @FXML
    private Button resetButton;
    @FXML
    private Button headButton;

    @FXML
    void playMedia(ActionEvent event) {
        mediaPlayer.play();
    }
    @FXML
    void pauseMedia(ActionEvent event) {
        mediaPlayer.pause();
    }
    @FXML
    void resetMedia(ActionEvent event) {
        if(mediaPlayer.getStatus() != MediaPlayer.Status.READY) {
            mediaPlayer.seek(Duration.seconds(0.0));
        }
    }
    @FXML
    void forward10Seconds(ActionEvent event) {
        Duration currentTime = mediaPlayer.getCurrentTime();
        Duration forwardTime = currentTime.add(Duration.seconds(10.0));
        mediaPlayer.seek(forwardTime);
    }
    @FXML
    void forward5Seconds(ActionEvent event) {
        Duration currentTime = mediaPlayer.getCurrentTime();
        Duration forwardTime = currentTime.add(Duration.seconds(5.0));
        mediaPlayer.seek(forwardTime);
    }
    @FXML
    void back10Seconds(ActionEvent event) {
        Duration currentTime = mediaPlayer.getCurrentTime();
        Duration backwardTime = currentTime.subtract(Duration.seconds(10.0));
        mediaPlayer.seek(backwardTime);
    }
    @FXML
    void back5Seconds(ActionEvent event) {
        Duration currentTime = mediaPlayer.getCurrentTime();
        Duration backwardTime = currentTime.subtract(Duration.seconds(5.0));
        mediaPlayer.seek(backwardTime);
    }

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;


    @FXML
    void initialize() {
        file = new File("D://Документи//Курсова//App//src//main//resources//com//example//app//video//Video_Lesson_2.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);

        backButton.setOnAction(event -> {
            backButton.getScene().getWindow().hide();
            openNewSceneLesson("Lesson3.fxml");
        });
        headButton.setOnAction(event -> {
            headButton.getScene().getWindow().hide();
            openNewSceneLesson("app.fxml");
        });

        forumButton.setOnAction(event -> {
            HyperLinkHelp("https://replace.org.ua/forum/26/");
        });
    }

    public void HyperLinkHelp(String url){
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
    public void openNewSceneLesson(String window) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(window)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("LearnCode");
        stage.setScene(new Scene(root, 1530, 800));
        stage.show();
    }

}
