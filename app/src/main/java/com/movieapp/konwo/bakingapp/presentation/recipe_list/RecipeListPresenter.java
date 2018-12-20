package com.movieapp.konwo.bakingapp.presentation.recipe_list;

import com.movieapp.konwo.bakingapp.RxUtils.schedulers.BaseSchedulerProvider;
import com.movieapp.konwo.bakingapp.data.remote.RecipeRepo;
import com.movieapp.konwo.bakingapp.data.remote.model.Recipe;
import com.movieapp.konwo.bakingapp.idlingresource.RecipesIdlingResource;
import com.movieapp.konwo.bakingapp.presentation.base.BasePresenter;

import java.util.List;

import rx.Subscriber;
import rx.functions.Action0;
import timber.log.Timber;

class RecipeListPresenter extends BasePresenter<RecipeListContract.View> implements RecipeListContract.Presenter {

    private final RecipeRepo mRecipeRepo;
    private final BaseSchedulerProvider mSchedulerProvider;

    RecipeListPresenter(RecipeRepo mRecipeRepo, BaseSchedulerProvider mSchedulerProvider) {
        this.mRecipeRepo = mRecipeRepo;
        this.mSchedulerProvider = mSchedulerProvider;
    }

    @Override
    public void loadRecipes(final RecipesIdlingResource idlingResource) {
        checkViewAttached();
        getView().showLoading();
        mRecipeRepo.getRecipes()
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        if (idlingResource != null) idlingResource.setIdleState(false);
                    }
                })
                .subscribeOn(mSchedulerProvider.computation())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Subscriber<List<Recipe>>() {
                    @Override
                    public void onCompleted() {}

                    @Override
                    public void onError(Throwable e) {
                        getView().hideLoading();
                        getView().onError(e.getMessage());
                        Timber.e(e);
                    }

                    @Override
                    public void onNext(List<Recipe> recipes) {
                        Timber.d(recipes.toString());
                        if (idlingResource != null) idlingResource.setIdleState(true);
                        getView().hideLoading();
                        getView().showRecipes(recipes);
                    }
                });
    }

    @Override
    public void navigateToRecipeSteps(Recipe recipe) {
        getView().showToRecipeDetails(recipe);
    }
}
