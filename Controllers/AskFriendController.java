package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * Created by yasin_000 on 12.12.2017.
 */
public class AskFriendController implements Initializable{

    @FXML
    Label askFriends;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String str [] = new String [5];
        str [0]="This movie is really cool";
        str [1]="This one sucks , no need to watch ";
        str [2]="Bro , I gave 10 points to this movie without thinking a sec";
        str [3]="Who knows that this one is one of the best movies I have ever watched";
        str [4]="That is a hiddent treasure ";

        int randomNum = new Random().nextInt((5) + 1);
        askFriends.setText(str[randomNum]);
    }

    public void goMain(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("res/homePage.fxml"));

        stage.setTitle("HomePage");
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }
}
