package app.example.com.retrofitsampleproject;

import android.util.Log;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by crasheng on 9/13/15.
 */

public class InternetRestAdapter {

    String TAG =  getClass().getSimpleName();
    public Retrofit retrofit;
    MovieApi api;



    public InternetRestAdapter(String base_url){
        Log.d(TAG, "InternetRestAdapter ");
        retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(MovieApi.class);
    }

    public MovieApi getApi() {
        return api;
    }


}
