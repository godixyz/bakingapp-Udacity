package com.movieapp.konwo.bakingapp.data.remote.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ingredient implements Parcelable {

    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("measure")
    @Expose
    private String measure;
    @SerializedName("ingredient")
    @Expose
    private String ingredient;

    public final static Creator<Ingredient> CREATOR = new Creator<Ingredient>() {
        @Override
        public Ingredient createFromParcel(Parcel parcel) {
            Ingredient instance = new Ingredient();
            instance.quantity = ((Double) parcel.readValue((Double.class.getClassLoader())));
            instance.measure = ((String) parcel.readValue((String.class.getClassLoader())));
            instance.ingredient = ((String) parcel.readValue((String.class.getClassLoader())));
            return instance;
        }

        @Override
        public Ingredient[] newArray(int size) {
            return new Ingredient[size];
        }
    };

    /**
     * No args constructor for use in serialization
     *
     */
    public Ingredient() {
    }

    /**
     *
     * @param measure
     * @param ingredient
     * @param quantity
     */

    public Ingredient(Double quantity, String measure, String ingredient) {
        super();
        this.quantity = quantity;
        this.measure = measure;
        this.ingredient = ingredient;
    }

    //getter
    public Double getQuantity() {
        return quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public String getIngredient() {
        return ingredient;
    }

    //setter
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(quantity);
        parcel.writeValue(measure);
        parcel.writeValue(ingredient);

    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "quantity=" + quantity +
                ", measure='" + measure + '\'' +
                ", ingredient='" + ingredient + '\'' +
                '}';
    }
}
