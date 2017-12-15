package Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by yasin_000 on 15.12.2017.
 */
public class UserController {

    public void goMain(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("res/homePage.fxml"));

        stage.setTitle("HomePage");
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }
}
