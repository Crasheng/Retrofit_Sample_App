package app.example.com.retrofitsampleproject.RESTControler;

import android.util.Log;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;


/**
 * Created by crasheng on 9/13/15.
 * Class wrapping the creation of the REST API
 */

public class InternetRestAdapter {

    String TAG =  getClass().getSimpleName();
    //Reference to the library
    public Retrofit retrofit;
    //Reference to MovieApi Interface
    MovieApi api;



    public InternetRestAdapter(String base_url){
        Log.d(TAG, "InternetRestAdapter ");

        //pass to retrofit our interface with its metadata assigned to every method
        //That is how retrofit can handle all backend operations
        //here is our factory requirements
        retrofit = new Retrofit.Builder()
                //Base URL required for all REST operations
                .baseUrl(base_url)
                //Retrofit 2.0+
                //You need to plug a Converter in yourself or Retrofit will be able to accept only the String result
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //API Ready to invoke methods on it.
        //here is the manufacturing
        api = retrofit.create(MovieApi.class);
    }

    public MovieApi getApi() {
        return api;
    }
}
