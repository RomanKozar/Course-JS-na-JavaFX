package com.example.app;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ExitBackController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exitDaButton;

    @FXML
    private Button exitNoButton;

    @FXML
    void initialize() {
        exitDaButton.setOnAction(event -> {
            exitDaButton.getScene().getWindow().hide();
            openNewSceneHello("hello-view.fxml");
        });
        exitNoButton.setOnAction(event -> {
            exitNoButton.getScene().getWindow().hide();
            openNewSceneLesson("app.fxml");
        });

    }

    public void openNewSceneLesson(String window) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(window)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Exit");
        stage.setScene(new Scene(root, 1530, 800));
        stage.show();
    }
    public void openNewSceneHello (String window) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(window)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("LearnCode");
        stage.setScene(new Scene(root, 700, 400));
        stage.show();
    }


}
