package Controllers;

import Entity.Genre;
import Entity.Movie;
import com.google.gson.Gson;
import db.Upload;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/**
 * Created by yasin_000 on 12.12.2017.
 */
public class SearchController {
    @FXML
    TextField searchedText;
    @FXML
    Label nameOfTheMovie;
    @FXML
    Label releaseDate;
    @FXML
    Label category;
    @FXML
    Label overview;

    @FXML
    public void search(ActionEvent actionEvent) throws IOException {
        final String text = searchedText.getText();

        final List<Movie> movieList = Upload.readXLSXFile();

        Gson g = new Gson();
        for (Movie m : movieList) {
            System.out.println(m.getTitle().toLowerCase().trim());
            if (m.getTitle().toLowerCase().trim().contains(text.toLowerCase().trim())){
                nameOfTheMovie.setText(m.getTitle());
                releaseDate.setText(m.getRelease_date());
                category.setText(String.valueOf(g.fromJson(m.getGenre(), Genre[].class)[0].getName()));
                overview.setText(m.getOverview());
            }
        }
    }

    public void goMain(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("res/homePage.fxml"));

        stage.setTitle("HomePage");
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }
}
