package com.movieapp.konwo.bakingapp.data.remote.model;

import java.util.List;
import java.util.Observable;

import retrofit2.http.GET;



public interface ApiService {
    @GET("android-baking-app-json")
    rx.Observable<List<Recipe>> fetchRecipes();
}
