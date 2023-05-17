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


public class Test1Controller {

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
            new Questions("1) Як правильно оголосити змінну в JavaScript?", new String[]{
                    "var myVar",
                    "let myVar",
                    "const myVar",
                    "myVar",
                    "Всі перераховані вище способи"
            }),
            new Questions("2) Яке з наведених нижче імен змінних не є \n допустимим в JavaScript?", new String[]{
                    " myVariable",
                    "_myVariable",
                    " $мояЗмінна",
                    "MyVariable",
                    "123myVariable"
            }),
            new Questions("3) Яка область видимості змінної, оголошеної з \n ключовим словом `var`?", new String[]{
                    "Область видимості блоку",
                    "Область видимості функції",
                    "Локальна область видимості",
                    "Область видимості об'єкту",
                    "Глобальна область видимості"
            }),
            new Questions("4) Яке ключове слово використовується для визначення \n константної змінної в JavaScript?", new String[]{
                    "var",
                    "let",
                    "const",
                    "тільки const",
                    "Можна використовувати як let, так і const"
            }),
            new Questions("5) Який результат дає додавання числа і рядка в \n JavaScript?", new String[]{
                    "Рядок перетворюється на число",
                    "Число перетворюється в рядок",
                    "Виникає помилка",
                    "Результатом є NaN",
                    "Число і рядок об'єднуються"
            }),
            new Questions("6) Як можна перевірити тип даних змінної в JavaScript?", new String[]{
                    "typeof змінної",
                    "тип змінної",
                    "змінна.typeof",
                    "typeof(змінна)",
                    "typeof змінної"
            }),
            new Questions("7) Який оператор використовується для конкатенації \n рядків у JavaScript?", new String[]{
                    "==",
                    "-",
                    "/",
                    "*",
                    "+"
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

}
