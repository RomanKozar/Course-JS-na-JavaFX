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

public class Article8Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;
    @FXML
    private Button headButton;

    @FXML
    private Button forumButton;
    @FXML
    private Button nextButton;

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
        engine.load("https://webdoky.org/uk/docs/Web/JavaScript/Reference/Global_Objects/Object/#opys");
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
