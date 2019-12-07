package com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.models;

import com.google.gson.annotations.SerializedName;

public class CategoryData {

    @SerializedName("categoryIdx")
    private int categoryIdx;

    @SerializedName("category")
    private String category;

    @SerializedName("categoryImg")
    private String categoryImg;

    public int getCategoryIdx() {
        return categoryIdx;
    }

    public String getCategory() {
        return category;
    }

    public String getCategoryImg() {
        return categoryImg;
    }
}
