package com.movieapp.konwo.bakingapp.data.remote.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Recipe implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("ingredients")
    @Expose
    private List<Ingredient> ingredients = new ArrayList<>();
    @SerializedName("steps")
    @Expose
    private List<Step> steps = new ArrayList<>();
    @SerializedName("servings")
    @Expose
    private Integer servings;
    @SerializedName("image")
    @Expose
    private String image;

    public final static Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @SuppressWarnings({
                "unchecked"
        })
        public Recipe createFromParcel(Parcel parcel) {
            Recipe instance = new Recipe();
            instance.id = ((Integer) parcel.readValue((Integer.class.getClassLoader())));
            instance.name = ((String) parcel.readValue((String.class.getClassLoader())));
            parcel.readList(instance.ingredients, (Ingredient.class.getClassLoader()));
            parcel.readList(instance.steps, (Step.class.getClassLoader()));
            instance.servings = ((Integer) parcel.readValue((Integer.class.getClassLoader())));
            instance.name = ((String) parcel.readValue((String.class.getClassLoader())));
            return instance;
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };


    /**
     * No args constructor for use in serialization
     *
     */
    public Recipe() {
    }

    /**
     *
     * @param ingredients
     * @param id
     * @param servings
     * @param name
     * @param image
     * @param steps
     */

    public Recipe(Integer id, String name, List<Ingredient> ingredients, List<Step> steps, Integer servings, String image) {
        super();
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
        this.servings = servings;
        this.image = image;
    }

    //setter
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public void setImage(String image) {
        this.image = image;
    }


    //getter
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public Integer getServings() {
        return servings;
    }

    public String getImage() {
        return image;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeValue(id);
        parcel.writeValue(name);
        parcel.writeList(ingredients);
        parcel.writeList(steps);
        parcel.writeValue(servings);
        parcel.writeValue(image);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", steps=" + steps +
                ", servings=" + servings +
                ", image='" + image + '\'' +
                '}';
    }
}
