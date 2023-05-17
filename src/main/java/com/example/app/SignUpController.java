package com.example.app;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import com.example.app.BaseData.DatabaseHandler;
import com.example.app.BaseData.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button signUpButton;

    @FXML
    private Button signUpBack;

    @FXML
    private CheckBox signUpCheckBoxFemale;

    @FXML
    private CheckBox signUpCheckBoxMale;

    @FXML
    private CheckBox signUpCheckBoxNonName;

    @FXML
    private TextField signUpLastName;

    @FXML
    private TextField signUpName;

    @FXML
    private TextField signUpSpecialty;

    @FXML
    void initialize() {
        signUpButton.setOnAction(event -> {
            SignUpNewUser();
            signUpButton.getScene().getWindow().hide();
            openNewScene("hello-view.fxml");
        });

        signUpBack.setOnAction(event -> {
            signUpBack.getScene().getWindow().hide();
            openNewScene("hello-view.fxml");
        });
    }
    private void SignUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String firstName = signUpName.getText();
        String lastName = signUpLastName.getText();
        String userName = login_field.getText();
        String password = password_field.getText();
        String specialty = signUpSpecialty.getText();
        String gender = "";
        if(signUpCheckBoxMale.isSelected()){
            gender = "Чоловік";
        } else if (signUpCheckBoxFemale.isSelected()){
            gender = "Дівчина";
        } else {
            gender = "NonName";
        }

        User user = new User(firstName, lastName, userName, password, specialty, gender);

        dbHandler.signUpUser(user);
    }

    public void openNewScene(String window) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(window)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Exit");
        stage.setScene(new Scene(root, 700, 400));
        stage.show();
    }

}
