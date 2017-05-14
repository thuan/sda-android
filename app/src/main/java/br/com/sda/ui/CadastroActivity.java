package br.com.sda.ui;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
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

/**
 * Created by thuan on 13/05/2017.
 */

public class CadastroActivity extends BaseActivity {

    @Bind(R.id.movie)
    EditText movieEt;

    @Bind(R.id.author)
    EditText authorEt;

    @Bind(R.id.description)
    EditText descriptionEt;

    @Bind(R.id.isFavorite)
    CheckBox isFavoriteEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        ButterKnife.bind(this);
        setupToolbar();
    }

    @OnClick(R.id.fabCadastro)
    public void onFabClicked(final View view) {

        MovieService service = RetrofitClient.getClient().create(MovieService.class);

        Movie movie = new Movie();

        movie.setName(movieEt.getText().toString());
        movie.setAuthor(authorEt.getText().toString());
        movie.setDescription(descriptionEt.getText().toString());
        movie.setFavorite(isFavoriteEt.isChecked());

        Call<Movie> response = service.addMovie(movie);

        response.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Response<Movie> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    Snackbar.make(view, "Filme cadastrado com sucesso!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(getApplicationContext(), "Erro " + t.getMessage(), Toast.LENGTH_LONG)
                        .show();
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
        return R.id.cadastro;
    }

    @Override
    public boolean providesActivityToolbar() {
        return true;
    }
}
