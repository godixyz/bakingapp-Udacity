package com.movieapp.konwo.bakingapp.presentation.recipe_step;

import com.movieapp.konwo.bakingapp.data.remote.model.Recipe;
import com.movieapp.konwo.bakingapp.presentation.base.BasePresenter;

import static com.google.common.base.Preconditions.checkNotNull;

class RecipeStepPresenter extends BasePresenter<RecipeStepContract.View> implements RecipeStepContract.Presenter {

    private final Recipe mRecipe;

    RecipeStepPresenter(Recipe recipe) {
        this.mRecipe = checkNotNull( recipe);
    }

    @Override
    public void attachView(RecipeStepContract.View mvpView) {
        super.attachView(mvpView);
        loadStepsToAdapter();
        loadRecipeName();
    }
    @Override
    public void loadStepsToAdapter() {
        getView().showStepsInViewpager(mRecipe.getSteps());
    }

    @Override
    public void loadRecipeName() {
        getView().showRecipeNameInAppBar(mRecipe.getName());
    }
}
