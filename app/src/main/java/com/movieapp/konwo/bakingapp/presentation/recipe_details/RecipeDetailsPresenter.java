package com.movieapp.konwo.bakingapp.presentation.recipe_details;

import com.movieapp.konwo.bakingapp.data.remote.model.Recipe;
import com.movieapp.konwo.bakingapp.presentation.base.BasePresenter;

import static com.google.common.base.Preconditions.checkNotNull;

class RecipeDetailsPresenter extends BasePresenter<RecipeDetailsContract.View> implements RecipeDetailsContract.Presenter {

    private Recipe mCurrentRecipe;

    RecipeDetailsPresenter(Recipe currentRecipe) {
        this.mCurrentRecipe = checkNotNull(currentRecipe);
    }

    @Override
    public void attachView(RecipeDetailsContract.View mvpView) {
        super.attachView(mvpView);
        loadRecipeName();
        loadIngredients();
        loadSteps();
    }

    @Override
    public void loadRecipeName() {
        getView().showRecipeNameInAppBar(mCurrentRecipe.getName());
    }
    @Override
    public void loadIngredients() {
        getView().showIngredients(mCurrentRecipe.getIngredients());
    }

    @Override
    public void loadSteps() {
        getView().showSteps(mCurrentRecipe.getSteps());
    }

    @Override
    public void loadStepData(int stepId) {
        getView().showStepsDetailInContainer(stepId);
    }

    @Override
    public void navigateToStepDetails(int stepId) {
        checkViewAttached();
        getView().showStepDetails(stepId);
    }

}
