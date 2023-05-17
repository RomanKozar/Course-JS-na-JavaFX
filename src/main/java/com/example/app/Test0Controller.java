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


public class Test0Controller {

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
            new Questions("1) Де можна використовувати JavaScript?", new String[]{
                    "Cерверні додатки",
                    "Мобільні додатки",
                    "Веб-додатки",
                    "Прикладне програмне забезпечення",
                    "Можна у всіх перерахованих"
            }),
            new Questions("2) У чому різниця між локальною та \n глобальною змінною?", new String[]{
                    "Відмінностей нема",
                    "Локальні видно всюди, глобальні лише у функціях",
                    "Глобальні можна перевизначати, локальні - ні",
                    "Локальні можна перевизначати, глобальні - ні",
                    "Глобальні видно всюди, локальні лише у функціях"
            }),
            new Questions("3) Хто є власником торгової марки JavaScript?", new String[]{
                    "Microsoft Corporation",
                    "Sun Microsystems",
                    "Netscape Communications",
                    "Intel",
                    "Oracle Corporation"
            }),
            new Questions("4) Яка змінна записана неправильно?", new String[]{
                    "var num = STRING;",
                    "var isDone = 0;",
                    "var b = false;",
                    "let number = 8.6",
                    "var number = 12,5"
            }),
            new Questions("5) Яке ключове слово використовується для \n оголошення змінних в JavaScript?", new String[]{
                    "let",
                    "const",
                    "variable",
                    "int",
                    "var"
            }),
            new Questions("6) Як перевірити тип даних змінної в JavaScript?", new String[]{
                    "type",
                    "checkType",
                    "instanceof",
                    "dataType",
                    "typeof"
            }),
            new Questions("7) Який оператор використовується для порівняння \n значень за рівністю в JavaScript?", new String[]{
                    "==",
                    "=",
                    "!=",
                    "<>",
                    "==="
            }),
            new Questions("8) Який метод використовується для додавання \n нового елементу в кінець масиву в JavaScript?", new String[]{
                    "pop()",
                    "shift()",
                    "unshift()",
                    "append()",
                    "push()"
            }),
            new Questions("9) Як отримати довжину рядка в JavaScript?", new String[]{
                    "count()",
                    "size()",
                    "sizeOf()",
                    "length",
                    "length()"
            }),
            new Questions("10) Яка функція використовується для виводу даних у \n консоль в JavaScript?", new String[]{
                    "print()",
                    "display()",
                    "console()",
                    "output()",
                    "log()"
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
            openNewSceneTest("Test1.fxml");
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
