package com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CategoryResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private ArrayList<CategoryData> result;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public ArrayList<CategoryData> getResult() {
        return result;
    }

}