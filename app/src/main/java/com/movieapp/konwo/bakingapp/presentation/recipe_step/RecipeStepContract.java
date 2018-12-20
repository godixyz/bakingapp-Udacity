package com.movieapp.konwo.bakingapp.presentation.recipe_step;

import com.movieapp.konwo.bakingapp.data.remote.model.Step;
import com.movieapp.konwo.bakingapp.presentation.base.MvpPresenter;
import com.movieapp.konwo.bakingapp.presentation.base.MvpView;

import java.util.List;

interface RecipeStepContract {

    interface View extends MvpView {
        void showStepsInViewpager(List<Step> steps);
        void showRecipeNameInAppBar(String recipeName);
        void moveToCurrentStepPage();
    }

    interface Presenter extends MvpPresenter<View> {
        void loadStepsToAdapter();

        void loadRecipeName();
    }
}
