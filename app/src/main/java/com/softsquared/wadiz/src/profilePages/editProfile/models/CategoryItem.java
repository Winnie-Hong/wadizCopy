package com.softsquared.wadiz.src.profilePages.editProfile.models;

import com.google.gson.annotations.SerializedName;

public class CategoryItem {

    @SerializedName("categoryIdx")
    private int categoryIdx;

    public CategoryItem(int categoryIdx) {
        this.categoryIdx = categoryIdx;
    }

    public int getCategoryIdx() {
        return categoryIdx;
    }
}


