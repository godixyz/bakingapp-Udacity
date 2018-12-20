package com.movieapp.konwo.bakingapp.presentation.recipe_list;

import com.movieapp.konwo.bakingapp.data.remote.model.Recipe;
import com.movieapp.konwo.bakingapp.idlingresource.RecipesIdlingResource;
import com.movieapp.konwo.bakingapp.presentation.base.MvpPresenter;
import com.movieapp.konwo.bakingapp.presentation.base.MvpView;

import java.util.List;

interface RecipeListContract {

    interface View extends MvpView {
        void showRecipes(List<Recipe> recipes);

        void showToRecipeDetails(Recipe recipe);
    }

    interface Presenter extends MvpPresenter<RecipeListContract.View> {

        void loadRecipes(RecipesIdlingResource idlingResource);

        void navigateToRecipeSteps(Recipe recipe);
    }
}
