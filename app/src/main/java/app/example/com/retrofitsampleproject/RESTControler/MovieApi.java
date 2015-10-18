package app.example.com.retrofitsampleproject.RESTControler;

import app.example.com.retrofitsampleproject.POJOs.Response;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Ahmad on 9/11/2015.
 * This interface the guidance for retrofit library that,
 * How you are using it to do your rest operations required by ur application
 */
public interface MovieApi {

    //3/discover/movie?sort_by=popularity.desc&api_key=b980eff87da0a635d18c8bd29bad78b0

    //Describe what is your following method does
    //passing to it a relative path
    @GET("/3/discover/movie")

    //Retrofit 2.0
    //your return type of any method is just a type (Call< T >) parametrized by your expected response model class
    Call<Response> requestMovieName(@Query("sort_by") String sort_type,
                           @Query("api_key") String api_key);
}
