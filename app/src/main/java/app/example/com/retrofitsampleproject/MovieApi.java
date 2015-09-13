package app.example.com.retrofitsampleproject;

import retrofit.Call;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Ahmad on 9/11/2015.
 */
public interface MovieApi {

    //3/discover/movie?sort_by=popularity.desc&api_key=b980eff87da0a635d18c8bd29bad78b0
    @GET("/3/discover/movie")
    Call<Response> requestMovieName(@Query("sort_by") String sort_type,
                           @Query("api_key") String api_key);
}
