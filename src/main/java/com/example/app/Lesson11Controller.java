package com.example.app;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Lesson11Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button appExitButton;

    @FXML
    private Button backButton;

    @FXML
    private Button forumButton;

    @FXML
    private Button nextButton;

    @FXML
    private Button questionButton0;

    @FXML
    private Button questionButton1;

    @FXML
    private Button questionButton2;
    @FXML
    private Button headButton;

    @FXML
    private Button videoButton;

    @FXML
    private WebView webView;

    private WebEngine engine;

    @FXML
    void initialize() {
        engine = webView.getEngine();
        loadPage();

        backButton.setOnAction(event -> {
            backButton.getScene().getWindow().hide();
            openNewSceneLesson("app.fxml");
        });
        videoButton.setOnAction(event -> {
            videoButton.getScene().getWindow().hide();
            openNewSceneVideo("Video10.fxml");
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
    public  void loadPage(){
        engine.load("https://www.programiz.com/javascript/online-compiler/");

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
    public void openNewSceneVideo(String window) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(window)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("LearnCode");
        stage.setScene(new Scene(root, 1060, 740));
        stage.show();
    }



}
