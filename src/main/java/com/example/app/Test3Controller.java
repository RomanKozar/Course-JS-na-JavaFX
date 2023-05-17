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


public class Test3Controller {

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
            new Questions("1) Який синтаксис має оператор case switch у JavaScript?", new String[]{
                    "switch { }",
                    "switch (умова) { }",
                    "switch (значення) { }",
                    "switch [вираз] { }",
                    "switch (вираз) { }"
            }),
            new Questions("2) Як задати регістр за замовчуванням в інструкції \n switch case?", new String[]{
                    "case default:",
                    "регістр за замовчуванням:",
                    "else case:",
                    "else:",
                    "default:"
            }),
            new Questions("3) Який оператор використовується для порівняння \n виразу в операторі switch case з кожним регістром?", new String[]{
                    "==",
                    "===",
                    "=",
                    "=>",
                    "===="
            }),
            new Questions("4) Що відбувається, якщо в операторі switch case \n опустити оператор break?", new String[]{
                    "Пропускається блок коду для відповідного регістру",
                    "Перевіряється наступний регістр",
                    "Виконується регістр за замовчуванням",
                    "Оператор switch case викликає помилку",
                    "Виконання коду падає на наступний регістр"
            }),
            new Questions("5) Чи можна використовувати декілька міток регістру для \n одного блоку коду в інструкції switch case?", new String[]{
                    "Ні, дозволено використовувати лише одну мітку регістру для одного блоку коду",
                    "Це залежить від версії JavaScript",
                    "Використання декількох міток регістру в JavaScript є застарілим",
                    "Кілька міток регістру дозволено лише для регістру за замовчуванням",
                    "Так, можна використовувати декілька міток регістру для одного блоку коду"
            }),
            new Questions("6) Яке призначення оператора break в операторі \n switch case?", new String[]{
                    "Він завершує весь оператор switch case",
                    "Не є обов'язковим і може бути опущений",
                    "Використовується для обробки помилок у блоці коду",
                    "Перехід до наступного регістру в інструкції switch case",
                    "Виходить з інструкції switch case після виконання блоку коду"
            }),
            new Questions("7) Чи можна використовувати змінну як вираз в \n інструкції case switch?", new String[]{
                    "Ні, у виразах можна використовувати тільки константні значення",
                    "Змінні можна використовувати тільки в регістрі за замовчуванням",
                    "Змінні можна використовувати лише у поєднанні з інструкцією if-else",
                    "Це залежить від типу даних змінної",
                    "Так, змінну можна використовувати як вираз в інструкції case switch"
            }),
            new Questions("8) Які типи даних можна використовувати як вирази в \n операторі switch case?", new String[]{
                    "Об'єктні та масивні типи даних",
                    "Логічні та нульові типи даних",
                    "Усі типи даних",
                    "Тільки примітивні типи даних",
                    "Рядкові та числові типи даних"
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
