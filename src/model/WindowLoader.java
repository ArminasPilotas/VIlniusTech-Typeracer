<<<<<<< HEAD
package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public final class WindowLoader{

    public void loadGameWindow(AnchorPane anchorPane) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("../view/GameWindow.fxml"));
        anchorPane.getChildren().setAll(pane);
    }

}
=======
package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public final class WindowLoader{

    public void loadGameWindow(AnchorPane anchorPane) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("../view/GameWindow.fxml"));
        anchorPane.getChildren().setAll(pane);
    }

}
>>>>>>> de77b63f8efce10dd1e2a6689b8f03c8e3e5a713
