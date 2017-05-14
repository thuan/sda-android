package br.com.sda.api;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by thuan on 14/05/2017.
 */

public class RetrofitClient {


    //TODO - RODANDO LOCALMENTE = MODIFICAR O IP
    private static final String BASE_URL = "http://192.168.25.2:8080";

    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
