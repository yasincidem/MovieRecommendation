package db;

import Entity.Movie;
import com.poiji.bind.Poiji;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by yasin_000 on 11.12.2017.
 */
public class Upload {

    public static void main(String args[])throws Exception {

    }

    public static List<Movie> readXLSXFile() throws IOException {
        return Poiji.fromExcel(new File("src/db/movies.xlsx"), Movie.class);
    }

}