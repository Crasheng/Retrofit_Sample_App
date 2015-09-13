package app.example.com.retrofitsampleproject;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.squareup.okhttp.Call;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.Retrofit;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InternetRestAdapter movies_api = new InternetRestAdapter("http://api.themoviedb.org/3/discover/movie");
        retrofit.Call<Response> response = movies_api.getApi().requestMovieName("popularity.desc", "b980eff87da0a635d18c8bd29bad78b0");
        response.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(retrofit.Response<Response> response) {
                List<Response.Movie> movies_list = response.body().getResults();
                List<String> movies_names = new ArrayList<>();
                for (Response.Movie movie: movies_list) {
                    movies_names.add(movie.getTitle());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.list_row, R.id.movie_name_text, movies_names);
                setListAdapter(adapter);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
