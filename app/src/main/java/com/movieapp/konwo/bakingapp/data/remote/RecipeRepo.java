package com.movieapp.konwo.bakingapp.data.remote;

import com.movieapp.konwo.bakingapp.data.remote.model.Recipe;

import java.util.List;

public interface RecipeRepo {
    rx.Observable<List<Recipe>> getRecipes();
}
