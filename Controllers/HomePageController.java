package Controllers;

import Entity.Movie;
import db.Upload;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class HomePageController implements Initializable{

    @FXML
    Button profileButton;
    @FXML
    Button searchButton;
    @FXML
    ListView popularMoviesListView;

    public ListView getPopularMoviesListView() {
        return popularMoviesListView;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            final ArrayList<String> collect = Upload.readXLSXFile()
                    .stream()
                    .map(Movie::getTitle)
                    .limit(13)
                    .collect(Collectors.toCollection(ArrayList::new));

            ObservableList<String> observableList =
                    FXCollections.observableList(collect);

            popularMoviesListView.setItems(observableList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void goProfile(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("res/user.fxml"));

        stage.setTitle("My Profile");
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }

    public void goSearch(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("res/search.fxml"));

        stage.setTitle("My Profile");
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }
    Parent parent;
    Stage stage;


    @FXML
    public void clickOnListViewItem(MouseEvent mouseEvent) throws IOException {
        System.out.println(popularMoviesListView.getSelectionModel().getSelectedIndex());

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("res/movieDetails.fxml"));
        try {
            parent = (Parent)loader.load();
        } catch (IOException ex) {}

        if(parent!=null){
            //we create a custom controller
            MovieDetailController controller  = loader.<MovieDetailController>getController();
            controller.initialize(popularMoviesListView.getSelectionModel().getSelectedIndex());
            //here we pass the reference to the  other controller


        }

        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        final Scene scene = new Scene(parent, 700, 500);

        stage.setScene(scene);
        stage.show();
    }


    public void goAllMovies(ActionEvent actionEvent) throws IOException{
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("res/allMoviePage.fxml"));

        stage.setTitle("All Movies");
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }
}
