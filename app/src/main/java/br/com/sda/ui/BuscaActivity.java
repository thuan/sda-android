package br.com.sda.ui;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.sda.R;
import br.com.sda.api.MovieService;
import br.com.sda.api.RetrofitClient;
import br.com.sda.model.Movie;
import br.com.sda.ui.base.BaseActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class BuscaActivity extends BaseActivity {

    @Bind(R.id.buscaFilme)
    EditText movieEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca);
        ButterKnife.bind(this);
        setupToolbar();
    }

    @OnClick(R.id.fabBusca)
    public void onFabClicked(final View view) {
        MovieService service = RetrofitClient.getClient().create(MovieService.class);

        Movie movie = new Movie();

        movie.setName(movieEt.getText().toString());

        Call<Movie> response = service.getMovieByName(movie.getName());

        response.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Response<Movie> response, Retrofit retrofit) {
                Movie movie = response.body();

                Snackbar.make(view, "Filme: " + movie.getName() +
                        " - Diretor: " + movie.getAuthor(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setupToolbar() {
        final ActionBar ab = getActionBarToolbar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                openDrawer();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int getSelfNavDrawerItem() {
        return R.id.buscar;
    }

    @Override
    public boolean providesActivityToolbar() {
        return true;
    }
}
