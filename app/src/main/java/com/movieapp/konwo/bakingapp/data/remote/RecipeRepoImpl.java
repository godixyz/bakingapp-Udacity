package com.movieapp.konwo.bakingapp.data.remote;

import com.movieapp.konwo.bakingapp.data.remote.model.ApiService;
import com.movieapp.konwo.bakingapp.data.remote.model.Recipe;

import java.util.List;

import rx.Observable;
import rx.functions.Func0;

import static com.google.common.base.Preconditions.checkNotNull;

public class RecipeRepoImpl implements RecipeRepo {

    private final ApiService apiService;

    public RecipeRepoImpl(ApiService apiService) {
        this.apiService = checkNotNull(apiService, "baking app Api Service cannot be null");
    }

    @Override
    public Observable<List<Recipe>> getRecipes() {
       return Observable.defer(new Func0<Observable<List<Recipe>>>() {
           @Override
           public Observable<List<Recipe>> call() {
               return apiService.fetchRecipes();
           }
       });
    }
}
