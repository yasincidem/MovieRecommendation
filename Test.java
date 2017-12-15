import Entity.Movie;
import db.Upload;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by yasin_000 on 11.12.2017.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        final List<Movie> movies = Upload.readXLSXFile();

        final Stream<String> stringStream = movies.stream().map(Movie::getGenre);
    }
}
