package com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BannerResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private ArrayList<Banner> result;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public ArrayList<Banner> getResult() {
        return result;
    }

}