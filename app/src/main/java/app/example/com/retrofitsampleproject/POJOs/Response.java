package app.example.com.retrofitsampleproject.POJOs;

import java.util.List;

/**
 * Created by Ahmad on 9/11/2015.
 * Data Access Object blueprint for the Response of movies data from Internet
 */
public class Response {

    //Server Response.
    /*{
   "page":1,
   "results":[
      {
         "adult":false,
         "backdrop_path":"/tbhdm8UJAb4ViCTsulYFL3lxMCd.jpg",
         "genre_ids":[
            53,
            28,
            12
         ],
         "id":76341,
         "original_language":"en",
         "original_title":"Mad Max: Fury Road",
         "overview":"An apocalyptic story set in the furthest reaches of .
         "release_date":"2015-05-15",
         "poster_path":"/kqjL17yufvn9OVLyXYpvtyrFfak.jpg",
         "popularity":55.998703,
         "title":"Mad Max: Fury Road",
         "video":false,
         "vote_average":7.6,
         "vote_count":2187
      }]
      }*/

    private List<Movie> results;

    public Response(){}

    public Response(List<Movie> Results)
    {
        this.results = Results;
    }

    public List<Movie> getResults() {
        return results;
    }

    public class Movie
    {

        private long id;
        private String original_title;
        private String overview;
        private String release_date;
        private String poster_path;
        private double popularity;
        private String title;
        private double vote_average;
        private int vote_count;
        private String backdrop_path;
        
        public Movie(){}
        
        public Movie(long id, String original_title, String overview, String release_date,
                 String poster_path, double popularity, String title, double vote_average,
                 int vote_count, String backdrop_path){
            this.id = id;
            this.original_title = original_title;
            this.overview = overview;
            this.release_date =  release_date;
            this.poster_path = poster_path;
            this.popularity = popularity;
            this.title = title;
            this.vote_average = vote_average;
            this.vote_count = vote_count;
            this.backdrop_path =  backdrop_path;
            
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getVote_average() {
            return vote_average;
        }

        public void setVote_average(double vote_average) {
            this.vote_average = vote_average;
        }

        public int getVote_count() {
            return vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }


        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }
    }
}
