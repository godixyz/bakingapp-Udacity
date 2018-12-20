package com.movieapp.konwo.bakingapp.presentation.recipe_details;

import android.os.Bundle;

import com.movieapp.konwo.bakingapp.R;
import com.movieapp.konwo.bakingapp.data.remote.model.Recipe;
import com.movieapp.konwo.bakingapp.presentation.base.BaseActivity;
import com.movieapp.konwo.bakingapp.utils.ActivityUtils;

public class RecipeDetailsActivity extends BaseActivity {

    public static final String RECIPE_KEY = "RECIPE_KEY";

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_recipe_details);

        Recipe recipe = getIntent().getParcelableExtra(RECIPE_KEY);
        Bundle bundle = new Bundle();
        bundle.putParcelable(RECIPE_KEY, recipe);

        RecipeDetailsContract.Presenter mPresenter = new RecipeDetailsPresenter(recipe);

        // add fragment
        RecipeDetailsFragment fragment = new RecipeDetailsFragment();
        fragment.setPresenter(mPresenter);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.content_frame_recipe_details, fragment)
                .commit();
    }


    @Override
    public void showSnackBarMessage(String message) {
        onError(message);
    }
}
