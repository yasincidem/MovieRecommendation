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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/**
 * Created by yasin_000 on 12.12.2017.
 */
public class MovieDetailController {

    @FXML
    Label askFriends;

    @FXML
    Label title;
    @FXML
    Label tagline;
    @FXML
    Label budget;
    @FXML
    Label genre;
    @FXML
    Label overview;
    @FXML
    Label date;
    @FXML
    Label revenue;
    @FXML
    Label runtime;
    @FXML
    Label voteAverage;
    @FXML
    Label voteCount;

    public void initialize(int index) {
        try {
            final List<Movie> movies = Upload.readXLSXFile();
            title.setText(movies.get(index).getTitle());
            tagline.setText(movies.get(index).getTagline());
            budget.setText(String.valueOf(movies.get(index).getBudget()));
            Gson g = new Gson();
            final Genre[] genres = g.fromJson(movies.get(index).getGenre(), Genre[].class);
            for (int i = 0; i < genres.length; i++) {
                genre.setText(genres[i].getName());
            }
            overview.setText(movies.get(index).getOverview());
            date.setText(movies.get(index).getRelease_date());
            revenue.setText(String.valueOf(movies.get(index).getRevenue()));
            runtime.setText(String.valueOf(movies.get(index).getRuntime()));
            voteAverage.setText(String.valueOf(movies.get(index).getVote_average()));
            voteCount.setText(String.valueOf(movies.get(index).getVote_count()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void onAskFriendsClick(ActionEvent event) throws  IOException{
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("../res/askFriends.fxml"));

        stage.setTitle("My Profile");
        stage.setScene(new Scene(root, 700, 500));
        stage.show();

    }

    public void goMain(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("res/homePage.fxml"));

        stage.setTitle("HomePage");
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }
}
