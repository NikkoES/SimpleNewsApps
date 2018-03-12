package com.example.nikkoekasaputra.simplenewsapps.api;

import com.example.nikkoekasaputra.simplenewsapps.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Nikko Eka Saputra on 11/02/2018.
 */

public interface BaseApiService {

    @GET("/v2/top-headlines")
    Call<NewsResponse> getListNews(@Query("country") String country, @Query("category") String category, @Query("apiKey") String apiKey);

}
