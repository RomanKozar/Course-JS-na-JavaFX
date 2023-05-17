package com.example.app;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

import com.example.app.BaseData.DatabaseHandler;
import com.example.app.BaseData.User;
import com.example.app.animation.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button authSignInButton;

    @FXML
    private Button loginSighUpButton;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    public void initialize() {

        authSignInButton.setOnAction(event -> {
//            authSignInButton.getScene().getWindow().hide();
            String loginText = login_field.getText().trim();
            String loginPassword = password_field.getText().trim();

            if(!loginText.equals("") && !loginPassword.equals("")){
                loginUser(loginText, loginPassword);
            } else {
                System.out.println("Error");
            }
        });

        loginSighUpButton.setOnAction(event -> {
            loginSighUpButton.getScene().getWindow().hide();
            openNewScene("signUp.fxml");
        });
    }

    private void loginUser(String loginText, String loginPassword) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;

        while(true){
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            counter++;
        }

        if(counter >= 1){
            openNewSceneApp("app.fxml");
            authSignInButton.getScene().getWindow().hide();
        }else{
            Shake userLoginAnim = new Shake(login_field);
            Shake userPassAnim = new Shake(password_field);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();
        }
    }

    public void openNewScene (String window) {
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
    public void openNewSceneApp (String window) {
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
