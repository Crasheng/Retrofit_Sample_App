package app.example.com.retrofitsampleproject;

import java.util.List;

/**
 * Created by Ahmad on 9/11/2015.
 */
public class Response {
    String movieName;
    List<Movie> Results;

    class Movie
    {
        private String backdrop_path;
        public long id;
        public String original_title;
        public String overview;
        public String release_date;
        public String poster_path;
        public double popularity;
        public String title;
        public double vote_average;
        public int vote_count;

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }
    }
}
