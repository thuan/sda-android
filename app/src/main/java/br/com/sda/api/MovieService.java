package br.com.sda.api;

import java.util.List;

import br.com.sda.model.Movie;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;


public interface MovieService {

    @GET("/movies")
    Call<List<Movie>> getMovies();

    @GET("/movies/{name}")
    Call<Movie> getMovieByName(@Path("name") String name);

    @POST("/movies")
    Call<Movie> addMovie(@Body Movie movie);
}
