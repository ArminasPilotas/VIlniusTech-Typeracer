package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.WindowLoader;

import java.io.IOException;


public class WelcomeWindowController {

    public Button continueButton;
    public TextField nicknameField;
    public AnchorPane welcomeWindowPane;

    public void handleButtonAction(ActionEvent actionEvent) throws IOException{
        if(!nicknameField.getText().isEmpty()){
            //loadGameWindow();
            new WindowLoader().loadGameWindow(welcomeWindowPane);
        }

    }
    private void loadGameWindow() throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("../view/GameWindow.fxml"));
        welcomeWindowPane.getChildren().setAll(pane);
    }

}
