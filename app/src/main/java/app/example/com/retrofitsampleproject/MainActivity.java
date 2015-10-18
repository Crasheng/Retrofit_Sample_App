package app.example.com.retrofitsampleproject;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.example.com.retrofitsampleproject.POJOs.Response;
import app.example.com.retrofitsampleproject.RESTControler.InternetRestAdapter;
import retrofit.Callback;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating Instance of Retrofit Wrapper sending to it the base URL
        InternetRestAdapter movies_api = new InternetRestAdapter("http://api.themoviedb.org/");

        //Doing network request sending the parameters (Sort_by= "?", Key="?")for the request
        retrofit.Call<Response> request = movies_api.getApi().requestMovieName("popularity.desc", "put ur API key here");

        //we invoke enqueue in case we need to make asynchronous request and this perfectly fits android framework.
        //if you would like to make synchronous request u can invoke "execute" method
        request.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(retrofit.Response<Response> response) {
                issueAvialableData(response);
            }

            //Here you can specify ehst happens if you do not have internet connection.
            @Override
            public void onFailure(Throwable t) {
                issueAFailure();
            }
        });
    }

    void issueAFailure(){
        //get reference to list view and disappear it.
        ListView names_list = (ListView) findViewById(android.R.id.list);
        names_list.setVisibility(View.GONE);

        //get reference to list view and appear it.
        TextView failure_message_view = (TextView) findViewById(R.id.failure_message_view);
        failure_message_view.setVisibility(View.VISIBLE);
        failure_message_view.setText("Connection Failed");
    }

    void issueAvialableData(retrofit.Response<Response> response){
        //Retrofit 2.0
        //to access the Data access object DAO you have to get the body of the incoming retrofit.Response<T>
        Response response_DAO = response.body();

        //Extracting all movies into a list
        List<Response.Movie> movies_list = response_DAO.getResults();

        //get the name of each movie in the list and add it to movies_names list
        List<String> movies_names = new ArrayList<>();
        for (Response.Movie movie: movies_list) {
            movies_names.add(movie.getTitle());
        }

        //initiating Array Adapter with the movies_names data
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.list_row, R.id.movie_name_text, movies_names);

        //set the list adapter to our ListActivity
        setListAdapter(adapter);
    }
}
