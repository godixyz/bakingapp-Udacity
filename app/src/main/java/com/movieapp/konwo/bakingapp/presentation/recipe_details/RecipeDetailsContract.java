package com.movieapp.konwo.bakingapp.presentation.recipe_details;

import com.movieapp.konwo.bakingapp.data.remote.model.Ingredient;
import com.movieapp.konwo.bakingapp.data.remote.model.Step;
import com.movieapp.konwo.bakingapp.presentation.base.MvpPresenter;
import com.movieapp.konwo.bakingapp.presentation.base.MvpView;

import java.util.List;

interface RecipeDetailsContract {

    interface View extends MvpView {
        void showSteps(List<Step> steps);

        void showIngredients(List<Ingredient> ingredients);

        void showRecipeNameInAppBar(String recipeName);

        void showStepDetails(int stepId);

        void showStepsDetailInContainer(int stepId);

        void setPresenter(Presenter presenter);
    }

    interface Presenter extends MvpPresenter<RecipeDetailsContract.View> {

        void loadRecipeName();

        void loadIngredients();

        void loadSteps();

        void loadStepData(int stepId);

        void navigateToStepDetails(int stepId);

    }
}
