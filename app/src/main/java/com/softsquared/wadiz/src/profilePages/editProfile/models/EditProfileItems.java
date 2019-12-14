package com.softsquared.wadiz.src.profilePages.editProfile.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class EditProfileItems {

    @SerializedName("userinfo")
    private String userinfo;

    @SerializedName("categoryItems")
    private ArrayList<CategoryItem> categoryItems;

    public EditProfileItems(String userinfo, ArrayList<CategoryItem> categoryItems) {
        this.userinfo = userinfo;
        this.categoryItems = categoryItems;
    }

    public String getUserinfo() {
        return userinfo;
    }

    public ArrayList<CategoryItem> getCategoryItems() {
        return categoryItems;
    }


}
