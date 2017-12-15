package Entity;

import com.poiji.annotation.ExcelCell;

/**
 * Created by yasin_000 on 11.12.2017.
 */
public class Movie {
    @ExcelCell(0)
    private long budget;
    @ExcelCell(1)
    private String genre;
    @ExcelCell(2)
    private String title;
    @ExcelCell(3)
    private String overview;
    @ExcelCell(4)
    private String release_date;
    @ExcelCell(5)
    private long revenue;
    @ExcelCell(6)
    private int runtime;
    @ExcelCell(7)
    private String tagline;
    @ExcelCell(8)
    private long vote_average;
    @ExcelCell(9)
    private int vote_count;

    @Override
    public String toString() {
        return "Movie{" +
                "budget=" + budget +
                ", genre='" + genre + '\'' +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", release_date='" + release_date + '\'' +
                ", revenue=" + revenue +
                ", runtime=" + runtime +
                ", tagline='" + tagline + '\'' +
                ", vote_average=" + vote_average +
                ", vote_count=" + vote_count +
                '}';
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public Long getRevenue() {
        return revenue;
    }

    public void setRevenue(Long revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public Long getVote_average() {
        return vote_average;
    }

    public void setVote_average(Long vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }


}
