package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements LoginCallback,Initializable {

    @FXML
    AnchorPane aPane;

    @FXML
    TextField txtID;

    @FXML
    TextField txtPassword;

    @FXML
    Label msgL;

    Stage mainStage;

    LoginSocketI loginSocketI;

    public Controller(){
        loginSocketI = SocketImplementation.getInstance();
        loginSocketI.setLoginCallback(Controller.this);

       new Thread(){
            @Override
            public void run() {
                super.run();

                loginSocketI.initSocket();
            }
        }.start();

    }

    @FXML
    public void onSignInClick(ActionEvent actionEvent) {
        loginSocketI.LoginUser(txtID.getText(),txtPassword.getText());
    }

    @FXML
    public void onSignUpClick(ActionEvent actionEvent) {
        loginSocketI.RegisterUSer(txtID.getText(),txtPassword.getText());
    }

    @Override
    public void onLogSuccess(String msg) {
        switch (msg){
            case "NotFound":
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        msgL.setText("ID or Passwrod not Found");
                    }
                });

                break;
            case "Found":
                Platform.runLater(new Runnable() {
                    @Override public void run() {
                        try{
                            Stage p  = new Stage();
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxmls/chatForm.fxml"));
                            Parent root1 = (Parent) fxmlLoader.load();
                            p.setTitle("Chat Form");
                            p.setScene(new Scene(root1, 597, 622));
                            p.show();
                            txtPassword.getScene().getWindow().hide();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

                break;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       // mainStage = (Stage) aPane.getScene().getWindow();
    }
}
