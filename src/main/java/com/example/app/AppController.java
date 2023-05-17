package com.example.app;

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
import javafx.stage.Stage;
import javafx.scene.control.Hyperlink;
import java.awt.Desktop;

public class AppController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button appButtonLesson0;

    @FXML
    private Button appButtonLesson1;

    @FXML
    private Button appButtonLesson10;

    @FXML
    private Button appButtonLesson11;

    @FXML
    private Button appButtonLesson2;

    @FXML
    private Button appButtonLesson3;

    @FXML
    private Button appButtonLesson4;

    @FXML
    private Button appButtonLesson5;

    @FXML
    private Button appButtonLesson6;

    @FXML
    private Button appButtonLesson7;

    @FXML
    private Button appButtonLesson8;

    @FXML
    private Button appButtonLesson9;

    @FXML
    private Button appExitButton;

    @FXML
    private Hyperlink appLinkDocument0;

    @FXML
    private Hyperlink appLinkDocument1;

    @FXML
    private Hyperlink appLinkDocument2;

    @FXML
    private Hyperlink appLinkDocument3;

    @FXML
    private Hyperlink appLinkDocument4;

    @FXML
    private Hyperlink appLinkDocument5;

    @FXML
    private Hyperlink appLinkDocument6;

    @FXML
    private Hyperlink appLinkHelp0;

    @FXML
    private Hyperlink appLinkHelp1;

    @FXML
    private Hyperlink appLinkHelp2;

    @FXML
    private Hyperlink appLinkHelp3;

    @FXML
    private Hyperlink appLinkHelp4;

    @FXML
    private Hyperlink appLinkHelp5;

    @FXML
    private Hyperlink appLinkHelp6;

    @FXML
    private Button articleButton0;

    @FXML
    private Button articleButton1;

    @FXML
    private Button articleButton2;

    @FXML
    private Button articleButton3;

    @FXML
    private Button articleButton4;

    @FXML
    private Button articleButton5;

    @FXML
    private Button articleButton6;

    @FXML
    private Button articleButton7;

    @FXML
    private Button articleButton8;

    @FXML
    private Button forumButton;

    @FXML
    private Button resetButton;

    @FXML
    private Button restoreButton;

    @FXML
    private Button startButton;

    @FXML
    private Button testButton0;

    @FXML
    private Button testButton1;

    @FXML
    private Button testButton2;

    @FXML
    private Button testButton3;
    @FXML
    private Button quizButton;

    @FXML
    void initialize() {
        appExitButton.setOnAction(event -> {
            appExitButton.getScene().getWindow().hide();
            openNewSceneExit("exit.fxml");
        });
        appButtonLesson0.setOnAction(event -> {
            appButtonLesson0.getScene().getWindow().hide();
            openNewSceneLesson("Lesson0.fxml");
        });
        appButtonLesson1.setOnAction(event -> {
            appButtonLesson1.getScene().getWindow().hide();
            openNewSceneLesson("Lesson1.fxml");
        });
        appButtonLesson2.setOnAction(event -> {
            appButtonLesson2.getScene().getWindow().hide();
            openNewSceneLesson("Lesson2.fxml");
        });
        appButtonLesson3.setOnAction(event -> {
            appButtonLesson3.getScene().getWindow().hide();
            openNewSceneLesson("Lesson3.fxml");
        });
        appButtonLesson4.setOnAction(event -> {
            appButtonLesson4.getScene().getWindow().hide();
            openNewSceneLesson("Lesson4.fxml");
        });
        appButtonLesson5.setOnAction(event -> {
            appButtonLesson5.getScene().getWindow().hide();
            openNewSceneLesson("Lesson5.fxml");
        });
        appButtonLesson6.setOnAction(event -> {
            appButtonLesson6.getScene().getWindow().hide();
            openNewSceneLesson("Lesson6.fxml");
        });
        appButtonLesson7.setOnAction(event -> {
            appButtonLesson7.getScene().getWindow().hide();
            openNewSceneLesson("Lesson7.fxml");
        });
        appButtonLesson8.setOnAction(event -> {
            appButtonLesson8.getScene().getWindow().hide();
            openNewSceneLesson("Lesson8.fxml");
        });
        appButtonLesson9.setOnAction(event -> {
            appButtonLesson9.getScene().getWindow().hide();
            openNewSceneLesson("Lesson9.fxml");
        });
        appButtonLesson10.setOnAction(event -> {
            appButtonLesson10.getScene().getWindow().hide();
            openNewSceneLesson("Lesson10.fxml");
        });
        appButtonLesson11.setOnAction(event -> {
            appButtonLesson11.getScene().getWindow().hide();
            openNewSceneLesson("Lesson11.fxml");
        });
        articleButton0.setOnAction(event -> {
            articleButton0.getScene().getWindow().hide();
            openNewSceneLesson("Article0.fxml");
        });
        articleButton1.setOnAction(event -> {
            articleButton1.getScene().getWindow().hide();
            openNewSceneLesson("Article1.fxml");
        });
        articleButton2.setOnAction(event -> {
            articleButton2.getScene().getWindow().hide();
            openNewSceneLesson("Article2.fxml");
        });
        articleButton3.setOnAction(event -> {
            articleButton3.getScene().getWindow().hide();
            openNewSceneLesson("Article3.fxml");
        });
        articleButton4.setOnAction(event -> {
            articleButton4.getScene().getWindow().hide();
            openNewSceneLesson("Article4.fxml");
        });
        articleButton5.setOnAction(event -> {
            articleButton5.getScene().getWindow().hide();
            openNewSceneLesson("Article5.fxml");
        });
        articleButton6.setOnAction(event -> {
            articleButton6.getScene().getWindow().hide();
            openNewSceneLesson("Article6.fxml");
        });
        articleButton7.setOnAction(event -> {
            articleButton7.getScene().getWindow().hide();
            openNewSceneLesson("Article7.fxml");
        });
        articleButton8.setOnAction(event -> {
            articleButton8.getScene().getWindow().hide();
            openNewSceneLesson("Article8.fxml");
        });
        testButton0.setOnAction(event -> {
            testButton0.getScene().getWindow().hide();
            openNewSceneTest("Test0.fxml");
        });
        testButton1.setOnAction(event -> {
            testButton1.getScene().getWindow().hide();
            openNewSceneTest("Test1.fxml");
        });
        testButton2.setOnAction(event -> {
            testButton2.getScene().getWindow().hide();
            openNewSceneTest("Test2.fxml");
        });
        testButton3.setOnAction(event -> {
            testButton3.getScene().getWindow().hide();
            openNewSceneTest("Test3.fxml");
        });
        startButton.setOnAction(event -> {
            startButton.getScene().getWindow().hide();
            openNewSceneLesson("Lesson1.fxml");
        });

        appLinkDocument0.setOnAction(event -> {
         HyperLinkDoc("https://uk.javascript.info/");
        });
        appLinkDocument1.setOnAction(event -> {
            HyperLinkDoc("https://uk.javascript.info/");
        });
        appLinkDocument2.setOnAction(event -> {
            HyperLinkDoc("https://uk.javascript.info/");
        });
        appLinkDocument3.setOnAction(event -> {
            HyperLinkDoc("https://uk.javascript.info/");
        });
        appLinkDocument4.setOnAction(event -> {
            HyperLinkDoc("https://uk.javascript.info/");
        });
        appLinkDocument5.setOnAction(event -> {
            HyperLinkDoc("https://uk.javascript.info/");
        });
        appLinkDocument6.setOnAction(event -> {
            HyperLinkDoc("https://uk.javascript.info/");
        });


        appLinkHelp0.setOnAction(event -> {
            HyperLinkHelp("https://replace.org.ua/forum/26/");
        });
        appLinkHelp1.setOnAction(event -> {
            HyperLinkHelp("https://replace.org.ua/forum/26/");
        });
        appLinkHelp2.setOnAction(event -> {
            HyperLinkHelp("https://replace.org.ua/forum/26/");
        });
        appLinkHelp3.setOnAction(event -> {
            HyperLinkHelp("https://replace.org.ua/forum/26/");
        });
        appLinkHelp4.setOnAction(event -> {
            HyperLinkHelp("https://replace.org.ua/forum/26/");
        });
        appLinkHelp5.setOnAction(event -> {
            HyperLinkHelp("https://replace.org.ua/forum/26/");
        });
        appLinkHelp6.setOnAction(event -> {
            HyperLinkHelp("https://replace.org.ua/forum/26/");
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

    public void HyperLinkDoc(String url){
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void openNewSceneExit(String window) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(window)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Exit");
        stage.setScene(new Scene(root, 367, 158));
        stage.show();
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

    public void openNewSceneTest(String window) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(window)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("LearnCode");
        stage.setScene(new Scene(root, 1000, 565));
        stage.show();
    }


}
