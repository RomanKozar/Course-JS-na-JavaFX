package com.example.app;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;


public class Test2Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button CssTestButton;

    @FXML
    private Button HtmlTestButton;

    @FXML
    private Button JavaTestButton;

    @FXML
    private Button MySqlTestButton;

    @FXML
    private ToggleGroup answer;

    @FXML
    private Button answerButton;

    @FXML
    private RadioButton answerRadioButton0;

    @FXML
    private RadioButton answerRadioButton1;

    @FXML
    private RadioButton answerRadioButton2;

    @FXML
    private RadioButton answerRadioButton3;

    @FXML
    private RadioButton answerRadioButton4;
    @FXML
    private Button headButton;

    @FXML
    private Button backButton;

    @FXML
    private Button nextButton;

    @FXML
    private Label questiontext;

    private final Questions[] questions = new Questions[] {
            new Questions("1) Як написати інструкцію if в JavaScript?", new String[]{
                    "if (умова) { }",
                    "if (умова) then { }",
                    "if умова то { }",
                    "if { умова }",
                    "if (умова) { }"
            }),
            new Questions("2) Який синтаксис запису інструкції if-else в JavaScript?", new String[]{
                    "if (умова) { } else { }",
                    "if { умова } else { }",
                    "if (умова) { } else",
                    "if { умова } else",
                    "if (умова) { } else { }"
            }),
            new Questions("3) Як у JavaScript можна перевірити рівність двох \n змінних?", new String[]{
                    "if (змінна1 = змінна2) { }",
                    "if (змінна1 === змінна2) { }",
                    "if (змінна1 = = = змінна2) { }",
                    "if (variable1.equals(variable2)) { }",
                    "if (змінна1 == змінна2) { }"
            }),
            new Questions("4) Як правильно записати інструкцію if з декількома \n умовами в JavaScript?", new String[]{
                    "if (умова1) && (умова2) { }",
                    "if (умова1 & умова2) { }",
                    "if (умова1) || (умова2) { }",
                    "if (умова1 || умова2) { }",
                    "if (умова1 && умова2) { }"
            }),
            new Questions("5) Як записати інструкцію if-else з переходом if-else \n в JavaScript?", new String[]{
                    "if (умова1) { } else { } else { }",
                    "if (умова1) { } else if (умова2) { }",
                    "if (умова1) { } else if { умова2 } else { }",
                    "if { умова1 } else if { умова2 } else { }",
                    "if (умова1) { } else if (умова2) { } else { }"
            }),
            new Questions("6) Як в JavaScript можна перевірити, що змінна не \n дорівнює певному значенню?", new String[]{
                    "if (змінна != значення) { }",
                    "if (variable <> value) { }",
                    "if (variable notEquals value) { }",
                    "if (змінна !=== value) { }",
                    "if (змінна !== значення) { }"
            }),
            new Questions("7) Яке призначення оператора else в операторі if-else?", new String[]{
                    "Він використовується для завершення роботи програми",
                    "Використовується для визначення нової умови",
                    "Не є обов'язковим і може бути опущений",
                    "Виконується, коли умова if є істинною",
                    "Виконується, коли умова if є хибною"
            })

    };

    private int nowQuestion = 0, correctAnswers;


    @FXML
    void initialize() {
        backButton.setOnAction(event -> {
            backButton.getScene().getWindow().hide();
            openNewSceneLesson("app.fxml");
        });
        headButton.setOnAction(event -> {
            headButton.getScene().getWindow().hide();
            openNewSceneLesson("app.fxml");
        });
        nextButton.setOnAction(event -> {
            nextButton.getScene().getWindow().hide();
            openNewSceneTest("Test3.fxml");
        });

        answerButton.setOnAction(event -> {
            RadioButton selectedRadio = (RadioButton) answer.getSelectedToggle();
            if(selectedRadio != null){
                String toggleGroupValue = selectedRadio.getText();

                if(toggleGroupValue.equals(questions[nowQuestion].correctAnswer())){
                    System.out.println("Правильна відповідь");
                    correctAnswers++;
                }else {
                    System.out.println("Неправильна відповідь");
                }
            }
            if(nowQuestion + 1 != questions.length){
                nowQuestion++;

                questiontext.setText(questions[nowQuestion].getQuestion());
                String[] answer = questions[nowQuestion].getAnswer();

                List<String> stringList = Arrays.asList(answer);
//                Collections.shuffle(stringList);

                answerRadioButton0.setText(stringList.get(0));
                answerRadioButton1.setText(stringList.get(1));
                answerRadioButton2.setText(stringList.get(2));
                answerRadioButton3.setText(stringList.get(3));
                answerRadioButton4.setText(stringList.get(4));

                if (selectedRadio != null) {
                    selectedRadio.setSelected(false);
                }
            } else {
                answerRadioButton0.setVisible(false);
                answerRadioButton1.setVisible(false);
                answerRadioButton2.setVisible(false);
                answerRadioButton3.setVisible(false);
                answerRadioButton4.setVisible(false);

                answerButton.setVisible(false);

                questiontext.setText("Ви відповіли правильно на " + correctAnswers + " питання");
            }
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
