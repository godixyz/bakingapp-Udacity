package com.movieapp.konwo.bakingapp.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.movieapp.konwo.bakingapp.R;

import static com.google.common.base.Preconditions.checkNotNull;

public class ActivityUtils {

    public static void addFragmentToActivity (@NonNull FragmentManager fragmentManager,
                                              @NonNull Fragment fragment, int frameId) {
        checkNotNull (fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }

    public static boolean isTbalet(Context context){
        return context.getResources().getBoolean(R.bool.isTablet);
    }
}
