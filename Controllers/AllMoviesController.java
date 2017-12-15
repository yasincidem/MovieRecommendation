package Controllers;

import Entity.Movie;
import db.Upload;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * Created by yasin_000 on 12.12.2017.
 */
public class AllMoviesController implements Initializable{
    @FXML
    ListView allMoviesListView;

    ObservableList<Movie> watchLaterList = FXCollections.observableList(new ArrayList<>());
    ObservableList<Movie> likedList = FXCollections.observableList(new ArrayList<>());

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            final ArrayList<String> collect = Upload.readXLSXFile()
                    .stream()
                    .map(Movie::getTitle)
                    .collect(Collectors.toCollection(ArrayList::new));

            ObservableList<String> observableList =
                    FXCollections.observableList(collect);

            allMoviesListView.setItems(observableList);
        } catch (IOException e) {
            e.printStackTrace();
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
